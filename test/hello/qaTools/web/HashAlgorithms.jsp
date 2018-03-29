<%@ page language="java" import="java.io.UnsupportedEncodingException" pageEncoding="gb2312"%>

<%
  String data=request.getParameter("username");
  int num= Integer.parseInt(request.getParameter("tableNum"));
  try {
				data = new String(data.getBytes("iso-8859-1"), "gb2312");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < data.length(); i++)
			hash = (hash ^ data.charAt(i)) * p;
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;
		
		hash = hash%num;
		if (hash<0) hash*=-1;
		String hashMsg = hash+"";
%>

<b><%=data%>µÄhashÖµ</b>£º<%=hashMsg%><br/>
<a href="#" onclick="history.go(-1)">·µ»Ø</a>

