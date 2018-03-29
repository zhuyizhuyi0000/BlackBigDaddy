<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="com.baidu.wanba.core.tool.*"%>
<%@ page language="java" import="java.io.UnsupportedEncodingException"%>
<%
	int userType = 0;
	int tableNum = 0;
	int num = 0;
	String userFlagDes = "";
	String sqlWhere = "";

	userType = Integer.parseInt(request.getParameter("userType"));
	tableNum = Integer.parseInt(request.getParameter("tableNum"));
	String sql = " select id,uid,userName,yxUserName from yx_user_info_"
			+ tableNum + " where ";
	UserInfoService userinfo = new UserInfoService();
	List recordList = null;

	recordList = userinfo.getUserInfoFromUserType(userType, tableNum,
			num);

	switch (userType) {
	case 0:
		userFlagDes = "账号不存在";
		break;
	case 1: {
		userFlagDes = "pass用户名账号";
		sqlWhere = "((id >= 0 and id < 23000000) or (id >= 50000000 and id < 1000000000) ) and username not like'@%'";
		break;
	}
	case 2: {
		userFlagDes = "pass无用户名账号";
		sqlWhere = "((id >= 0 and id < 23000000) or (id >= 50000000 and id < 1000000000) )  and username  like'@%' and yxUsername is  null";

		break;
	}
	case 3: {
		userFlagDes = "pass无用户名账号升级为有用户名账号";
		sqlWhere = "((id >= 0 and id < 23000000) or (id >= 50000000 and id < 1000000000) )  and username  like'@%' and yxUsername is not null";

		break;
	}
	case 4: {
		userFlagDes = "快推账号";
		sqlWhere = "((id >= 23000000 and id < 49000000) or (id >= 1000000001 and id < 1500000000)) and yxUsername is null";

		break;
	}
	case 5: {
		userFlagDes = "快推升级账号";
		sqlWhere = "((id >= 23000000 and id < 49000000) or (id >= 1000000001 and id < 1500000000)) and username not like'%@%' and yxUsername is not null";

		break;
	}
	case 6: {
		userFlagDes = "快推绑定账号";
		sqlWhere = "((id >= 23000000 and id < 49000000) or (id >= 1000000001 and id < 1500000000))  and username  like'%@%' and yxUsername is not null";

		break;
	}
	case 7: {
		userFlagDes = "第三方账号";
		sqlWhere = "(id >= 1500000001 and id < 2000000000)";

		break;
	}
	}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'getUserFromUserType.jsp' starting page</title>

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
		<h3><%=userFlagDes%>在 表yx_user_info_<%=tableNum%></h3>
		<h3>
			查询条件：
		</h3>
		<br />
		<%=sql + sqlWhere%><br />
		<h3>
			查询结果：
		</h3>
		<br />
		<%=recordList%>
		<br />
		<a href="#" onclick="history.go(-1)">返回</a>
	</body>
</html>
