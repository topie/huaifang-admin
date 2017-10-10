package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IHouseInfoService;
import com.topie.huaifang.core.service.IHouseNodeService;
import com.topie.huaifang.database.core.model.HouseInfo;
import com.topie.huaifang.database.core.model.HouseNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Service
public class HouseInfoServiceImpl extends BaseService<HouseInfo> implements IHouseInfoService {

    @Autowired
    private IHouseNodeService iHouseNodeService;

    @Override
    public PageInfo<HouseInfo> selectByFilterAndPage(HouseInfo houseInfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<HouseInfo> list = selectByFilter(houseInfo);
        return new PageInfo<>(list);
    }

    @Override
    public List<HouseInfo> selectByFilter(HouseInfo houseInfo) {
        Example example = new Example(HouseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        HouseNode node = null;
        if (StringUtils.isNotEmpty(houseInfo.getXq())) {
            node = iHouseNodeService.selectByKey(Integer.parseInt(houseInfo.getXq()));
            criteria.andEqualTo("xq", node.getName());
        }
        if (StringUtils.isNotEmpty(houseInfo.getLc())) {
            node = iHouseNodeService.selectByKey(Integer.parseInt(houseInfo.getLc()));
            criteria.andEqualTo("lh", node.getName());
        }
        if (StringUtils.isNotEmpty(houseInfo.getDy())) {
            node = iHouseNodeService.selectByKey(Integer.parseInt(houseInfo.getDy()));
            criteria.andEqualTo("dy", node.getName());
        }
        if (StringUtils.isNotEmpty(houseInfo.getLc())) {
            node = iHouseNodeService.selectByKey(Integer.parseInt(houseInfo.getLc()));
            criteria.andEqualTo("lc", node.getName());
        }
        if (houseInfo.getHouseNodeId() != null) criteria.andEqualTo("houseNodeId", houseInfo.getHouseNodeId());
        return getMapper().selectByExample(example);
    }

}
