package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IHouseInfoService;
import com.topie.huaifang.core.service.IHouseNodeService;
import com.topie.huaifang.database.core.model.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private ICommonQueryService iCommonQueryService;

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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iHouseInfoService.delete(id);
        return ResponseUtil.success();
    }

}
