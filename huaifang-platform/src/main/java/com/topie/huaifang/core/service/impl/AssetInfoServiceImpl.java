package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAssetInfoService;
import com.topie.huaifang.database.core.model.AssetInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AssetInfoServiceImpl extends BaseService<AssetInfo> implements IAssetInfoService {

    @Override
    public PageInfo<AssetInfo> selectByFilterAndPage(AssetInfo assetInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AssetInfo> list = selectByFilter(assetInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<AssetInfo> selectByFilter(AssetInfo assetInfo) {
        Example example = new Example(AssetInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(assetInfo.getAssetName()))
            criteria.andLike("assetName", "%" + assetInfo.getAssetName() + "%");
        return getMapper().selectByExample(example);
    }

}
