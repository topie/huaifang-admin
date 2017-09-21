package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.dto.QuestionAnswerDto;
import com.topie.huaifang.core.dto.QuestionItemDto;
import com.topie.huaifang.core.service.*;
import com.topie.huaifang.database.core.model.*;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/question")
public class MoQuestionController {

    @Autowired
    private IQuestionnaireInfoService iQuestionnaireInfoService;

    @Autowired
    private IQuestionnaireItemService iQuestionnaireItemService;

    @Autowired
    private IQuestionnaireOptionService iQuestionnaireOptionService;

    @Autowired
    private IQuestionnaireResultService iQuestionnaireResultService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(QuestionnaireInfo questionnaireInfo,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<QuestionnaireInfo> pageInfo = iQuestionnaireInfoService
                .selectByFilterAndPage(questionnaireInfo, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public Result itemList(QuestionnaireItem questionnaireItem) {
        List<QuestionnaireItem> list = iQuestionnaireItemService.selectByFilter(questionnaireItem);
        for (QuestionnaireItem item : list) {
            QuestionnaireOption o = new QuestionnaireOption();
            o.setItemId(item.getId());
            List<QuestionnaireOption> optionList = iQuestionnaireOptionService.selectByFilter(o);
            List<Map> options = new ArrayList<>();
            for (QuestionnaireOption option : optionList) {
                Map m = new HashMap();
                m.put("optionId", option.getId());
                m.put("optionText", option.getText());
                options.add(m);
            }
            item.setOptions(options);
        }
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Result post(@RequestBody QuestionAnswerDto questionAnswerDto) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error("未登录");
        for (QuestionItemDto questionItemDto : questionAnswerDto.getItems()) {
            QuestionnaireResult result = new QuestionnaireResult();
            result.setInfoId(questionAnswerDto.getInfoId());
            result.setItemId(questionItemDto.getItemId());
            result.setOptionId(questionItemDto.getOptionId());
            result.setUserId(appUser.getId());
            iQuestionnaireResultService.saveNotNull(result);
        }
        return ResponseUtil.success();
    }

}
