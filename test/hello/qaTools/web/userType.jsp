<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="com.baidu.wanba.core.tool.*"%>
<%@ page language="java" import="java.io.UnsupportedEncodingException"%>
<%@page import="com.baidu.wanba.core.UserCookie"%>
<%
	String username = request.getParameter("username");
	Long id = -2L;
	Long uid = -2L;
	String yxUserName = "";
	String userFlagDes = "";
	String ucStr = "";
	Map map = null;
	int userFlag = 0;
	
	ConnectTool.getConnection();
	try {
		username = new String(username.getBytes("iso-8859-1"), "gb2312");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	UserInfoService userinfo = new UserInfoService();
	List recordList = userinfo.findUserInfo(username);
	List yxUserrecordList = null;

	if (!recordList.isEmpty()) {
		map = (Map) recordList.get(0);
		id = (Long) map.get("id");
		uid = (Long) map.get("uid");
		//yxUserName字段不为空的时候再次查询
		if (map.get("yxUserName") != null) {
			yxUserName = map.get("yxUserName").toString();
			yxUserrecordList = userinfo.findUserInfo(yxUserName);
		}
	} else {
		//快推升级账号查询结果为空，需再次查询youxi_user_id_0表
		List quickRecordList = userinfo
				.findUserInfoFromQuickId(username);

		if (!quickRecordList.isEmpty()) {
			Map quickmap = (Map) quickRecordList.get(0);
			recordList = userinfo.findUserInfo(quickmap.get("userName")
					.toString());
			map = (Map) recordList.get(0);
			id = (Long) map.get("id");
			uid = (Long) map.get("uid");
			username =  map.get("userName").toString();
		} else {
			userFlag = 0;
		}

	}

	//校验用户账号类型
	userFlag = userinfo.checkUserTypeFromUInfo(id, uid, username,
			yxUserName);
	switch (userFlag) {
	case 0:
		userFlagDes = "账号不存在";
		break;
	case 1:
		userFlagDes = "pass用户名账号";
		break;
	case 2:
		userFlagDes = "pass无用户名账号";
		break;
	case 3:
		userFlagDes = "pass无用户名账号升级为有用户名账号";
		break;
	case 4:
		userFlagDes = "快推账号";
		break;
	case 5:
		userFlagDes = "快推升级账号";
		break;
	case 6:
		userFlagDes = "快推绑定账号";
		break;
	case 7:
		userFlagDes = "第三方账号";
		break;
	}

	//生成cookie
	//UserCookie uc = new UserCookie(request, response);
	///uc.setLoginName(username);
	//uc.setYxLoginName(yxUserName);
	//uc.setId(id);
	//uc.setUid(uid);
	//ucStr = uc.getCookieStr(uc);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<h3><%=username%>的账号类型：</h3><b><%=userFlagDes%></b><br /><br />
		<%=recordList%><br />
		<%=yxUserrecordList%><br />
		
		<h3><%=username%>的cookie：</h3>
		<br />
		<%=ucStr%><br />
		<a href="#" onclick="history.go(-1)">返回</a>
	</body>
</html>
