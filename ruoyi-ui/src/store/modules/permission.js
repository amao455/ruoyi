import auth from "@/plugins/auth";
import router, { constantRoutes, dynamicRoutes } from "@/router";
import { getRouters } from "@/api/menu";
import Layout from "@/layout/index";
import ParentView from "@/components/ParentView";
import InnerLink from "@/layout/components/InnerLink";

const permission = {
  state: {
    routes: [], // 完整路由表，包括常量路由和动态添加的路由
    addRoutes: [], // 动态添加的路由，根据用户权限动态生成的路由配置数组
    defaultRoutes: [], // 默认路由，主要用于标签页的管理
    topbarRouters: [], // 顶部导航栏使用的路由
    sidebarRouters: [], // 侧边栏菜单使用的路由
  },
  
  mutations: {
    SET_ROUTES: (state, routes) => {
      state.addRoutes = routes;
      state.routes = constantRoutes.concat(routes);
    },
    SET_DEFAULT_ROUTES: (state, routes) => {
      state.defaultRoutes = constantRoutes.concat(routes);
    },
    SET_TOPBAR_ROUTES: (state, routes) => {
      state.topbarRouters = routes;
    },
    SET_SIDEBAR_ROUTERS: (state, routes) => {
      state.sidebarRouters = routes;
    },
  },
  actions: {
    /**
     * todo 超重要 根据用户权限“动态”生成并添加路由
     * 1.通过调用后端API获取用户权限路由
     * 2.通过filterAsyncRouter处理路由
     * 3.更新各种路由状态
     * 4.返回处理后的路由
     * */
    GenerateRoutes({ commit }) {
      return new Promise((resolve) => {
        // 向后端请求路由数据
        getRouters().then((res) => {
          const sdata = JSON.parse(JSON.stringify(res.data));
          const rdata = JSON.parse(JSON.stringify(res.data));
          const sidebarRoutes = filterAsyncRouter(sdata); // 保持嵌套结构，用于菜单显示
          const rewriteRoutes = filterAsyncRouter(rdata, false, true); // 扁平化处理，用于路由匹配
          const asyncRoutes = filterDynamicRoutes(dynamicRoutes); // 前端权限验证，防止用户直接访问URl绕过权限控制
          rewriteRoutes.push({ path: "*", redirect: "/404", hidden: true });
          router.addRoutes(asyncRoutes); // 将过滤后的动态路由添加到Vue Router中，使这些路由在应用中生效
          commit("SET_ROUTES", rewriteRoutes); // 设置完整路由
          commit("SET_SIDEBAR_ROUTERS", constantRoutes.concat(sidebarRoutes)); // 设置侧边栏路由
          commit("SET_DEFAULT_ROUTES", sidebarRoutes); // 用于标签页显示和默认页面
          commit("SET_TOPBAR_ROUTES", sidebarRoutes); // 设置顶部导航路由
          resolve(rewriteRoutes);
        });
      });
    },
  },
};

// 遍历后台传来的路由字符串，将其转换为Vue Router可识别的路由对象，并处理组件的动态加载
/**
 * asyncRouterMap: 后端返回的路由配置数组
 * lastRouter: 上级路由对象（默认false）
 * type: 是否需要特殊处理子路由（默认false）
 * 将字符串形式的组件名转换为实际的Vue组件或动态导入函数
 * 递归处理所有层级的路由
 * 为Vue Router准备标准的路由配置格式
 * 支持路由懒加载，提升应用性能
 */
function filterAsyncRouter(asyncRouterMap, lastRouter = false, type = false) {
  return asyncRouterMap.filter((route) => {
    if (type && route.children) {
      route.children = filterChildren(route.children);
    }
    if (route.component) {
      if (route.component === "Layout") {
        route.component = Layout; // 替换为实际的Layout组件
      } else if (route.component === "ParentView") {
        route.component = ParentView; // 替换为ParentView组件
      } else if (route.component === "InnerLink") {
        route.component = InnerLink; // 替换为InnerLink组件
      } else {
        // 一级菜单可以通过静态路由进行直接访问，但是后面的菜单就不行了
        route.component = loadView(route.component); // 动态加载其他组件
      }
    }
    if (route.children != null && route.children && route.children.length) {
      route.children = filterAsyncRouter(route.children, route, type);
    } else {
      delete route["children"];
      delete route["redirect"];
    }
    return true;
  });
}

// 处理和扁平化嵌套的子路由结构
function filterChildren(childrenMap, lastRouter = false) {
  var children = [];
  childrenMap.forEach((el, index) => {
    if (el.children && el.children.length) {
      if (el.component === "ParentView" && !lastRouter) {
        el.children.forEach((c) => {
          c.path = el.path + "/" + c.path;
          if (c.children && c.children.length) {
            children = children.concat(filterChildren(c.children, c));
            return;
          }
          children.push(c);
        });
        return;
      }
    }
    if (lastRouter) {
      el.path = lastRouter.path + "/" + el.path;
      if (el.children && el.children.length) {
        children = children.concat(filterChildren(el.children, el));
        return;
      }
    }
    children = children.concat(el);
  });
  return children;
}

// 动态路由遍历，验证用户是否具备权限，这个是验证，防止用户通过访问URl绕过权限控制
/**
 * 遍历动态路由，验证是否具备权限
 * 1.遍历路由配置
 * 2 根据权限或角色验证是否具有访问权限
 * 3 过滤出用户有权访问的路由
 */
export function filterDynamicRoutes(routes) {
  const res = [];
  routes.forEach((route) => {
    if (route.permissions) {
      // 如果路由配置了权限
      if (auth.hasPermiOr(route.permissions)) {
        res.push(route); // 添加到结果中
      }
    } else if (route.roles) {
      // 如果路由配置了角色
      if (auth.hasRoleOr(route.roles)) {
        res.push(route); // 添加到结果中
      }
    }
  });
  return res;
}

// 动态加载视图组件，实现路由的懒加载
export const loadView = (view) => {
  if (process.env.NODE_ENV === "development") {
    return (resolve) => require([`@/views/${view}`], resolve);
  } else {
    // 使用 import 实现生产环境的路由懒加载
    return () => import(`@/views/${view}`);
  }
};

export default permission;
