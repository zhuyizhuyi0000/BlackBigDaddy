package com.baidu.youxi.open.javaDemo;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author baidu youxi
 * 通过post方式发送角色参数，进入游戏模块
 */
public class PostRoleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6616732486082643001L;
	private static final Log Logger = LogFactory.getLog(PostRoleServlet.class);

	/**
	 * Constructor of the object.
	 */
	public PostRoleServlet() {
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
			 * user_id、server_id、api_key、role_name、action、timestamp、sign
			 * 
			 */
			String user_id = request.getParameter("user_id");
			if ("".equals(user_id)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3009");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}

			String server_id = request.getParameter("server_id");
			if ("".equals(server_id)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3012");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}

			String api_key = request.getParameter("api_key");
			if ("".equals(api_key)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3013");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}

			
			String role_name = request.getParameter("role_name");
			if ("".equals(role_name)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3015");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
			String action = request.getParameter("action");
			if ("".equals(action)) {
				request.setAttribute("msg", "传递参数错误！错误代码：3016");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}	
			
			//一下这句是专门针对从页面提交过来的参数，如果role_name不是从页面提交过来，不需要以下这句
			role_name=new String(role_name.getBytes("ISO8859-1"),"GBK");
			
			role_name=Util.encodeStr(role_name, "UTF-8");
            TreeMap<String, String> params = new TreeMap<String, String>();
            String timestamp=Util.getFormatDate(new Date(), "yyyy-MM-dd hh:mm:ss");
            params.put("user_id", user_id);
            params.put("server_id", server_id);
            params.put("api_key", api_key);
            params.put("role_name", role_name);
            params.put("timestamp",timestamp );
            params.put("action", action);
            String signature = Util.sign(params,Util.API_SERCET);
            
            Map sigMap = new HashMap<String, String>();
            sigMap.put("user_id", user_id);
            sigMap.put("server_id", server_id);
            sigMap.put("api_key", api_key);
            sigMap.put("role_name", role_name);
            sigMap.put("timestamp", timestamp);
            sigMap.put("action", action);
            sigMap.put("sign", signature);
            System.out.println("signature is "+signature);
            String res=Util.postAppInfo(sigMap, Util.ROLE_REST_URL);
            response.getWriter().print(res);

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
