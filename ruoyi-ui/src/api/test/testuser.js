import request from '@/utils/request'

// 查询test列表
export function listTestuser(query) {
  return request({
    url: '/test/testuser/list',
    method: 'get',
    params: query
  })
}

// 查询test详细
export function getTestuser(id) {
  return request({
    url: '/test/testuser/' + id,
    method: 'get'
  })
}

// 新增test
export function addTestuser(data) {
  return request({
    url: '/test/testuser',
    method: 'post',
    data: data
  })
}

// 修改test
export function updateTestuser(data) {
  return request({
    url: '/test/testuser',
    method: 'put',
    data: data
  })
}

// 删除test
export function delTestuser(id) {
  return request({
    url: '/test/testuser/' + id,
    method: 'delete'
  })
}
