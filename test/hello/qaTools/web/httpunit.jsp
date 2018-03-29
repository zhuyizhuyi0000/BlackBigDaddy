<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="com.baidu.wanba.core.tool.*"%>
<%@ page language="java" import="java.io.UnsupportedEncodingException"%>
<%
//db
String dbUrl= request.getParameter("dbUrl");
String dbUser="";
String dbPwd="";


if (dbUrl.equals("test09")){
  dbUrl="jdbc:mysql://10.32.48.25:3306/httpunitcase?useUnicode=true&characterEncoding=UTF-8";
  dbUser="game";
  dbPwd="game";
}

System.out.println("111111111111111:");
String id = request.getParameter("id");
System.out.println("22222222222222222:");

String caseSql = "select * from http_case where id =" + id;

System.out.println("aaaaaaaaaacaseSql:"+caseSql);
System.out.println("aaaaaaaaaadbUrl:"+dbUrl);
System.out.println("aaaaaaaaaadbUser:"+dbUser);
System.out.println("aaaaaaaaaadbPwd:"+dbPwd);

List recordList = JDBCTool.selectNew(dbUrl,dbUser,dbPwd,caseSql);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<h3> \case id =<%=id%> ：</h3>
		<%=recordList%>
		
		<a href="#" onclick="history.go(-1)">����</a>
	</body>
</html>