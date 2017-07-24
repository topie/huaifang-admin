package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IHouseNodeService;
import com.topie.huaifang.database.core.model.HouseNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Service
public class HouseNodeServiceImpl extends BaseService<HouseNode> implements IHouseNodeService {

    @Override
    public PageInfo<HouseNode> selectByFilterAndPage(HouseNode houseNode, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HouseNode> list = selectByFilter(houseNode);
        return new PageInfo<>(list);
    }

    @Override
    public List<HouseNode> selectByFilter(HouseNode houseNode) {
        Example example = new Example(HouseNode.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(houseNode.getName())) criteria.andLike("name", "%" + houseNode.getName() + "%");
        return getMapper().selectByExample(example);
    }

}
