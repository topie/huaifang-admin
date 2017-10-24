package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AroundActivityJoin;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAroundActivityJoinService extends IService<AroundActivityJoin> {

    PageInfo<AroundActivityJoin> selectByFilterAndPage(AroundActivityJoin aroundActivityJoin, int pageNum, int pageSize);

    List<AroundActivityJoin> selectByFilter(AroundActivityJoin aroundActivityJoin);
}
