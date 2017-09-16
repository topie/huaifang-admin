package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.QuestionnaireItem;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IQuestionnaireItemService extends IService<QuestionnaireItem> {

    PageInfo<QuestionnaireItem> selectByFilterAndPage(QuestionnaireItem questionnaireItem, int pageNum, int pageSize);

    List<QuestionnaireItem> selectByFilter(QuestionnaireItem questionnaireItem);
}
