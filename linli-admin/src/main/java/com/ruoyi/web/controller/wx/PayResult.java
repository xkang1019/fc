
package com.ruoyi.web.controller.wx;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import weixinpay.common.Signature;
import weixinpay.common.StreamUtil;
import weixinpay.util.XML;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


/**
 * 接收支付结果
 */

@Controller
@RequestMapping("/weixinpay")
public class PayResult {
    private static final long serialVersionUID = 1L;
    private static final Logger L = LoggerFactory.getLogger(PayResult.class);




    @RequestMapping(value = "/PayResult", method = RequestMethod.POST)
    public void PayResult(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String reqParams = StreamUtil.read(request.getInputStream());
        Map map = XML.readStringXmlOut(reqParams);
        L.info("-------支付结果:" + reqParams);
        StringBuffer sb = new StringBuffer("<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");
        StringBuffer sb2 = new StringBuffer("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[通知签名验证失败]]></return_msg></xml>");
        StringBuffer sb3 = new StringBuffer("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[参数错误]]></return_msg></xml>");


        String  result_code = (String) map.get("result_code");
        String  orderid = (String) map.get("attach");
        String  transactionNum = (String) map.get("transaction_id");
        String  tradeNo = (String) map.get("out_trade_no");
        String  moeny = (String) map.get("total_fee");


        L.info("-------result_code:" + result_code);
        L.info("-------orderid:" + orderid);
        //判断sign 是否相等
        String[] orderIdArr = orderid.split(",");
        //生成签名
        String sign=(String)map.get("sign");
        L.info("--------返回的sign"+sign);
        map.remove("sign");
        String example= Signature.getSign(map);
        L.info("--------原本的支付sign"+example);
        if (sign.equals(example)) {
            if ("SUCCESS".equals(result_code)) {
                // orderid = (Integer) map.get("attach");
                /*判断Sign是否相等，防止绕过支付*/
             /*   if(orderService.batchUpdOrderIsPay(orderIdArr,transactionNum,tradeNo)>0){
                    RedisUtil.del(orderIdArr);
                    L.info("支付成功");
                }

                PayInfoDO payInfoDO = new PayInfoDO();
                payInfoDO.setMoeny(moeny);
                payInfoDO.setPaytype("订单支付");
                payInfoDO.setTime(new Date());
                payInfoDO.setUserid(orderid);
                payInfoDO.setParams(sign+"------"+tradeNo);
                payInfoService.save(payInfoDO);

                OrderDO orderDO =  orderService.get(Integer.valueOf(orderid));

                sendPayOrderMode(orderid,orderDO);*/


                response.getWriter().append(sb.toString());
            } else {
                response.getWriter().append(sb3.toString());
            }
        }else {
            response.getWriter().append(sb2.toString());
        }
        response.getWriter().flush();
        response.getWriter().close();
    }




    @RequestMapping(value = "/vipPayResult", method = RequestMethod.POST)
    public void vipPayResult(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String reqParams = StreamUtil.read(request.getInputStream());
        Map map = XML.readStringXmlOut(reqParams);
        L.info("-------支付结果:" + reqParams);
        StringBuffer sb = new StringBuffer("<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");
        StringBuffer sb2 = new StringBuffer("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[通知签名验证失败]]></return_msg></xml>");
        StringBuffer sb3 = new StringBuffer("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[参数错误]]></return_msg></xml>");


        String  result_code = (String) map.get("result_code");
        String  userId = (String) map.get("attach");
        String  transactionNum = (String) map.get("transaction_id");
        String  tradeNo = (String) map.get("out_trade_no");
        String  moeny = (String) map.get("total_fee");
        L.info("-------result_code:" + result_code);
        L.info("-------userId:" + userId);
        String[] userIdArr = userId.split(",");
        //判断sign 是否相等
        //生成签名
        String sign=(String)map.get("sign");
        L.info("--------返回的sign"+sign);
        map.remove("sign");
        String example= Signature.getSign(map);
        L.info("--------原本的支付sign"+example);
        if (sign.equals(example)) {
            if ("SUCCESS".equals(result_code)) {
                // orderid = (Integer) map.get("attach");
                /*判断Sign是否相等，防止绕过支付*/
              /* UserDO vipInfo =  userService.selUserVipInfo(Long.valueOf(userIdArr[0]));
                UserDO userDO = new UserDO();
               if (null==vipInfo.getBegin()){
                   userDO.setBegin(new Date());
               }
                if (null==vipInfo.getEnd()){
                    userDO.setEnd(DateUtil.getAddMonth(new Date(), Integer.parseInt(userIdArr[1])));
                }else {
                   if (DateUtil.getDayBetweenTwoDate(vipInfo.getEnd(),new Date())){
                       userDO.setEnd(DateUtil.getAddMonth(vipInfo.getEnd(), Integer.parseInt(userIdArr[1])));
                   }else {
                       userDO.setEnd(DateUtil.getAddMonth(new Date(), Integer.parseInt(userIdArr[1])));
                   }
                }
                userDO.setUserId(Long.valueOf(userIdArr[0]));
                userDO.setUserType(1);
                userService.updateInfo(userDO);
                //充值会员   修改未支付订单运费问题
                Map<String,Object> map1 = new HashMap<>(16);
                map1.put("dataflag",1);
                map1.put("ispay",0);
                map1.put("userid",Long.valueOf(userIdArr[0]));
                List<OrderDO> list = orderService.list(map1);
                for (OrderDO orderDO:list){
                    if(orderDO.getDelivermoney().intValue()!=0) {
                        OrderDO orderDO1 = new OrderDO();
                        orderDO1.setOrderid(orderDO1.getOrderid());
                        orderDO1.setRealtotalmoney(orderDO.getRealtotalmoney().subtract(new BigDecimal(2)));
                        orderDO1.setDelivermoney(new BigDecimal(0));
                        orderService.update(orderDO1);



                    }
                }
                PayInfoDO payInfoDO = new PayInfoDO();
                payInfoDO.setMoeny(moeny);
                payInfoDO.setPaytype("会员支付");
                payInfoDO.setTime(new Date());
                payInfoDO.setUserid(userIdArr[0]);
                payInfoDO.setParams(sign+"------"+tradeNo);
                payInfoService.save(payInfoDO);

                //发送消息模板
                sendPayVipMode(userDO.getUserId()+"",(Double.parseDouble(moeny)/100)+"",userIdArr[1]);
*/
                response.getWriter().append(sb.toString());
            } else {
                response.getWriter().append(sb3.toString());
            }
        }else {
            response.getWriter().append(sb2.toString());
        }
        response.getWriter().flush();
        response.getWriter().close();
    }



    /*private String getRedisOpenId(String orderid){
       return RedisUtil.get(GetOpenId.OPENID+orderid);
    }*/

    /**
     *  发送下单模板
     * @param orderid
     * @param orderDO
     */
   /* private void sendPayOrderMode(String orderid,OrderDO orderDO){
        String openid = getRedisOpenId(orderid);
        String formId = RedisUtil.get(OrderController.FORMID+orderid);
        GetAccess_token.payOrder(openid,formId,orderDO);
    }*/

    /**
     * 发送vip购买模板
     * @param userId
     * @param money
     * @param month
     */
   /* private void sendPayVipMode(String userId,String money,String month){
        String openid = RedisUtil.get(GetOpenId.OPENID+userId);
        String formId = RedisUtil.get(OrderController.FORMID+userId);
        GetAccess_token.payVip(openid,formId,money,month);
    }*/

}



