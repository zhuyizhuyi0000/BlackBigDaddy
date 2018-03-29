package com.baidu.wanba.core.tool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCManagerService {
	private static JDBCManagerService instance;

	private ComboPooledDataSource cpds = null;

	private static String _driverClass = "org.gjt.mm.mysql.Driver";

	
	// 数据库配置.
	private static String _jdbcUrl = "jdbc:mysql://10.32.32.69:3306/game?useUnicode=true&characterEncoding=UTF-8";

	private static String _user = "game";

	private static String _password = "game";

	public String getDriverClass() {
		return _driverClass;
	}

	public String getUser() {
		return _user;
	}

	public String getPassword() {
		return _password;
	}

	public String getUrl() {
		return _jdbcUrl;
	}

	private JDBCManagerService() {
		this.cpds = new ComboPooledDataSource();
		try {
			this.cpds.setDriverClass(JDBCManagerService._driverClass);
		
			System.out.println("_jdbcUrl = "+_jdbcUrl);
			this.cpds.setJdbcUrl(JDBCManagerService._jdbcUrl);
			this.cpds.setUser(JDBCManagerService._user);
			this.cpds.setPassword(JDBCManagerService._password);

			this.cpds.setInitialPoolSize(5);
			this.cpds.setMinPoolSize(5);
			this.cpds.setAcquireIncrement(5);
			this.cpds.setMaxPoolSize(100);
			this.cpds.setMaxIdleTime(1000);// 单位是秒,若为0则永不丢弃。Default: 0
			// added by yanghuicheng
			cpds.setIdleConnectionTestPeriod(60);
			cpds.setAcquireRetryAttempts(10);
			cpds.setAcquireRetryDelay(1000);
			cpds.setBreakAfterAcquireFailure(false);

			System.out.println("datasource connection pool succeeded");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			JDBCManagerService.instance = null;
		}
	}

	public static JDBCManagerService getInstance() {
		if (instance == null) {
			instance = new JDBCManagerService();
		}
		return instance;
	}

	public static void initJDBCManagerService(String driver, String jdbcUrl,
			String user, String password) {
		JDBCManagerService._driverClass = driver;
		JDBCManagerService._jdbcUrl = jdbcUrl;
		JDBCManagerService._user = user;
		JDBCManagerService._password = password;
	}

	public Connection getConnection() {
		if (cpds == null) {
			System.out.println("connection pool closed，no more available Connection");
			return null;
		} else {
			try {
				return this.cpds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public void free(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

	}

	public void freeC3p0Pool() {
		if (this.cpds != null) {
			cpds.close();
			System.out.println("close datasource connecion pool");
		}

	}

	public ComboPooledDataSource getCpds() {
		return cpds;
	}
	public static void main(String[] args) {
		JDBCManagerService.getInstance().getConnection();
		
		
	}
}
