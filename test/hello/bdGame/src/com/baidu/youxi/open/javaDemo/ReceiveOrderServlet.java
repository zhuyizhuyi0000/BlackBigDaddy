package com.baidu.youxi.open.javaDemo;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 游戏厂商接收百度游戏平台成功订单通知
 * 
 *
 */
public class ReceiveOrderServlet extends HttpServlet{
	/**
	 * Constructor of the object.
	 */
	public ReceiveOrderServlet() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

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
		String return_attach = request.getParameter("return_attach"); //url重写了，编码是utf-8
		String sign = request.getParameter("sign"); 

		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		apiparamsMap.put("api_key", api_key);
		apiparamsMap.put("order_id", order_id);
		apiparamsMap.put("wanba_oid", wanba_oid);
		apiparamsMap.put("amount", amount);
		apiparamsMap.put("currency", currency);
		apiparamsMap.put("result", result);
		apiparamsMap.put("back_send", back_send);
		apiparamsMap.put("return_attach", return_attach);
		
		
		System.out.println(apiparamsMap);
		// 如果签名不对，则返回
//		if (!sign.equals(Util.sign(apiparamsMap, Util.API_SERCET))) {
//			request.setAttribute("msg", "签名不对");
//			request.getRequestDispatcher("error.jsp")
//					.forward(request, response);
//		}else{
//			//后台通知返回
//			if ("Y".equals(back_send)) {
//				response.getWriter().print(Util.LAST_NOTICE_SUCCESS_CONTENT);
//				response.getWriter().close();
//			} else {//前台通知处理
//				request.setAttribute("msg", "收到订单");
//				request.getRequestDispatcher("error.jsp")
//						.forward(request, response);
//			}
//		}
		return;	
	}
}
