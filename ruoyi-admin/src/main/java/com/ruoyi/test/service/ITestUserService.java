package com.ruoyi.test.service;

import java.util.List;
import com.ruoyi.test.domain.TestUser;

/**
 * testService接口
 * 
 * @author ruoyi
 * @date 2024-11-26
 */
public interface ITestUserService 
{
    /**
     * 查询test
     * 
     * @param id test主键
     * @return test
     */
    public TestUser selectTestUserById(Long id);

    /**
     * 查询test列表
     * 
     * @param testUser test
     * @return test集合
     */
    public List<TestUser> selectTestUserList(TestUser testUser);

    /**
     * 新增test
     * 
     * @param testUser test
     * @return 结果
     */
    public int insertTestUser(TestUser testUser);

    /**
     * 修改test
     * 
     * @param testUser test
     * @return 结果
     */
    public int updateTestUser(TestUser testUser);

    /**
     * 批量删除test
     * 
     * @param ids 需要删除的test主键集合
     * @return 结果
     */
    public int deleteTestUserByIds(Long[] ids);

    /**
     * 删除test信息
     * 
     * @param id test主键
     * @return 结果
     */
    public int deleteTestUserById(Long id);
}
