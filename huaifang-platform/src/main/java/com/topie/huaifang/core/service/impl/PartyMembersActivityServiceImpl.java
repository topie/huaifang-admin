package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPartyMembersActivityService;
import com.topie.huaifang.database.core.model.PartyMembersActivity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PartyMembersActivityServiceImpl extends BaseService<PartyMembersActivity>
        implements IPartyMembersActivityService {

    @Override
    public PageInfo<PartyMembersActivity> selectByFilterAndPage(PartyMembersActivity partyMembersActivity, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PartyMembersActivity> list = selectByFilter(partyMembersActivity);
        return new PageInfo<>(list);
    }

    @Override
    public List<PartyMembersActivity> selectByFilter(PartyMembersActivity partyMembersActivity) {
        Example example = new Example(PartyMembersActivity.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(partyMembersActivity.getTopic()))
            criteria.andLike("topic", "%" + partyMembersActivity.getTopic() + "%");
        if (partyMembersActivity.getStatus() != null) criteria.andEqualTo("status", partyMembersActivity.getStatus());
        return getMapper().selectByExample(example);
    }

}
