package com.ruoyi.web.controller.fc;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Form;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.fc.domain.User;
import com.ruoyi.fc.service.IUserService;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.jsoup.helper.DataUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import weixinpay.common.MD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("fc/index")
public class FcIndexConteroller extends BaseController {
    private final org.slf4j.Logger L = LoggerFactory.getLogger(this.getClass());

    public static final int userType1 = 1; //朋友

    public static final int userType2 = 2; //朋友圈

    public static final int userType3 = 3;

    @Autowired
    private IUserService userService;
    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private ISysUserService sysUserService;

    private String prefix = "fc/index";


//    @GetMapping()
//    public String login(String code, ModelMap modelMap)
//    {
//        modelMap.put("code",code);
//
//        return prefix + "/fclogin";
//    }


    @GetMapping("/jump")
    public String jump()
    {
        return prefix + "/jump";
    }


    @Form
    @GetMapping("/index")
    public String prize(String code, ModelMap modelMap,HttpServletRequest request) throws ServletException, IOException {
        getopenIdWeb(code);
        int  prizeCount =iSysUserService.selectUserPrizeCountById(getUserId());
        String token = (String) request.getAttribute("token");
        System.out.println("token:"+token);
        modelMap.put("token",token);
        modelMap.put("prizeCount",prizeCount);
        return prefix + "/index";
    }


    @GetMapping("/usrPrize")
    public String userPrize(ModelMap modelMap)
    {
        User user = new User();
        user.setUid(Math.toIntExact(getUserId()));
        updPrizeOut();
        modelMap.put("prizeList",userService.selectUserList(user));
        return prefix + "/usrPrize";
    }




    private   String[]  updPrizeOut(){
        String  nowdate = DateUtil.getFromNow(-1);
        User user = new User();
        user.setUid(Math.toIntExact(getUserId()));
        user.setStatus(1);
        user.setDatetime(DateUtil.strToDateLong(nowdate));
        System.out.println("DateUtil.strToDateLong(nowdate):"+DateUtil.strToDateLong(nowdate));
        String[] outPrizeArr =  userService.selectOutList(user);
        if (outPrizeArr.length!=0){
            userService.updateUserStatus(outPrizeArr);
        }

       return outPrizeArr;

    }


    private AjaxResult getopenIdWeb(String code) throws ServletException, IOException {
        System.out.println(code+":code");
        HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx28cc809e924ed56b&secret=c4ac7344f8ae120f9da65019e7f48d0d&code="+code+"&grant_type=authorization_code");
        //设置请求器的配置
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse res = httpClient.execute(httpGet);
        HttpEntity entity = res.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.toJSONString());
        if("".equals(jsonObject.getString("openid"))||jsonObject.getString("openid")==null){
            return error("获取openid失败");
        }
        System.out.println("unionid:"+jsonObject.getString("unionid"));
        return  ajaxLogin(MD5.MD5Encode(jsonObject.getString("openid")),null);
    }

    private AjaxResult ajaxLogin(String openId, @RequestParam(required = false) String name) {
        String password ="123456";
        System.out.println("--------------------"+openId+"----------"+password);
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", openId);
        int userindex  = 0; //userService.list(map).size();
        String stuats = sysUserService.checkLoginNameUnique(openId);
        if (stuats.equals(UserConstants.MENU_NAME_UNIQUE)){
            SysUser user = new SysUser();
            user.setLoginName(openId);
            user.setUserName("微信用户");
            user.setSalt("123456");
            user.setPassword(passwordService.encryptPassword(openId, openId, user.getSalt()));
            user.setCreateBy(openId);
            user.setRoleIds(new Long[]{2L});
            user.setPostIds(new Long[]{4L});
            user.setPrize(1);
            user.setSumprize(2);
            if (sysUserService.insertUser(user)>0) {
                L.info("用户注册成功--------------------");
            }else {
                L.info("用户注册失败--------------------");
            }

        }
        if(!openId.equals("undefined")&&openId!=null&&!"".equals(openId)) {
            UsernamePasswordToken token = new UsernamePasswordToken(openId, openId,true);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
                L.info("用户登入成功--------------------"+subject.getSession().getId());
                return success().put("sessionid", subject.getSession().getId());
            } catch (AuthenticationException e) {
                return error("用户或密码错误");
            }
        }

        return error("未授权");
    }



}
