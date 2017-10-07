package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IPersonInfoLiveService;
import com.topie.huaifang.database.core.model.PersonInfoLive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/personInfoLive")
public class PersonInfoLiveController {

    @Autowired
    private IPersonInfoLiveService iPersonInfoLiveService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(PersonInfoLive personInfoLive,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PersonInfoLive> pageInfo = iPersonInfoLiveService
                .selectByFilterAndPage(personInfoLive, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_person_info_live");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(PersonInfoLive personInfoLive) {
        int result = iPersonInfoLiveService.saveNotNull(personInfoLive);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(PersonInfoLive personInfoLive) {
        iPersonInfoLiveService.updateNotNull(personInfoLive);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        PersonInfoLive personInfoLive = iPersonInfoLiveService.selectByKey(id);
        return ResponseUtil.success(personInfoLive);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iPersonInfoLiveService.delete(id);
        return ResponseUtil.success();
    }

}
