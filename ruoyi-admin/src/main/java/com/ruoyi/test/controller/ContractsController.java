package com.ruoyi.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.Contracts;
import com.ruoyi.test.service.IContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 合同信息Controller
 *
 * @author ruoyi
 * @date 2024-12-04
 */
@RestController
@RequestMapping("/test/testInfo")
public class ContractsController extends BaseController {
    @Autowired
    private IContractsService contractsService;

    /**
     * 查询合同信息列表
     */
    @PreAuthorize("@ss.hasPermi('test:testInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Contracts contracts) {
        startPage();
        List<Contracts> list = contractsService.selectContractsList(contracts);
        return getDataTable(list);
    }

    /**
     * 导出合同信息列表
     */
    @PreAuthorize("@ss.hasPermi('test:testInfo:export')")
    @Log(title = "合同信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Contracts contracts) {
        List<Contracts> list = contractsService.selectContractsList(contracts);
        ExcelUtil<Contracts> util = new ExcelUtil<Contracts>(Contracts.class);
        util.exportExcel(response, list, "合同信息数据");
    }

    /**
     * 获取合同信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testInfo:query')")
    @GetMapping(value = "/{contractId}")
    public AjaxResult getInfo(@PathVariable("contractId") Long contractId) {
        return success(contractsService.selectContractsByContractId(contractId));
    }

    /**
     * 新增合同信息
     */
    @PreAuthorize("@ss.hasPermi('test:testInfo:add')")
    @Log(title = "合同信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Contracts contracts) {
        return toAjax(contractsService.insertContracts(contracts));
    }

    /**
     * 修改合同信息
     */
    @PreAuthorize("@ss.hasPermi('test:testInfo:edit')")
    @Log(title = "合同信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Contracts contracts) {
        return toAjax(contractsService.updateContracts(contracts));
    }

    /**
     * 删除合同信息
     */
    @PreAuthorize("@ss.hasPermi('test:testInfo:remove')")
    @Log(title = "合同信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contractIds}")
    public AjaxResult remove(@PathVariable Long[] contractIds) {
        return toAjax(contractsService.deleteContractsByContractIds(contractIds));
    }
}
