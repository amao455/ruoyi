<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="二级单位客户名称" prop="secondaryUnitName">
        <el-input
          v-model="queryParams.secondaryUnitName"
          placeholder="请输入二级单位客户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户名称" prop="clientName">
        <el-input
          v-model="queryParams.clientName"
          placeholder="请输入客户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同名称" prop="contractName">
        <el-input
          v-model="queryParams.contractName"
          placeholder="请输入合同名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目编号" prop="projectCode">
        <el-input
          v-model="queryParams.projectCode"
          placeholder="请输入项目编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区域" prop="region">
        <el-input
          v-model="queryParams.region"
          placeholder="请输入区域"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户信用等级" prop="clientCreditLevel">
        <el-input
          v-model="queryParams.clientCreditLevel"
          placeholder="请输入客户信用等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同金额" prop="contractAmount">
        <el-input
          v-model="queryParams.contractAmount"
          placeholder="请输入合同金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已确认收入金额" prop="confirmedRevenue">
        <el-input
          v-model="queryParams.confirmedRevenue"
          placeholder="请输入已确认收入金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已回款金额" prop="returnedAmount">
        <el-input
          v-model="queryParams.returnedAmount"
          placeholder="请输入已回款金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="尚未确认收入金额" prop="unconfirmedRevenue">
        <el-input
          v-model="queryParams.unconfirmedRevenue"
          placeholder="请输入尚未确认收入金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开票后确认收入时间" prop="revenueConfirmationDate">
        <el-input
          v-model="queryParams.revenueConfirmationDate"
          placeholder="请输入开票后确认收入时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开票后确认收入金额" prop="confirmedAfterInvoice">
        <el-input
          v-model="queryParams.confirmedAfterInvoice"
          placeholder="请输入开票后确认收入金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已清收金额" prop="recoveredAmount">
        <el-input
          v-model="queryParams.recoveredAmount"
          placeholder="请输入已清收金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="应收账款余额" prop="accountsReceivableBalance">
        <el-input
          v-model="queryParams.accountsReceivableBalance"
          placeholder="请输入应收账款余额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="1年以内" prop="arWithin1Year">
        <el-input
          v-model="queryParams.arWithin1Year"
          placeholder="请输入1年以内"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="1-2年" prop="ar1To2Years">
        <el-input
          v-model="queryParams.ar1To2Years"
          placeholder="请输入1-2年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="2-3年" prop="ar2To3Years">
        <el-input
          v-model="queryParams.ar2To3Years"
          placeholder="请输入2-3年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="3-4年" prop="ar3To4Years">
        <el-input
          v-model="queryParams.ar3To4Years"
          placeholder="请输入3-4年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="4-5年" prop="ar4To5Years">
        <el-input
          v-model="queryParams.ar4To5Years"
          placeholder="请输入4-5年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="5年以上" prop="ar5PlusYears">
        <el-input
          v-model="queryParams.ar5PlusYears"
          placeholder="请输入5年以上"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="逾期应收账款" prop="overdueAr">
        <el-input
          v-model="queryParams.overdueAr"
          placeholder="请输入逾期应收账款"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="逾期三年应收账款" prop="overdueAr3Years">
        <el-input
          v-model="queryParams.overdueAr3Years"
          placeholder="请输入逾期三年应收账款"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人" prop="responsiblePerson">
        <el-input
          v-model="queryParams.responsiblePerson"
          placeholder="请输入负责人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二级单位负责人" prop="secondaryUnitPerson">
        <el-input
          v-model="queryParams.secondaryUnitPerson"
          placeholder="请输入二级单位负责人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否发送对账函" prop="reconciliationSent">
        <el-input
          v-model="queryParams.reconciliationSent"
          placeholder="请输入是否发送对账函"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已回函" prop="reconciliationReceived">
        <el-input
          v-model="queryParams.reconciliationReceived"
          placeholder="请输入已回函"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否与应收账款一致" prop="reconciliationMatch">
        <el-input
          v-model="queryParams.reconciliationMatch"
          placeholder="请输入是否与应收账款一致"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同约定回款时间" prop="agreedPaymentDate">
        <el-input
          v-model="queryParams.agreedPaymentDate"
          placeholder="请输入合同约定回款时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目分类名称" prop="projectClassificationName">
        <el-input
          v-model="queryParams.projectClassificationName"
          placeholder="请输入项目分类名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同资产科目名称" prop="contractAssetAccountName">
        <el-input
          v-model="queryParams.contractAssetAccountName"
          placeholder="请输入合同资产科目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同资产期末金额" prop="contractAssetEndingBalance">
        <el-input
          v-model="queryParams.contractAssetEndingBalance"
          placeholder="请输入合同资产期末金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="插入日期" prop="insertDate">
        <el-date-picker clearable
          v-model="queryParams.insertDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择插入日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['test:testInfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['test:testInfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['test:testInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['test:testInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="testInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="合同编号" align="center" prop="contractId" />
      <el-table-column label="二级单位客户名称" align="center" prop="secondaryUnitName" />
      <el-table-column label="客户名称" align="center" prop="clientName" />
      <el-table-column label="合同名称" align="center" prop="contractName" />
      <el-table-column label="项目编号" align="center" prop="projectCode" />
      <el-table-column label="区域" align="center" prop="region" />
      <el-table-column label="客户性质" align="center" prop="clientType" />
      <el-table-column label="客户信用等级" align="center" prop="clientCreditLevel" />
      <el-table-column label="合同金额" align="center" prop="contractAmount" />
      <el-table-column label="已确认收入金额" align="center" prop="confirmedRevenue" />
      <el-table-column label="已回款金额" align="center" prop="returnedAmount" />
      <el-table-column label="尚未确认收入金额" align="center" prop="unconfirmedRevenue" />
      <el-table-column label="开票后确认收入时间" align="center" prop="revenueConfirmationDate" />
      <el-table-column label="开票后确认收入金额" align="center" prop="confirmedAfterInvoice" />
      <el-table-column label="已清收金额" align="center" prop="recoveredAmount" />
      <el-table-column label="应收账款余额" align="center" prop="accountsReceivableBalance" />
      <el-table-column label="1年以内" align="center" prop="arWithin1Year" />
      <el-table-column label="1-2年" align="center" prop="ar1To2Years" />
      <el-table-column label="2-3年" align="center" prop="ar2To3Years" />
      <el-table-column label="3-4年" align="center" prop="ar3To4Years" />
      <el-table-column label="4-5年" align="center" prop="ar4To5Years" />
      <el-table-column label="5年以上" align="center" prop="ar5PlusYears" />
      <el-table-column label="逾期应收账款" align="center" prop="overdueAr" />
      <el-table-column label="逾期三年应收账款" align="center" prop="overdueAr3Years" />
      <el-table-column label="负责人" align="center" prop="responsiblePerson" />
      <el-table-column label="二级单位负责人" align="center" prop="secondaryUnitPerson" />
      <el-table-column label="是否发送对账函" align="center" prop="reconciliationSent" />
      <el-table-column label="已回函" align="center" prop="reconciliationReceived" />
      <el-table-column label="诉讼情况" align="center" prop="litigationStatus" />
      <el-table-column label="是否与应收账款一致" align="center" prop="reconciliationMatch" />
      <el-table-column label="合同约定回款时间" align="center" prop="agreedPaymentDate" />
      <el-table-column label="项目分类名称" align="center" prop="projectClassificationName" />
      <el-table-column label="合同资产科目名称" align="center" prop="contractAssetAccountName" />
      <el-table-column label="合同资产期末金额" align="center" prop="contractAssetEndingBalance" />
      <el-table-column label="插入日期" align="center" prop="insertDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.insertDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['test:testInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['test:testInfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改合同信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="二级单位客户名称" prop="secondaryUnitName">
          <el-input v-model="form.secondaryUnitName" placeholder="请输入二级单位客户名称" />
        </el-form-item>
        <el-form-item label="客户名称" prop="clientName">
          <el-input v-model="form.clientName" placeholder="请输入客户名称" />
        </el-form-item>
        <el-form-item label="合同名称" prop="contractName">
          <el-input v-model="form.contractName" placeholder="请输入合同名称" />
        </el-form-item>
        <el-form-item label="项目编号" prop="projectCode">
          <el-input v-model="form.projectCode" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="区域" prop="region">
          <el-input v-model="form.region" placeholder="请输入区域" />
        </el-form-item>
        <el-form-item label="客户信用等级" prop="clientCreditLevel">
          <el-input v-model="form.clientCreditLevel" placeholder="请输入客户信用等级" />
        </el-form-item>
        <el-form-item label="合同金额" prop="contractAmount">
          <el-input v-model="form.contractAmount" placeholder="请输入合同金额" />
        </el-form-item>
        <el-form-item label="已确认收入金额" prop="confirmedRevenue">
          <el-input v-model="form.confirmedRevenue" placeholder="请输入已确认收入金额" />
        </el-form-item>
        <el-form-item label="已回款金额" prop="returnedAmount">
          <el-input v-model="form.returnedAmount" placeholder="请输入已回款金额" />
        </el-form-item>
        <el-form-item label="尚未确认收入金额" prop="unconfirmedRevenue">
          <el-input v-model="form.unconfirmedRevenue" placeholder="请输入尚未确认收入金额" />
        </el-form-item>
        <el-form-item label="开票后确认收入时间" prop="revenueConfirmationDate">
          <el-input v-model="form.revenueConfirmationDate" placeholder="请输入开票后确认收入时间" />
        </el-form-item>
        <el-form-item label="开票后确认收入金额" prop="confirmedAfterInvoice">
          <el-input v-model="form.confirmedAfterInvoice" placeholder="请输入开票后确认收入金额" />
        </el-form-item>
        <el-form-item label="已清收金额" prop="recoveredAmount">
          <el-input v-model="form.recoveredAmount" placeholder="请输入已清收金额" />
        </el-form-item>
        <el-form-item label="应收账款余额" prop="accountsReceivableBalance">
          <el-input v-model="form.accountsReceivableBalance" placeholder="请输入应收账款余额" />
        </el-form-item>
        <el-form-item label="1年以内" prop="arWithin1Year">
          <el-input v-model="form.arWithin1Year" placeholder="请输入1年以内" />
        </el-form-item>
        <el-form-item label="1-2年" prop="ar1To2Years">
          <el-input v-model="form.ar1To2Years" placeholder="请输入1-2年" />
        </el-form-item>
        <el-form-item label="2-3年" prop="ar2To3Years">
          <el-input v-model="form.ar2To3Years" placeholder="请输入2-3年" />
        </el-form-item>
        <el-form-item label="3-4年" prop="ar3To4Years">
          <el-input v-model="form.ar3To4Years" placeholder="请输入3-4年" />
        </el-form-item>
        <el-form-item label="4-5年" prop="ar4To5Years">
          <el-input v-model="form.ar4To5Years" placeholder="请输入4-5年" />
        </el-form-item>
        <el-form-item label="5年以上" prop="ar5PlusYears">
          <el-input v-model="form.ar5PlusYears" placeholder="请输入5年以上" />
        </el-form-item>
        <el-form-item label="逾期应收账款" prop="overdueAr">
          <el-input v-model="form.overdueAr" placeholder="请输入逾期应收账款" />
        </el-form-item>
        <el-form-item label="逾期三年应收账款" prop="overdueAr3Years">
          <el-input v-model="form.overdueAr3Years" placeholder="请输入逾期三年应收账款" />
        </el-form-item>
        <el-form-item label="负责人" prop="responsiblePerson">
          <el-input v-model="form.responsiblePerson" placeholder="请输入负责人" />
        </el-form-item>
        <el-form-item label="二级单位负责人" prop="secondaryUnitPerson">
          <el-input v-model="form.secondaryUnitPerson" placeholder="请输入二级单位负责人" />
        </el-form-item>
        <el-form-item label="是否发送对账函" prop="reconciliationSent">
          <el-input v-model="form.reconciliationSent" placeholder="请输入是否发送对账函" />
        </el-form-item>
        <el-form-item label="已回函" prop="reconciliationReceived">
          <el-input v-model="form.reconciliationReceived" placeholder="请输入已回函" />
        </el-form-item>
        <el-form-item label="是否与应收账款一致" prop="reconciliationMatch">
          <el-input v-model="form.reconciliationMatch" placeholder="请输入是否与应收账款一致" />
        </el-form-item>
        <el-form-item label="合同约定回款时间" prop="agreedPaymentDate">
          <el-input v-model="form.agreedPaymentDate" placeholder="请输入合同约定回款时间" />
        </el-form-item>
        <el-form-item label="项目分类名称" prop="projectClassificationName">
          <el-input v-model="form.projectClassificationName" placeholder="请输入项目分类名称" />
        </el-form-item>
        <el-form-item label="合同资产科目名称" prop="contractAssetAccountName">
          <el-input v-model="form.contractAssetAccountName" placeholder="请输入合同资产科目名称" />
        </el-form-item>
        <el-form-item label="合同资产期末金额" prop="contractAssetEndingBalance">
          <el-input v-model="form.contractAssetEndingBalance" placeholder="请输入合同资产期末金额" />
        </el-form-item>
        <el-form-item label="插入日期" prop="insertDate">
          <el-date-picker clearable
            v-model="form.insertDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择插入日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTestInfo, getTestInfo, delTestInfo, addTestInfo, updateTestInfo } from "@/api/test/testInfo";

