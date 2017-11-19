package com.topie.huaifang.database.core.dao;

import com.topie.huaifang.core.dto.TagUserDTO;
import com.topie.huaifang.database.core.model.Tag;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TagMapper extends Mapper<Tag> {

    List<TagUserDTO> selectAppUsers(@Param("tagId") Integer tagId);

    int insertUserTag(@Param("userId") Integer userId, @Param("tagId") Integer tagId);

    int deleteUserTag(@Param("userId") Integer userId, @Param("tagId") Integer tagId);

    List<Integer> selectTagIdsByUserId(@Param("userId")Integer userId);

}
