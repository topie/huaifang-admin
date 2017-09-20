package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppMessage;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppMessageService extends IService<AppMessage> {

    PageInfo<AppMessage> selectByFilterAndPage(AppMessage appMessage, int pageNum, int pageSize);

    List<AppMessage> selectByFilter(AppMessage appMessage);

    void sendSystemAppMessage(Integer toUserId, String icon, String title, String content);

    void sentUserAppMessage(Integer fromUserId, Integer toUserId, String title);

}
