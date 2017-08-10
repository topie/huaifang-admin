package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.HouseInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IHouseInfoService extends IService<HouseInfo> {

    PageInfo<HouseInfo> selectByFilterAndPage(HouseInfo houseInfo, int pageNum, int pageSize);

    List<HouseInfo> selectByFilter(HouseInfo houseInfo);
}
