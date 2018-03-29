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
    
    <title>百度游戏java版demo</title>
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
  <h1>1、模拟进入游戏</h1>
    <form name="loginGame" method=post action="enterGameServlet">
    <input type="text" name="user_id" value="6789" />
    <input type="text" name="api_key" value="api_key"/>
    <input type="text" name="server_id" value="server_id"/>
    <input type="text" name="cm_flag" value="y"/>
    <input type="text" name="timestamp" value="2010-10-20 10:20:40"/>
    <input type="text" name="sign" value="D5DACCDAB3CC8A7B402D01870374721B"/>   
   <br/>
    <input type="submit" value="进入游戏">
    </form>
    
   <h1>2、充值接口,请查看ReceiveOrderServlet</h1>
    
   <h1>3、模拟实时POST角色</h1>
    <form name="loginGame" method=post action="postRoleServlet">
    <input type="text" name="user_id" value="6789" />
    <input type="text" name="api_key" value="api_key"/>
    <input type="text" name="server_id" value="server_id"/>
    <input type="text" name="role_name" value="role_name"/>
    <input type="text" name="action" value="action"/>
    <input type="text" name="timestamp" value="2010-10-20 10:20:40"/>
    <input type="text" name="sign" value="D5DACCDAB3CC8A7B402D01870374721B"/>   
   <br/>
    <input type="submit" value="实时POST角色">
    </form>
  
  </body>
</html>
