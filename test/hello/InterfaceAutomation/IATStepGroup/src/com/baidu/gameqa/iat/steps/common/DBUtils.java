package com.baidu.gameqa.iat.steps.common;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.mysql.jdbc.PreparedStatement;

/**
 * 操作数据库工具类
 * 
 * @author yanglei12
 * @version V1.0 创建时间：2014年6月20日 下午5:43:59
 */
public class DBUtils {

	/**
	 * 根据不同jdbc链接，获取数据库链接Connection对象--数据库链接的基本操作
	 * 
	 * @return
	 * @create by yanglei12 2014-04-16
	 */
	public static Connection getConnection(String driverName, String dbUrl,
			String dbUsername, String dbPassword) {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			SimpleLogger.logInfo(DBUtils.class, "get connection " + conn);
			return conn;
		} catch (Exception e) {
			SimpleLogger.logError(DBUtils.class, e.getMessage());
			return null;
		}
	}

	/**
	 * 数据库链接关闭函数
	 * 
	 * @param conn
	 * @author yanglei12
	 * @date 2014-4-16 下午02:38:28
	 */
	public static void closeConn(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			SimpleLogger.logError(DBUtils.class, e.getMessage());
		}
	}

	/**
	 * 关闭PreparedStatement链接
	 * 
	 * @param ps
	 * @author yanglei12
	 * @date 2014-4-16 下午04:12:30
	 */
	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			SimpleLogger.logError(DBUtils.class, e.getMessage());
		}
	}

	/**
	 * 关闭ResultSet链接
	 * 
	 * @param rs
	 * @author yanglei12
	 * @date 2014-4-16 下午04:13:12
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			SimpleLogger.logError(DBUtils.class, e.getMessage());
		}
	}

	/**
	 * 数据库查询操作
	 * 
	 * @param conn
	 * @param sqlString
	 * @return
	 * @create by yanglei12 2014-04-16
	 */
	public static ResultSet query(Connection conn, String sqlString) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (!sqlString.isEmpty() && conn != null) {
			try {
				ps = (PreparedStatement) conn.prepareStatement(sqlString);
				rs = ps.executeQuery(sqlString);
				SimpleLogger.logInfo(DBUtils.class,
						"query sql result set is +++" + rs);
				return rs;
			} catch (Exception e) {
				SimpleLogger.logError(DBUtils.class, e.getMessage());
				return null;
			}
		} else {
			SimpleLogger.logInfo(DBUtils.class, "query sql params error");
			return null;
		}
	}

	/**
	 * 数据库更新操作
	 * 
	 * @param conn
	 * @param sqlString
	 * @return
	 * @author yanglei12
	 * @date 2014-4-16 下午02:50:59
	 */
	public static int update(Connection conn, String sqlString) {
		PreparedStatement ps = null;
		if (!sqlString.isEmpty() && conn != null) {
			try {
				ps = (PreparedStatement) conn.prepareStatement(sqlString);
				int flag = ps.executeUpdate();
				return flag;
			} catch (Exception e) {
				SimpleLogger.logError(DBUtils.class, e.getMessage());
				return -1;
			}
		} else {
			SimpleLogger.logInfo(DBUtils.class, "query sql params error");
			return -1;
		}
	}

	/**
	 * 数据库insert插入操作
	 * 
	 * @param conn
	 * @param sqlString
	 * @return
	 * @author yanglei12
	 * @date 2014-4-16 下午04:15:56
	 */
	public static int insert(Connection conn, String sqlString) {
		PreparedStatement ps = null;
		if (!sqlString.isEmpty() && conn != null) {
			try {
				ps = (PreparedStatement) conn.prepareStatement(sqlString);
				int num = ps.executeUpdate();
				return num;
			} catch (Exception e) {
				SimpleLogger.logError(DBUtils.class, e.getMessage());
				return -1;
			}
		} else {
			SimpleLogger.logInfo(DBUtils.class, "query sql params error");
			return -1;
		}
	}

	/**
	 * 数据库删除操作
	 * 
	 * @param conn
	 * @param sqlString
	 * @return
	 * @author yanglei12
	 * @date 2014-4-16 下午04:21:07
	 */
	public static int delete(Connection conn, String sqlString) {
		PreparedStatement ps = null;
		if (!sqlString.isEmpty() && conn != null) {
			try {
				ps = (PreparedStatement) conn.prepareStatement(sqlString);
				int num = ps.executeUpdate();
				return num;
			} catch (Exception e) {
				SimpleLogger.logError(DBUtils.class, e.getMessage());
				return -1;
			}
		} else {
			SimpleLogger.logInfo(DBUtils.class, "query sql params error");
			return -1;
		}
	}

	/**
	 * 抽象通用的拼装insert sql语句方法
	 * 
	 * @param tableName
	 * @param map
	 * @return
	 * @author yanglei12
	 * @date 2014-5-7 下午04:01:24
	 */
	public static String togetherInsertSql(String tableName,
			Map<String, String> map) {
		String beginStr = "INSERT INTO ";
		String columnStr = "";
		String valueStr = "";

		if (!tableName.equals("") && !map.isEmpty()) {
			for (Entry<String, String> entry : map.entrySet()) {
				columnStr += entry.getKey() + ",";
				valueStr += "'" + entry.getValue() + "',";
			}
			columnStr = "(" + columnStr.substring(0, columnStr.length() - 1)
					+ ")";
			valueStr = "(" + valueStr.substring(0, valueStr.length() - 1) + ")";
			return beginStr + tableName + " " + columnStr + " VALUES "
					+ valueStr + ";";
		} else {
			SimpleLogger.logError(DBUtils.class,
					"tableName or map params error");
			return null;
		}
	}

	/**
	 * 动态拼装查询sql的前半部分，不带where部分
	 * 
	 * @param filedList
	 * @param tableName
	 * @return
	 * @author yanglei12
	 * @date 2014-5-12 下午04:18:26
	 */
	public static String togetherQuerySql(List<String> filedList,
			String tableName) {
		String filed = "";
		String selectStr = "SELECT";

		if (!tableName.equals("")) {
			if (filedList.isEmpty()) {
				filed = " * ";
				return selectStr + filed + "FROM " + tableName;
			} else {
				for (String eachFiled : filedList) {
					filed += eachFiled + ",";
				}
				return selectStr + " " + filed.substring(0, filed.length() - 1)
						+ " FROM " + tableName;
			}
		} else {
			SimpleLogger.logError(DBUtils.class, "tableName params error");
			return "";
		}
	}

	/**
	 * 动态拼装update语句，不带限制条件
	 * 
	 * @param pairMap
	 * @param tableName
	 * @return
	 * @author yanglei12
	 * @date 2014-5-12 下午05:02:19
	 */
	public static String togetherUpdateSql(Map<String, String> pairMap,
			String tableName) {
		String update = "UPDATE";
		String set = "SET";
		String result = "";

		if (!tableName.equals("") && pairMap.size() != 0) {
			String pairString = "";
			for (Entry<String, String> entry : pairMap.entrySet()) {
				pairString += "`" + entry.getKey() + "`";
				pairString += "='" + entry.getValue() + "',";
			}
			pairString = pairString.substring(0, pairString.length() - 1);
			System.out.println(pairString);
			result = update + " `" + tableName + "` " + set + " " + pairString;
			return result;
		} else {
			SimpleLogger.logError(DBUtils.class,
					"pairMap or tableName params error");
			return null;
		}
	}
	
	/**
	 * 根据传入的paramterID来构造UPDATE语句
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年7月4日 上午11:39:49
	 */
	public static String togetherUpdateSqlWithPara(String parameterID) throws Exception {
		@SuppressWarnings("deprecation")
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		HashMap<String, String> pairMap = new HashMap<String, String>();
		String tableName = parameter.getValue("table");
		String sql;

		if (parameter.getValue("setKey").contains("#")
				&& parameter.getValue("setValue").contains("#")) {
			String[] keys = parameter.getValue("setKey").split("#");
			String[] values = parameter.getValue("setValue").split("#");

			for (int i = 0; i < keys.length; i++) {
				pairMap.put(keys[i], URLEncoder.encode(values[i], "UTF-8").replace("+", "%20"));
				System.out.println(keys[i]);
				System.out.println(values[i]);
			}
		} else {
			//没办法URLEncoder处理空格就会有问题，只能转码完再replace下，，，
			pairMap.put(parameter.getValue("setKey"),
					URLEncoder.encode(parameter.getValue("setValue"), "UTF-8").replace("+", "%20"));
		}
		
		if (parameter.getValue("whereKey").contains("#") && parameter.getValue("whereValue").contains("#")) {
			String[] whereKeys = parameter.getValue("whereKey").split("#");
			String[] whereValues = parameter.getValue("whereValue").split("#");
			StringBuilder limit = new StringBuilder();
			
			limit.append(" WHERE ");
			for (int i = 0; i < whereKeys.length; i++) {
				limit.append("`" + whereKeys[i] + "` = " + whereValues[i]);
				if(i != whereKeys.length - 1){
					limit.append(" and ");
				} else {
					limit.append("");
				}
			}
			sql = DBUtils.togetherUpdateSql(pairMap, tableName) + limit.toString();
		} else {
			sql = DBUtils.togetherUpdateSql(pairMap, tableName) + " WHERE `"
					+ parameter.getValue("whereKey") + "` = "
					+ parameter.getValue("whereValue");
		}
		return sql;
	}
	
	public static void main(String[] args) {
		String tableName = "youxi_gift_product";
		
		HashMap<String, String> pairMap = new HashMap<String, String>();
		pairMap.put("userLimit", "[{\"code\":\"userBindEmail\"}]");
		pairMap.put("type", "1");
		
		System.out.println(togetherUpdateSql(pairMap, tableName));
	}
}
