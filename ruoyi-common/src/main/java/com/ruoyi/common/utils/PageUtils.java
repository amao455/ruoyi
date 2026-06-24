package com.ruoyi.common.utils;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 * 
 * @author ruoyi
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        // 从HTTP请求中提取分页参数（页码、每页条数、排序字段等）
        PageDomain pageDomain = TableSupport.buildPageRequest();
        // 获取页码
        Integer pageNum = pageDomain.getPageNum();
        // 获取每页显示条数
        Integer pageSize = pageDomain.getPageSize();
        // 获取排序字符串并进行SQL注入防护转义
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        // 获取接理性标志（防止页码越界）
        Boolean reasonable = pageDomain.getReasonable();
        // 启动PageHelper分页插件，将参数存入ThreadLocal中
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);// setReasonable()函数的作用是设置分页查询时是否启用合理化模式
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
