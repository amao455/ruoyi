package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.TestUserMapper;
import com.ruoyi.test.domain.TestUser;
import com.ruoyi.test.service.ITestUserService;

/**
 * testService业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-26
 */
@Service
public class TestUserServiceImpl implements ITestUserService 
{
    @Autowired
    private TestUserMapper testUserMapper;

    /**
     * 查询test
     * 
     * @param id test主键
     * @return test
     */
    @Override
    public TestUser selectTestUserById(Long id)
    {
        return testUserMapper.selectTestUserById(id);
    }

    /**
     * 查询test列表
     * 
     * @param testUser test
     * @return test
     */
    @Override
    public List<TestUser> selectTestUserList(TestUser testUser)
    {
        return testUserMapper.selectTestUserList(testUser);
    }

    /**
     * 新增test
     * 
     * @param testUser test
     * @return 结果
     */
    @Override
    public int insertTestUser(TestUser testUser)
    {
        return testUserMapper.insertTestUser(testUser);
    }

    /**
     * 修改test
     * 
     * @param testUser test
     * @return 结果
     */
    @Override
    public int updateTestUser(TestUser testUser)
    {
        return testUserMapper.updateTestUser(testUser);
    }

    /**
     * 批量删除test
     * 
     * @param ids 需要删除的test主键
     * @return 结果
     */
    @Override
    public int deleteTestUserByIds(Long[] ids)
    {
        return testUserMapper.deleteTestUserByIds(ids);
    }

    /**
     * 删除test信息
     * 
     * @param id test主键
     * @return 结果
     */
    @Override
    public int deleteTestUserById(Long id)
    {
        return testUserMapper.deleteTestUserById(id);
    }
}
