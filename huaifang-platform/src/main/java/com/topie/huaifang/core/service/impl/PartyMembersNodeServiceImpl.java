package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IPartyMembersNodeService;
import com.topie.huaifang.database.core.model.PartyMembersNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PartyMembersNodeServiceImpl extends BaseService<PartyMembersNode> implements IPartyMembersNodeService {

    @Override
    public PageInfo<PartyMembersNode> selectByFilterAndPage(PartyMembersNode partyMembersNode, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PartyMembersNode> list = selectByFilter(partyMembersNode);
        return new PageInfo<>(list);
    }

    @Override
    public List<PartyMembersNode> selectByFilter(PartyMembersNode partyMembersNode) {
        Example example = new Example(PartyMembersNode.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(partyMembersNode.getName()))
            criteria.andLike("name", "%" + partyMembersNode.getName() + "%");
        if (partyMembersNode.getPid() != null) criteria.andEqualTo("pid", partyMembersNode.getPid());
        return getMapper().selectByExample(example);
    }

}
