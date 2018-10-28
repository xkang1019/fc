package weixinpay.common;

/**
 * Created by 87734 on 2018/3/19.
 */
public class Config {
    public static String accessTokenUrl="https://api.weixin.qq.com/cgi-bin/token?appid=APPID&secret=SECRET&grant_type=client_credential";
    public static String appid="wx75cc21ff8c7f13a2";
    public static String secret="cb8bda00ca7f4f47a5710df3fac02f2c";
    public static String codeUrl="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=ACCESS_TOKEN";
    public static String getAccessTokenUrl(){
        return accessTokenUrl.replace("APPID",appid).replace("SECRET",secret);
    }
}
