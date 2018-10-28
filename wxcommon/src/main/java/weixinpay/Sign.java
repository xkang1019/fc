package weixinpay;/*
package com.yima.ssm.weixinpay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yima.ssm.weixinpay.common.Configure;
import com.yima.ssm.weixinpay.common.RandomStringGenerator;
import com.yima.ssm.weixinpay.common.Signature;
import com.yima.ssm.weixinpay.model.SignInfo;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*/
/**
 * 再签名
 *//*

@Controller
@RequestMapping("/weixinpay")
public class Sign  {
	private static final long serialVersionUID = 1L;
	private static final Logger L = Logger.getLogger(Sign.class);

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



}
*/
