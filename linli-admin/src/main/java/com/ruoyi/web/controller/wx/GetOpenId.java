package com.ruoyi.web.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import io.swagger.annotations.*;
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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import weixinpay.GetAccess_token;
import weixinpay.common.*;
import weixinpay.model.OrderInfo;
import weixinpay.model.SignInfo;
import weixinpay.mp.aes.AesException;
import weixinpay.mp.aes.WXBizMsgCrypt;
import weixinpay.util.XML;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Servlet implementation class GetOpenId
 */
@Controller
@RequestMapping("/weixinpay")
@Api(value = "/weixinpay" ,description = "微信相关操作")
public class GetOpenId extends BaseController {
	private final org.slf4j.Logger L = LoggerFactory.getLogger(this.getClass());

	private static  final Long  ROLE = Long.valueOf(56);

	public static  final String OPENID ="openId_";

	private static final long serialVersionUID = 1L;

	@Autowired
	private PasswordService passwordService;

	@Autowired
	private ISysUserService userService;


	@ApiOperation(notes = "GetOpenId", httpMethod = "POST", value = "登入接口:获取openid同时登入返回jsessionid")
	@ApiResponses(value = {@ApiResponse(code = 0, message = "登入成功返回sessionid"),
			@ApiResponse(code = 1, message = "操作失败"),
			@ApiResponse(code = 500, message = "返回错误信息")})
	@ApiImplicitParams(@ApiImplicitParam(name = "code", value = "微信提供的code",paramType = "code", required = true,dataType = "String") )
	@RequestMapping(value = "/GetOpenId",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult GetOpenId(HttpServletRequest request, HttpServletResponse response , HttpSession session) throws ServletException, IOException {
		String code = request.getParameter("code");
		String appID = request.getParameter("appID");
		String secret = request.getParameter("secret");
		System.out.println(code+":code");
		HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid="+Configure.getAppidmm()+"&secret="+ Configure.getSecretmm()+"&js_code="+code+"&grant_type=authorization_code");
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
		session.setAttribute("openid",jsonObject.getString("openid"));
		return  ajaxLogin(MD5.MD5Encode(jsonObject.getString("openid")),null);
        //response.getWriter().append(jsonObject.toString());
	}


	@ApiOperation(notes = "getOpenIdWeb", httpMethod = "POST", value = "登入接口:获取openid同时登入返回jsessionid")
	@ApiResponses(value = {@ApiResponse(code = 0, message = "登入成功返回sessionid"),
			@ApiResponse(code = 1, message = "操作失败"),
			@ApiResponse(code = 500, message = "返回错误信息")})
	@ApiImplicitParams(@ApiImplicitParam(name = "code", value = "微信提供的code",paramType = "code", required = true,dataType = "String") )
	@RequestMapping(value = "/getOpenIdWeb",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getopenIdWeb(HttpServletRequest request, HttpServletResponse response , HttpSession session) throws ServletException, IOException {
		String code = request.getParameter("code");
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
		session.setAttribute("openid",jsonObject.getString("openid"));
		return  ajaxLogin(MD5.MD5Encode(jsonObject.getString("openid")),null);
		//response.getWriter().append(jsonObject.toString());
	}







	@RequestMapping(value = "/Sign",method = RequestMethod.POST)
	public void Sign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String repay_id = request.getParameter("repay_id");
			SignInfo signInfo = new SignInfo();
			signInfo.setAppId(Configure.getAppID());
			long time = System.currentTimeMillis()/1000;
			signInfo.setTimeStamp(String.valueOf(time));
			signInfo.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
			signInfo.setRepay_id("prepay_id="+repay_id);
			signInfo.setSignType("MD5");
			//生成签名
			String sign = Signature.getSign(signInfo);

			JSONObject json = new JSONObject();
			json.put("timeStamp", signInfo.getTimeStamp());
			json.put("nonceStr", signInfo.getNonceStr());
			json.put("package", signInfo.getRepay_id());
			json.put("signType", signInfo.getSignType());
			json.put("paySign", sign);
			L.info("-------再签名:"+json.toJSONString());
			response.getWriter().append(json.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			L.error("-------", e);
		}
	}

	@RequestMapping(value = "/Xiadan",method = RequestMethod.POST)
	public void Xiadan(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {

		String openid =  getOpenId(request,response);
		if("".equals(openid)||null==openid||"NULL".equals(openid)){
			openid = (String) session.getAttribute("openid");
		}
		// TODO Auto-generated method stub
		//String openid = (String) session.getAttribute("openid");
	    String id =	request.getParameter("id");
		//OrderDO orderDO = orderService.get(Integer.valueOf(id));
		String[] orderid = id.split(",");
		L.info("id:"+id);
		L.info("orderid.length:"+orderid.length+"-------"+orderid[0]);
		L.info("openid:"+openid);
	/*	BigDecimal realTotalMoney = orderService.selIsPayAllByUserToMoney(orderid);
		L.info("realTotalMoney:"+realTotalMoney+"");
		int totalFee = realTotalMoney.multiply(new BigDecimal(100)).intValue();
		L.info("totalFee:"+totalFee);*/
		try {
			//发模板消息



			OrderInfo order = new OrderInfo();
			order.setAppid(Configure.getAppID());
			order.setMch_id(Configure.getMch_id());
			order.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
			order.setBody("HXFresh");
			order.setOut_trade_no(UUID.randomUUID().toString().replace("-",""));
			order.setTotal_fee(1);
			order.setSpbill_create_ip("193.112.92.61");
			order.setNotify_url("https://c.haichenpeisong.com/weixinpay/PayResult");
			order.setTrade_type("JSAPI");
			order.setOpenid(openid);
			order.setSign_type("MD5");
			order.setAttach(id);
			//生成签名
			String sign = Signature.getSign(order);
			order.setSign(sign);
			L.info("---------下单返回sign:"+sign);
			String result = HttpRequest.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder",order,openid);
			L.info("---------下单返回:"+result);
			Map map =	XML.readStringXmlOut(result);
			JSONObject json = new JSONObject();
			json.put("prepay_id", map.get("prepay_id"));

			/*//测试
			sendPayOrderMode(orderid[0]);*/

			response.getWriter().append(json.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
			L.error("-------", e);
		}

	}




	@RequestMapping(value = "/XiadanVip",method = RequestMethod.POST)
	public void XiadanVip(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	String openid = (String) session.getAttribute("openid");
		String openid =  getOpenId(request,response);
		String month =	request.getParameter("month");
		//发送服务通知
		String formId =  request.getParameter("formId");


		//OrderDO orderDO = orderService.get(Integer.valueOf(id));
		 String userInfo = getUserId()+","+month;
		if("".equals(openid)||null==openid||"NULL".equals(openid)){
			openid = (String) session.getAttribute("openid");
		}





		L.info("openid:"+openid);
		L.info("month:"+month);

		if ("6".equals(month)) {
			month = "5";
		}
		if ("12".equals(month)) {
			month = "9";
		}


		try {
			OrderInfo order = new OrderInfo();
			order.setAppid(Configure.getAppID());
			order.setMch_id(Configure.getMch_id());
			order.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
			order.setBody("HXFreshVip");
			order.setOut_trade_no(UUID.randomUUID().toString().replace("-",""));
			order.setTotal_fee(Integer.parseInt(month)*1000);
			order.setSpbill_create_ip("193.112.92.61");
			order.setNotify_url("https://c.haichenpeisong.com/weixinpay/vipPayResult");
			order.setTrade_type("JSAPI");
			order.setOpenid(openid);
			order.setSign_type("MD5");
			order.setAttach(userInfo);
			//生成签名
			String sign = Signature.getSign(order);
			order.setSign(sign);
			L.info("sign:-----------"+sign);
			String result = HttpRequest.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder",order,openid);
			L.info("---------下单返回:"+result);
			Map map =	XML.readStringXmlOut(result);
			JSONObject json = new JSONObject();
			json.put("prepay_id", map.get("prepay_id"));
			response.getWriter().append(json.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
			L.error("-------", e);
		}

	}



	@RequestMapping(value = "/ajaxLogin",method = RequestMethod.GET)
	@ResponseBody
    AjaxResult ajaxLogin(String openId, @RequestParam(required = false) String name) {
		String password ="123456";
		System.out.println("--------------------"+openId+"----------"+password);
		Map<String, Object> map = new HashMap<>(16);
		map.put("username", openId);
		int userindex  = 0; //userService.list(map).size();
		String stuats = userService.checkLoginNameUnique(openId);
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
			if (userService.insertUser(user)>0) {
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
				return success().put("sessionid", subject.getSession().getId());
			} catch (AuthenticationException e) {
				return error("用户或密码错误");
			}
		}

		return error("未授权");
	}


	/*@RequiresPermissions("mc:order:outPay")
	@RequestMapping(value = "/refund",method = RequestMethod.POST)
	public void refund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId=request.getParameter("orderId");
		String money=request.getParameter("money");
		String remark=request.getParameter("remark");

		L.info("orderId"+orderId);
		L.info("money"+money);
		// TODO Auto-generated method stub
		try {
			 int moeny = (int) (Double.parseDouble(money)*100);
			Refund refund=new Refund();
			String result=refund.wechatRefund(orderId,moeny,orderService,remark);
			L.info("result"+result);
			XStream xstream = new XStream() {
				@Override
				protected MapperWrapper wrapMapper(MapperWrapper next) {
					return new MapperWrapper(next) {
						@Override
						public boolean shouldSerializeMember(Class definedIn, String fieldName) {
							if (definedIn == Object.class) {
								return false;
							}
							return super.shouldSerializeMember(definedIn, fieldName);
						}
					};
				}
			};
			xstream.alias("xml", ReturnRefund.class);
			ReturnRefund returnRefund=(ReturnRefund)xstream.fromXML(result);
			if(returnRefund.getResult_code().equals("SUCCESS")){
				*//*OrderDO order_1 = new OrderDO();
				//代发货//
				order_1.setOrderstatus(-3);
				orderService.update(order_1);*//*

				//退款记录
				PayInfoDO payInfoDO = new PayInfoDO();
				payInfoDO.setMoeny(money);
				payInfoDO.setPaytype("申请退款");
				payInfoDO.setTime(new Date());
				payInfoDO.setUserid(getUserId()+"");
				payInfoDO.setParams(orderId+"------"+money);
				payInfoService.save(payInfoDO);


				OrderRefundsDO orderRefundsDO = new OrderRefundsDO(orderId+"",getUserId()+"",returnRefund.getOut_refund_no(),remark,new Date(),new BigDecimal(money));
				orderRefundsService.save(orderRefundsDO);
				OrderRefundsApplyInfoDO orderRefundsApplyInfoDO = new OrderRefundsApplyInfoDO();
				orderRefundsApplyInfoDO.setOrderid(Integer.valueOf(orderId));
				orderRefundsApplyInfoDO.setStatus(1);
				orderRefundsApplyInfoDO.setRefundsmoney(new BigDecimal(money));
				orderRefundsApplyInfoService.updateByOrderId(orderRefundsApplyInfoDO);
				L.info("success to refund");
			}
			response.getWriter().append(returnRefund.getResult_code());
		} catch (Exception e) {
			e.printStackTrace();
			L.error("-------", e);
		}
	}*/




	@RequestMapping(value = "/wechatParam",method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult wechatParam(String url) {
		String jsapi_ticket =GetAccess_token.getJsapi_ticket();
		return  success().put("wechatParam",weixinpay.util.Signature.makeWXTicket(jsapi_ticket,url));
	}


	@Async
	@GetMapping("/sdasdasd")
	@ResponseBody
	String test()  {
		return 	"aaaa";
	}


	public String getOpenId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid="+Configure.getAppID()+"&secret="+Configure.getSecret()+"&js_code="+code+"&grant_type=authorization_code");
		//设置请求器的配置
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse res = httpClient.execute(httpGet);
		HttpEntity entity = res.getEntity();
		String result = EntityUtils.toString(entity, "UTF-8");
		JSONObject jsonObject = JSONObject.parseObject(result);
		System.out.println(jsonObject.toJSONString());
		if("".equals(jsonObject.getString("openid"))||jsonObject.getString("openid")==null){
			L.info("获取OPENID失败");
			return "NULL";
		}
		return jsonObject.getString("openid");
		//response.getWriter().append(jsonObject.toString());
	}

	/*//订单的OPENID
	private void setRedisOpenId(String orderid,String openId){
		RedisUtil.setex(OPENID+orderid,openId,30*60);
	}
	//会员的OPENID
	private void setRedisOpenId(long userid,String openId){
		RedisUtil.setex(OPENID+userid,openId,30*60);
	}

	//测试
	private String getRedisOpenId(String orderid){
		return RedisUtil.get(GetOpenId.OPENID+orderid);
	}
	//测试
	private void sendPayOrderMode(String orderid,OrderDO orderDO){
		String openid = getRedisOpenId(orderid);
		String formId = RedisUtil.get(OrderController.FORMID+orderid);
		GetAccess_token.payOrder(openid,formId,orderDO);
	}*/

}
