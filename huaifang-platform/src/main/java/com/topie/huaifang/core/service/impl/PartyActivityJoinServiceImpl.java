package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPartyActivityJoinService;
import com.topie.huaifang.database.core.model.PartyActivityJoin;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PartyActivityJoinServiceImpl extends BaseService<PartyActivityJoin> implements IPartyActivityJoinService {

    @Override
    public PageInfo<PartyActivityJoin> selectByFilterAndPage(PartyActivityJoin partyActivityJoin, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PartyActivityJoin> list = selectByFilter(partyActivityJoin);
        return new PageInfo<>(list);
    }

    @Override
    public List<PartyActivityJoin> selectByFilter(PartyActivityJoin partyActivityJoin) {
        Example example = new Example(PartyActivityJoin.class);
        Example.Criteria criteria = example.createCriteria();
        if (partyActivityJoin.getUserId() != null) criteria.andEqualTo("userId", partyActivityJoin.getUserId());
        if (partyActivityJoin.getActivityId() != null)
            criteria.andEqualTo("activityId", partyActivityJoin.getActivityId());
        return getMapper().selectByExample(example);
    }

}
