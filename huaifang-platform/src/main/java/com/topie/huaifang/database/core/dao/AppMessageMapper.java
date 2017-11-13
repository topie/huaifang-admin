package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.AppMessage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppMessageMapper extends Mapper<AppMessage> {

    List<AppMessage> selectByFilter(AppMessage appMessage);
}
