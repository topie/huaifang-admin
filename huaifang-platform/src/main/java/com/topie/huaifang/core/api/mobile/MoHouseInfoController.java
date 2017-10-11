package com.topie.huaifang.core.api.mobile;

import com.topie.huaifang.common.utils.*;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/houseInfo")
public class MoHouseInfoController {

    @Autowired
    private IHouseInfoService iHouseInfoService;

    @Autowired
    private IHouseNodeService iHouseNodeService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private IPersonInfoService iPersonInfoService;

    @RequestMapping(value = "/node", method = RequestMethod.GET)
    @ResponseBody
    public Result treeNodes(@RequestParam(value = "parentId", required = false, defaultValue = "-1") Integer parentId) {
        List<TreeNode> nodes = new ArrayList<>();
        HouseNode houseNode = new HouseNode();
        houseNode.setPid(parentId);
        List<HouseNode> list = iHouseNodeService.selectByFilter(houseNode);
        for (HouseNode nodeInfo : list) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(nodeInfo.getId());
            treeNode.setpId(nodeInfo.getPid());
            treeNode.setName(nodeInfo.getName());
            nodes.add(treeNode);
        }
        return ResponseUtil.success(PageConvertUtil.grid(nodes));
    }

    @RequestMapping(value = "/house", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam("nodeId") Integer nodeId) {
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setHouseNodeId(nodeId);
        List<HouseInfo> list = iHouseInfoService.selectByFilter(houseInfo);
        return ResponseUtil.success(PageConvertUtil.grid(list));
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    @ResponseBody
    public Result auth(@RequestParam("houseId") Integer houseId, PersonInfo personInfo) {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error("未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        personInfo.setpImportTime(new Date());
        iPersonInfoService.saveNotNull(personInfo);//人口信息
        AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
        authUser.setHouseId(houseId);
        authUser.setPersonId(personInfo.getpId());
        iAuthUserService.updateNotNull(authUser);//认证关系
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/myHouse", method = RequestMethod.GET)
    @ResponseBody
    public Result myHouse() {
        Integer userId = SecurityUtil.getCurrentUserId();
        if (userId == null) return ResponseUtil.error("未登录");
        AppUser appUser = iAppUserService.selectByPlatformId(userId);
        if (appUser == null) return ResponseUtil.error("用户不存在");
        AuthUser authUser = iAuthUserService.selectByKey(appUser.getId());
        if (authUser == null || authUser.getHouseId() == 0) {
            return ResponseUtil.error("未认证");
        }
        HouseInfo houseInfo = iHouseInfoService.selectByKey(authUser.getHouseId());
        return ResponseUtil.success(houseInfo);
    }
}
