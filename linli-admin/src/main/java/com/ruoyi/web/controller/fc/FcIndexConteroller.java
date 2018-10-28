package com.ruoyi.web.controller.fc;

import com.ruoyi.fc.domain.User;
import com.ruoyi.fc.service.IUserService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fc/index")
public class FcIndexConteroller extends BaseController {

    public static final int userType1 = 1; //朋友

    public static final int userType2 = 2; //朋友圈

    public static final int userType3 = 3;

    @Autowired
    private IUserService userService;
    @Autowired
    private ISysUserService iSysUserService;

    private String prefix = "fc/index";


    @GetMapping()
    public String login(String code, ModelMap modelMap)
    {
        modelMap.put("code",code);
        return prefix + "/fclogin";
    }


    @GetMapping("/jump")
    public String jump()
    {
        return prefix + "/jump";
    }

    @GetMapping("/index")
    public String prize(String code, ModelMap modelMap)
    {
        modelMap.put("prizeCount",iSysUserService.selectUserPrizeCountById(getUserId()));
        return prefix + "/index";
    }


    @GetMapping("/usrPrize")
    public String userPrize(ModelMap modelMap)
    {
        User user = new User();
       // user.setUid(Math.toIntExact(getUserId()));
        modelMap.put("prizeList",userService.selectUserList(user));
        return prefix + "/usrPrize";
    }

}
