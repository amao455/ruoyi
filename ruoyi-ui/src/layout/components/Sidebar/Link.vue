<template>
  <!-- 动态组件语法，完整工作流程如下：
    1.组件接收：Link 组件接收 to 属性
    2.类型判断：根据 to 值判断是否为外部链接 is的取值有"router-link"和"a"两种情况
    3.动态渲染：
      3.1.外部链接 → 渲染为 <a> 标签
      3.2.内部路由 → 渲染为 <router-link> 组件
    4.属性绑定：根据类型绑定相应的属性（href 或 to）
    5.内容显示：显示插槽中的内容（菜单项图标和文字）-->
  <component :is="type" v-bind="linkProps(to)">
    <!-- 内容分发组件，允许父组件向Link组件传递内容 -->
    <slot />
  </component>
</template>

<script>
import { isExternal } from "@/utils/validate";

export default {
  props: {
    to: {
      type: [String, Object],
      required: true,
    },
  },
  computed: {
    isExternal() {
      return isExternal(this.to);
    },
    type() {
      if (this.isExternal) {
        return "a";
      }
      return "router-link";
    },
  },
  methods: {
    linkProps(to) {
      if (this.isExternal) {
        return {
          href: to,
          target: "_blank",
          rel: "noopener",
        };
      }
      return {
        to: to,
      };
    },
  },
};
</script>
