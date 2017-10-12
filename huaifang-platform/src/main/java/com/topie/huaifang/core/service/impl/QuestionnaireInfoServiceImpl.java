package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IQuestionnaireInfoService;
import com.topie.huaifang.database.core.model.QuestionnaireInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class QuestionnaireInfoServiceImpl extends BaseService<QuestionnaireInfo> implements IQuestionnaireInfoService {

    @Override
    public PageInfo<QuestionnaireInfo> selectByFilterAndPage(QuestionnaireInfo questionnaireInfo, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionnaireInfo> list = selectByFilter(questionnaireInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<QuestionnaireInfo> selectByFilter(QuestionnaireInfo questionnaireInfo) {
        Example example = new Example(QuestionnaireInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (questionnaireInfo != null) {
            if (StringUtils.isNotEmpty(questionnaireInfo.getName()))
                criteria.andLike("name", "%" + questionnaireInfo.getName() + "%");
            if (StringUtils.isNotEmpty(questionnaireInfo.getStatus()))
                criteria.andEqualTo("status", questionnaireInfo.getStatus());
        }
        example.setOrderByClause(" id desc");
        return getMapper().selectByExample(example);
    }

}
