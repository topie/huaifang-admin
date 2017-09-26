package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.ILibraryBookService;
import com.topie.huaifang.database.core.model.LibraryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/libraryBook")
public class MoLibraryBookController {

    @Autowired
    private ILibraryBookService iLibraryBookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(LibraryBook libraryBook,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<LibraryBook> pageInfo = iLibraryBookService.selectByFilterAndPage(libraryBook, pageNum, pageSize);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    public Result category() {
        List<String> tags = iLibraryBookService.selectBookTags();
        return ResponseUtil.success(PageConvertUtil.grid(tags));
    }

}
