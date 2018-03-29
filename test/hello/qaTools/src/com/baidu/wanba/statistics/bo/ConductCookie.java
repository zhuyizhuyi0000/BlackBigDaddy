package com.baidu.wanba.statistics.bo;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.baidu.wanba.core.Constant;
import com.baidu.wanba.core.UserCookie;
import com.baidu.wanba.util.CookieUtils;
import com.baidu.wanba.util.DesCryptUtil;
import com.baidu.wanba.util.UUIDUtil;

public class ConductCookie {

	private HttpServletRequest request;

	private HttpServletResponse response;

	/**
	 * ΨһId
	 */
	private String uniqueId;

	/**
	 * �ٶ���Ϸ�û�Id
	 */
	private Long userId;

	/**
	 * �ٶ���Ϸ�û�passport Id
	 */
	private Long passportId;

	/**
	 * ���û���ʶ ����-���û� 0-���û�
	 */
	private String newUserFlag;

	/**
	 * ��½״̬��0-δ��¼ 1-��½��2-��¼ 3-ע���½��
	 */
	private String loginFlag;

	/**
	 * ���״̬��0-û��� 1-�����½ 2-���ע�� 3-���������½ 4-�������ע�ᣩ
	 */
	private String clickFlag;

	/**
	 *��ǰҳ��url
	 */
	private Long webURLId;

	/**
	 *��ǰҳ��url���� youxi bbs
	 */
	private String webUrlType;

	/**
	 * ��ϷId
	 */
	private Long gameId;

	/**
	 * cookie����
	 */
	private long logTimes;

	public static final String CONDUCT_COOKIE_WEB_URL_TYPE_YOUXI = "youxi";
	public static final String CONDUCT_COOKIE_WEB_URL_TYPE_BBS = "bbs";
	public static final String CONDUCT_COOKIE_WEB_URL_TYPE_APP_STORE = "appstore";

	public static final String CONDUCT_COOKIE_KEY = "youxi_userinfo_cookies";

	public static final String CONDUCT_LOG = "/home/work/local/tomcat/logs/newbehavior/";

	public static final String CONDUCT_NO_LOGIN = "0";

	public static final String CONDUCT_LANDING = "1";

	public static final String CONDUCT_LOGIN = "2";

	public static final String CONDUCT_REGISTER = "3";

	public static final String CONDUCT_NO_CLICK = "0";

	public static final String CONDUCT_CLICK_LOGIN = "1";

	public static final String CONDUCT_CLICK_REG = "2";

	public static final String CONDUCT_CLICK_POPLOGIN = "3";

	public static final String CONDUCT_CLICK_POPREG = "4";

	public static final Long CONDUCT_NO_ID = 0L;

	public static final Long CONDUCT_INDEX_ID = -1L;

	public static final Long CONDUCT_GMAE_ID = -2L;

	public static final Long CONDUCT_MYGAME_ID = -3L;

	public static final Long CONDUCT_BBS_ID = -4L;
	public static final Long CONDUCT_APPSTORE_ID = -5L;

	public static final Long CONDUCT_NO_GAME = 0L;

	public ConductCookie() {

	}

