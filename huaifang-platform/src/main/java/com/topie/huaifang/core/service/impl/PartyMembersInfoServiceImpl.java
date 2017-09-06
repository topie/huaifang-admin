package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPartyMembersInfoService;
import com.topie.huaifang.database.core.model.PartyMembersInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PartyMembersInfoServiceImpl extends BaseService<PartyMembersInfo> implements IPartyMembersInfoService {

    @Override
    public PageInfo<PartyMembersInfo> selectByFilterAndPage(PartyMembersInfo partyMembersInfo, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PartyMembersInfo> list = selectByFilter(partyMembersInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<PartyMembersInfo> selectByFilter(PartyMembersInfo partyMembersInfo) {
        Example example = new Example(PartyMembersInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(partyMembersInfo.getName()))
            criteria.andLike("name", "%" + partyMembersInfo.getName() + "%");
        if (partyMembersInfo.getNodeId() != null) criteria.andEqualTo("nodeId", partyMembersInfo.getNodeId());
        return getMapper().selectByExample(example);
    }

}
