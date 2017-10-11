package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IQuestionnaireResultService;
import com.topie.huaifang.database.core.dao.QuestionnaireResultMapper;
import com.topie.huaifang.database.core.model.QuestionnaireResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireResultServiceImpl extends BaseService<QuestionnaireResult>
        implements IQuestionnaireResultService {

    @Autowired
    private QuestionnaireResultMapper questionnaireResultMapper;

    @Override
    public PageInfo<QuestionnaireResult> selectByFilterAndPage(QuestionnaireResult questionnaireResult, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionnaireResult> list = selectByFilter(questionnaireResult);
        return new PageInfo<>(list);
    }

    @Override
    public List<QuestionnaireResult> selectByFilter(QuestionnaireResult questionnaireResult) {
        Example example = new Example(QuestionnaireResult.class);
        Example.Criteria criteria = example.createCriteria();
        if (questionnaireResult.getUserId() != null) criteria.andEqualTo("userId", questionnaireResult.getUserId());
        return getMapper().selectByExample(example);
    }

    @Override
    public Integer countDistinctUserId(Map arg) {
        return questionnaireResultMapper.countDistinctUser(arg);
    }

}
