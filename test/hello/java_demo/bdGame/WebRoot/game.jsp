<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gameList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body></br> </br>
  <div align="center">
           登录成功！
           开始 游戏页面。
  </div>
   <div align="center">
  user_id =<%=request.getAttribute("msg1") %></br>
  server_id=<%=request.getAttribute("msg2") %></br>
  api_key=<%=request.getAttribute("msg3") %></br>
  cm_flag=<%=request.getAttribute("msg4") %></br>
  time_stamp=<%=request.getAttribute("msg5") %></br>
  sign=<%=request.getAttribute("msg6") %></br>
   </div>
  </body>
</html>
