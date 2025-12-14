package com.ruoyi.test.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.test.domain.TestUser;
import com.ruoyi.test.service.ITestUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * testController
 *
 * @author ruoyi
 * @date 2024-11-26
 */
@RestController
@RequestMapping("/test/testuser")
public class TestUserController extends BaseController {
    @Autowired
    private ITestUserService testUserService;

    /**
     * 查询test列表
     */
    @PreAuthorize("@ss.hasPermi('test:testuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestUser testUser) {
        startPage();
        List<TestUser> list = testUserService.selectTestUserList(testUser);
        return getDataTable(list);
    }

    /**
     * 导出test列表
     */
    @PreAuthorize("@ss.hasPermi('test:testuser:export')")
    @Log(title = "test", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestUser testUser) {
        List<TestUser> list = testUserService.selectTestUserList(testUser);
        ExcelUtil<TestUser> util = new ExcelUtil<TestUser>(TestUser.class);
        util.exportExcel(response, list, "test数据");
    }

    /**
     * 获取test详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(testUserService.selectTestUserById(id));
    }

    /**
     * 新增test
     */
    @PreAuthorize("@ss.hasPermi('test:testuser:add')")
    @Log(title = "test", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestUser testUser) {
        return toAjax(testUserService.insertTestUser(testUser));
    }

    /**
     * 修改test
     */
    @PreAuthorize("@ss.hasPermi('test:testuser:edit')")
    @Log(title = "test", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestUser testUser) {
        return toAjax(testUserService.updateTestUser(testUser));
    }

    /**
     * 删除test
     */
    @PreAuthorize("@ss.hasPermi('test:testuser:remove')")
    @Log(title = "test", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(testUserService.deleteTestUserByIds(ids));
    }
}
