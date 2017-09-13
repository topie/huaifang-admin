package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AdviceBox;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAdviceBoxService extends IService<AdviceBox> {

    PageInfo<AdviceBox> selectByFilterAndPage(AdviceBox adviceBox, int pageNum, int pageSize);

    List<AdviceBox> selectByFilter(AdviceBox adviceBox);
}
