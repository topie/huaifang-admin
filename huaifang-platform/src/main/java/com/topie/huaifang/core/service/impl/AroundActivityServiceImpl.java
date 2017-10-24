package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAroundActivityService;
import com.topie.huaifang.database.core.model.AroundActivity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AroundActivityServiceImpl extends BaseService<AroundActivity> implements IAroundActivityService {

    @Override
    public PageInfo<AroundActivity> selectByFilterAndPage(AroundActivity aroundActivity, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AroundActivity> list = selectByFilter(aroundActivity);
        return new PageInfo<>(list);
    }

    @Override
    public List<AroundActivity> selectByFilter(AroundActivity aroundActivity) {
        Example example = new Example(AroundActivity.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(aroundActivity.getTitle()))
            criteria.andLike("title", "%" + aroundActivity.getTitle() + "%");
        if (aroundActivity.getStatus() != null) criteria.andEqualTo("status", aroundActivity.getStatus());
        return getMapper().selectByExample(example);
    }

}
