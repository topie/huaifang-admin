package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.PartyActivityJoin;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IPartyActivityJoinService extends IService<PartyActivityJoin> {

    PageInfo<PartyActivityJoin> selectByFilterAndPage(PartyActivityJoin partyActivityJoin, int pageNum, int pageSize);

    List<PartyActivityJoin> selectByFilter(PartyActivityJoin partyActivityJoin);
}
