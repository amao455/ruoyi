/**
* v-hasPermi 操作权限处理
* 功能：根据当前用户的操作权限，决定某个元素是否显示
* 核心逻辑：
* 从 Vue 的状态中读取当前用户拥有的权限列表
* 看你在模板里传入的权限值是什么
* 如果用户拥有其中任何一个权限，或者是超级权限 *:*:*，就保留元素
* 否则，就把这个元素从 DOM 中移除
* Copyright (c) 2019 ruoyi
*/

import store from '@/store'

export default {
  inserted(el, binding, vnode) {
    const { value } = binding
    const all_permission = "*:*:*";
    // 获取当前用户的权限列表
    const permissions = store.getters && store.getters.permissions

    if (value && value instanceof Array && value.length > 0) {
      const permissionFlag = value

      // 判断当前用户是否拥有传入的权限值，或者是否拥有超级权限 *:*:*
      const hasPermissions = permissions.some(permission => {
        return all_permission === permission || permissionFlag.includes(permission)
      })
      // 如果当前用户没有传入的权限值，也没有超级权限，就把这个元素从 DOM 中移除
      if (!hasPermissions) {
        el.parentNode && el.parentNode.removeChild(el)
      }
    } else {
      throw new Error(`请设置操作权限标签值`)
    }
  }
}
