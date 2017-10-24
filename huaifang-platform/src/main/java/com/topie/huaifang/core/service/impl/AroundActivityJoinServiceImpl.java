package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAroundActivityJoinService;
import com.topie.huaifang.database.core.model.AroundActivityJoin;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AroundActivityJoinServiceImpl extends BaseService<AroundActivityJoin>
        implements IAroundActivityJoinService {

    @Override
    public PageInfo<AroundActivityJoin> selectByFilterAndPage(AroundActivityJoin aroundActivityJoin, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AroundActivityJoin> list = selectByFilter(aroundActivityJoin);
        return new PageInfo<>(list);
    }

    @Override
    public List<AroundActivityJoin> selectByFilter(AroundActivityJoin aroundActivityJoin) {
        Example example = new Example(AroundActivityJoin.class);
        Example.Criteria criteria = example.createCriteria();
        if (aroundActivityJoin.getUserId() != null) criteria.andEqualTo("userId", aroundActivityJoin.getUserId());
        if (aroundActivityJoin.getActivityId() != null)
            criteria.andEqualTo("activityId", aroundActivityJoin.getActivityId());
        return getMapper().selectByExample(example);
    }

}
