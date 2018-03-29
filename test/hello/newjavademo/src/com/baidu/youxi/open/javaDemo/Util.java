package com.baidu.youxi.open.javaDemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * 
 * @author baidu youxi
 * 
 * 百度游戏平台接口工具类
 * 
 * API_KEY是游戏对应的GameID API_SERCET是游戏对应的CertKey
 * RECEIVIE_ORDER_URL是游戏厂商接收百度游戏平台成功订单通知的地址
 */
public class Util {
	/*-----------私有参数，即需要修改部分-------------*/
	/**
	 * 游戏ID,需要游戏平台人工提供
	 */
	public final static int GAME_ID = 319;

	/**
	 * 游戏唯一标识
	 */
	public final static String API_KEY = "25fcc8e001254ab5e52e0004fcccc82e";

	/**
	 * 游戏对应的密钥
	 */
	public final static String API_SERCET = "2c95998d25fcc8e00125fcccc82e0005";

	/**
	 * 游戏厂商接收百度游戏成功订单通知的地址
	 */
	public final static String RECEIVIE_ORDER_URL = "http://127.0.0.1:8080/javademo/receiveOrderServlet";

	/*-----------公共参数-------------*/
	/**
	 * 进入游戏的rest接口地址
	 */
	public final static String ENTER_GAME_REST_URL = "http://youxi.baidu.com/rest";

	/**
	 * 下订单rest接口地址
	 */
	public final static String REG_ORDER_REST_URL = "http://youxi.baidu.com/order_rest";

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

	public static void main(String[] args) {
		String s = "{response: {code: \"112\",msg: \"免登录成功\"}}";
		System.out.println(getStatusFromJSON(s));
	}
}
