package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.AppManager;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AppManagerMapper extends Mapper<AppManager> {

    void updateToNotCurrent(@Param("systemType") String systemType, @Param("id") Integer id);
}
