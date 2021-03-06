package weixinpay.common;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


public class HttpRequest {
	//连接超时时间，默认10秒
    private static final int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private static final int connectTimeout = 30000;

	private static final org.slf4j.Logger L = LoggerFactory.getLogger(HttpRequest.class);


	/**
	 * post请求
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyStoreException 
	 * @throws KeyManagementException 
	 * @throws UnrecoverableKeyException 
	 */
	public static String sendPost(String url, Object xmlObj,String openid) throws ClientProtocolException, IOException, UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		

        
		HttpPost httpPost = new HttpPost(url);
		//解决XStream对出现双下划线的bugnew XmlFriendlyNameCoder("-_", "_")
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8"));// new XmlFriendlyNameCoder("-_", "_")
        xStreamForRequestPostData.alias("xml", xmlObj.getClass());
        //将要提交给API的数据对象转换成XML格式数据Post给API
        //String postDataXML = xStreamForRequestPostData.toXML(xmlObj).replace("__", "_");
		String postDataXML = xStreamForRequestPostData.toXML(xmlObj);
		postDataXML = postDataXML.replace("__", "_");

		L.info("postDataXML",postDataXML);

		String  xmlstrat = postDataXML.substring(0,postDataXML.lastIndexOf("<openid>"));
		String open = "<openid>"+openid+"</openid>";
		String  xmlend = postDataXML.substring(postDataXML.lastIndexOf("</openid>")+9);

		postDataXML =xmlstrat+open+xmlend;
		L.debug("postDataXML修改opneid后",postDataXML);
		System.out.println("对象转换成XML格式数据"+postDataXML);
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
		System.out.println("对象--------------"+postEntity);
        //设置请求器的配置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
		System.out.println("requestConfig--------------"+requestConfig);
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        return result;
	}
	/**
	 * 自定义证书管理器，信任所有证书
	 * @author pc
	 *
	 */
	public static class MyX509TrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(
				java.security.cert.X509Certificate[] arg0, String arg1)
				throws java.security.cert.CertificateException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void checkServerTrusted(
				java.security.cert.X509Certificate[] arg0, String arg1)
				throws java.security.cert.CertificateException {
			// TODO Auto-generated method stub
			
		}
		@Override
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
      }


}
