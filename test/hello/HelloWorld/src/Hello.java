import java.security.MessageDigest;
import java.util.Iterator;
import java.util.TreeMap;

public class Hello
{
	public final static String BASE_CODE = "utf-8";
	public final static String API_SERCET_398 ="8a9a538c3de38a2e013dfcc111e746ce";
  public static void main (String args[])
  {
//	 String ddd ="http://youxi.baidu.com/jee.xhtml";
//	 if (ddd.contains("html"))
//	 {
//		 System.out.print("1");
//	 }
//	 int i=127;
//	 double c; 
//	 float d;
//	 c = i + 1;
//	 d = i + 1;
//	 System.out.print(c);
//	 System.out.print(d);
	  String api_key ="3de38a2e013daa4ec12846cdfcc111e7" ;
		String order_id = "499a140dc9db60490";
		String wanba_oid = "136691830075420091";
		String amount = "1";
		String currency ="CNY";
		String result = "1";
		String back_send = "Y"; 
		String timestamp = "2013-04-26 03:42:20";
		String server_id ="0" ;
		String user_id = "744312825";
		String API_SERCET_392="8a9a538c3de38a2e013dfcc111e746ce";
		TreeMap<String, String> apiparamsMap3 = new TreeMap<String, String>();
		apiparamsMap3.put("api_key", api_key);
		apiparamsMap3.put("order_id", order_id);
		apiparamsMap3.put("wanba_oid", wanba_oid);
		apiparamsMap3.put("amount", amount);
		apiparamsMap3.put("currency", currency);
		apiparamsMap3.put("result", result);
		apiparamsMap3.put("back_send", back_send);
		apiparamsMap3.put("timestamp", timestamp);
		apiparamsMap3.put("server_id", server_id);
		apiparamsMap3.put("user_id", user_id);
		String sign =sign(apiparamsMap3, API_SERCET_398);
		System.out.print(sign);
		
  }
  public static String sign(TreeMap<String, String> params, String secret) {

		String result = null;
		if (params == null)
			return result;
		Iterator<String> iter = params.keySet().iterator();
		StringBuffer orgin = new StringBuffer(secret);
		while (iter.hasNext()) {
			String name = (String) iter.next();
			orgin.append(name).append(params.get(name));
		}
//		System.out.println("source string is :"+orgin.toString());
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byte2hex(md.digest(orgin.toString().getBytes(BASE_CODE)));
		} catch (Exception ex) {
			throw new java.lang.RuntimeException("sign error !");
		}
		return result;
	}
  private static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}
}