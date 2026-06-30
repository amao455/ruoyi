<template>
  <div id="app">
    <!-- 占位组件，根据当前路由，动态渲染对应页面视图 -->
    <router-view />
    <!-- 主题切换组件 -->
    <theme-picker />
  </div>
</template>

<script>
import ThemePicker from "@/components/ThemePicker";

export default {
  name: "App",
  components: { ThemePicker },
  // （自动调用）该方法并非模板里直接调用的普通方法，它是 vue-meta 插件定义的生命周期式元信息接口，只要插件启用，就会被框架使用。
  // 当 dynamicTitle 开启时，取当前页面的 title（由路由守卫中 store.dispatch("settings/setTitle", ...) 设置）
  // 最终浏览器标签页标题变为：页面标题 - 若依管理系统
  // 如果没有子标题，则只显示：若依管理系统
  metaInfo() {
    return {
      title:
        this.$store.state.settings.dynamicTitle &&
        this.$store.state.settings.title,
      titleTemplate: (title) => {
        return title
          ? `${title} - ${process.env.VUE_APP_TITLE}`
          : process.env.VUE_APP_TITLE;
      },
    };
  },
};
</script>

<style scoped>
#app .theme-picker {
  display: none;
}
</style>
