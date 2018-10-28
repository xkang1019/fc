package weixinpay;/*
package com.yima.ssm.weixinpay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yima.ssm.weixinpay.common.Configure;
import com.yima.ssm.weixinpay.common.HttpRequest;
import com.yima.ssm.weixinpay.common.RandomStringGenerator;
import com.yima.ssm.weixinpay.common.Signature;
import com.yima.ssm.weixinpay.model.OrderInfo;
import com.yima.ssm.weixinpay.model.OrderReturnInfo;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*/
/**
 * 统一下单接口
 *//*

@Controller
@RequestMapping("/weixinpay")
public class Xiadan  {
	private static final long serialVersionUID = 1L;
	private static final Logger L = Logger.getLogger(Xiadan.class);



	@RequestMapping(value = "/Xiadan",method = RequestMethod.POST)
	public void Xiadan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String openid = request.getParameter("openid");
			OrderInfo order = new OrderInfo();
			order.setAppid(Configure.getAppID());
			order.setMch_id(Configure.getMch_id());
			order.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
			order.setBody("dfdfdf");
			order.setOut_trade_no(RandomStringGenerator.getRandomStringByLength(32));
			order.setTotal_fee(10);
			order.setSpbill_create_ip("123.57.218.54");
			order.setNotify_url("https://www.see-source.com/weixinpay/PayResult");
			order.setTrade_type("JSAPI");
			order.setOpenid(openid);
			order.setSign_type("MD5");
			//生成签名
			String sign = Signature.getSign(order);
			order.setSign(sign);
			
			
			String result = HttpRequest.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder", order);
			System.out.println(result);
			L.info("---------下单返回:"+result);
			XStream xStream = new XStream();
			xStream.alias("xml", OrderReturnInfo.class);

			OrderReturnInfo returnInfo = (OrderReturnInfo)xStream.fromXML(result);
			JSONObject json = new JSONObject();
			json.put("prepay_id", returnInfo.getPrepay_id());
			response.getWriter().append(json.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
			L.error("-------", e);
		}
		
	}



}
*/
