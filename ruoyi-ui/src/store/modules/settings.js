import defaultSettings from "@/settings";

const {
  sideTheme,
  showSettings,
  topNav,
  tagsView,
  fixedHeader,
  sidebarLogo,
  dynamicTitle,
} = defaultSettings;

// 从本地存储中获取布局设置
const storageSetting = JSON.parse(localStorage.getItem("layout-setting")) || "";

const state = {
  title: "", // 网页标题
  theme: storageSetting.theme || "#409EFF", // 主题颜色配置
  sideTheme: storageSetting.sideTheme || sideTheme, // 侧边栏主题
  showSettings: showSettings, /// 系统设置开关
  topNav: storageSetting.topNav === undefined ? topNav : storageSetting.topNav, // 顶部导航栏开关
  tagsView:
    storageSetting.tagsView === undefined ? tagsView : storageSetting.tagsView, // 标签页显示开关
  fixedHeader:
    storageSetting.fixedHeader === undefined
      ? fixedHeader
      : storageSetting.fixedHeader, // 固定头部开关
  sidebarLogo:
    storageSetting.sidebarLogo === undefined
      ? sidebarLogo
      : storageSetting.sidebarLogo, // 侧边栏Logo显示
  dynamicTitle:
    storageSetting.dynamicTitle === undefined
      ? dynamicTitle
      : storageSetting.dynamicTitle, // 动态标题开关
};

const mutations = {
  CHANGE_SETTING: (state, { key, value }) => {
    if (state.hasOwnProperty(key)) {
      state[key] = value;
    }
  },
};

const actions = {
  // 修改布局设置
  changeSetting({ commit }, data) {
    commit("CHANGE_SETTING", data);
  },
  // 设置网页标题
  setTitle({ commit }, title) {
    state.title = title;
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
