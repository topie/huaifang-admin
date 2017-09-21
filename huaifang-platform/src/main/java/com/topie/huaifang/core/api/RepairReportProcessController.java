package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IRepairReportProcessService;
import com.topie.huaifang.core.service.IRepairReportService;
import com.topie.huaifang.database.core.model.RepairReport;
import com.topie.huaifang.database.core.model.RepairReportProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/repairReportProcess")
public class RepairReportProcessController {

    @Autowired
    private IRepairReportProcessService iRepairReportProcessService;

    @Autowired
    private IRepairReportService iRepairReportService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(RepairReportProcess repairReportProcess,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<RepairReportProcess> pageInfo = iRepairReportProcessService
                .selectByFilterAndPage(repairReportProcess, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_repair_report_process");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(RepairReportProcess repairReportProcess) {
        int result = iRepairReportProcessService.saveNotNull(repairReportProcess);
        Integer reportId = repairReportProcess.getReportId();
        RepairReport repairReport = iRepairReportService.selectByKey(reportId);
        if ("未反馈".equals(repairReport.getStatus())) {
            repairReport.setStatus("待维修");
            iRepairReportService.updateNotNull(repairReport);
        }
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(RepairReportProcess repairReportProcess) {
        iRepairReportProcessService.updateNotNull(repairReportProcess);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        RepairReportProcess repairReportProcess = iRepairReportProcessService.selectByKey(id);
        return ResponseUtil.success(repairReportProcess);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iRepairReportProcessService.delete(id);
        return ResponseUtil.success();
    }

}
