import java.security.MessageDigest;
import java.util.Iterator;
import java.util.TreeMap;

public class Changshang {
	public static void main(String args[])
	{
String lq="http://youxi.baidu.com/receive_order_new.xhtml?";
String lj="http://youxi.baidu.com/receive_order_new.xhtml?oid=133655435457919093&store_oid=220a16fa9d800adb0&pay_oid=133655435457919093&amount=1&currency=CNY&store_name=baidu_wanba&pay_name=BaiduCoin.&order_status=30&back_send=Y&return_attach=hand&sig=912f6741c684dc2502a81b02faaaf814";
String lk="http://youxi.baidu.com/receive_order_new.xhtml?oid=133657931837166762&store_oid=259a212654098a0b8&pay_oid=133657931837166762&amount=10&currency=CNY&store_name=baidu_wanba&pay_name=YeepayGameCard.JUNNET-NET&order_status=30&back_send=Y&return_attach=hand&sig=038770e6ccd1a7abf05d53039d3cdc2f";
String lh="http://youxi.baidu.com/receive_order_new.xhtml?oid=133657926547766742&store_oid=262a16a21f1237788&pay_oid=133657926547766742&amount=100&currency=CNY&store_name=baidu_wanba&pay_name=Yeepay.CCBC&order_status=30&back_send=Y&return_attach=hand&sig=f42a14b9987d8df5196d6cea8c2c24a1";

String lc="http://mall.com/somepath?";
String ld="http://mall.com/somepath?api_key=a001&user_id=110&server_id=s1&order_id=1234567890&wanba_oid=567567567&amount=100&currency=CNY&result=1&back_send=Y&timestamp=2010-04-22 12:12:12&sign=6B8F88EF76780B1195DAFFCEA3C81D28";

String API_KEY = "25fcc8e001254ab5e52e0004fcccc82e";
String API_SERCET = "2c95998d25fcc8e00125fcccc82e0005";

//	getrequest cc =new getrequest();
//	String result =cc.backSend(ld);
//	String api_key=cc.getApi_key();

//	String result =new getrequest().backSend(ld);
	String result =new getrequest().backSend(ld,API_KEY,API_SERCET);
	System.out.println(result);
	
//	System.out.println(api_key);

//private String api_key;
//private String user_id;
//private String server_id;
//private String order_id;
//private String wanba_oid;
//private String amount;    
//private String currency;  
//private String result;
//private String back_send;
//private String timestamp;
//private String sign;
//String api_key="";
//String user_id="";
//String server_id="";
//String order_id="";
//String wanba_oid="";
//String amount="";    
//String currency="";  
//String result="";
//String back_send="";
//String timestamp="";
//String sign="";
//final String Q_BACK_SEND ="N";
//final String H_BACK_SEND ="Y";
//final String FH="<!--recv=ok-->";
//System.out.println(lc.length());
//if(!ld.substring(0,lc.length()).equals(lc))
//	System.out.println("网址错误");
	
//lc,"api_key=","&user_id=","&server_id=","&order_id=","&wanba_oid=","&amount=","&currency=","&result=","&back_send=","&timestamp=","&sign="
//String link = ld.substring(ld.indexOf("?") + 1);
//System.out.println(link);

//String[] sArray=new String[30];
//sArray=link.split("\\&");
//for(int i=0;i<sArray.length;i++)
//{
//	
//	sArray[i]=sArray[i].substring(sArray[i].indexOf("=")+1);
//
//	System.out.println("i="+sArray[i]);
//}

//api_key=sArray[0];
//user_id=sArray[1];
//server_id=sArray[2];
//order_id=sArray[3];
//wanba_oid=sArray[4];
//amount=sArray[5];    
//currency=sArray[6];  
//result=sArray[7];
//back_send=sArray[8];
//timestamp=sArray[9];
//sign=sArray[10];
//
//if(back_send.equals(H_BACK_SEND))
//	System.out.println("1");
//else if(back_send.equals(Q_BACK_SEND))
//	System.out.println("2");
//else
//	System.out.println("E");

	}
}

