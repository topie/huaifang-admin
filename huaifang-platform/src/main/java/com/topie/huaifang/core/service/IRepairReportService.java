package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.RepairReport;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IRepairReportService extends IService<RepairReport> {

    PageInfo<RepairReport> selectByFilterAndPage(RepairReport repairReport, int pageNum, int pageSize);

    List<RepairReport> selectByFilter(RepairReport repairReport);
}
