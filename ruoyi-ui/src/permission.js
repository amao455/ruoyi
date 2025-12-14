import router from "./router";
import store from "./store";
import { Message } from "element-ui";
import NProgress from "nprogress";
import "nprogress/nprogress.css";
import { getToken } from "@/utils/auth";
import { isRelogin } from "@/utils/request";

NProgress.configure({ showSpinner: false });

// 创建白名单，定义无需登录即可访问的页面路径
const whiteList = ["/login", "/register"];

//页面跳转前都会调用该方法
router.beforeEach((to, from, next) => {
  // 开启进度条
  NProgress.start();
  // 从本地cookie中直接获取token
  // 已登录用户
  if (getToken()) {
    // 设置页面标题
    to.meta.title && store.dispatch("settings/setTitle", to.meta.title);
    /* has token*/
    // 如果已登录却访问/login，重定向到首页
    if (to.path === "/login") {
      next({ path: "/" });
      NProgress.done();
    } else if (whiteList.indexOf(to.path) !== -1) {
      // 处理已登录但访问非白名单页面的情况
      next();
    } else {
      // 处理用户信息的加载情况
      // 判断用户信息是否加载
      // 未加载
      if (store.getters.roles.length === 0) {
        // 标记正在进行重复登录的操作，防止重新请求
        isRelogin.show = true;
        // 判断当前用户是否已拉取完user_info信息
        store
          .dispatch("GetInfo")
          .then(() => {
            // 清除重登录标记
            isRelogin.show = false;
            // 根据用户角色生成可访问的动态路由表
            store.dispatch("GenerateRoutes").then((accessRoutes) => {
              // 根据roles权限生成可访问的路由表
              router.addRoutes(accessRoutes); // 动态添加可访问路由表
              next({ ...to, replace: true }); // hack方法 确保addRoutes已完成
            });
          })
          .catch((err) => {
            store.dispatch("LogOut").then(() => {
              Message.error(err);
              next({ path: "/" });
            });
          });
      } else {
        // 用户信息已加载
        next();
      }
    }
  } else {
    // 未登录用户（无token）
    // 没有token
    if (whiteList.indexOf(to.path) !== -1) {
      // 在免登录白名单，直接进入
      next();
    } else {
      // 重定向的作用：用户在登录完成后可以直接跳转到重定向的网页，无缝体验
      next(`/login?redirect=${encodeURIComponent(to.fullPath)}`); // 否则全部重定向到登录页
      NProgress.done();
    }
  }
});

router.afterEach(() => {
  NProgress.done();
});
