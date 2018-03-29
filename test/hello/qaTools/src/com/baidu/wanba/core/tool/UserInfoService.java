package com.baidu.wanba.core.tool;

import java.util.List;
import java.util.Map;

import com.baidu.wanba.util.HashAlgorithms;

public class UserInfoService {
	private final static int TAB_NUM = 30;
	private final static String COMMON_TAB_NAME = "yx_user_info_";

	/**
	 * 得到表名
	 */
	public String getTableName(String username) {
		String name = "";
		int tableNum = HashAlgorithms.FNVHash1(username) % TAB_NUM;
		if (tableNum < 0) {
			tableNum *= -1;
		}
		name = COMMON_TAB_NAME + tableNum;
		return name;
	}

	/**
	 * 根据用户名 查数据库user表
	 * 
	 * @param username
	 * @return
	 */
	public List findUserInfo(String userName) {

		String sql = " select id,uid,userName,yxUserName from "
				+ this.getTableName(userName) + " where username=? ";
		String qksql = " select userName from youxi_user_id_0 where yxUserName=? ";
		List recordList = null;
		List qkrecordList = null;
		Map map = null;

		// user表中查找用户
		recordList = JDBCTool.select(sql, userName);
		return recordList;
	}

	/**
	 * 
	 * 对于快推升级用户，升级前的账号在user表中查不到，需到youxi_user_id_0表查询
	 * 
	 * @param username
	 * @return
	 */
	public List findUserInfoFromQuickId(String yxUserName) {

		String sql = " select userName from youxi_user_id_0 where yxUserName=? ";
		List recordList = null;

		recordList = JDBCTool.select(sql, yxUserName);

		return recordList;
	}

	/**
	 * 根据用户名 获得用户的类型
	 * 
	 * @param username
	 * @return 1：pass用户名账号 2：pass无用户名账号 3：pass无用户名账号升级为有用户名账号 4：快推账号 5：快推升级账号
	 *         6：快推绑定账号 7：第三方账号
	 */
	public int checkUserTypeFromUname(String userName) {
		int userFlag = 0;
		List recordList = null;
		Long id;
		Long uid;
		String yxUserName = "";
		Map map = null;
		recordList = this.findUserInfo(userName);
		if (recordList.isEmpty()) {
			return userFlag = 0;
		} else {
			map = (Map) recordList.get(0);
		}

		// 获得用户表数据
		id = (Long) map.get("id");
		uid = (Long) map.get("uid");
		if (map.get("yxUserName") != null) {
			yxUserName = map.get("yxUserName").toString();
		}
		return userFlag = checkUserTypeFromUInfo(id, uid, userName, yxUserName);
	}

	/**
	 * 根据用户名 获得用户的类型
	 * 
	 * @param username
	 * @return 1：pass用户名账号 2：pass无用户名账号 3：pass无用户名账号升级为有用户名账号 4：快推账号 5：快推升级账号
	 *         6：快推绑定账号 7：第三方账号
	 */
	public int checkUserTypeFromUInfo(Long id, Long uid, String userName,
			String yxUserName) {
		int userFlag = 0;
		// 快推绑定；pass绑定
		if (uid == -1) {
			if ((yxUserName.charAt(0) == '@')) {
				return userFlag = 3;
			} else {
				return userFlag = 6;
			}
		}
		// pass账号
		if ((id >= 0 && id < 23000000) || (id >= 50000000 && id < 1000000000)) {

			if ((userName.charAt(0) == '@') && (yxUserName != "")) {
				return userFlag = 3;
			} else if ((userName.charAt(0) == '@') && (yxUserName == "")) {
				return userFlag = 2;
			} else {
				return userFlag = 1;
			}
		}
		// 快推账号
		else if ((id >= 23000000 && id < 49000000)
				|| (id >= 1000000001 && id < 1500000000)) {
			if ((userName.contains("@")) && (yxUserName != "")) {
				return userFlag = 6;
			} else if ((userName.contains("@")) && (yxUserName == "")) {
				return userFlag = 4;
			} else {
				return userFlag = 5;
			}

		}

		// 第三方账号
		else if ((id >= 1500000001) && (id < 2000000000)) {
			return userFlag = 7;
		}

		return userFlag;
	}

	/**
	 * 
	 * 对于快推升级用户，升级前的账号在user表中查不到，需到youxi_user_id_0表查询
	 * 
	 * @param userType
	 *            1：pass用户名账号 2：pass无用户名账号 3：pass无用户名账号升级为有用户名账号 4：快推账号 5：快推升级账号
	 *            6：快推绑定账号 7：第三方账号
	 * @return
	 */
	public List getUserInfoFromUserType(int UserType,int tableNum, int num) {
		String tableName = COMMON_TAB_NAME +tableNum;
		String sql = " select id,uid,userName,yxUserName from " + tableName
				+ " where ";
		String sqlWhere = "";
		List recordList = null;
		switch (UserType) {
		case 0: {
			return null;
		}
		case 1: {
			sqlWhere = "((id >= 0 and id < 23000000) or (id >= 50000000 and id < 1000000000) ) and username not like'@%'";
			break;
		}

		case 2:
			sqlWhere = "((id >= 0 and id < 23000000) or (id >= 50000000 and id < 1000000000) )  and username  like'@%' and yxUsername is  null";

			break;
		case 3:
			sqlWhere = "((id >= 0 and id < 23000000) or (id >= 50000000 and id < 1000000000) )  and username  like'@%' and yxUsername is not null";

			break;

		case 4:
			sqlWhere = "((id >= 23000000 and id < 49000000) or (id >= 1000000001 and id < 1500000000)) and yxUsername is null";

			break;
		case 5:
			sqlWhere = "((id >= 23000000 and id < 49000000) or (id >= 1000000001 and id < 1500000000)) and username not like'%@%' and yxUsername is not null";

			break;
		case 6:
			sqlWhere = "((id >= 23000000 and id < 49000000) or (id >= 1000000001 and id < 1500000000))  and username  like'%@%' and yxUsername is not null";

			break;
		case 7:
			sqlWhere = "(id >= 1500000001 and id < 2000000000)";
			break;
		}
		
		
		recordList = JDBCTool.select(sql+sqlWhere);
		
		return recordList;
	}

	public static void main(String[] args) {
		Long id = 29000005L;
		Long uid = 104073497L;
		String userName = "游戏测试_wj2";
		String yxUserName = "wj2@qq.com";
		String userFlagDes = "";
		UserInfoService userInfoService = new UserInfoService();
		int flag = userInfoService.checkUserTypeFromUInfo(id, uid, userName,
				yxUserName);

		switch (flag) {
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

		System.out.println(flag);
		System.out.println(userFlagDes);
	}
}
