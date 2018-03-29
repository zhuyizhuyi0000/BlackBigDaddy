package com.baidu.wanba.core.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectTool {
	// ≤‚ ‘
	/*
	 * public static Connection getConnection() throws Exception {
	 * Class.forName("com.mysql.jdbc.Driver").newInstance(); return
	 * DriverManager.getConnection(
	 * "jdbc:mysql://10.81.34.18:4429/game?useUnicode=true&characterEncoding=UTF-8"
	 * , "game", "game"); }
	 */

	// œﬂ…œ
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		return DriverManager
				.getConnection(
						"jdbc:mysql://10.32.32.69:3306/game?useUnicode=true&characterEncoding=UTF-8",
						"game", "game");
	}

	/*
	 * dbUrl:
	 * dbUser£∫
	 * dbPwd£∫
	 */
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
	// public static void main(String[] args) {
	// ConnectTool.getConnection();
	// }
}
