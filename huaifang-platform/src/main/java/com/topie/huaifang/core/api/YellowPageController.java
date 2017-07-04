package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.Option;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.enums.YellowPageType;
import com.topie.huaifang.core.service.IYellowPageService;
import com.topie.huaifang.database.core.model.YellowPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/core/yellowPage")
public class YellowPageController {

    @Autowired
    private IYellowPageService iYellowPageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(YellowPage yellowPage,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<YellowPage> pageInfo = iYellowPageService.selectByFilterAndPage(yellowPage, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(YellowPage yellowPage) {
        int result = iYellowPageService.saveNotNull(yellowPage);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(YellowPage yellowPage) {
        iYellowPageService.updateNotNull(yellowPage);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        YellowPage yellowPage = iYellowPageService.selectByKey(id);
        return ResponseUtil.success(yellowPage);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iYellowPageService.delete(id);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/options", method = RequestMethod.GET)
    @ResponseBody
    public List<Option> options() {
        List<Option> options = new ArrayList<>();
        for (YellowPageType item : YellowPageType.getItemList()) {
            options.add(new Option(item.getName(), item.getCode()));
        }
        return options;
    }

}
