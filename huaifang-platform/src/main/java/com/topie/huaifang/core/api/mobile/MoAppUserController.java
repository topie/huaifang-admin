package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.dto.AuthDto;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.service.UserService;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/appUser")
public class MoAppUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private IAppMessageService iAppMessageService;

    @Autowired
    private IAppUserMessageService iAppUserMessageService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private IPersonInfoService iPersonInfoService;

    @Autowired
    private IPersonInfoRentService iPersonInfoRentService;

    @Autowired
    private IPersonInfoLiveService iPersonInfoLiveService;

    @Autowired
    private IHouseInfoService iHouseInfoService;

    @Autowired
    private ICompanyInfoService iCompanyInfoService;

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    @ResponseBody
    public Result friends() {
        Integer userId = SecurityUtil.getCurrentUserId();
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        List<AppUser> friends = iAppUserService.selectAllAppUserFriends(appUser.getId());
        return ResponseUtil.success(PageConvertUtil.grid(friends));
    }

    @RequestMapping(value = "/maybeKnown", method = RequestMethod.GET)
    @ResponseBody
    public Result maybeKnown(AppUser appUser,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        Integer userId = SecurityUtil.getCurrentUserId();
        AppUser app = iAppUserService.selectByPlatformId(userId);
        if (app == null) return ResponseUtil.error("用户不存在");
        List<AppUser> friends = iAppUserService.selectAllAppUserFriends(app.getId());
        List<Integer> notInUserList = new ArrayList<>();
        notInUserList.add(app.getId());
        for (AppUser friend : friends) {
            notInUserList.add(friend.getId());
        }
        if (CollectionUtils.isNotEmpty(notInUserList)) {
            appUser.setNotInUserIds(notInUserList);
        }
        PageInfo<AppUser> pageInfo = iAppUserService.selectByFilterAndPage(appUser, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@RequestParam(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByKey(id);
        return ResponseUtil.success(appUser);
    }

    @RequestMapping(value = "/addFriend", method = RequestMethod.GET)
    @ResponseBody
    public Result addFriend(@RequestParam(value = "id") Integer id) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        iAppUserService.insertToAddFriend(appUser.getId(), id);
        iAppMessageService.sendSystemAppMessage(id, appUser.getHeadImage(), appUser.getNickname() + "添加好友",
                appUser.getNickname() + "添加您为好友");
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result sendMessage(@RequestParam(value = "userId") Integer userId,
            @RequestParam(value = "content") String content) {
        Integer cUserId = SecurityUtil.getCurrentUserId();
        if (cUserId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(cUserId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        iAppUserMessageService
                .insertToSendUserAppMessage(cUserId, appUser.getNickname(), appUser.getHeadImage(), userId, content);
        iAppMessageService.sentUserAppMessage(cUserId, userId, appUser.getNickname() + "发来新的消息");
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePassword(@RequestParam("id") Integer id, @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        AppUser appUser = iAppUserService.selectByKey(id);
        if (oldPassword.equals(appUser.getPassword())) {
            userService.updatePassword(appUser.getPlatformId(), appUser.getPassword());
            appUser.setPassword(newPassword);
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result updateInfo(@RequestParam(value = "headImage", required = false) String headImage,
            @RequestParam(value = "nickName", required = false) String nickName) {
        Integer cUserId = SecurityUtil.getCurrentUserId();
        if (cUserId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(cUserId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        if (StringUtils.isNotEmpty(headImage)) {
            appUser.setHeadImage(headImage);
        }
        if (StringUtils.isNotEmpty(nickName)) {
            appUser.setNickname(nickName);
        }
        iAppUserService.updateNotNull(appUser);
        return ResponseUtil.success(appUser);
    }

    @RequestMapping(value = "/currentAppUser", method = RequestMethod.GET)
    @ResponseBody
    public Result currentAppUser() {
        Map result = new HashMap();
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        result.put("base", appUser);
        if (appUser.getStatus() == 2) {
            Map m = new HashMap<>();
            AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
            PersonInfo personInfo = iPersonInfoService.selectByKey(authUser.getPersonId());
            HouseInfo houseInfo = iHouseInfoService.selectByKey(authUser.getHouseId());
            m.put("xq", houseInfo.getXq());
            m.put("lh", houseInfo.getLh());
            m.put("dy", houseInfo.getDy());
            m.put("lc", houseInfo.getLc());
            m.put("mp", houseInfo.getRoomNumber());
            m.put("name", personInfo.getpName());
            m.put("idn", personInfo.getpIdentifyNumber());
            m.put("sf", personInfo.getpPersonType());
            result.put("shenfen", m);
        }
        return ResponseUtil.success(appUser);
    }

    @RequestMapping(value = "/authInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result authInfo() {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        if (appUser.getStatus() != 2) {
            return ResponseUtil.error("未认证");
        } else {
            Map result = new HashMap<>();
            AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
            PersonInfo personInfo = iPersonInfoService.selectByKey(authUser.getPersonId());
            HouseInfo houseInfo = iHouseInfoService.selectByKey(authUser.getHouseId());
            CompanyInfo companyInfo = iCompanyInfoService.selectByKey(authUser.getCompanyId());
            result.put("xq", houseInfo.getXq());
            result.put("lh", houseInfo.getLh());
            result.put("dy", houseInfo.getDy());
            result.put("lc", houseInfo.getLc());
            result.put("mp", houseInfo.getRoomNumber());
            result.put("name", personInfo.getpName());
            result.put("idn", personInfo.getpIdentifyNumber());
            result.put("sf", personInfo.getpPersonType());
            result.put("company", companyInfo.getCompanyName());
            return ResponseUtil.success(result);
        }
    }

    @RequestMapping(value = "/auth")
    @ResponseBody
    public Result auth(@RequestBody AuthDto authDto) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error(401, "未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
        PersonInfo personInfo = new PersonInfo();
        if (authUser != null && authUser.getPersonId() != null && authUser.getPersonId() > 0) {
            personInfo = iPersonInfoService.selectByKey(authUser.getPersonId());
        }
        personInfo.setpName(authDto.getpName());
        personInfo.setpIdentifyNumber(authDto.getpIdentifyNumber());
        personInfo.setpPersonType(authDto.getpPersonType());
        Integer houseId = authDto.getHouseId();
        personInfo.setpImportTime(new Date());
        personInfo.setpMobilePhone(appUser.getMobilePhone());
        HouseInfo houseInfo = iHouseInfoService.selectByKey(houseId);
        personInfo.setpHouseNodeId(houseId);
        personInfo.setpHouseInfo(houseInfo.getAddress() + " " + houseInfo.getRoomNumber());
        if (personInfo.getpId() != null) {
            iPersonInfoService.updateNotNull(personInfo);//人口信息
        } else {
            iPersonInfoService.saveNotNull(personInfo);//人口信息
        }
        if ("租户".equals(personInfo.getpPersonType())) {
            PersonInfoRent personInfoRent = new PersonInfoRent();
            personInfoRent.setrPersonId(personInfo.getpId());
            personInfoRent.setrContact(personInfo.getpMobilePhone());
            personInfoRent.setrIdentifyNumber(personInfo.getpIdentifyNumber());
            personInfoRent.setrName(personInfo.getpName());
            iPersonInfoRentService.saveNotNull(personInfoRent);
        } else {
            PersonInfoLive personInfoLive = new PersonInfoLive();
            personInfoLive.setlPersonId(personInfo.getpId());
            personInfoLive.setlContact(personInfo.getpMobilePhone());
            personInfoLive.setlIdentifyNumber(personInfo.getpIdentifyNumber());
            personInfoLive.setlName(personInfo.getpName());
            iPersonInfoLiveService.saveNotNull(personInfoLive);
        }
        if (authUser != null) {
            authUser.setCompanyId(authDto.getCompanyId());
            authUser.setHouseId(houseId);
            authUser.setPersonId(personInfo.getpId());
            iAuthUserService.updateNotNull(authUser);//认证关系
        }
        appUser.setStatus(1);
        appUser.setRealname(personInfo.getpName());
        appUser.setNickname(personInfo.getpName());
        iAppUserService.updateNotNull(appUser);
        return ResponseUtil.success();
    }

}
