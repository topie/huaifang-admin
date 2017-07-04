package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IYellowPageService;
import com.topie.huaifang.database.core.model.YellowPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Service
public class YellowPageServiceImpl extends BaseService<YellowPage> implements IYellowPageService {

    @Override
    public PageInfo<YellowPage> selectByFilterAndPage(YellowPage yellowPage, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<YellowPage> list = selectByFilter(yellowPage);
        return new PageInfo<>(list);
    }

    @Override
    public List<YellowPage> selectByFilter(YellowPage yellowPage) {
        Example example = new Example(YellowPage.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(yellowPage.getName())) criteria.andLike("name", "%" + yellowPage.getName() + "%");
        if (yellowPage.getType() != null) criteria.andEqualTo("type", yellowPage.getType());
        if (StringUtils.isNotEmpty(yellowPage.getSortWithOutOrderBy()))
            example.setOrderByClause(yellowPage.getSortWithOutOrderBy());
        return getMapper().selectByExample(example);
    }

}
