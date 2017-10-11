package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.exception.AuBzConstant;
import com.topie.huaifang.security.exception.AuthBusinessException;
import com.topie.huaifang.security.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private IHouseInfoService iHouseInfoService;

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
    public Result insertRent(@Valid PersonInfo personInfo, PersonInfoRent personInfoRent, BindingResult result) {
        if (result.hasErrors()) return ResponseUtil.error(result.getFieldError().getDefaultMessage());
        personInfo.setpImportTime(new Date());
        iPersonInfoService.saveNotNull(personInfo);
        User user = new User();
        user.setLoginName(personInfo.getpMobilePhone());
        user.setContactPhone(personInfo.getpMobilePhone());
        user.setDisplayName(personInfo.getpName());
        user.setPassword(personInfo.getpIdentifyNumber().substring(personInfo.getpIdentifyNumber().length() - 6));
        if (userService.findExistUser(user) > 0) {
            throw new AuthBusinessException(AuBzConstant.MOBILE_EXIST);
        }
        userService.insertUser(user);
        AppUser appUser = new AppUser();
        appUser.setRegTime(new Date());
        appUser.setNickname(personInfo.getpName());
        appUser.setRealname(personInfo.getpName());
        appUser.setPlatformId(user.getId());
        appUser.setPassword(personInfo.getpIdentifyNumber().substring(personInfo.getpIdentifyNumber().length() - 6));
        appUser.setAddTime(new Date());
        appUser.setMobilePhone(personInfo.getpMobilePhone());
        appUser.setLoginStatus(1);
        appUser.setStatus(0);
        iAppUserService.saveNotNull(appUser);
        personInfoRent.setrPersonId(personInfo.getpId());
        personInfoRent.setrName(personInfo.getpName());
        personInfoRent.setrIdentifyNumber(personInfo.getpIdentifyNumber());
        personInfoRent.setrContact(personInfo.getpMobilePhone());
        iPersonInfoRentService.saveNotNull(personInfoRent);
        AuthUser authUser = new AuthUser();
        authUser.setUserId(appUser.getId());
        authUser.setPersonId(personInfo.getpId());
        iAuthUserService.saveNotNull(authUser);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/insertLive", method = RequestMethod.POST)
    @ResponseBody
    public Result insertLive(@Valid PersonInfo personInfo, PersonInfoLive personInfoLive, BindingResult result) {
        if (result.hasErrors()) return ResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        personInfo.setpImportTime(new Date());
        iPersonInfoService.saveNotNull(personInfo);
        User user = new User();
        user.setLoginName(personInfo.getpMobilePhone());
        user.setContactPhone(personInfo.getpMobilePhone());
        user.setDisplayName(personInfo.getpName());
        user.setPassword(personInfo.getpIdentifyNumber().substring(personInfo.getpIdentifyNumber().length() - 6));
        if (userService.findExistUser(user) > 0) {
            throw new AuthBusinessException(AuBzConstant.MOBILE_EXIST);
        }
        userService.insertUser(user);
        AppUser appUser = new AppUser();
        appUser.setRegTime(new Date());
        appUser.setNickname(personInfo.getpName());
        appUser.setRealname(personInfo.getpName());
        appUser.setPlatformId(user.getId());
        appUser.setPassword(personInfo.getpIdentifyNumber().substring(personInfo.getpIdentifyNumber().length() - 6));
        appUser.setAddTime(new Date());
        appUser.setMobilePhone(personInfo.getpMobilePhone());
        appUser.setLoginStatus(1);
        appUser.setStatus(0);
        iAppUserService.saveNotNull(appUser);
        personInfoLive.setlPersonId(personInfo.getpId());
        personInfoLive.setlName(personInfo.getpName());
        personInfoLive.setlIdentifyNumber(personInfo.getpIdentifyNumber());
        personInfoLive.setlContact(personInfo.getpMobilePhone());
        iPersonInfoLiveService.saveNotNull(personInfoLive);
        AuthUser authUser = new AuthUser();
        authUser.setUserId(appUser.getId());
        authUser.setPersonId(personInfo.getpId());
        iAuthUserService.saveNotNull(authUser);
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

    @RequestMapping(value = "/loadByAppUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadByAppUser(@PathVariable(value = "id") Integer id) {
        AuthUser authUser = new AuthUser();
        authUser.setUserId(id);
        List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
        if (CollectionUtils.isNotEmpty(authUsers)) {
            Integer pId = authUsers.get(0).getPersonId();
            PersonInfo personInfo = iPersonInfoService.selectByKey(pId);
            return ResponseUtil.success(personInfo);
        } else {
            return ResponseUtil.success();
        }

    }

    @RequestMapping(value = "/loadRentByAppUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadRentByAppUser(@PathVariable(value = "id") Integer id) {
        AuthUser authUser = new AuthUser();
        authUser.setUserId(id);
        List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
        if (CollectionUtils.isNotEmpty(authUsers)) {
            Integer pId = authUsers.get(0).getPersonId();
            PersonInfoRent personInfoRent = iPersonInfoRentService.selectByPersonId(pId);
            return ResponseUtil.success(personInfoRent);
        } else {
            return ResponseUtil.success();
        }

    }

    @RequestMapping(value = "/loadLiveByAppUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadLiveByAppUser(@PathVariable(value = "id") Integer id) {
        AuthUser authUser = new AuthUser();
        authUser.setUserId(id);
        List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
        if (CollectionUtils.isNotEmpty(authUsers)) {
            Integer pId = authUsers.get(0).getPersonId();
            PersonInfoLive personInfoLive = iPersonInfoLiveService.selectByPersonId(pId);
            return ResponseUtil.success(personInfoLive);
        } else {
            return ResponseUtil.success();
        }

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

    @RequestMapping(value = "/bindHouse")
    @ResponseBody
    public Result bindHouse(@RequestParam(value = "personId") Integer personId,
            @RequestParam(value = "houseId") Integer houseId) {
        if (houseId > 0) ResponseUtil.error("请选择房屋节点绑定");
        houseId = -houseId;
        AuthUser authUser = new AuthUser();
        authUser.setPersonId(personId);
        List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
        if (CollectionUtils.isNotEmpty(authUsers)) {
            authUser = authUsers.get(0);
            authUser.setHouseId(houseId);
            iAuthUserService.updateNotNull(authUser);
            HouseInfo houseInfo = iHouseInfoService.selectByKey(houseId);
            PersonInfo personInfo = iPersonInfoService.selectByKey(personId);
            personInfo.setpHouseNodeId(houseId);
            personInfo.setpHouseInfo(houseInfo.getAddress() + " " + houseInfo.getRoomNumber());
            iPersonInfoService.updateNotNull(personInfo);
        } else {
            return ResponseUtil.error("改人口信息未绑定平台账号");
        }
        return ResponseUtil.success();
    }

}
