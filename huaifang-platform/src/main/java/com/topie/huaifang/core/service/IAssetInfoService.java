package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AssetInfo;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAssetInfoService extends IService<AssetInfo> {

    PageInfo<AssetInfo> selectByFilterAndPage(AssetInfo assetInfo, int pageNum, int pageSize);

    List<AssetInfo> selectByFilter(AssetInfo assetInfo);
}
