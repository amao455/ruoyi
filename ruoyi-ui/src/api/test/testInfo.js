import request from '@/utils/request'

// 查询合同信息列表
export function listTestInfo(query) {
  return request({
    url: '/test/testInfo/list',
    method: 'get',
    params: query
  })
}

// 查询合同信息详细
export function getTestInfo(contractId) {
  return request({
    url: '/test/testInfo/' + contractId,
    method: 'get'
  })
}

// 新增合同信息
export function addTestInfo(data) {
  return request({
    url: '/test/testInfo',
    method: 'post',
    data: data
  })
}

// 修改合同信息
export function updateTestInfo(data) {
  return request({
    url: '/test/testInfo',
    method: 'put',
    data: data
  })
}

// 删除合同信息
export function delTestInfo(contractId) {
  return request({
    url: '/test/testInfo/' + contractId,
    method: 'delete'
  })
}
