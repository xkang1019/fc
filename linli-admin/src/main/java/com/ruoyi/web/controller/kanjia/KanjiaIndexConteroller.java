package com.ruoyi.web.controller.kanjia;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Form;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.fc.domain.User;
import com.ruoyi.fc.service.IUserService;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.kanjia.domain.KanjiaUser;
import com.ruoyi.kanjia.service.IKanjiaUserHelpinfoService;
import com.ruoyi.kanjia.service.IKanjiaUserService;
import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysConfigService;
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
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import weixinpay.GetAccess_token;
import weixinpay.common.MD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("kanjia/index")
public class KanjiaIndexConteroller extends BaseController {
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

    private String prefix = "kanjia/index";

    @Autowired
    private IKanjiaUserService kanjiaUserService;

    @Autowired
    private IKanjiaUserHelpinfoService kanjiaUserHelpinfoService;

    @Autowired
    private ISysConfigService configService;


//    @GetMapping()
//    public String login(String code, ModelMap modelMap)
//    {
//        modelMap.put("code",code);
//
//        return prefix + "/fclogin";
//    }

    @GetMapping("/jump")
    public String jump(ModelMap mmp,String uid)
    {
        System.out.println("uid:"+uid);
        mmp.put("toUid",uid);
        return prefix + "/jump";

    }


    @GetMapping("/test")
    public String test(ModelMap modelMap)
    {
        SysConfig activityEndTime = configService.selectConfigById((long)107);
        SysConfig activityUrl = configService.selectConfigById((long)109);
        modelMap.put("isSingUp",false);
        modelMap.put("uid",1);
        modelMap.put("isSingUp",true);
        modelMap.put("toUid",0);
        modelMap.put("token",2);
        modelMap.put("prizeCount",3);
        modelMap.put("presentPrice",100);
        modelMap.put("floorPrice",200);
        modelMap.put("originalPrice",300);
        modelMap.put("productNum",400);
        modelMap.put("surplusNum",500);
        modelMap.put("activityEndTime",activityEndTime.getConfigValue());
        modelMap.put("activityUrl",activityUrl.getConfigValue());
        modelMap.put("uimg",getUser().getAvatar());
        modelMap.put("nickname",getUser().getUserName());
        return prefix + "/index";
    }

    @Form
    @GetMapping("/index")
    public String prize(String code,String state, ModelMap modelMap,HttpServletRequest request) throws ServletException, IOException {
        getopenIdWeb(code);
       // int  prizeCount =iSysUserService.selectUserPrizeCountById(getUserId());
        String token = (String) request.getAttribute("token");
        System.out.println("token:"+token);
        KanjiaUser kanjiaUser = new KanjiaUser();
        kanjiaUser.setUid(Math.toIntExact(getUserId()));
        List<KanjiaUser> list = kanjiaUserService.selectKanjiaUserList(kanjiaUser);


        //现价
        SysConfig presentPrice = configService.selectConfigById((long)100);
        //低价
        SysConfig floorPrice =   configService.selectConfigById((long)101);
        //原价
        SysConfig originalPrice =  configService.selectConfigById((long)102);
        //产品总
        SysConfig productNum =  configService.selectConfigById((long)103);
        //产品剩余
        SysConfig surplusNum =  configService.selectConfigById((long)104);

        SysConfig activityEndTime = configService.selectConfigById((long)107);

        SysConfig activityUrl = configService.selectConfigById((long)109);


        if (list.size()>0){
            modelMap.put("isSingUp",true);
            modelMap.put("uid",getUserId());

            if ("0".equals(state)){
                modelMap.put("uimg",getUser().getAvatar());
                modelMap.put("nickname",getUser().getUserName());
                modelMap.put("presentPrice",list.get(0).getPresentPrice());
            }else {
                KanjiaUser kanjiaUser2 = new KanjiaUser();
                kanjiaUser.setUid(Integer.valueOf(state));
                List<KanjiaUser> list2 = kanjiaUserService.selectKanjiaUserList(kanjiaUser);
                modelMap.put("uimg",list2.get(0).getUimg());
                modelMap.put("nickname",list2.get(0).getNickname());
                modelMap.put("presentPrice",list2.get(0).getPresentPrice());
            }

        }else {

            if ("0".equals(state)){
                modelMap.put("uimg",getUser().getAvatar());
                modelMap.put("nickname",getUser().getUserName());
            }else {
                KanjiaUser kanjiaUser2 = new KanjiaUser();
                kanjiaUser.setUid(Integer.valueOf(state));
                List<KanjiaUser> list2 = kanjiaUserService.selectKanjiaUserList(kanjiaUser);
                modelMap.put("uimg",list2.get(0).getUimg());
                modelMap.put("nickname",list2.get(0).getNickname());
            }
            modelMap.put("isSingUp",false);
            modelMap.put("presentPrice",originalPrice.getConfigValue());

        }


        modelMap.put("toUid",state);
        modelMap.put("token",token);
      //  modelMap.put("prizeCount",prizeCount);

        modelMap.put("floorPrice",floorPrice.getConfigValue());
        modelMap.put("originalPrice",originalPrice.getConfigValue());
        modelMap.put("productNum",productNum.getConfigValue());
        modelMap.put("surplusNum",surplusNum.getConfigValue());
        modelMap.put("activityEndTime",activityEndTime.getConfigValue());
        modelMap.put("activityUrl",activityUrl.getConfigValue());
        return prefix + "/index";
    }

