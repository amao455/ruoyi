<!-- 渲染侧边栏菜单，根据路由、主题和折叠状态显示样式与菜单项 -->
<template>
  <div
    :class="{ 'has-logo': showLogo }"
    :style="{
      backgroundColor:
        settings.sideTheme === 'theme-dark'
          ? variables.menuBackground
          : variables.menuLightBackground,
    }"
  >
    <!-- 顶部logo区域 -->
    <logo v-if="showLogo" :collapse="isCollapse" />
    <!-- 滚动容器 -->
    <el-scrollbar :class="settings.sideTheme" wrap-class="scrollbar-wrapper">
      <!-- Element UI菜单组件 -->
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :background-color="
          settings.sideTheme === 'theme-dark'
            ? variables.menuBackground
            : variables.menuLightBackground
        "
        :text-color="
          settings.sideTheme === 'theme-dark'
            ? variables.menuColor
            : variables.menuLightColor
        "
        :unique-opened="true"
        :active-text-color="settings.theme"
        :collapse-transition="false"
        mode="vertical"
      >
        <!-- 遍历的是顶层路由数组 -->
        <sidebar-item
          v-for="(route, index) in sidebarRouters"
          :key="route.path + index"
          :item="route"
          :base-path="route.path"
        />
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import Logo from "./Logo";
import SidebarItem from "./SidebarItem";
import variables from "@/assets/styles/variables.scss";

export default {
  components: { SidebarItem, Logo },
  computed: {
    ...mapState(["settings"]),
    ...mapGetters(["sidebarRouters", "sidebar"]),
    activeMenu() {
      const route = this.$route;
      const { meta, path } = route;
      // if set path, the sidebar will highlight the path you set
      if (meta.activeMenu) {
        return meta.activeMenu;
      }
      return path;
    },
    // 左侧栏是否显示logo
    showLogo() {
      return this.$store.state.settings.sidebarLogo;
    },
    // 获取主题色
    variables() {
      return variables;
    },
    // 获取侧栏折叠状态
    isCollapse() {
      return !this.sidebar.opened;
    },
  },
};
</script>