	public ConductCookie(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void setCookie(ConductCookie cc) {

		String value = null;
		try {
			value = URLEncoder.encode(cc.toString(), "UTF-8");
			value = DesCryptUtil.encrypt(value, Constant.COOKIE_PASSWORD);
			value = URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int cookieTime = 3153600; // һ��
		CookieUtils.addCookie(response, CONDUCT_COOKIE_KEY, value, cookieTime);
	}

	public ConductCookie getCookie() {

		Cookie cookie = CookieUtils.getCookie(request, CONDUCT_COOKIE_KEY);
		if (cookie == null) {
			return null;
		}
		String result = null;
		try {
			result = URLDecoder.decode(cookie.getValue(), "UTF-8");
			result = DesCryptUtil.dectrypt(result, Constant.COOKIE_PASSWORD);
			result = URLDecoder.decode(result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		JSONObject json = null;
		try {
			json = JSONObject.fromObject(result);
		} catch (Exception e) {
			System.out.println("jsonException:" + result);
			return null;
		}

		ConductCookie cc = new ConductCookie();
		Long userId = -1L;
		Long passportId = -1L;
		String loginFlag = null;
		String clickFlag = null;
		Long webURLId = -1L;
		Long logTimes = 0L;
		String newUserFlag = null;
		Long gameId = -1L;
		String webUrlType = null;

		if (json.has("userId")
				&& StringUtils.isNotBlank(json.getString("userId"))) {
			userId = NumberUtils.toLong(json.getString("userId"));
		}
		if (json.has("passportId")
				&& StringUtils.isNotBlank(json.getString("passportId"))) {
			passportId = NumberUtils.toLong(json.getString("passportId"));
		}
		if (json.has("loginFlag")
				&& StringUtils.isNotBlank(json.getString("loginFlag"))) {
			loginFlag = json.getString("loginFlag");
		}
		if (json.has("clickFlag")
				&& StringUtils.isNotBlank(json.getString("clickFlag"))) {
			clickFlag = json.getString("clickFlag");
		}
		if (json.has("webURLId")
				&& StringUtils.isNotBlank(json.getString("webURLId"))) {
			webURLId = NumberUtils.toLong(json.getString("webURLId"));
		}
		if (json.has("logTimes")
				&& StringUtils.isNotBlank(json.getString("logTimes"))) {
			logTimes = NumberUtils.toLong(json.getString("logTimes"));
		}
		if (json.has("newUserFlag")
				&& StringUtils.isNotBlank(json.getString("newUserFlag"))) {
			newUserFlag = json.getString("newUserFlag");
		}
		if (json.has("gameId")
				&& StringUtils.isNotBlank(json.getString("gameId"))) {
			gameId = NumberUtils.toLong(json.getString("gameId"));
		}
		if (json.has("webUrlType")
				&& StringUtils.isNotBlank(json.getString("webUrlType"))) {
			webUrlType = json.getString("webUrlType");
		}

		cc.setUserId(userId);
		cc.setPassportId(passportId);
		cc.setLoginFlag(loginFlag);
		cc.setClickFlag(clickFlag);
		cc.setWebURLId(webURLId);
		cc.setLogTimes(logTimes + 1L);
		cc.setGameId(gameId);
		cc.setWebUrlType(webUrlType);

		if (StringUtils.isNotBlank(json.getString("uniqueId"))) {
			cc.setUniqueId(json.getString("uniqueId"));
		} else {
			cc.setUniqueId(UUIDUtil.generateSimple());
		}
		if (!"0".equals(newUserFlag)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			String date = sd.format(new Date());
			if (!date.equals(newUserFlag)) {
				newUserFlag = "0";
			}
		}
		cc.setNewUserFlag(newUserFlag);
		return cc;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("uniqueId", uniqueId);
		json.put("userId", userId);
		json.put("passportId", passportId);
		json.put("loginFlag", loginFlag);
		json.put("clickFlag", clickFlag);
		json.put("webURLId", webURLId);
		json.put("logTimes", logTimes);
		json.put("newUserFlag", newUserFlag);
		json.put("gameId", gameId);
		json.put("webUrlType", webUrlType);
		return json.toString();
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPassportId() {
		return passportId;
	}

	public void setPassportId(Long passportId) {
		this.passportId = passportId;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getClickFlag() {
		return clickFlag;
	}

	public void setClickFlag(String clickFlag) {
		this.clickFlag = clickFlag;
	}

	public long getLogTimes() {
		return logTimes;
	}

	public void setLogTimes(long logTimes) {
		this.logTimes = logTimes;
	}

	public Long getWebURLId() {
		return webURLId;
	}

	public void setWebURLId(Long webURLId) {
		this.webURLId = webURLId;
	}

	public String getNewUserFlag() {
		return newUserFlag;
	}

	public void setNewUserFlag(String newUserFlag) {
		this.newUserFlag = newUserFlag;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getWebUrlType() {
		return webUrlType;
	}

	public void setWebUrlType(String webUrlType) {
		this.webUrlType = webUrlType;
	}

	public void getCookieFromStr(String cookie) {
		String result = "";

		try {
			result = URLDecoder.decode(cookie, "UTF-8");
			result = DesCryptUtil.dectrypt(result, Constant.COOKIE_PASSWORD);
			result = URLDecoder.decode(result, "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("=========usercookie:" + result);

	}

	public String getCookieStr(ConductCookie conductCookie) {
		String value = null;
		try {
			value = URLEncoder.encode(conductCookie.toString(), "UTF-8");
			value = DesCryptUtil.encrypt(value, Constant.COOKIE_PASSWORD);
			value = URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		// ����cookie������cookie�ֶ�
		ConductCookie conductCookie = new ConductCookie();
		conductCookie
				.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f23742253232756e697175654964253232253341253232373030303137363665663938253232253243253232757365724964253232253341343130303030333125324325323270617373706f727449642532322533412d312532432532326c6f67696e466c616725323225334125323231253232253243253232636c69636b466c61672532322533412532323125323225324325323277656255524c49642532322533413233382532432532326c6f6754696d657325323225334131302532432532326e657755736572466c6167253232253341253232323031322d30332d313325323225324325323267616d65496425323225334131313825324325323277656255726c54797065253232253341253232796f757869253232253744");

		// ����cookie�ֶ�����cookie��
		conductCookie.setClickFlag("1");
		conductCookie.setUniqueId("70001766ef98");
		conductCookie.setUserId(41000031L);
		conductCookie.setPassportId(-1L);
		conductCookie.setLoginFlag("1");
		conductCookie.setWebURLId(238L);
		conductCookie.setWebUrlType("youxi");
		conductCookie.setGameId(118L);
		conductCookie.setLogTimes(10);
		conductCookie.setNewUserFlag("2012-03-13");
		
		String cookieStr = conductCookie.getCookieStr(conductCookie);
		System.out.println("+++++++conductCookie:" + cookieStr);

	}
}
