package com.baidu.wanba.core.tool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTool {
	/*
	 * ��ȡ�������˵������
	 */
	public static List<Map<String, Object>> listOutputData(String sql,
			String startDate, String endDate) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		Map<String, Object> mapDataMap = null;
		String[] keys = { "companyName", "gameName", "sAmout", "ratio",
				"fAmount", "bdNum", "bdMoney", "szNum", "szMoney", "bankNum",
				"bankMoney", "bfbNum", "bfbMoney" };
		try {
			ps = ConnectTool.getConnection().prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ResultSet rs = ps.executeQuery();
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
		}
		return list;
	}

	public static void insertOrUpdate(String sql, Object... values) {
		PreparedStatement ps = null;
		try {
			ps = ConnectTool.getConnection().prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i + 1, values[i]);
			}

			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertOrUpdateNew(String db, String dbUser,
			String dbPwd, String sql) {
		PreparedStatement ps = null;
		try {
			ps = ConnectTool.getConnection(db, dbUser, dbPwd).prepareStatement(
					sql);
			System.out.println("--------------:" + sql);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Map<String, Object>> select(String sql, Object... values) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		Map<String, Object> mapDataMap = null;

		try {
			ps = ConnectTool.getConnection().prepareStatement(sql);

			for (int i = 0; i < values.length; i++) {
				ps.setObject(i + 1, values[i]);
			}

			ResultSet rs = ps.executeQuery();

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
		}
		return list;
	}

	public static List<Map<String, Object>> selectNew(String db, String dbUser,
			String dbPwd, String sql) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		PreparedStatement ps = null;
		Map<String, Object> mapDataMap = null;

		try {
			ps = ConnectTool.getConnection(db, dbUser, dbPwd).prepareStatement(
					sql);

			ResultSet rs = ps.executeQuery();

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
		}
		return list;
	}
 
	public static void main(String[] args) {
		System.out.println("test");
	}
}
