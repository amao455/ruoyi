package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.ContractsMapper;
import com.ruoyi.test.domain.Contracts;
import com.ruoyi.test.service.IContractsService;

/**
 * 合同信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
@Service
public class ContractsServiceImpl implements IContractsService 
{
    @Autowired
    private ContractsMapper contractsMapper;

    /**
     * 查询合同信息
     * 
     * @param contractId 合同信息主键
     * @return 合同信息
     */
    @Override
    public Contracts selectContractsByContractId(Long contractId)
    {
        return contractsMapper.selectContractsByContractId(contractId);
    }

    /**
     * 查询合同信息列表
     * 
     * @param contracts 合同信息
     * @return 合同信息
     */
    @Override
    public List<Contracts> selectContractsList(Contracts contracts)
    {
        return contractsMapper.selectContractsList(contracts);
    }

    /**
     * 新增合同信息
     * 
     * @param contracts 合同信息
     * @return 结果
     */
    @Override
    public int insertContracts(Contracts contracts)
    {
        return contractsMapper.insertContracts(contracts);
    }

    /**
     * 修改合同信息
     * 
     * @param contracts 合同信息
     * @return 结果
     */
    @Override
    public int updateContracts(Contracts contracts)
    {
        return contractsMapper.updateContracts(contracts);
    }

    /**
     * 批量删除合同信息
     * 
     * @param contractIds 需要删除的合同信息主键
     * @return 结果
     */
    @Override
    public int deleteContractsByContractIds(Long[] contractIds)
    {
        return contractsMapper.deleteContractsByContractIds(contractIds);
    }

    /**
     * 删除合同信息信息
     * 
     * @param contractId 合同信息主键
     * @return 结果
     */
    @Override
    public int deleteContractsByContractId(Long contractId)
    {
        return contractsMapper.deleteContractsByContractId(contractId);
    }
}
