package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.ILibraryBookService;
import com.topie.huaifang.database.core.model.LibraryBook;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class LibraryBookServiceImpl extends BaseService<LibraryBook> implements ILibraryBookService {

    @Override
    public PageInfo<LibraryBook> selectByFilterAndPage(LibraryBook libraryBook, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LibraryBook> list = selectByFilter(libraryBook);
        return new PageInfo<>(list);
    }

    @Override
    public List<LibraryBook> selectByFilter(LibraryBook libraryBook) {
        Example example = new Example(LibraryBook.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(libraryBook.getAuthor()))
            criteria.andLike("author", "%" + libraryBook.getAuthor() + "%");
        if (StringUtils.isNotEmpty(libraryBook.getBookName()))
            criteria.andLike("bookName", "%" + libraryBook.getBookName() + "%");
        return getMapper().selectByExample(example);
    }

}