    /**
     * 我的减价
     * @param modelMap
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Form
    @GetMapping("/web/selme")
    public String prize(ModelMap modelMap,HttpServletRequest request) throws ServletException, IOException {

       // int  prizeCount =iSysUserService.selectUserPrizeCountById(getUserId());
        String token = (String) request.getAttribute("token");
        System.out.println("token:"+token);
        KanjiaUser kanjiaUser = new KanjiaUser();
        kanjiaUser.setUid(Math.toIntExact(getUserId()));
        List<KanjiaUser> list = kanjiaUserService.selectKanjiaUserList(kanjiaUser);

        //现价
        SysConfig presentPrice = configService.selectConfigById((long)100);
        //低价
        SysConfig floorPrice =   configService.selectConfigById((long)101);
        //原价
        SysConfig originalPrice =  configService.selectConfigById((long)102);
        //产品总
        SysConfig productNum =  configService.selectConfigById((long)103);
        //产品剩余
        SysConfig surplusNum =  configService.selectConfigById((long)104);

        SysConfig activityEndTime = configService.selectConfigById((long)107);

        SysConfig activityUrl = configService.selectConfigById((long)109);

        if (list.size()>0){
            modelMap.put("isSingUp",true);
            modelMap.put("uid",getUserId());
            modelMap.put("presentPrice",list.get(0).getPresentPrice());
            modelMap.put("uimg",getUser().getAvatar());
            modelMap.put("nickname",getUser().getUserName());
        }else {
            modelMap.put("isSingUp",false);
            modelMap.put("presentPrice",originalPrice.getConfigValue());

        }
        modelMap.put("toUid",0);
        modelMap.put("token",token);
       // modelMap.put("prizeCount",prizeCount);
        modelMap.put("floorPrice",floorPrice.getConfigValue());
        modelMap.put("originalPrice",originalPrice.getConfigValue());
        modelMap.put("productNum",productNum.getConfigValue());
        modelMap.put("surplusNum",surplusNum.getConfigValue());
        modelMap.put("activityEndTime",activityEndTime.getConfigValue());
        modelMap.put("activityUrl",activityUrl.getConfigValue());
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
        return  ajaxLogin(jsonObject.getString("openid"),jsonObject.getString("access_token"));
    }



    private AjaxResult ajaxLogin(String openId,String access_token) throws ServletException, IOException{
        String password ="123456";
        System.out.println("--------------------"+openId+"----------"+password);
        int userindex  = 0; //userService.list(map).size();
        String stuats = sysUserService.checkLoginNameUnique(openId);
        if (stuats.equals(UserConstants.MENU_NAME_UNIQUE)){
            AjaxResult ajaxResult =  getWxImg(access_token,openId);
            SysUser user = new SysUser();
            user.setLoginName(openId);
            user.setUserName((String) ajaxResult.get("nickname"));
            user.setAvatar((String) ajaxResult.get("headimgurl"));
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


    private AjaxResult getWxImg(String access_token,String openid) throws ServletException, IOException {
        System.out.println("openid:"+openid);
        System.out.println("access_token:"+access_token);
        HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN");
        //设置请求器的配置
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse res = httpClient.execute(httpGet);
        HttpEntity entity = res.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.toJSONString());
        if("".equals(jsonObject.getString("nickname"))||jsonObject.getString("nickname")==null){
            return error("获取openid失败");
        }

        return  success().put("nickname",jsonObject.getString("nickname")).put("headimgurl",jsonObject.getString("headimgurl"));
    }


}
