package weixinpay;


import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixinpay.common.Configure;
import weixinpay.common.HttpUtil;
import weixinpay.model.TemplateInfo;

/**
 * 模板消息发送
 */

public class GetAccess_token {
    private static final Logger logger = LoggerFactory.getLogger("GetAccess_token");

    private static String ACCESSURL="https://api.weixin.qq.com/cgi-bin/token" ;//获取access链接
    private static String MENDMESSAGEFWH="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
    private static String MENDMESSAGE="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" ;//获取access链接

    private static  String JSIPA_TICKET ="https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    //支付成功
    private static String template_id1="yG78xjOEQvvvjgUto0vphktS2BQcNs81D8p6jKtUZ7w";
    //购买会员
    private static String template_id2="1mDf-rxffpn0UOLJZTGcZ8kxLgoeu2AmBqUDcXhkJjs";
    //售后申请
    private static String template_id3="NPs2YZ-yeikvh_xiE2uwQFXEx7Xn1vpviApCAenJ1g8";

    //订单状态通知
    // private  static  String  template_id4 ="AGpDIiolrlNZw0Q46J6pDY-Jm3fzSNLzfl2Eo2uxaY4";
    private  static  String  template_id4 =" -vRBWCPVrVGfWbvqeRO-iMssM6aOG4m7uAFnfBdxG4g";
    //订单完成通知

    //xgfsShYDTVSnticYBHv833AiSNJHAaA2Z-0J71gyp_I
    private  static  String  template_id5 ="CDdKoW8oHcNm1vgJGfLyRK5z6BoFURIVUcgfYA_4bOE";

    /**
     * 获取 access_token
     * @return
     */
    public static  String getAccess_token(){
        String access_token ="";
       boolean isAccess_token = RedisUtil.exists("access_token");

        if (!isAccess_token) {
            String a = HttpUtil.sendGet(ACCESSURL, "grant_type=client_credential&appid=" + Configure.getAppID() + "&secret=" + Configure.getSecret());
            JSONObject jsonObject = JSONObject.parseObject(a);
            access_token = jsonObject.getString("access_token");
            logger.info("access_token",access_token);
            RedisUtil.setex("access_token", access_token, 7200);
        }
        access_token = RedisUtil.get("access_token");
        return  access_token;

    }


    /**
     * 获取 access_token
     * @return
     */
    public static  String getAccess_tokenGZH(){
        String access_token ="";
        boolean isAccess_token = RedisUtil.exists("access_token");

        if (!isAccess_token) {
            String a = HttpUtil.sendGet(ACCESSURL, "grant_type=client_credential&appid=" + Configure.getAppidmm() + "&secret=" + Configure.getSecretmm());
            JSONObject jsonObject = JSONObject.parseObject(a);
            access_token = jsonObject.getString("access_token");
            RedisUtil.setex("access_tokenGZH", access_token, 7200);
        }
        access_token = RedisUtil.get("access_tokenGZH");
        return  access_token;

    }



    /**
     * 获取 access_token
     * @return
     */
    public static  String getAccess_tokenJS(){
        String access_token;
        boolean isAccess_token = RedisUtil.exists("access_tokenJS");
        logger.info("isAccess_token",isAccess_token);
        if (!isAccess_token) {
            String a = HttpUtil.sendGet(ACCESSURL, "grant_type=client_credential&appid=" + Configure.getAppidmm() + "&secret=" + Configure.getSecretmm());
            JSONObject jsonObject = JSONObject.parseObject(a);
            access_token = jsonObject.getString("access_token");
            RedisUtil.setex("access_tokenJS", access_token, 7200);
        }
        access_token = RedisUtil.get("access_tokenJS");
        logger.info("access_token",access_token);
        return  access_token;


    }

    public static  String getJsapi_ticket(){
        String jsapi_ticket ;
      boolean   isJsapi_ticket = RedisUtil.exists("jsapi_ticket");
        logger.info("isJsapi_ticket",isJsapi_ticket);
        if (!isJsapi_ticket) {
            String a = HttpUtil.sendGet(JSIPA_TICKET, "access_token="+getAccess_tokenJS()+"&type=jsapi");
            JSONObject jsonObject = JSONObject.parseObject(a);
            jsapi_ticket = jsonObject.getString("ticket");
            RedisUtil.setex("jsapi_ticket", jsapi_ticket, 7200);
        }
        jsapi_ticket = RedisUtil.get("jsapi_ticket");
        logger.info("jsapi_ticket",jsapi_ticket);
        return  jsapi_ticket;

    }




    //支付订单通知
   /* public  static String payOrder(String touser, String formId, OrderDO orderDO) {
        String keyword1=orderDO.getOrderno();
        String keyword2=orderDO.getRealtotalmoney()+"元";
        String keyword3= DateUtil.getStringDate();
        String keyword4=orderDO.getUseraddress();
        String keyword5="您好，您的订单信息我们已经收到，我们将会在明天早上时间送至您门口。我们的服务与质量，从一而终！";
        String json = TemplateInfo.New()
                .setTouser(touser)
                .setTemplate_id(template_id1)
                .setForm_id(formId)
                .setPage("pages/index/index")
                .add("keyword1",keyword1,"#173177")
                .add("keyword2",keyword2,"#173177")
                .add("keyword3",keyword3,"#173177")
                .add("keyword4",keyword4,"#173177")
                .add("keyword5",keyword5,"#173177")
                .build();
        JSONObject jsonObject =   HttpUtil.httpsRequest(MENDMESSAGE+getAccess_token(),"POST", json);
        System.out.println("result"+jsonObject.toJSONString());
        return  jsonObject.toJSONString();

    }*/


