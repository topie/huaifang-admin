package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.IRepairReportProcessService;
import com.topie.huaifang.core.service.IRepairReportService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.RepairReport;
import com.topie.huaifang.database.core.model.RepairReportProcess;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/repairReport")
public class MoRepairReportController {

    @Autowired
    private IRepairReportService iRepairReportService;

    @Autowired
    private IRepairReportProcessService iRepairReportProcessService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(RepairReport repairReport,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401,"未登录");
        repairReport.setContactUserId(appUser.getId());
        PageInfo<RepairReport> pageInfo = iRepairReportService.selectByFilterAndPage(repairReport, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Result post(@RequestBody RepairReport repairReport) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401,"未登录");
        repairReport.setContactUserId(appUser.getId());
        repairReport.setStatus("未处理");
        int result = iRepairReportService.saveNotNull(repairReport);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/process/list", method = RequestMethod.GET)
    @ResponseBody
    public Result processList(@RequestParam(value = "id") Integer id) {
        RepairReportProcess rrp = new RepairReportProcess();
        rrp.setReportId(id);
        List<RepairReportProcess> list = iRepairReportProcessService.selectByFilter(rrp);
        return ResponseUtil.success(PageConvertUtil.grid(list));
    }

    @RequestMapping(value = "/process/post", method = RequestMethod.GET)
    @ResponseBody
    public Result processPost(@RequestBody RepairReportProcess repairReportProcess) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401,"未登录");
        repairReportProcess.setContactUserId(appUser.getId());
        repairReportProcess.setProcessTime(new Date());
        iRepairReportProcessService.saveNotNull(repairReportProcess);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iRepairReportService.delete(id);
        return ResponseUtil.success();
    }

}
