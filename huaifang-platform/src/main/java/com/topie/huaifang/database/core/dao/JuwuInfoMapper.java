package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.JuwuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface JuwuInfoMapper extends Mapper<JuwuInfo> {

    List<JuwuInfo> selectTitles();
}
