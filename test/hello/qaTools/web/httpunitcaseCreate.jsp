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

//url: project,url,urlname
String project = request.getParameter("project");
String url = request.getParameter("url");
String urlname = request.getParameter("urlname");

//case:urlname,cooiename...
String cookieName = request.getParameter("cookieName");
String methodType = request.getParameter("methodType");
String parameter = request.getParameter("parameter");
String expected = request.getParameter("expected");
String expectedType = request.getParameter("expectedType");
String expectedDataType = request.getParameter("expectedDataType");
String assertType = request.getParameter("assertType");
String flag1 = request.getParameter("flag1");
String status = request.getParameter("status");
String des = request.getParameter("des");
String flag4 = request.getParameter("flag4");
String flag5 = request.getParameter("flag5");


String urlSql = "INSERT INTO http_url (url, urlname, project,status) VALUES ";
String caseSql = "INSERT INTO http_case (urlname, cookieName, methodType, parameter, expected, expectedType, expectedDataType, assertType, flag1, status, des, flag4, flag5) VALUES ";
String casevalus = "'"+urlname+"',"+"'"+cookieName+"',"+"'"+methodType+"',"+"'"+parameter+"',"+"'"+expected+"',"+"'"+expectedType+"',"+"'"+expectedDataType+"',"+"'"+assertType+"',"+"'"+flag1+"',"+"'"+status+"',"+"'"+des+"',"+"'"+flag4+"',"+"'"+flag5+"'";

caseSql = caseSql+ "(" +casevalus+")";
	System.out.println("aaaaaaaaaacaseSql:"+caseSql);

System.out.println("aaaaaaaaaadbUrl:"+dbUrl);
System.out.println("aaaaaaaaaadbUser:"+dbUser);
System.out.println("aaaaaaaaaadbPwd:"+dbPwd);	
JDBCTool.insertOrUpdateNew(dbUrl,dbUser,dbPwd,caseSql);

%>