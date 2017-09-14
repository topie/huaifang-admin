package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.ActionGuide;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IActionGuideService extends IService<ActionGuide> {

    PageInfo<ActionGuide> selectByFilterAndPage(ActionGuide actionGuide, int pageNum, int pageSize);

    List<ActionGuide> selectByFilter(ActionGuide actionGuide);
}
