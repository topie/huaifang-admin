package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.PersonInfo;
import com.topie.huaifang.database.core.model.PersonInfoLive;
import com.topie.huaifang.database.core.model.PersonInfoRent;
import com.topie.huaifang.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/personInfo")
public class PersonInfoController {

    @Autowired
    private IPersonInfoService iPersonInfoService;

    @Autowired
    private IPersonInfoLiveService iPersonInfoLiveService;

    @Autowired
    private IPersonInfoRentService iPersonInfoRentService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @Autowired
    private UserService userService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(PersonInfo personInfo,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<PersonInfo> pageInfo = iPersonInfoService.selectByFilterAndPage(personInfo, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_person_info");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insertRent", method = RequestMethod.POST)
    @ResponseBody
    public Result insertRent(PersonInfo personInfo, PersonInfoRent personInfoRent) {
        personInfo.setpImportTime(new Date());
        iPersonInfoService.saveNotNull(personInfo);
        personInfoRent.setrPersonId(personInfo.getpId());
        iPersonInfoRentService.saveNotNull(personInfoRent);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/insertLive", method = RequestMethod.POST)
    @ResponseBody
    public Result insertLive(PersonInfo personInfo, PersonInfoLive personInfoLive) {
        personInfo.setpImportTime(new Date());
        iPersonInfoService.saveNotNull(personInfo);
        personInfoLive.setlPersonId(personInfo.getpId());
        iPersonInfoLiveService.saveNotNull(personInfoLive);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/updateRent", method = RequestMethod.POST)
    @ResponseBody
    public Result updateRent(PersonInfo personInfo, PersonInfoRent personInfoRent) {
        iPersonInfoService.updateNotNull(personInfo);
        personInfoRent.setrPersonId(personInfo.getpId());
        iPersonInfoRentService.updateNotNull(personInfoRent);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/updateLive", method = RequestMethod.POST)
    @ResponseBody
    public Result updateLive(PersonInfo personInfo, PersonInfoLive personInfoLive) {
        iPersonInfoService.updateNotNull(personInfo);
        personInfoLive.setlPersonId(personInfo.getpId());
        iPersonInfoLiveService.updateNotNull(personInfoLive);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/loadLive/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadLive(@PathVariable(value = "id") Integer id) {
        PersonInfo personInfo = iPersonInfoService.selectByKey(id);
        PersonInfoLive personInfoLive = iPersonInfoLiveService.selectByPersonId(id);
        List list = new ArrayList();
        list.add(personInfo);
        list.add(personInfoLive);
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/loadRent/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadRent(@PathVariable(value = "id") Integer id) {
        PersonInfo personInfo = iPersonInfoService.selectByKey(id);
        PersonInfoRent personInfoRent = iPersonInfoRentService.selectByPersonId(id);
        List list = new ArrayList();
        list.add(personInfo);
        list.add(personInfoRent);
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iPersonInfoService.delete(id);
        PersonInfoRent personInfoRent = iPersonInfoRentService.selectByPersonId(id);
        if (personInfoRent != null) iPersonInfoRentService.delete(personInfoRent.getrId());
        PersonInfoLive personInfoLive = iPersonInfoLiveService.selectByPersonId(id);
        if (personInfoLive != null) iPersonInfoLiveService.delete(personInfoLive.getlId());
        return ResponseUtil.success();
    }

}
