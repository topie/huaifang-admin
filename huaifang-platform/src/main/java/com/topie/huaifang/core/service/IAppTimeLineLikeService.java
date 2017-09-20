package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppTimeLineLike;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppTimeLineLikeService extends IService<AppTimeLineLike> {

    PageInfo<AppTimeLineLike> selectByFilterAndPage(AppTimeLineLike appTimeLineLike, int pageNum, int pageSize);

    List<AppTimeLineLike> selectByFilter(AppTimeLineLike appTimeLineLike);
}
