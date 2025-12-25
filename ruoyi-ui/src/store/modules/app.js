import Cookies from "js-cookie";

const state = {
  // 侧边栏状态
  sidebar: {
    opened: Cookies.get("sidebarStatus")
      ? !!+Cookies.get("sidebarStatus")
      : true,
    withoutAnimation: false,
    hide: false,
  },
  // 设备类型
  device: "desktop",
  // 组件尺寸
  size: Cookies.get("size") || "medium",
};

const mutations = {
  // 切换侧边栏的展开/收起状态
  TOGGLE_SIDEBAR: (state) => {
    if (state.sidebar.hide) {
      return false;
    }
    state.sidebar.opened = !state.sidebar.opened;
    state.sidebar.withoutAnimation = false;
    if (state.sidebar.opened) {
      Cookies.set("sidebarStatus", 1);
    } else {
      Cookies.set("sidebarStatus", 0);
    }
  },
  CLOSE_SIDEBAR: (state, withoutAnimation) => {
    Cookies.set("sidebarStatus", 0);
    state.sidebar.opened = false;
    state.sidebar.withoutAnimation = withoutAnimation;
  },
  TOGGLE_DEVICE: (state, device) => {
    state.device = device;
  },
  SET_SIZE: (state, size) => {
    state.size = size;
    Cookies.set("size", size);
  },
  SET_SIDEBAR_HIDE: (state, status) => {
    state.sidebar.hide = status;
  },
};

const actions = {
  toggleSideBar({ commit }) {
    commit("TOGGLE_SIDEBAR");
  },
  closeSideBar({ commit }, { withoutAnimation }) {
    commit("CLOSE_SIDEBAR", withoutAnimation);
  },
  toggleDevice({ commit }, device) {
    commit("TOGGLE_DEVICE", device);
  },
  setSize({ commit }, size) {
    commit("SET_SIZE", size);
  },
  toggleSideBarHide({ commit }, status) {
    commit("SET_SIDEBAR_HIDE", status);
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
