<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.baidu.youxi.open.javaDemo.Util"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="javascript:loginGame.submit">POST方式登录游戏Demo</a>
    <form name="loginGame" method=post action="/enterGameServlet">
    <input type="text" name="user_id" value="6789" />
    <input type="text" name="api_key" value=""/>
    <input type="text" name="server_id" value=""/>
    <input type="text" name="cm_flag" value="y"/>
    <input type="text" name="timestamp" value=""/>
    <input type="text" name="sign" value=""/>   
    </form>
    <br/>
    <br/>
    <br/>
  
  </body>
</html>
