package com.topie.huaifang.core.api.mobile;

import com.github.pagehelper.PageInfo;
import com.topie.huaifang.common.utils.PageConvertUtil;
import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppTimeLineCommentService;
import com.topie.huaifang.core.service.IAppTimeLineLikeService;
import com.topie.huaifang.core.service.IAppTimeLineService;
import com.topie.huaifang.core.service.IAppUserService;
import com.topie.huaifang.database.core.model.AppTimeLine;
import com.topie.huaifang.database.core.model.AppTimeLineComment;
import com.topie.huaifang.database.core.model.AppTimeLineLike;
import com.topie.huaifang.database.core.model.AppUser;
import com.topie.huaifang.security.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/appTimeLine")
public class MoAppTimeLineController {

    @Autowired
    private IAppTimeLineService iAppTimeLineService;

    @Autowired
    private IAppTimeLineCommentService iAppTimeLineCommentService;

    @Autowired
    private IAppTimeLineLikeService iAppTimeLineLikeService;

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(AppTimeLine appTimeLine,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "1000") int pageSize) {
        PageInfo<AppTimeLine> pageInfo = iAppTimeLineService.selectByFilterAndPage(appTimeLine, pageNum, pageSize);
        for (AppTimeLine timeLine : pageInfo.getList()) {
            AppTimeLineComment comment = new AppTimeLineComment();
            comment.setLineId(timeLine.getId());
            List<AppTimeLineComment> commentList = iAppTimeLineCommentService.selectByFilter(comment);
            timeLine.setComments(commentList);
        }
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public Result post(@RequestBody AppTimeLine appTimeLine) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401, "未登录");
        appTimeLine.setAddUserId(appUser.getId());
        appTimeLine.setAddUserName(appUser.getNickname());
        int result = iAppTimeLineService.saveNotNull(appTimeLine);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    @ResponseBody
    public Result like(@RequestParam(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401, "未登录");
        AppTimeLineLike appTimeLineLike = new AppTimeLineLike();
        appTimeLineLike.setLineId(id);
        appTimeLineLike.setUserId(appUser.getId());
        appTimeLineLike.setUserName(appUser.getNickname());
        appTimeLineLike.setLikeTime(new Date());
        iAppTimeLineLikeService.saveNotNull(appTimeLineLike);
        return ResponseUtil.success(appTimeLineLike.getId());
    }

    @RequestMapping(value = "/unlike", method = RequestMethod.GET)
    @ResponseBody
    public Result unlike(@RequestParam(value = "id") Integer id) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401, "未登录");
        AppTimeLineLike appTimeLineLike = new AppTimeLineLike();
        appTimeLineLike.setLineId(id);
        appTimeLineLike.setUserId(appUser.getId());
        List<AppTimeLineLike> list = iAppTimeLineLikeService.selectByFilter(appTimeLineLike);
        for (AppTimeLineLike timeLineLike : list) {
            iAppTimeLineLikeService.delete(timeLineLike.getId());
        }
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Result comment(@RequestBody AppTimeLineComment appTimeLineComment) {
        AppUser appUser = iAppUserService.selectByPlatformId(SecurityUtil.getCurrentUserId());
        if (appUser == null) return ResponseUtil.error(401, "未登录");
        appTimeLineComment.setUserId(appUser.getId());
        appTimeLineComment.setUserName(appUser.getNickname());
        appTimeLineComment.setCommentTime(new Date());
        int result = iAppTimeLineCommentService.saveNotNull(appTimeLineComment);
        return result > 0 ? ResponseUtil.success() : ResponseUtil.error();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@RequestParam(value = "id") Integer id) {
        iAppTimeLineService.delete(id);
        return ResponseUtil.success();
    }

}
