package dolink;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;

public class LightLoad {
	public static void main(String args[]){
	String user_id ;
	String api_key ;
	String server_id ;
	String cm_flag ;
	String timestamp ;
	String secret;
	String sign = "" ;
	String jscx_sign = "";
	String cz_sign = "";
	String yuming = "";
	String yuming2 = "";
	String yuming3 = "";
	
	
	user_id = "744312825";
//	user_id = "235143816";
	
//	api_key = "3de397e1013dbd2c3a687a59eddad187";
	api_key = "43a9a8ea01436a7c2c100f46ad61fa40";
//	server_id = "2";
	server_id = "s1";
	cm_flag = "n";
//	secret = "8aa6198d3de397e1013deddad1877a5a";
	secret = "8a9a5db843a9a8ea0143ad61fa400f47";
	yuming ="http://m0636.baiduwebgame.com/dntgg/dntglg";
	yuming2 ="http://dntg.pay.lingyuwangluo.com/dntgc/dntgrls";
	yuming3 ="http://baidu.wolcool.com:18000";
	timestamp =	getNowTime() ;
//	System.out.println(timestamp);
	
	TreeMap<String,String> feiqi = new TreeMap<String,String>();
	feiqi.put("user_id", user_id);
	feiqi.put("api_key", api_key);
	feiqi.put("server_id", server_id);
	feiqi.put("cm_flag", cm_flag);
	feiqi.put("timestamp", timestamp);

	String chuan = sign(feiqi,secret);
//	System.out.println(chuan);
	sign = md5(chuan);
//	System.out.println(sign);
	
	String test = yuming + "?" + "user_id=" + user_id + "&api_key=" + api_key + "&server_id=" + server_id + "&cm_flag=" + cm_flag + "&timestamp=" + timestamp + "&sign=" + sign;

//	System.out.println(test);
////////////////////////////////////////	
//	
	TreeMap<String,String> jscx = new TreeMap<String,String>();
	jscx.put("user_id", user_id);
	jscx.put("api_key", api_key);
	jscx.put("server_id", server_id);
	jscx.put("timestamp", timestamp);

	String chuan2 = sign(jscx,secret);
//	System.out.println(chuan2);
	jscx_sign = md5(chuan2);
//	System.out.println(jscx_sign);
	
	String test2 = yuming2 + "?" + "user_id=" + user_id + "&api_key=" + api_key + "&server_id=" + server_id +  "&timestamp=" + timestamp + "&sign=" + jscx_sign;

//	System.out.println(test2);
////////////////////////////////////////
//	
	String order_id = "test88888";
	String wanba_oid ="test99999";
	String amount ="1";
	String currency = "CNY";
	String result = "1";
	String back_send = "Y";
//	String back_send = "N";	
	
	TreeMap<String,String> cz = new TreeMap<String,String>();
	cz.put("user_id", user_id);
	cz.put("api_key", api_key);
	cz.put("server_id", server_id);
	cz.put("timestamp", timestamp);
	cz.put("order_id", order_id);
	cz.put("wanba_oid", wanba_oid);
	cz.put("amount", amount);
	cz.put("currency", currency);
	cz.put("result", "1");
	cz.put("back_send", back_send);

	
	String chuan3 = sign(cz,secret);
	cz_sign = md5(chuan3);
	
	String test3 = yuming3 + "?" + "user_id=" + user_id + "&api_key=" + api_key + "&server_id=" + server_id +  "&timestamp=" + timestamp + "&order_id=" + order_id +"&wanba_oid="+wanba_oid +"&amount="+amount+"&currency="+currency+"&result="+result+"&back_send="+back_send+ "&sign=" + cz_sign;
	@SuppressWarnings("deprecation")
	String timestamp1 =URLEncoder.encode(timestamp);
	String test4 = yuming3 + "?" + "user_id=" + user_id + "&api_key=" + api_key + "&server_id=" + server_id +  "&timestamp=" + timestamp1 + "&order_id=" + order_id +"&wanba_oid="+wanba_oid +"&amount="+amount+"&currency="+currency+"&result="+result+"&back_send="+back_send+ "&sign=" + cz_sign;
	 
	System.out.println(test3);
	System.out.println(test4);
	}
	
public static String getNowTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(new Date());
		   }

public static String sign(TreeMap<String, String> params, String secret) {

	String result = null;
	if (params == null)
		return result;
	Iterator<String> iter = params.keySet().iterator();
	StringBuffer sec = new StringBuffer(secret);
	while (iter.hasNext()) {
		String name = (String) iter.next();
		sec.append(name).append(params.get(name));
	}
	result = sec.toString();
//	System.out.println(result);
	return result;
}

public static String md5(String chuan){
	String result = null;
	if (chuan == null)
		return result;
	try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		result = byte2hex(md.digest(chuan.getBytes("utf-8")));
	} catch (Exception ex) {
		throw new java.lang.RuntimeException("sign error !");
	}
	return result;
}

private static String byte2hex(byte[] j) {
	StringBuffer hs = new StringBuffer();
	String stmp = "";
	for (int i = 0; i < j.length; i++) {
		stmp = (java.lang.Integer.toHexString(j[i] & 0XFF));
		if (stmp.length() == 1)
			hs.append("0").append(stmp);
		else
			hs.append(stmp);
	}
	return hs.toString().toUpperCase();
}



}


