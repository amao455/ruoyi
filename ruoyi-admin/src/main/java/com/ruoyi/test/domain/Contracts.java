package com.ruoyi.test.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同信息对象 contracts
 * 
 * @author ruoyi
 * @date 2024-12-04
 */
public class Contracts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同编号 */
    private Long contractId;

    /** 二级单位客户名称 */
    @Excel(name = "二级单位客户名称")
    private String secondaryUnitName;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String clientName;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectCode;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 客户性质 */
    @Excel(name = "客户性质")
    private String clientType;

    /** 客户信用等级 */
    @Excel(name = "客户信用等级")
    private String clientCreditLevel;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private BigDecimal contractAmount;

    /** 已确认收入金额 */
    @Excel(name = "已确认收入金额")
    private BigDecimal confirmedRevenue;

    /** 已回款金额 */
    @Excel(name = "已回款金额")
    private BigDecimal returnedAmount;

    /** 尚未确认收入金额 */
    @Excel(name = "尚未确认收入金额")
    private BigDecimal unconfirmedRevenue;

    /** 开票后确认收入时间 */
    @Excel(name = "开票后确认收入时间")
    private String revenueConfirmationDate;

    /** 开票后确认收入金额 */
    @Excel(name = "开票后确认收入金额")
    private BigDecimal confirmedAfterInvoice;

    /** 已清收金额 */
    @Excel(name = "已清收金额")
    private BigDecimal recoveredAmount;

    /** 应收账款余额 */
    @Excel(name = "应收账款余额")
    private BigDecimal accountsReceivableBalance;

    /** 1年以内 */
    @Excel(name = "1年以内")
    private BigDecimal arWithin1Year;

    /** 1-2年 */
    @Excel(name = "1-2年")
    private BigDecimal ar1To2Years;

    /** 2-3年 */
    @Excel(name = "2-3年")
    private BigDecimal ar2To3Years;

    /** 3-4年 */
    @Excel(name = "3-4年")
    private BigDecimal ar3To4Years;

    /** 4-5年 */
    @Excel(name = "4-5年")
    private BigDecimal ar4To5Years;

    /** 5年以上 */
    @Excel(name = "5年以上")
    private BigDecimal ar5PlusYears;

    /** 逾期应收账款 */
    @Excel(name = "逾期应收账款")
    private BigDecimal overdueAr;

    /** 逾期三年应收账款 */
    @Excel(name = "逾期三年应收账款")
    private BigDecimal overdueAr3Years;

    /** 负责人 */
    @Excel(name = "负责人")
    private String responsiblePerson;

    /** 二级单位负责人 */
    @Excel(name = "二级单位负责人")
    private String secondaryUnitPerson;

    /** 是否发送对账函 */
    @Excel(name = "是否发送对账函")
    private Integer reconciliationSent;

    /** 已回函 */
    @Excel(name = "已回函")
    private Integer reconciliationReceived;

    /** 诉讼情况 */
    @Excel(name = "诉讼情况")
    private String litigationStatus;

    /** 是否与应收账款一致 */
    @Excel(name = "是否与应收账款一致")
    private String reconciliationMatch;

    /** 合同约定回款时间 */
    @Excel(name = "合同约定回款时间")
    private String agreedPaymentDate;

    /** 项目分类名称 */
    @Excel(name = "项目分类名称")
    private String projectClassificationName;

    /** 合同资产科目名称 */
    @Excel(name = "合同资产科目名称")
    private String contractAssetAccountName;

    /** 合同资产期末金额 */
    @Excel(name = "合同资产期末金额")
    private BigDecimal contractAssetEndingBalance;

    /** 插入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "插入日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date insertDate;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setSecondaryUnitName(String secondaryUnitName) 
    {
        this.secondaryUnitName = secondaryUnitName;
    }

    public String getSecondaryUnitName() 
    {
        return secondaryUnitName;
    }
    public void setClientName(String clientName) 
    {
        this.clientName = clientName;
    }

    public String getClientName() 
    {
        return clientName;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setProjectCode(String projectCode) 
    {
        this.projectCode = projectCode;
    }

    public String getProjectCode() 
    {
        return projectCode;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setClientType(String clientType) 
    {
        this.clientType = clientType;
    }

    public String getClientType() 
    {
        return clientType;
    }
    public void setClientCreditLevel(String clientCreditLevel) 
    {
        this.clientCreditLevel = clientCreditLevel;
    }

    public String getClientCreditLevel() 
    {
        return clientCreditLevel;
    }
    public void setContractAmount(BigDecimal contractAmount) 
    {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getContractAmount() 
    {
        return contractAmount;
    }
    public void setConfirmedRevenue(BigDecimal confirmedRevenue) 
    {
        this.confirmedRevenue = confirmedRevenue;
    }

    public BigDecimal getConfirmedRevenue() 
    {
        return confirmedRevenue;
    }
    public void setReturnedAmount(BigDecimal returnedAmount) 
    {
        this.returnedAmount = returnedAmount;
    }

    public BigDecimal getReturnedAmount() 
    {
        return returnedAmount;
    }
    public void setUnconfirmedRevenue(BigDecimal unconfirmedRevenue) 
    {
        this.unconfirmedRevenue = unconfirmedRevenue;
    }

    public BigDecimal getUnconfirmedRevenue() 
    {
        return unconfirmedRevenue;
    }
    public void setRevenueConfirmationDate(String revenueConfirmationDate) 
    {
        this.revenueConfirmationDate = revenueConfirmationDate;
    }

    public String getRevenueConfirmationDate() 
    {
        return revenueConfirmationDate;
    }
    public void setConfirmedAfterInvoice(BigDecimal confirmedAfterInvoice) 
    {
        this.confirmedAfterInvoice = confirmedAfterInvoice;
    }

    public BigDecimal getConfirmedAfterInvoice() 
    {
        return confirmedAfterInvoice;
    }
    public void setRecoveredAmount(BigDecimal recoveredAmount) 
    {
        this.recoveredAmount = recoveredAmount;
    }

    public BigDecimal getRecoveredAmount() 
    {
        return recoveredAmount;
    }
    public void setAccountsReceivableBalance(BigDecimal accountsReceivableBalance) 
    {
        this.accountsReceivableBalance = accountsReceivableBalance;
    }

    public BigDecimal getAccountsReceivableBalance() 
    {
        return accountsReceivableBalance;
    }
    public void setArWithin1Year(BigDecimal arWithin1Year) 
    {
        this.arWithin1Year = arWithin1Year;
    }

    public BigDecimal getArWithin1Year() 
    {
        return arWithin1Year;
    }
    public void setAr1To2Years(BigDecimal ar1To2Years) 
    {
        this.ar1To2Years = ar1To2Years;
    }

    public BigDecimal getAr1To2Years() 
    {
        return ar1To2Years;
    }
    public void setAr2To3Years(BigDecimal ar2To3Years) 
    {
        this.ar2To3Years = ar2To3Years;
    }

    public BigDecimal getAr2To3Years() 
    {
        return ar2To3Years;
    }
    public void setAr3To4Years(BigDecimal ar3To4Years) 
    {
        this.ar3To4Years = ar3To4Years;
    }

    public BigDecimal getAr3To4Years() 
    {
        return ar3To4Years;
    }
    public void setAr4To5Years(BigDecimal ar4To5Years) 
    {
        this.ar4To5Years = ar4To5Years;
    }

    public BigDecimal getAr4To5Years() 
    {
        return ar4To5Years;
    }
    public void setAr5PlusYears(BigDecimal ar5PlusYears) 
    {
        this.ar5PlusYears = ar5PlusYears;
    }

    public BigDecimal getAr5PlusYears() 
    {
        return ar5PlusYears;
    }
    public void setOverdueAr(BigDecimal overdueAr) 
    {
        this.overdueAr = overdueAr;
    }

    public BigDecimal getOverdueAr() 
    {
        return overdueAr;
    }
    public void setOverdueAr3Years(BigDecimal overdueAr3Years) 
    {
        this.overdueAr3Years = overdueAr3Years;
    }

    public BigDecimal getOverdueAr3Years() 
    {
        return overdueAr3Years;
    }
    public void setResponsiblePerson(String responsiblePerson) 
    {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePerson() 
    {
        return responsiblePerson;
    }
    public void setSecondaryUnitPerson(String secondaryUnitPerson) 
    {
        this.secondaryUnitPerson = secondaryUnitPerson;
    }

    public String getSecondaryUnitPerson() 
    {
        return secondaryUnitPerson;
    }
    public void setReconciliationSent(Integer reconciliationSent) 
    {
        this.reconciliationSent = reconciliationSent;
    }

    public Integer getReconciliationSent() 
    {
        return reconciliationSent;
    }
    public void setReconciliationReceived(Integer reconciliationReceived) 
    {
        this.reconciliationReceived = reconciliationReceived;
    }

    public Integer getReconciliationReceived() 
    {
        return reconciliationReceived;
    }
    public void setLitigationStatus(String litigationStatus) 
    {
        this.litigationStatus = litigationStatus;
    }

    public String getLitigationStatus() 
    {
        return litigationStatus;
    }
    public void setReconciliationMatch(String reconciliationMatch) 
    {
        this.reconciliationMatch = reconciliationMatch;
    }

    public String getReconciliationMatch() 
    {
        return reconciliationMatch;
    }
    public void setAgreedPaymentDate(String agreedPaymentDate) 
    {
        this.agreedPaymentDate = agreedPaymentDate;
    }

    public String getAgreedPaymentDate() 
    {
        return agreedPaymentDate;
    }
    public void setProjectClassificationName(String projectClassificationName) 
    {
        this.projectClassificationName = projectClassificationName;
    }

    public String getProjectClassificationName() 
    {
        return projectClassificationName;
    }
    public void setContractAssetAccountName(String contractAssetAccountName) 
    {
        this.contractAssetAccountName = contractAssetAccountName;
    }

    public String getContractAssetAccountName() 
    {
        return contractAssetAccountName;
    }
    public void setContractAssetEndingBalance(BigDecimal contractAssetEndingBalance) 
    {
        this.contractAssetEndingBalance = contractAssetEndingBalance;
    }

    public BigDecimal getContractAssetEndingBalance() 
    {
        return contractAssetEndingBalance;
    }
    public void setInsertDate(Date insertDate) 
    {
        this.insertDate = insertDate;
    }

    public Date getInsertDate() 
    {
        return insertDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("secondaryUnitName", getSecondaryUnitName())
            .append("clientName", getClientName())
            .append("contractName", getContractName())
            .append("projectCode", getProjectCode())
            .append("region", getRegion())
            .append("clientType", getClientType())
            .append("clientCreditLevel", getClientCreditLevel())
            .append("contractAmount", getContractAmount())
            .append("confirmedRevenue", getConfirmedRevenue())
            .append("returnedAmount", getReturnedAmount())
            .append("unconfirmedRevenue", getUnconfirmedRevenue())
            .append("revenueConfirmationDate", getRevenueConfirmationDate())
            .append("confirmedAfterInvoice", getConfirmedAfterInvoice())
            .append("recoveredAmount", getRecoveredAmount())
            .append("accountsReceivableBalance", getAccountsReceivableBalance())
            .append("arWithin1Year", getArWithin1Year())
            .append("ar1To2Years", getAr1To2Years())
            .append("ar2To3Years", getAr2To3Years())
            .append("ar3To4Years", getAr3To4Years())
            .append("ar4To5Years", getAr4To5Years())
            .append("ar5PlusYears", getAr5PlusYears())
            .append("overdueAr", getOverdueAr())
            .append("overdueAr3Years", getOverdueAr3Years())
            .append("responsiblePerson", getResponsiblePerson())
            .append("secondaryUnitPerson", getSecondaryUnitPerson())
            .append("reconciliationSent", getReconciliationSent())
            .append("reconciliationReceived", getReconciliationReceived())
            .append("litigationStatus", getLitigationStatus())
            .append("reconciliationMatch", getReconciliationMatch())
            .append("agreedPaymentDate", getAgreedPaymentDate())
            .append("projectClassificationName", getProjectClassificationName())
            .append("contractAssetAccountName", getContractAssetAccountName())
            .append("contractAssetEndingBalance", getContractAssetEndingBalance())
            .append("insertDate", getInsertDate())
            .toString();
    }
}
