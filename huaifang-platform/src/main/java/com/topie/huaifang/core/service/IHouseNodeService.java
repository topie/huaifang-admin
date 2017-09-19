package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.HouseNode;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IHouseNodeService extends IService<HouseNode> {

    PageInfo<HouseNode> selectByFilterAndPage(HouseNode houseNode, int pageNum, int pageSize);

    List<HouseNode> selectByFilter(HouseNode houseNode);


}
