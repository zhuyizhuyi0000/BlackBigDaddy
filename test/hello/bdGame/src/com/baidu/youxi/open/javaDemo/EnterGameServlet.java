package com.baidu.youxi.open.javaDemo;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 接收登录游戏请求，进入游戏模块
 */
public class EnterGameServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6616732486082643001L;
	private static final Log Logger = LogFactory.getLog(EnterGameServlet.class);

	/**
	 * Constructor of the object.
	 */
	public EnterGameServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
					IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
					IOException {
		try {
			/**需要的参数：
			 * user_id、server_id、cm_flag、timestamp、sign
			 * 
			 */
			String userId = request.getParameter("user_id");
			if ("".equals(userId)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3009");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}

			String serverId = request.getParameter("server_id");
			if ("".equals(serverId)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3012");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}

			String cmFlag = request.getParameter("cm_flag");
			if ("".equals(cmFlag)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3013");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			
			String timestamp = request.getParameter("timestamp");
			if ("".equals(timestamp)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3014");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			
			String sign = request.getParameter("sign");
			if ("".equals(sign)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3015");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			
            TreeMap<String, String> params = new TreeMap<String, String>();
            params.put("user_id", userId);
            params.put("server_id", serverId);
            params.put("api_key", Util.API_KEY);
            params.put("cm_flag", cmFlag);
            params.put("timestamp", timestamp);
            
            String signature = Util.sign(params, Util.API_SERCET);
            System.out.println(signature);
            
           
            if(signature.equals(sign)){
            	
				request.getRequestDispatcher("game.jsp").forward(request,response);
           
            }else{ // 如果签名不对，则返回
            	
    			request.setAttribute("msg", "登录游戏失败：签名不正确");
    			request.getRequestDispatcher("error.jsp").forward(request,response);
            
            }			

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "服务器异常，请稍候再试！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
	}	
	
}
