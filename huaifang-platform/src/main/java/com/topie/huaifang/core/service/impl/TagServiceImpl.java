package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.dto.TagUserDTO;
import com.topie.huaifang.core.service.ITagService;
import com.topie.huaifang.database.core.dao.TagMapper;
import com.topie.huaifang.database.core.model.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TagServiceImpl extends BaseService<Tag> implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public PageInfo<Tag> selectByFilterAndPage(Tag tag, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> list = selectByFilter(tag);
        return new PageInfo<>(list);
    }

    @Override
    public List<Tag> selectByFilter(Tag tag) {
        Example example = new Example(Tag.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(tag.getTagName())) criteria.andLike("tagName", "%" + tag.getTagName() + "%");
        return getMapper().selectByExample(example);
    }

    @Override
    public PageInfo<TagUserDTO> selectAppUsersByPage(Integer tagId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TagUserDTO> list = tagMapper.selectAppUsers(tagId);
        return new PageInfo<>(list);
    }

    @Override
    public int insertUserTag(Integer userId, Integer tagId) {
        return tagMapper.insertUserTag(userId, tagId);
    }

    @Override
    public int deleteUserTag(Integer userId, Integer tagId) {
        return tagMapper.deleteUserTag(userId, tagId);
    }

}
