package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.database.core.model.AppUserMessage;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface IAppUserMessageService extends IService<AppUserMessage> {

    PageInfo<AppUserMessage> selectByFilterAndPage(AppUserMessage appUserMessage, int pageNum, int pageSize);

    List<AppUserMessage> selectByFilter(AppUserMessage appUserMessage);

    int insertToSendUserAppMessage(Integer fromUserId, String nickname, String headImage, Integer toUserId, String content);
}