class getrequest
{
	private String api_key;
	private String user_id;
	private String server_id;
	private String order_id;
	private String wanba_oid;
	private String amount;    
	private String currency;  
	private String result;
	private String back_send;
	private String timestamp;
	private String sign;
	private static final String Q_BACK_SEND ="N";
	private static final String H_BACK_SEND ="Y";
	private static final String FH="<!--recv=ok-->";
//	private static final String URL_HEAD="http://mall.com/somepath?";
	
//	public final static String API_KEY = "25fcc8e001254ab5e52e0004fcccc82e";
//	public final static String API_SERCET = "2c95998d25fcc8e00125fcccc82e0005";
	public String cm_flag ="y";
	
	public getrequest()
	{}
//	public String backSend(String Url)
	public String backSend(String Url,String API_KEY,String API_SERCET)
	{
		if(Url == null)
		return "通知为空";
		else if(API_KEY == null)
			return "缺少API_KEY";
		else if(API_SERCET == null)
			return "缺少API_SERCET";
//		if(!Url.substring(0,URL_HEAD.length()).equals(URL_HEAD))
//			{
//			return "网址错误";
//			}
		
		String link = Url.substring(Url.indexOf("?") + 1);
		
		String[] sArray=new String[30];
		sArray=link.split("\\&");
		for(int i=0;i<sArray.length;i++)
		{	
			sArray[i]=sArray[i].substring(sArray[i].indexOf("=")+1);
			if (sArray[i].length()<=0 || sArray[i] ==null)
				return "传递参数错误，缺少第"+(i+1)+"项";
		}
		try
		{
		this.api_key=sArray[0];
		this.user_id=sArray[1];
		this.server_id=sArray[2];
		this.order_id=sArray[3];
		this.wanba_oid=sArray[4];
		this.amount=sArray[5];    
		this.currency=sArray[6];  
		this.result=sArray[7];
		this.back_send=sArray[8];
		this.timestamp=sArray[9];
		this.sign=sArray[10];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return "Url格式不对";
		}
		
		TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("user_id", user_id);
        params.put("server_id", server_id);
        params.put("api_key", API_KEY);
        params.put("cm_flag", cm_flag);
        params.put("timestamp", timestamp);
        
        String result007 =null;
        
//		System.out.println(params+"+++"+API_KEY+"+++"+API_SERCET);
		Iterator<String> iter = params.keySet().iterator();
		StringBuffer orgin = new StringBuffer(API_SERCET);
		while (iter.hasNext()) {
			String name = (String) iter.next();
			orgin.append(name).append(params.get(name));
		}
//		System.out.println(orgin);
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			result007 = byte2hex(md5.digest(orgin.toString().getBytes("utf-8")));
		} catch (Exception ex) {
			throw new java.lang.RuntimeException("sign error !");
		}
//		System.out.println(result007);
//		System.out.println(sign);	
		if(result007 == null || !result007.equals(sign))
			return "签名认证错误！";
		
		if(back_send.equals(H_BACK_SEND))
			return FH;
		else if(back_send.equals(Q_BACK_SEND))
			return "前台通知OK";
		else
			return "ERROR";


	}
	/**
	 * 二进制转字符串
	 */
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

	public String getApi_key()
	{
		return api_key;
	}
	public String getUser_id()
	{
		return user_id;
	}
	public String getServer_id()
	{
		return server_id;
	}
	public String getOrder_id()
	{
		return order_id;
	}
	public String getWanba_oid()
	{
		return wanba_oid;
	}
	public String getAmount()
	{
		return amount;
	}
	public String getCurrency()
	{
		return currency;
	}
	public String getResult()
	{
		return result;
	}
	public String getBack_send()
	{
		return back_send;
	}
	public String getTimestamp()
	{
		return timestamp;
	}
	public String getSign()
	{
		return sign;
	}
}
