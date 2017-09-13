package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.LibraryBook;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface ILibraryBookService extends IService<LibraryBook> {

    PageInfo<LibraryBook> selectByFilterAndPage(LibraryBook libraryBook, int pageNum, int pageSize);

    List<LibraryBook> selectByFilter(LibraryBook libraryBook);
}