export default {
  name: "TestInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 合同信息表格数据
      testInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        secondaryUnitName: null,
        clientName: null,
        contractName: null,
        projectCode: null,
        region: null,
        clientType: null,
        clientCreditLevel: null,
        contractAmount: null,
        confirmedRevenue: null,
        returnedAmount: null,
        unconfirmedRevenue: null,
        revenueConfirmationDate: null,
        confirmedAfterInvoice: null,
        recoveredAmount: null,
        accountsReceivableBalance: null,
        arWithin1Year: null,
        ar1To2Years: null,
        ar2To3Years: null,
        ar3To4Years: null,
        ar4To5Years: null,
        ar5PlusYears: null,
        overdueAr: null,
        overdueAr3Years: null,
        responsiblePerson: null,
        secondaryUnitPerson: null,
        reconciliationSent: null,
        reconciliationReceived: null,
        litigationStatus: null,
        reconciliationMatch: null,
        agreedPaymentDate: null,
        projectClassificationName: null,
        contractAssetAccountName: null,
        contractAssetEndingBalance: null,
        insertDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        secondaryUnitName: [
          { required: true, message: "二级单位客户名称不能为空", trigger: "blur" }
        ],
        clientName: [
          { required: true, message: "客户名称不能为空", trigger: "blur" }
        ],
        contractName: [
          { required: true, message: "合同名称不能为空", trigger: "blur" }
        ],
        contractAmount: [
          { required: true, message: "合同金额不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询合同信息列表 */
    getList() {
      this.loading = true;
      listTestInfo(this.queryParams).then(response => {
        this.testInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        contractId: null,
        secondaryUnitName: null,
        clientName: null,
        contractName: null,
        projectCode: null,
        region: null,
        clientType: null,
        clientCreditLevel: null,
        contractAmount: null,
        confirmedRevenue: null,
        returnedAmount: null,
        unconfirmedRevenue: null,
        revenueConfirmationDate: null,
        confirmedAfterInvoice: null,
        recoveredAmount: null,
        accountsReceivableBalance: null,
        arWithin1Year: null,
        ar1To2Years: null,
        ar2To3Years: null,
        ar3To4Years: null,
        ar4To5Years: null,
        ar5PlusYears: null,
        overdueAr: null,
        overdueAr3Years: null,
        responsiblePerson: null,
        secondaryUnitPerson: null,
        reconciliationSent: null,
        reconciliationReceived: null,
        litigationStatus: null,
        reconciliationMatch: null,
        agreedPaymentDate: null,
        projectClassificationName: null,
        contractAssetAccountName: null,
        contractAssetEndingBalance: null,
        insertDate: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.contractId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加合同信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const contractId = row.contractId || this.ids
      getTestInfo(contractId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改合同信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.contractId != null) {
            updateTestInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTestInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const contractIds = row.contractId || this.ids;
      this.$modal.confirm('是否确认删除合同信息编号为"' + contractIds + '"的数据项？').then(function() {
        return delTestInfo(contractIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('test/testInfo/export', {
        ...this.queryParams
      }, `testInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
