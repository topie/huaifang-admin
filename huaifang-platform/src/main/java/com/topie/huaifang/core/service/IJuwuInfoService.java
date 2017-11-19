package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.JuwuInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IJuwuInfoService extends IService<JuwuInfo> {

    PageInfo<JuwuInfo> selectByFilterAndPage(JuwuInfo juwuInfo, int pageNum, int pageSize);

    List<JuwuInfo> selectByFilter(JuwuInfo juwuInfo);

    List<JuwuInfo> selectTitles();

}
