package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.ActionGuideCat;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IActionGuideCatService extends IService<ActionGuideCat> {

    PageInfo<ActionGuideCat> selectByFilterAndPage(ActionGuideCat actionGuideCat, int pageNum, int pageSize);

    List<ActionGuideCat> selectByFilter(ActionGuideCat actionGuideCat);
}
