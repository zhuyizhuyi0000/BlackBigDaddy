package com.baidu.youxi.open.javaDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 游戏厂商接收百度游戏平台成功订单通知
 *
 */
public class ReceiveOrderServlet extends HttpServlet{
	/**
	 * Constructor of the object.
	 */
	int game_id_test = 392;
		
	/**
	 * 游戏唯一标识
	 */
	public final static String API_KEY_392 = "374091170137a21d74d0005c49e0b946";

	/**
	 * 游戏对应的密钥
	 */
	public final static String API_SERCET_392 = "8ad1a29c37409117013749e0b946005d";
	
	public ReceiveOrderServlet() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

//	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 百度游戏平台传递的参数
		 */
		String api_key = request.getParameter("api_key");
		String order_id = request.getParameter("order_id");
		String wanba_oid = request.getParameter("wanba_oid");
		String amount = request.getParameter("amount");
		String currency = request.getParameter("currency");
		String result = request.getParameter("result");
		String back_send = request.getParameter("back_send"); 
		String timestamp = request.getParameter("timestamp");
		String server_id = request.getParameter("server_id");
		String user_id = request.getParameter("user_id");
//		String return_attach = request.getParameter("return_attach"); //url重写了，编码是utf-8
		String sign = request.getParameter("sign"); 
		
		
//		Enumeration test = request.getParameterNames(); //发送请求页面中form表单里所有具有name属性的表单对象获取(包括button).返回一个Enumeration类型的枚举
//		StringBuffer allc =new StringBuffer();
//		while(test.hasMoreElements())
//		{
//			String alld =(String)test.nextElement();
//			allc.append(alld+",");
//		}
//		//writeGBKLog(allc.toString(),"D:/test.log");	
//		writeGBKLog(allc.toString(),"/home/work/local/tomcat/webapps/bdGame/log/test.log");
	
		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		apiparamsMap.put("api_key", api_key);
		apiparamsMap.put("order_id", order_id);
		apiparamsMap.put("wanba_oid", wanba_oid);
		apiparamsMap.put("amount", amount);
		apiparamsMap.put("currency", currency);
		apiparamsMap.put("result", result);
		apiparamsMap.put("back_send", back_send);
		apiparamsMap.put("timestamp", timestamp);
		apiparamsMap.put("server_id", server_id);
		apiparamsMap.put("user_id", user_id);

		
		writeGBKLog(apiparamsMap.toString(),"/home/work/local/tomcat/webapps/bdGame/log/test.log");
//		writeGBKLog(apiparamsMap.toString(),"D:/test.log");
	
		
//		PrintWriter pw = response.getWriter();
//
//		pw.println(api_key+"hello,world,My first Eclipse Servlet!"+order_id);

		
//		 如果签名不对，则返回
		if(!api_key.equals(API_KEY_392)){
			writeGBKLog("error!api_key WRONG!GAME ID:"+game_id_test,"/home/work/local/tomcat/webapps/bdGame/log/test.log");
			request.setAttribute("msg", "api_key不符");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}else{
			if (!sign.equals(Util.sign(apiparamsMap, API_SERCET_392))) {
			writeGBKLog("error!sign not equal!GAME ID:"+game_id_test,"/home/work/local/tomcat/webapps/bdGame/log/test.log");
			request.setAttribute("msg", "签名不对");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}else{
			//后台通知返回
			if ("Y".equals(back_send)) {
				writeGBKLog("OK!houtai~rev-ok,ID:"+game_id_test,"/home/work/local/tomcat/webapps/bdGame/log/test.log");
				response.getWriter().print(Util.LAST_NOTICE_SUCCESS_CONTENT);
				response.getWriter().close();
		}else{
			//前台通知处理
				writeGBKLog("OK!qiantai~rev-ok,ID:"+game_id_test,"/home/work/local/tomcat/webapps/bdGame/log/test.log");
				request.setAttribute("msg", "收到订单");
				request.getRequestDispatcher("error.jsp")
						.forward(request, response);
			}
		}
		}
		
//		response.getWriter().print(Util.LAST_NOTICE_SUCCESS_CONTENT);
//		response.getWriter().close();
		
		return;	
	}
public static void writeGBKLog(String msg, String logFileName) {
	PrintWriter pw = null;
	FileWriter logFile = null;
	File f = null;
	try {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		logFileName = logFileName + "." + dateFormat.format(new Date());
		f = new File(StringUtils.substringBeforeLast(logFileName, "/"));
		if (!f.exists()) {
			f.mkdirs();
		}
		logFile = new FileWriter(logFileName, true);
		pw = new PrintWriter(logFile);
		String printString = msg;
		pw.println(new String(printString.getBytes("gbk")));
		pw.flush();
		pw.close();
		pw = null;
		logFile.close();
		logFile = null;
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (pw != null)
			pw.close();
		pw = null;
		if (logFile != null) {
			try {
				logFile.close();
				logFile = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
}
