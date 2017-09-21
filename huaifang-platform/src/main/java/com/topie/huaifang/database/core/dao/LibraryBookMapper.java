package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.database.core.model.LibraryBook;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LibraryBookMapper extends Mapper<LibraryBook> {

    List<String> selectBookTags();

}
