package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.CunwuInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface ICunwuInfoService extends IService<CunwuInfo> {

    PageInfo<CunwuInfo> selectByFilterAndPage(CunwuInfo cunwuInfo, int pageNum, int pageSize);

    List<CunwuInfo> selectByFilter(CunwuInfo cunwuInfo);
}
