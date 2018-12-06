package com.ruoyi.web.controller.kanjia;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Form;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kanjia.domain.KanjiaUser;
import com.ruoyi.kanjia.service.IKanjiaUserService;
import com.ruoyi.system.domain.SysUser;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import weixinpay.GetAccess_token;
import weixinpay.common.MD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报名 信息操作处理
 * 
 * @author xkang
 * @date 2018-12-06
 */
@Controller
@RequestMapping("/kanjia/kanjiaUser")
public class KanjiaUserController extends BaseController
{
    private String prefix = "kanjia/kanjiaUser";
	
	@Autowired
	private IKanjiaUserService kanjiaUserService;
	
	@RequiresPermissions("kanjia:kanjiaUser:view")
	@GetMapping()
	public String kanjiaUser()
	{
	    return prefix + "/kanjiaUser";
	}
	
	/**
	 * 查询报名列表
	 */
	@RequiresPermissions("kanjia:kanjiaUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(KanjiaUser kanjiaUser)
	{
		startPage();
        List<KanjiaUser> list = kanjiaUserService.selectKanjiaUserList(kanjiaUser);
		return getDataTable(list);
	}
	
	/**
	 * 新增报名
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存报名
	 */
	@RequiresPermissions("kanjia:kanjiaUser:add")
	@Log(title = "报名", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(KanjiaUser kanjiaUser)
	{		
		return toAjax(kanjiaUserService.insertKanjiaUser(kanjiaUser));
	}

	/**
	 * 修改报名
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		KanjiaUser kanjiaUser = kanjiaUserService.selectKanjiaUserById(id);
		mmap.put("kanjiaUser", kanjiaUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存报名
	 */
	@RequiresPermissions("kanjia:kanjiaUser:edit")
	@Log(title = "报名", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(KanjiaUser kanjiaUser)
	{		
		return toAjax(kanjiaUserService.updateKanjiaUser(kanjiaUser));
	}
	
	/**
	 * 删除报名
	 */
	@RequiresPermissions("kanjia:kanjiaUser:remove")
	@Log(title = "报名", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(kanjiaUserService.deleteKanjiaUserByIds(ids));
	}


	@Form
	@PostMapping("/web/add")
	@ResponseBody
	public AjaxResult webAddSave(KanjiaUser kanjiaUser,HttpSession session,HttpServletRequest request) throws ServletException, IOException
	{
		AjaxResult ajaxResult =getWxImg(session);
		String nickname = (String) ajaxResult.get("nickname");
		String uimg = (String) ajaxResult.get("headimgurl");
		kanjiaUser.setUid(Math.toIntExact(getUserId()));
		kanjiaUser.setUimg(uimg);
		kanjiaUser.setNickname(nickname);
		kanjiaUser.setPresentPrice(new BigDecimal(999));
		kanjiaUser.setOriginalPrice(new BigDecimal(888));
		kanjiaUser.setFloorPrice(new BigDecimal(298));
		return toAjax(kanjiaUserService.insertKanjiaUser(kanjiaUser));
	}

	private AjaxResult getWxImg(HttpSession session) throws ServletException, IOException {
		String openid = (String) session.getAttribute("openid");
		HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/userinfo?access_token="+ GetAccess_token.getAccess_token()+"&openid="+openid+"&lang=zh_CN");
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
