package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.CunwuInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CunwuInfoMapper extends Mapper<CunwuInfo> {

    List<CunwuInfo> selectTitles();
}
