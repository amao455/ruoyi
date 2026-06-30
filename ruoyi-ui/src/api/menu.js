import request from "@/utils/request";

// 获取当前用户路由
export const getRouters = () => {
  return request({
    url: "/getRouters",
    method: "get",
  });
};
