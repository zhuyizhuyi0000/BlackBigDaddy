package com.baidu.youxi.open.javaDemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class Util {
	/*-----------私有参数，即需要修改部分-------------*/
	/**
	 * 游戏ID,需要游戏平台人工提供
	 */
	public final static int GAME_ID = 392;

	/**
	 * 游戏唯一标识
	 */
	public final static String API_KEY = "374091170137a21d74d0005c49e0b946";

	/**
	 * 游戏对应的密钥
	 */
	public final static String API_SERCET = "8ad1a29c37409117013749e0b946005d";

	/**
	 * 游戏厂商接收百度游戏成功订单通知的地址
	 */
	public final static String RECEIVIE_ORDER_URL = "http://bb-game-test09.vm.baidu.com:8080/bdGame/receiveOrderServlet";

	/*-----------公共参数-------------*/
	/**
	 * 进入游戏的rest接口地址
	 */
	public final static String ENTER_GAME_REST_URL = "http://youxibeta.baidu.com/rest";

	/**
	 * 下订单rest接口地址
	 */
	public final static String REG_ORDER_REST_URL = "http://youxibeta.baidu.com/order_rest";
	
	/**
	 * POST角色rest接口地址
	 */
	public final static String ROLE_REST_URL = "http://youxibeta.baidu.com/game_role_rest";

	public final static String BASE_CODE = "utf-8";

	public final static String ISO_CODE = "iso-8859-1";

	/**
	 * 版本号
	 */
	public final static String VERSION = "1.0";

	/**
	 * 下订单最大金额
	 */
	public final static float MAX_AMOUNT = 10000000.0f;

	/**
	 * 后台通知成功返回内容
	 */
	public final static String LAST_NOTICE_SUCCESS_CONTENT = "<!--recv=ok-->";

	/**
	 * 后台通知失败返回内容
	 */
	public final static String LAST_NOTICE_FAIL_CONTENT = "<!--recv=fail-->";

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

	/**
	 * 
	 * @param apiparamsMap
	 * @return
	 * 
	 * 组装url参数
	 */
	public static String tranferMapToUrl(TreeMap<String, String> apiparamsMap) {
		StringBuilder param = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<String, String> e = it.next();
			param.append("&").append(e.getKey()).append("=").append(
					e.getValue());
		}
		return param.toString().substring(1);
	}

	/**
	 * 签名方法，用于生成签名。
	 * 
	 * @param params
	 *            传给服务器的参数
	 * 
	 * @param secret
	 *            分配给您的APP_SECRET
	 */
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
		System.out.println("source string is :"+orgin.toString());
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byte2hex(md.digest(orgin.toString().getBytes(BASE_CODE)));
		} catch (Exception ex) {
			throw new java.lang.RuntimeException("sign error !");
		}
		return result;
	}

	/**
	 * 得到返回的内容
	 */
	public static String getResult(String urlStr, String content) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.connect();

			// 写数据流
			DataOutputStream out = new DataOutputStream(connection
					.getOutputStream());
			out.writeBytes(content);
			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), BASE_CODE));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return null;
	}

	/**
	 * 解释xml得到状态值
	 * 
	 * @param resultStr
	 * @return
	 */
	public static String getStatusFromXML(String resultStr) {
		String status = "";
		StringReader read = null;
		InputSource source = null;
		SAXBuilder builder = null;
		Document document = null;

		try {
			read = new StringReader(resultStr);
			source = new InputSource(read);
			builder = new SAXBuilder();
			document = builder.build(source);
			Element root = document.getRootElement();

			if (root.getChild("code") != null) {
				status = root.getChild("code").getText();
			} else
				status = root.getChild("error_code").getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (read != null) {
				read.close();
			}
		}

		return status;
	}

	/**
	 * 解释json得到状态值
	 * 
	 * @param resultStr
	 * @return
	 */
	public static String getStatusFromJSON(String resultStr) {
		String status = "";
		JSONObject json = ((JSONObject) JSONObject.fromObject(resultStr).get(
				"response"));
		if (json.containsKey("code")) {
			status = json.getString("code");
		} else {
			status = json.getString("error_code");
		}
		return status;
	}
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
	
	
	/**
	 * 读取游戏厂商的信息
	 * 
	 * @return
	 */
	public static String postAppInfo(java.util.Map sigMap, String callUrl) {
		BufferedReader reader = null;
		String resStr = "";
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter("http.socket.timeout", 3000);
		PostMethod pMethod = null;
		try {
			pMethod = new PostMethod(callUrl);
		} catch (Exception e) {
			return "ERROR_-100";
		}
		
		Object[] keys = sigMap.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			pMethod.addParameter(keys[i].toString(), sigMap.get(
					keys[i].toString()).toString());
		}

		try {
			int ret = httpClient.executeMethod(pMethod);
			if (ret >= 200 && ret <= 399) { // 通知成功
				reader = new BufferedReader(new InputStreamReader(pMethod
						.getResponseBodyAsStream()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					resStr = line;
				}
				reader.close();
				
			}
		} catch (HttpException e) {
			return "ERROR_http";
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR_io";
		}finally{
				try {
					if(reader!= null)
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return resStr;
	}
    /**
     * 以固定编码方式进行编码
     * @param srcStr
     * @param code
     * @return
     */
	public static String encodeStr(String srcStr, String code) {
		String s = "";
		if (!StringUtils.isBlank(srcStr)) {
			try {
				s = URLEncoder.encode(srcStr, code);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;
	}
	public static void main(String[] args) {
		String s = "{response: {code: \"112\",msg: \"免登录成功\"}}";
		System.out.println(getStatusFromJSON(s));
	}
}
