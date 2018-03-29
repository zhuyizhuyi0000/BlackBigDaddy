<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="com.baidu.wanba.util.*"%>
<%@ page language="java" import="java.io.UnsupportedEncodingException"%>
<%
	int databaseNum = 0;
	int gameid = 0;
	int jiekouNum=0;
	int htNum=0;
	String coid = "";
	String username = "";
    String msg1="";
	String msg2="";
	String ht1="";
	String ht1t="";
	String htlink="";
	databaseNum = Integer.parseInt(request.getParameter("databaseNum"));
	coid = request.getParameter("coid");
	username = request.getParameter("username");
	gameid = Integer.parseInt(request.getParameter("gameid"));
	jiekouNum = Integer.parseInt(request.getParameter("jiekouNum"));
	htNum = Integer.parseInt(request.getParameter("htNum"));
	if(htNum == 0){
		ht1="http://10.48.25.72:8092/admin/admin_cache_tool.xhtml?key=OrderInfoService.getOrderInfoById.";
		ht1t=".storeName.baidu_wanba";
	}else if(htNum == 1){
		ht1="http://10.23.238.221:8080/admin/admin_cache_tool.xhtml?key=OrderInfoService.getOrderInfoById.";
		ht1t=".storeName.baidu_wanba";
	}
	
	CreateBackUrl userinfo = new CreateBackUrl();
	String msg =userinfo.selectdo(databaseNum,coid,username,gameid,jiekouNum);
	if(msg.length()>50)
			{
				String[] sArray=new String[30];
				sArray=msg.split("\\%");
				msg1=sArray[0];
				msg2=sArray[1];
				coid=sArray[2];
				msg ="";
				htlink=ht1+coid+ht1t;
			}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP  starting page</title>
<script type="text/javascript">
var oid ="<%=coid%>";
var doid="<%=htlink%>";
if(oid != ""){
      window.onload=function(){
     	window.open(doid);
      }}
	</script>
	
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
	<form id="Form" name="Form" action="/chargeorder.jsp" method="post">
	
	


		
		<h2>结果</h2><h3><%=msg%><br></h3>
		<p>
			<table id="tooltable" width="100%" border="1">
	

		<h3>订单号：<%=coid%> <br></h3><h3>后台通知：
		<br> 
		<input type="text" name="username1" value="<%=msg1%>" size="60%">  
		<br> <INPUT name="pclog" type="button" value="后台GO" onClick="window.open('<%=msg1%>')"  >
		<h3> 
		</h3>前台通知：
		<br> 
		<input type="text" name="username2" value="<%=msg2%>" size="60%">  <br> 
		<br><INPUT name="pclog2" type="button" value="前台GO" onClick="window.open('<%=msg2%>')" >
 
		<br> 
 
	</h3></body>
</html>
