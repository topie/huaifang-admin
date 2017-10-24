package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AroundActivity;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAroundActivityService extends IService<AroundActivity> {

    PageInfo<AroundActivity> selectByFilterAndPage(AroundActivity aroundActivity, int pageNum, int pageSize);

    List<AroundActivity> selectByFilter(AroundActivity aroundActivity);
}
