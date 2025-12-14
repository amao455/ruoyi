import hasRole from "./permission/hasRole";
import hasPermi from "./permission/hasPermi";
import dialogDrag from "./dialog/drag";
import dialogDragWidth from "./dialog/dragWidth";
import dialogDragHeight from "./dialog/dragHeight";
import clipboard from "./module/clipboard";

// 导入多个自定义指令模块
const install = function (Vue) {
  Vue.directive("hasRole", hasRole);
  Vue.directive("hasPermi", hasPermi);
  Vue.directive("clipboard", clipboard);
  Vue.directive("dialogDrag", dialogDrag);
  Vue.directive("dialogDragWidth", dialogDragWidth);
  Vue.directive("dialogDragHeight", dialogDragHeight);
};

// 环境检测：通过 if (window.Vue) 检测是否在浏览器环境中直接使用
// 全局暴露：将 hasRole 和 hasPermi 指令直接挂载到 window 对象上，使其可以在全局访问
// 自动安装：当检测到 window.Vue 存在时，自动调用 Vue.use(install) 安装所有自定义指令
if (window.Vue) {
  window["hasRole"] = hasRole;
  window["hasPermi"] = hasPermi;
  Vue.use(install); // eslint-disable-line
}

export default install;
