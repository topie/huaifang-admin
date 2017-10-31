package com.topie.huaifang.core.api.mobile;

import com.topie.huaifang.common.utils.ResponseUtil;
import com.topie.huaifang.common.utils.Result;
import com.topie.huaifang.core.service.IAppManagerService;
import com.topie.huaifang.database.core.model.AppManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenguojun on 2017/4/19.
 */
@Controller
@RequestMapping("/api/m/appManager")
public class MoAppManagerController {

    @Autowired
    private IAppManagerService iAppManagerService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public Result current(@RequestParam(value = "system") String system) {
        AppManager a = new AppManager();
        a.setCurrent(1);
        a.setSystemType(system);
        List<AppManager> list = iAppManagerService.selectByFilter(a);
        if (list.size() > 0) {
            AppManager appManager = list.get(0);
            return ResponseUtil.success(appManager);
        } else {
            return ResponseUtil.error("未上传版本");
        }
    }

}
