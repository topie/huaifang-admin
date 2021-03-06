package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.common.utils.TreeNode;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.AuthUser;
import com.topie.huaifang.database.core.model.HouseInfo;
import com.topie.huaifang.database.core.model.HouseNode;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/houseInfo")
public class HouseInfoController {

    @Autowired
    private IHouseInfoService iHouseInfoService;

    @Autowired
    private IHouseNodeService iHouseNodeService;

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(HouseInfo houseInfo,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<HouseInfo> pageInfo = iHouseInfoService.selectByFilterAndPage(houseInfo, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_house_info");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(HouseInfo houseInfo) {
        String[] ads = houseInfo.getAddress().split(" ");
        for (int i = 0; i < ads.length; i++) {
            String d = ads[i];
            switch (i) {
                case 0:
                    houseInfo.setXq(d);
                    break;
                case 1:
                    houseInfo.setLh(d);
                    break;
                case 2:
                    houseInfo.setDy(d);
                    break;
                case 3:
                    houseInfo.setLc(d);
                    break;
            }
        }
        houseInfo.setHouseNo(houseInfo.getId() + houseInfo.getRoomNumber());
        int result = iHouseInfoService.saveNotNull(houseInfo);

        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(HouseInfo houseInfo) {
        houseInfo.setXq("");
        houseInfo.setLh("");
        houseInfo.setDy("");
        houseInfo.setLc("");
        String[] ads = houseInfo.getAddress().split(" ");
        for (int i = 0; i < ads.length; i++) {
            String d = ads[i];
            switch (i) {
                case 0:
                    houseInfo.setXq(d);
                    break;
                case 1:
                    houseInfo.setLh(d);
                    break;
                case 2:
                    houseInfo.setDy(d);
                    break;
                case 3:
                    houseInfo.setLc(d);
                    break;
            }
        }
        houseInfo.setHouseNo(houseInfo.getId() + houseInfo.getRoomNumber());
        iHouseInfoService.updateNotNull(houseInfo);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        HouseInfo houseInfo = iHouseInfoService.selectByKey(id);
        return ResponseUtil.success(houseInfo);
    }

    @RequestMapping(value = "/loadByAppUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result loadByAppUser(@PathVariable(value = "id") Integer id) {
        AuthUser authUser = new AuthUser();
        authUser.setUserId(id);
        List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
        if (CollectionUtils.isNotEmpty(authUsers)) {
            Integer houseId = authUsers.get(0).getHouseId();
            HouseInfo houseInfo = iHouseInfoService.selectByKey(houseId);
            return ResponseUtil.success(houseInfo);
        } else {
            return ResponseUtil.success();
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iHouseInfoService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/treeNodes")
    @ResponseBody
    public Object treeNodes(@RequestParam(value = "personId", required = false) Integer personId) {
        HouseNode houseNode = new HouseNode();
        List<TreeNode> nodes = new ArrayList<>();
        List<HouseNode> list = iHouseNodeService.selectByFilter(houseNode);
        for (HouseNode nodeInfo : list) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(nodeInfo.getId());
            treeNode.setpId(nodeInfo.getPid());
            treeNode.setName(nodeInfo.getName());
            treeNode.setIcon("upload/node.png");
            nodes.add(treeNode);
        }
        AuthUser cu = new AuthUser();
        if (personId != null) {
            AuthUser authUser = new AuthUser();
            authUser.setPersonId(personId);
            List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
            if (CollectionUtils.isNotEmpty(authUsers)) {
                cu = authUsers.get(0);
            }
        }
        List<HouseInfo> houseInfos = iHouseInfoService.selectAll();
        for (HouseInfo houseInfo : houseInfos) {
            TreeNode treeNode = new TreeNode();
            treeNode.setIcon("upload/house.png");
            treeNode.setId(-houseInfo.getId());
            treeNode.setpId(houseInfo.getHouseNodeId());
            treeNode.setName(houseInfo.getRoomNumber());
            if (cu.getHouseId() != null && cu.getHouseId().intValue() == houseInfo.getId().intValue()) {
                treeNode.setChecked(true);
            }
            nodes.add(treeNode);
        }
        return nodes;
    }

    @RequestMapping(value = "/bindUsers", method = RequestMethod.GET)
    @ResponseBody
    public Result bindUsers(@RequestParam(value = "id") Integer id) {
        AuthUser authUser = new AuthUser();
        authUser.setHouseId(id);
        List<AuthUser> authUsers = iAuthUserService.selectByFilter(authUser);
        List<Integer> userList = new ArrayList<>();
        for (AuthUser aUser : authUsers) {
            userList.add(aUser.getUserId());
        }
        List<AppUser> appUsers = new ArrayList<>();
        if (userList.size() > 0) {
            AppUser appUser = new AppUser();
            appUser.setUserIds(userList);
            appUsers = iAppUserService.selectByFilter(appUser);
        }
        return ResponseUtil.success(PageConvertUtil.grid(appUsers));
    }

}
