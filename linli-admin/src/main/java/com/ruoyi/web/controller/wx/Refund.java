package com.ruoyi.web.controller.wx;


public class Refund {
	/*public String wechatRefund(String orderId,int money,OrderService orderService,String remark) {
		System.out.println(orderId);
		System.out.println(orderId);
		System.out.println(money);
		//OrderServiceImpl orderService=new OrderServiceImpl();



		String trade_no="";
		if(true){
			*//*trade_no=orderDO.getTradeNo();
			int total_fee_1 =  orderDO.getRealtotalmoney().multiply(new BigDecimal(100)).intValue();*//*

			String out_refund_no = RandomStringGenerator.getRandomStringByLength(32);// 退款单号
			String out_trade_no =trade_no;// 订单号
			String total_fee = 111+"";// 总金额
			String nonce_str = RandomStringGenerator.getRandomStringByLength(32);// 随机字符串
			String appid = Configure.getAppID();
			String appsecret = Configure.getSecret();
			String mch_id = Configure.getMch_id();
			String op_user_id = Configure.getMch_id();//就是MCHID
			String partnerkey = Configure.getKey();//商户平台上的那个KEY
			SortedMap<String, String> packageParams = new TreeMap<String, String>();
			packageParams.put("appid", appid);
			packageParams.put("mch_id", mch_id);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("out_trade_no", out_trade_no);
			packageParams.put("out_refund_no", out_refund_no);
			packageParams.put("total_fee", total_fee);
			packageParams.put("refund_fee", String.valueOf(money));
			packageParams.put("op_user_id", op_user_id);
			packageParams.put("refund_desc",remark);

			RequestHandler reqHandler = new RequestHandler(
					null, null);
			reqHandler.init(appid, appsecret, partnerkey);

			String sign = reqHandler.createSign(packageParams);
			System.out.println("sign______________"+sign);
			String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
					+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
					+ "</nonce_str>" + "<sign><![CDATA[" + sign + "]]></sign>"
					+ "<out_trade_no>" + out_trade_no + "</out_trade_no>"
					+ "<out_refund_no>" + out_refund_no + "</out_refund_no>"
					+ "<total_fee>" + total_fee + "</total_fee>"
					+ "<refund_fee>" + money + "</refund_fee>"
					+ "<op_user_id>" + op_user_id + "</op_user_id>"
					+ "<refund_desc>" + remark + "</refund_desc>"
					+"</xml>";
			String createOrderURL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
			System.out.println("xml______________"+xml);
			try {
				String s= ClientCustomSSL.doRefund(createOrderURL, xml);
				System.out.println(s);
				return s;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trade_no;
	}*/

}
