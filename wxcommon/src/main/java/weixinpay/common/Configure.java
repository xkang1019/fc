package weixinpay.common;

public class Configure {
//	private static String key = "Zlj15118039179106771571910677157";//"你的商户的api秘钥";

	private static String key = "cnmcnmcnmcnmcnmcnmcnmcnmcnmcnm66";//"你的商户的api秘钥";
	//小程序ID
	//private static String appID = "wxc28fb3fa952224c6";//你的小程序id

	private static String appID = "wx41c0216a833ba01a";
	//商户号
	private static String mch_id = "1501784421";  //"你的商户号";
	//你的小程序的secret
	//private static String secret = "6499466b7590a8a5ce569b3bc21852ba";

	private static String secret = "9be4961adeea29c50ae8562c5ac66c9b";


	private static  String GzhAppId ="wx9753ad1c9b413b7f";

	private static  String GzhSecret ="26ba6fa2f7239fcc7d96a7c41cf733ec";

	private static  String appidmm = "wx28cc809e924ed56b";//fc

	private static String secretmm= "c4ac7344f8ae120f9da65019e7f48d0d";//fc


	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		Configure.secret = secret;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static String getMch_id() {
		return mch_id;
	}

	public static void setMch_id(String mch_id) {
		Configure.mch_id = mch_id;
	}

	public static String getGzhAppId() {
		return GzhAppId;
	}

	public static void setGzhAppId(String gzhAppId) {
		GzhAppId = gzhAppId;
	}

	public static String getGzhSecret() {
		return GzhSecret;
	}

	public static void setGzhSecret(String gzhSecret) {
		GzhSecret = gzhSecret;
	}

	public static String getAppidmm() {
		return appidmm;
	}

	public static void setAppidmm(String appidmm) {
		Configure.appidmm = appidmm;
	}

	public static String getSecretmm() {
		return secretmm;
	}

	public static void setSecretmm(String secretmm) {
		Configure.secretmm = secretmm;
	}
}