    //购买会员通知
    public  static String payVip(String touser, String formId, String money,String month) {
        String keyword1=month+"个月";
        String keyword2=money+"元";
        String keyword3="19902916261";
        String keyword4="海星配送"+month+"个月会员";
        String keyword5="您好，您已经成为了我们尊贵的会员，您接下来将拥有免配送费、无条件退货等相关会员权利，感谢您的支持！";

        String json = TemplateInfo.New()
                .setTouser(touser)
                .setTemplate_id(template_id2)
                .setForm_id(formId)
                .setPage("pages/index/index")
                .add("keyword1",keyword1,"#173177")
                .add("keyword2",keyword2,"#173177")
                .add("keyword3",keyword3,"#173177")
                .add("keyword4",keyword4,"#173177")
                .add("keyword5",keyword5,"#173177")
                .build();
        JSONObject jsonObject =   HttpUtil.httpsRequest(MENDMESSAGE+getAccess_token(),"POST", json);
        System.out.println("result"+jsonObject.toJSONString());
        return  jsonObject.toJSONString();

    }



    //申请售后通知
    public  static String refundsOrderInfo(String touser, String formId, String orderno,String remark) {
        String keyword1="售后申请";
        String keyword2="审核中";
        String keyword3=orderno;
        //String keyword4=DateUtil.getStringDate();
        String keyword5="您的退款申请我们已经处理，我们会在1天内把相关款项原路退回至您微信，请您注意查收。给您造成的不便敬请谅解，祝您生活愉快！";
        String json = TemplateInfo.New()
                .setTouser(touser)
                .setTemplate_id(template_id3)
                .setForm_id(formId)
                .setPage("pages/index/index")
                .add("keyword1",keyword1,"#173177")
                .add("keyword2",keyword2,"#173177")
                .add("keyword3",keyword3,"#173177")
                .add("keyword4",keyword3,"#173177")
                .add("keyword5",keyword5,"#173177")
                .build();
        JSONObject jsonObject =   HttpUtil.httpsRequest(MENDMESSAGE+getAccess_token(),"POST", json);
        System.out.println("result"+jsonObject.toJSONString());
        return  jsonObject.toJSONString();

    }

    //订单状态通知
    /*public  static String sendOrderStatus(String touser, String formId, OrderDO orderDO) {
        String first="您好，您的订单已与小区其他业主的菜一起送到了小区，稍后我们会在您要求的时间内送至您楼上，感谢您的支持，祝您生活愉快!";
        String remark ="我们的服务与态度，从一而终———————海星配送";
        String keyword1=orderDO.getOrderno();
        String keyword2=DateUtil.dateToStrLong(orderDO.getCreatetime());
        String keyword3=orderDO.getRealtotalmoney()+"元";
        String keyword4=orderDO.getUsername();
        String keyword5=orderDO.getUseraddress();
        String json = TemplateInfo.New()
                .setTouser(touser)
                .setTemplate_id(template_id4)
                .setUrl("http://weixin.qq.com/download")
                .setForm_id(formId)
                .setPage("pages/index/index")
                .setMini(Configure.getAppID(),"pages/index/index")
                .add("first",first,"#173177")
                .add("keyword1",keyword1,"#173177")
                .add("keyword2",keyword2,"#173177")
                .add("keyword3",keyword3,"#173177")
                .add("keyword4",keyword4,"#173177")
                .add("keyword5",keyword5,"#173177")
                .add("remark",remark,"#173177")
                .build();
        System.out.println("json"+json);
        JSONObject jsonObject =   HttpUtil.httpsRequest(MENDMESSAGEFWH+getAccess_tokenGZH(),"POST", json);
        System.out.println("result"+jsonObject.toJSONString());
        return  jsonObject.toJSONString();

    }*/


    //订单完成通知
    /*public  static String sendOrderEnd(String touser, String formId,OrderDO orderDO) {
        String keyword1=orderDO.getOrderno();
        String keyword2=orderDO.getRealtotalmoney()+"元";
        String keyword3=orderDO.getUseraddress();
        String keyword4="您的订单已完成，后续如果有什么问题请联系我们售后，感谢您的支持，祝您生活愉快!";
        String json = TemplateInfo.New()
                .setTouser(touser)
                .setTemplate_id(template_id5)
                .setForm_id(formId)
                .setPage("pages/index/index")
                .add("keyword1",keyword1,"#173177")
                .add("keyword2",keyword2,"#173177")
                .add("keyword3",keyword3,"#173177")
                .add("keyword4",keyword4,"#173177")
                .build();
        JSONObject jsonObject =   HttpUtil.httpsRequest(MENDMESSAGE+getAccess_token(),"POST", json);
        System.out.println("result"+jsonObject.toJSONString());
        return  jsonObject.toJSONString();

    }
*/


}
