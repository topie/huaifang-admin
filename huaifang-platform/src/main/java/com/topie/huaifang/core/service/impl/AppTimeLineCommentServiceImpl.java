package com.topie.huaifang.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.baseservice.impl.BaseService;
import com.topie.huaifang.core.service.IAppTimeLineCommentService;
import com.topie.huaifang.database.core.model.AppTimeLineComment;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppTimeLineCommentServiceImpl extends BaseService<AppTimeLineComment>
        implements IAppTimeLineCommentService {

    @Override
    public PageInfo<AppTimeLineComment> selectByFilterAndPage(AppTimeLineComment appTimeLineComment, int pageNum,
            int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppTimeLineComment> list = selectByFilter(appTimeLineComment);
        return new PageInfo<>(list);
    }

    @Override
    public List<AppTimeLineComment> selectByFilter(AppTimeLineComment appTimeLineComment) {
        Example example = new Example(AppTimeLineComment.class);
        Example.Criteria criteria = example.createCriteria();
        if (appTimeLineComment.getLineId() != null) criteria.andEqualTo("lineId", appTimeLineComment.getLineId());
        if (appTimeLineComment.getCommentTime() != null)
            criteria.andGreaterThan("commentTime", appTimeLineComment.getCommentTime());
        example.setOrderByClause(" commentTime asc");
        return getMapper().selectByExample(example);
    }

}
