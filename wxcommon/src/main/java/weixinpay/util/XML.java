package weixinpay.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML与JavaBean相互转换工具类
 */
public  class XML {

    public static void main(String[] args) {
        String s="<xml><nonce_str>5K8264ILTKCH16CQ2502SI8ZNMTM67VS</nonce_str><out_trade_no>001t1521101043741</out_trade_no><device_info >WEB</device_info ><openid>o4lmljscgZDnjI4xthqMMnEr02fo</openid><total_fee>0.01</total_fee><trade_type>JSAPI</trade_type><body>商品描述。XX项目</body></xml>";
        Map map=readStringXmlOut(s);
        System.out.println(map.get("nonce_str"));
    }

    public static String map2XmlString(Map<String, String> map) {
        String xmlResult = "";

        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (String key : map.keySet()) {
            System.out.println(key + "========" + map.get(key));

            String value = "<![CDATA[" + map.get(key) + "]]>";
            sb.append("<" + key + ">" + value + "</" + key + ">");
            System.out.println();
        }
        sb.append("</xml>");
        xmlResult = sb.toString();

        return xmlResult;
    }

    /**
     * @param xml
     * @return Map
     * @description 将xml字符串转换成map
     */
    public static Map<String, String> readStringXmlOut(String xml) {
        Map<String, String> map = new HashMap<String, String>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            @SuppressWarnings("unchecked")
            List<Element> list = rootElt.elements();// 获取根节点下所有节点
            for (Element element : list) { // 遍历节点
                map.put(element.getName(), element.getText()); // 节点的name为map的key，text为map的value
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

