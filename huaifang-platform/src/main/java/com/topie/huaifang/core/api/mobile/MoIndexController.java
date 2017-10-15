package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenguojun on 2017/4/19.
 * 1.消息
 * a.前3个问卷调查
 * b.前3个社区公告
 * c.前3个物业公告
 * 2.前8个可能认识的人
 */
@Controller
@RequestMapping("/api/m/index")
public class MoIndexController {

    @Autowired
    private INoticeService iNoticeService;

    @Autowired
    private IQuestionnaireInfoService iQuestionnaireInfoService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private IPersonInfoService iPersonInfoService;

    @Autowired
    private IHouseInfoService iHouseInfoService;

    @RequestMapping(value = "/maybeKnown", method = RequestMethod.GET)
    @ResponseBody
    public Result maybeKnown(AppUser appUser,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "8") int pageSize) {
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

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    @ResponseBody
    public Result news() {
        Map result = new HashMap<>();

        QuestionnaireInfo questionnaireInfo = new QuestionnaireInfo();
        PageInfo<QuestionnaireInfo> pageInfo = iQuestionnaireInfoService.selectByFilterAndPage(questionnaireInfo, 1, 3);
        List<Map> list1 = new ArrayList<>();
        for (QuestionnaireInfo info : pageInfo.getList()) {
            Map m = new HashMap();
            m.put("id", info.getId());
            m.put("title", info.getName());
            list1.add(m);
        }
        result.put("1", list1);
        Notice notice = new Notice();
        notice.setIsOnline(true);
        notice.setType(0);
        PageInfo<Notice> pageInfo2 = iNoticeService.selectByFilterAndPage(notice, 1, 3);
        List<Map> list2 = new ArrayList<>();
        for (Notice n : pageInfo2.getList()) {
            Map m = new HashMap();
            m.put("id", n.getId());
            m.put("title", n.getTitle());
            list2.add(m);
        }
        result.put("2", list2);

        notice.setType(1);
        pageInfo2 = iNoticeService.selectByFilterAndPage(notice, 1, 3);
        List<Map> list3 = new ArrayList<>();
        for (Notice n : pageInfo2.getList()) {
            Map m = new HashMap();
            m.put("id", n.getId());
            m.put("title", n.getTitle());
            list3.add(m);
        }
        result.put("3", list3);
        return ResponseUtil.success(result);
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result currentAppUser() {
        Map result = new HashMap();
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        result.put("base", appUser);
        result.put("status", appUser.getStatus());
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
        return ResponseUtil.success(result);
    }

    @RequestMapping(value = "/head", method = RequestMethod.GET)
    @ResponseBody
    public Result head() {
        Map result = new HashMap();
        result.put("head", "upload/head.jpg");
        return ResponseUtil.success(result);
    }

}
