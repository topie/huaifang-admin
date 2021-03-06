package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.core.service.INoticeService;
import com.topie.huaifang.core.service.ITagService;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.database.core.model.Notice;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/notice")
public class MoNoticeController {

    @Autowired
    private INoticeService iNoticeService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private ITagService iTagService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(Notice notice,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        notice.setIsOnline(true);
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        List<Integer> tagIds = new ArrayList<>();
        tagIds.add(0);
        if (appUser != null) {
            List<Integer> list = iTagService.selectTagIdsByUserId(appUser.getId());
            for (Integer id : list) {
                tagIds.add(id);
            }
        }
        notice.setTagIds(tagIds);
        PageInfo<Notice> pageInfo = iNoticeService.selectByFilterAndPage(notice, pageNum, pageSize);
        if (pageNum > pageInfo.getPages()) {
            return ResponseUtil.success(PageConvertUtil.grid(new ArrayList<>()));
        }
        for (Notice item : pageInfo.getList()) {
            item.setContent(null);
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@RequestParam(value = "id") Integer id) {
        Notice notice = iNoticeService.selectByKey(id);
        notice.setReadCount(notice.getReadCount() + 1);
        iNoticeService.updateNotNull(notice);
        return ResponseUtil.success(notice);
    }
}
