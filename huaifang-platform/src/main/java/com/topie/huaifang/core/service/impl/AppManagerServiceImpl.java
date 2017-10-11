package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppManagerService;
import com.topie.huaifang.database.core.model.AppManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppManagerServiceImpl extends BaseService<AppManager> implements IAppManagerService {

    @Override
    public PageInfo<AppManager> selectByFilterAndPage(AppManager appManager, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppManager> list = selectByFilter(appManager);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppManager> selectByFilter(AppManager appManager) {
        Example example = new Example(AppManager.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(appManager.getSystemType()))
            criteria.andEqualTo("systemType", appManager.getSystemType());
        example.setOrderByClause("publish_time desc");
        return getMapper().selectByExample(example);
    }

}
