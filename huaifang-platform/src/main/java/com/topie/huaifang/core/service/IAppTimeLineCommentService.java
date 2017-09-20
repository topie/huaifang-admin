package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppTimeLineComment;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppTimeLineCommentService extends IService<AppTimeLineComment> {

    PageInfo<AppTimeLineComment> selectByFilterAndPage(AppTimeLineComment appTimeLineComment, int pageNum, int pageSize);

    List<AppTimeLineComment> selectByFilter(AppTimeLineComment appTimeLineComment);
}
