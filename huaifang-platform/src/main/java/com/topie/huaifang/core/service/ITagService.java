package com.topie.huaifang.core.service;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.IService;
import com.topie.huaifang.core.dto.TagUserDTO;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.Tag;

import java.util.List;

/**
 * Created by chenguojun on 2017/6/27.
 */
public interface ITagService extends IService<Tag> {

    PageInfo<Tag> selectByFilterAndPage(Tag tag, int pageNum, int pageSize);

    List<Tag> selectByFilter(Tag tag);

    PageInfo<TagUserDTO> selectAppUsersByPage(Integer tagId, int pageNum, int pageSize);

    int insertUserTag(Integer userId, Integer tagId);

    int deleteUserTag(Integer userId, Integer tagId);

}
