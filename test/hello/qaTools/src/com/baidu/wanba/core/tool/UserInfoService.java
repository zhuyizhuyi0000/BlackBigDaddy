package com.baidu.wanba.core.tool;

import java.util.List;
import java.util.Map;

import com.baidu.wanba.util.HashAlgorithms;

public class UserInfoService {
	private final static int TAB_NUM = 30;
	private final static String COMMON_TAB_NAME = "yx_user_info_";

	/**
	 * �õ�����
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
	 * �����û��� �����ݿ�user��
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

		// user���в����û�
		recordList = JDBCTool.select(sql, userName);
		return recordList;
	}

	/**
	 * 
	 * ���ڿ��������û�������ǰ���˺���user���в鲻�����赽youxi_user_id_0���ѯ
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
	 * �����û��� ����û�������
	 * 
	 * @param username
	 * @return 1��pass�û����˺� 2��pass���û����˺� 3��pass���û����˺�����Ϊ���û����˺� 4�������˺� 5�����������˺�
	 *         6�����ư��˺� 7���������˺�
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

		// ����û�������
		id = (Long) map.get("id");
		uid = (Long) map.get("uid");
		if (map.get("yxUserName") != null) {
			yxUserName = map.get("yxUserName").toString();
		}
		return userFlag = checkUserTypeFromUInfo(id, uid, userName, yxUserName);
	}

	/**
	 * �����û��� ����û�������
	 * 
	 * @param username
	 * @return 1��pass�û����˺� 2��pass���û����˺� 3��pass���û����˺�����Ϊ���û����˺� 4�������˺� 5�����������˺�
	 *         6�����ư��˺� 7���������˺�
	 */
	public int checkUserTypeFromUInfo(Long id, Long uid, String userName,
			String yxUserName) {
		int userFlag = 0;
		// ���ư󶨣�pass��
		if (uid == -1) {
			if ((yxUserName.charAt(0) == '@')) {
				return userFlag = 3;
			} else {
				return userFlag = 6;
			}
		}
		// pass�˺�
		if ((id >= 0 && id < 23000000) || (id >= 50000000 && id < 1000000000)) {

			if ((userName.charAt(0) == '@') && (yxUserName != "")) {
				return userFlag = 3;
			} else if ((userName.charAt(0) == '@') && (yxUserName == "")) {
				return userFlag = 2;
			} else {
				return userFlag = 1;
			}
		}
		// �����˺�
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

		// �������˺�
		else if ((id >= 1500000001) && (id < 2000000000)) {
			return userFlag = 7;
		}

		return userFlag;
	}

	/**
	 * 
	 * ���ڿ��������û�������ǰ���˺���user���в鲻�����赽youxi_user_id_0���ѯ
	 * 
	 * @param userType
	 *            1��pass�û����˺� 2��pass���û����˺� 3��pass���û����˺�����Ϊ���û����˺� 4�������˺� 5�����������˺�
	 *            6�����ư��˺� 7���������˺�
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
		String userName = "��Ϸ����_wj2";
		String yxUserName = "wj2@qq.com";
		String userFlagDes = "";
		UserInfoService userInfoService = new UserInfoService();
		int flag = userInfoService.checkUserTypeFromUInfo(id, uid, userName,
				yxUserName);

		switch (flag) {
		case 0:
			userFlagDes = "�˺Ų�����";
			break;
		case 1:
			userFlagDes = "pass�û����˺�";
			break;
		case 2:
			userFlagDes = "pass���û����˺�";
			break;
		case 3:
			userFlagDes = "pass���û����˺�����Ϊ���û����˺�";
			break;
		case 4:
			userFlagDes = "�����˺�";
			break;
		case 5:
			userFlagDes = "���������˺�";
			break;
		case 6:
			userFlagDes = "���ư��˺�";
			break;
		case 7:
			userFlagDes = "�������˺�";
			break;
		}

		System.out.println(flag);
		System.out.println(userFlagDes);
	}
}
