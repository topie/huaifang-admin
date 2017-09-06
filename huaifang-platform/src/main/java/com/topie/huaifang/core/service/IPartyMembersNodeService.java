package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PartyMembersNode;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPartyMembersNodeService extends IService<PartyMembersNode> {

    PageInfo<PartyMembersNode> selectByFilterAndPage(PartyMembersNode partyMembersNode, int pageNum, int pageSize);

    List<PartyMembersNode> selectByFilter(PartyMembersNode partyMembersNode);
}
