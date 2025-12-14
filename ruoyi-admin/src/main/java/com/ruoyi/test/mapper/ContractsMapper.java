package com.ruoyi.test.mapper;

import java.util.List;
import com.ruoyi.test.domain.Contracts;

/**
 * 合同信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public interface ContractsMapper 
{
    /**
     * 查询合同信息
     * 
     * @param contractId 合同信息主键
     * @return 合同信息
     */
    public Contracts selectContractsByContractId(Long contractId);

    /**
     * 查询合同信息列表
     * 
     * @param contracts 合同信息
     * @return 合同信息集合
     */
    public List<Contracts> selectContractsList(Contracts contracts);

    /**
     * 新增合同信息
     * 
     * @param contracts 合同信息
     * @return 结果
     */
    public int insertContracts(Contracts contracts);

    /**
     * 修改合同信息
     * 
     * @param contracts 合同信息
     * @return 结果
     */
    public int updateContracts(Contracts contracts);

    /**
     * 删除合同信息
     * 
     * @param contractId 合同信息主键
     * @return 结果
     */
    public int deleteContractsByContractId(Long contractId);

    /**
     * 批量删除合同信息
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteContractsByContractIds(Long[] contractIds);
}
