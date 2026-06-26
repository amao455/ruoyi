<!-- 接收一个动态路由参数，然后把浏览器地址替换成真正的目标路径 -->
<script>
export default {
  created() {
    const { params, query } = this.$route;
    const { path } = params;
    this.$router.replace({ path: "/" + path, query });
  },
  render: function (h) {
    return h(); // avoid warning message
  },
};
</script>
