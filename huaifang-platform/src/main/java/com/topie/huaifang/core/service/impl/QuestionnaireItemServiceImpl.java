package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IQuestionnaireItemService;
import com.topie.huaifang.database.core.model.QuestionnaireItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class QuestionnaireItemServiceImpl extends BaseService<QuestionnaireItem> implements IQuestionnaireItemService {

    @Override
    public PageInfo<QuestionnaireItem> selectByFilterAndPage(QuestionnaireItem questionnaireItem, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionnaireItem> list = selectByFilter(questionnaireItem);
        return new PageInfo<>(list);
    }

    @Override
    public List<QuestionnaireItem> selectByFilter(QuestionnaireItem questionnaireItem) {
        Example example = new Example(QuestionnaireItem.class);
        Example.Criteria criteria = example.createCriteria();
        if (questionnaireItem != null) {
            if (questionnaireItem.getInfoId() != null) criteria.andEqualTo("infoId", questionnaireItem.getInfoId());
        }
        if (StringUtils.isNotEmpty(questionnaireItem.getSortWithOutOrderBy())) {
            example.setOrderByClause(questionnaireItem.getSortWithOutOrderBy());
        } else {
            example.setOrderByClause(" question_index asc");
        }

        return getMapper().selectByExample(example);
    }

}
