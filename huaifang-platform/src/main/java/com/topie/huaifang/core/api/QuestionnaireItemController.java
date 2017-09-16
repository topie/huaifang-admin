package com.topie.huaifang.core.api;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.tools.plugins.FormItem;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ICommonQueryService;
import com.topie.huaifang.core.service.IQuestionnaireItemService;
import com.topie.huaifang.core.service.IQuestionnaireOptionService;
import com.topie.huaifang.database.core.model.QuestionnaireItem;
import com.topie.huaifang.database.core.model.QuestionnaireOption;
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
@RequestMapping("/api/core/questionnaireItem")
public class QuestionnaireItemController {

    @Autowired
    private IQuestionnaireItemService iQuestionnaireItemService;

    @Autowired
    private IQuestionnaireOptionService iQuestionnaireOptionService;

    @Autowired
    private ICommonQueryService iCommonQueryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(QuestionnaireItem questionnaireItem,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<QuestionnaireItem> pageInfo = iQuestionnaireItemService
                .selectByFilterAndPage(questionnaireItem, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/formItems", method = RequestMethod.GET)
    @ResponseBody
    public Result formItems() {
        List<FormItem> list = iCommonQueryService.selectFormItemsByTable("d_questionnaire_item");
        return ResponseUtil.success(list);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insert(QuestionnaireItem questionnaireItem, String[] optionText, Integer[] optionIndex) {
        int result = iQuestionnaireItemService.saveNotNull(questionnaireItem);
        if (result > 0) {
            for (int i = 0; i < optionIndex.length; i++) {
                QuestionnaireOption questionnaireOption = new QuestionnaireOption();
                questionnaireOption.setItemId(questionnaireItem.getId());
                questionnaireOption.setOptionIndex(optionIndex[i]);
                questionnaireOption.setText(optionText[i]);
                iQuestionnaireOptionService.saveNotNull(questionnaireOption);
            }
        }
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(QuestionnaireItem questionnaireItem, String[] optionText, Integer[] optionIndex,
            Integer[] optionId) {
        iQuestionnaireItemService.updateNotNull(questionnaireItem);
        for (int i = 0; i < optionIndex.length; i++) {
            QuestionnaireOption questionnaireOption = new QuestionnaireOption();
            questionnaireOption.setOptionIndex(optionIndex[i]);
            questionnaireOption.setItemId(questionnaireItem.getId());
            questionnaireOption.setText(optionText[i]);
            if (optionId[i] != null) {
                questionnaireOption.setId(optionId[i]);
                iQuestionnaireOptionService.updateNotNull(questionnaireOption);
            } else {
                iQuestionnaireOptionService.saveNotNull(questionnaireOption);
            }
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/updateIndex", method = RequestMethod.POST)
    @ResponseBody
    public Result updateIndex(String idArr, String indexArr) {
        String[] ids = idArr.split(",");
        String[] indexes = indexArr.split(",");
        for (int i = 0; i < ids.length; i++) {
            QuestionnaireItem item = new QuestionnaireItem();
            item.setId(Integer.parseInt(ids[i]));
            item.setQuestionIndex(Integer.parseInt(indexes[i]));
            iQuestionnaireItemService.updateNotNull(item);
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result load(@PathVariable(value = "id") Integer id) {
        QuestionnaireItem questionnaireItem = iQuestionnaireItemService.selectByKey(id);
        QuestionnaireOption o = new QuestionnaireOption();
        o.setItemId(questionnaireItem.getId());
        List<QuestionnaireOption> optionList = iQuestionnaireOptionService.selectByFilter(o);
        List<Map> options = new ArrayList<>();
        for (QuestionnaireOption option : optionList) {
            Map m = new HashMap();
            m.put("optionId", option.getId());
            m.put("optionText", option.getText());
            m.put("optionIndex", option.getOptionIndex());
            options.add(m);
        }
        questionnaireItem.setOptions(options);
        return ResponseUtil.success(questionnaireItem);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iQuestionnaireItemService.delete(id);
        return ResponseUtil.success();
    }

}
