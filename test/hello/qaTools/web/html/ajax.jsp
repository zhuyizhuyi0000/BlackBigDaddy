<%@ page language="java" pageEncoding="gb2312"%>
<%
    request.setAttribute("decorator", "none");

		// �����ı�����(content type)
		response.setContentType("text/html");
		// �����ı����͵ı����ʽ
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
	  out.println("{msg:'hello,ajax!'}");	
%>
