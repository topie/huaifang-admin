package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppManagerService;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.database.core.model.AppManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/appManager")
public class AppManagerController {

    @Autowired
    private IAppManagerService iAppManagerService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AppManager appManager,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<AppManager> pageInfo = iAppManagerService.selectByFilterAndPage(appManager, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_app_manager");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(AppManager appManager) {
        appManager.setPublishTime(new Date());
        int result = iAppManagerService.saveNotNull(appManager);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(AppManager appManager) {
        iAppManagerService.updateNotNull(appManager);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        AppManager appManager = iAppManagerService.selectByKey(id);
        return ResponseUtil.success(appManager);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iAppManagerService.delete(id);
        return ResponseUtil.success();
    }

}
