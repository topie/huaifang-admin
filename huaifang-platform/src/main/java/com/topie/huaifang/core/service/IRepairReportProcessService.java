package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.RepairReportProcess;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IRepairReportProcessService extends IService<RepairReportProcess> {

    PageInfo<RepairReportProcess> selectByFilterAndPage(RepairReportProcess repairReportProcess, int pageNum, int pageSize);

    List<RepairReportProcess> selectByFilter(RepairReportProcess repairReportProcess);
}
