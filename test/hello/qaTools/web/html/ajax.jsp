<%@ page language="java" pageEncoding="gb2312"%>
<%
    request.setAttribute("decorator", "none");

		// 设置文本类型(content type)
		response.setContentType("text/html");
		// 设置文本类型的编码格式
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
	  out.println("{msg:'hello,ajax!'}");	
%>
