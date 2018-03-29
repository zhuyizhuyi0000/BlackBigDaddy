package com.baidu.game.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcQuery {
	private String url;
	private String user;
	private String passWord;
	
	public JdbcQuery(String url, String user, String passWord) {
		this.url = url;
		this.user = user;
		this.passWord = passWord;
	}

	public List<Map<String, Object>> find(String sql, Object... values) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		Map<String, Object> mapDataMap = null;
		java.sql.Connection connection = null;
		ResultSet rs = null;
		try {
			connection = this.getConnection();
			ps = connection.prepareStatement(sql);

			for (int i = 0; i < values.length; i++) {
				ps.setObject(i + 1, values[i]);
			}

			rs = ps.executeQuery();

			String[] keys = new String[rs.getMetaData().getColumnCount()];
			for (int i = 0; i < keys.length; i++) {
				keys[i] = rs.getMetaData().getColumnName(i + 1);
			}

			while (rs.next()) {
				mapDataMap = new HashMap<String, Object>();
				for (int i = 0; i < keys.length; i++) {
					mapDataMap.put(keys[i], rs.getObject(keys[i]));
				}
				list.add(mapDataMap);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if (connection != null) {
						connection.close();
					}

					if (ps != null) {
						ps.close();
					}
					
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return list;
	}
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		return DriverManager.getConnection(url, user, passWord);
	}
}
