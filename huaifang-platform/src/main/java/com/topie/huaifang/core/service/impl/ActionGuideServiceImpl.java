package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IActionGuideService;
import com.topie.huaifang.database.core.model.ActionGuide;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ActionGuideServiceImpl extends BaseService<ActionGuide> implements IActionGuideService {

    @Override
    public PageInfo<ActionGuide> selectByFilterAndPage(ActionGuide actionGuide, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActionGuide> list = selectByFilter(actionGuide);
        return new PageInfo<>(list);
    }

    @Override
    public List<ActionGuide> selectByFilter(ActionGuide actionGuide) {
        Example example = new Example(ActionGuide.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(actionGuide.getCatId())) criteria.andEqualTo("catId", actionGuide.getCatId());
        if (StringUtils.isNotEmpty(actionGuide.getTitle()))
            criteria.andLike("title", "%" + actionGuide.getTitle() + "%");
        return getMapper().selectByExample(example);
    }

}
