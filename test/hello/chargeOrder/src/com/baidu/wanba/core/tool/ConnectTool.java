package com.baidu.wanba.core.tool;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectTool {
	
	public static Connection getConnection() throws Exception
	{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
return DriverManager.getConnection("jdbc:mysql://localhost:3306/game?useUnicode=true&characterEncoding=UTF-8", "root", "1234");
	}
	public static Connection getConnection(String dbUrl, String dbUser,
			String dbPwd) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
	}

	public static void close(Connection conn, PreparedStatement pstmt,
			Statement stmt, ResultSet rst) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rst != null) {
				rst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
