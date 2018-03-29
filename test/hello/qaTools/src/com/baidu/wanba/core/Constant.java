package com.baidu.wanba.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Constant {
	/** cookie用常量 */
	public static final String COOKIE_KEY = "wanba_cookies";
	public static final String SPLITTER = "{||}";
	public static final String COOKIE_PASSWORD = "BAIDU.WANBA3.0";
	public static final String USER_XTEA_KEY = "abcdc672a65326fa";
	public static final String PROMOTION_XTEA_KEY = "beccc872a64316ba";
	public static final String PROMOTION_COOKIE_KEY = "wanba_promotion_cookies";
	public static final String PROMOTION_COOKIE_PASSWORD = "WANBA_PROMOTION";
	public static final String COOKIE_ID="cookieId";
	/**
	 * 用户名加密key
	 */
	public static final String USERNAME_PASSWORD = "YOUXI_USER";
	
	public static final String CLIENT_INVOKE_CLASS = "client_invoke_class";
	public static final String CLIENT_INVOKE_METHOD = "client_invoke_method";
	public static final String CLIENT_RETURN_METHOD = "client_return_method";
	
	public static final long UID_CONVERT_BASE_NUMBER = 50000000l;
	
	public static final long USER_ID_TRANSFER_NUMBER = 3000000000l;

	public static final String CACHE_MANAGER = "mclient0";

	public static String SERVLET_MAPPING = "*.xhtml";

	public static final String ERROR_MESSAGE = "errorMsg";
	
	public static final String BD_PLAFFORM = "baidu";

	/** radio 选择值 1 代表是 -1 代表否 */
	public static final int RADIO_YES_VALUE = 1;

	public static final int RADIO_NO_VALUE = -1;

	public static final String SUCCESS_FLAG = "succeed";

	/**
	 * 默认无动作在线有效时间为4小时
	 */
	public static final long LOGIN_EFFECTIVE_TIME = 14400000;

	/**
	 * 用于分页传递当前网址
	 */
	public static final String CURRENT_URL = "curURL";

	public static final String WANBA_GUEST = "百度网友";

	public static final int NUMBER_PER_PAGE = 5;

	public static final String PARAMETER_SIGN = "sip_sign";// 请求签名

	/**
	 * 百度passport cookie name
	 */
	public static final String COOKIE_PASSPORT = "BDUSS";
	
	public static final String COOKIE_PASSPORT_USER = "USERID";
	
	public static final String COOKIE_BAIDUID = "BAIDUID";
	
	public static final String BAIDU_DOMAIN = ".baidu.com";

	public static final int ORDER_ASC = 1;

	public static final int ORDER_DESC = -1;

	public static final String SCORE_DIV_NAME = "game_";

	/**
	 * CMS页面本地保存目录
	 */
	public static final String CMS_LOCAL_PATH = "/cms";

	public static final String UPLOAD_LOCAL_PATH = "/upload";

	public static String FTL_PATH = "/templates/";

	public static final double DEFAULT_DIVIDEND_RATIO = 40.0d;

	public static final String WANBA_STORENAME = "baidu_wanba";

	public static final String WANBA_CODE = "UTF-8";

	public static final String WANBA_RESPONSE_TAG = "response";

	public static final String YX_URL = "http://youxi.baidu.com";
	
	public static final String YX_IMG_URL = "http://p1.youxi.bdimg.com";
	
	public static final String SPACE_IMG_URL = "http://himg.bdimg.com/sys/portrait/item/";
	
	public static String PLATFORM_URL = "http://youxi.baidu.com";
	
	public static String IYOUXI_URL = "http://iyouxi.baidu.com";


	public static final String GENDER_MALE = "M";

	public static final String GENDER_FEMALE = "F";

	public static Map<String, String> USER_GENDER = new HashMap<String, String>();

	static {
		USER_GENDER.put(GENDER_MALE, "\u7537"); // 男
		USER_GENDER.put(GENDER_FEMALE, "\u5973"); // 女
		if(StringUtils.contains(System.getProperty("serverName"), "rd00") || StringUtils.contains(System.getProperty("serverName"), "rd01")){
			PLATFORM_URL = "http://youxibeta.baidu.com";
			IYOUXI_URL = "http://iyouxibeta.baidu.com";
		}else if(StringUtils.contains(System.getProperty("serverName"), "test00")|| StringUtils.contains(System.getProperty("serverName"), "test02")){
			PLATFORM_URL = "http://youxitest.baidu.com";
			IYOUXI_URL = "http://iyouxitest.baidu.com";
		}else{
			PLATFORM_URL = "http://youxi.baidu.com";
			IYOUXI_URL = "http://iyouxi.baidu.com";
		}
	}

	/*
	 * 支付方式前缀
	 */
	public static final String BAIDU_PAY = "Bai";
	public static final String SHENZHOU_PAY = "ShZX";
	public static final String BAIDU_PAY_DESC = "百度";
	public static final String SHENZHOU_PAY_DESC = "神州行";
	public static final String BANK_PAY_DESC = "银行类";
	
	/*
	 *反奖活动类型 
	 */
	public static final String SINGLE_CHARGE = "single";
	public static final String FIRST_CHARGE = "first";
	public static final String TOTAL_CHARGE = "total";
	public static final String SCORE_CHARGE = "score";
	
	/**
	 * 小游戏日志文件名
	 */
	public static final String PLAY_GAME_FROM_MINI_LOG = "/home/work/local/tomcat/logs/minigame/play_game_from_mini.log.";
	
	public static final long QUICK_USER_FLAG = -1l;
	public static final int QUICK_USER_UUID = 1001;
	
	/**
	 * 第三方用户起始UID
	 */
	public static final long THIRD_PART_START_UID = 1500000000l;
	
	/**
	 * 第三方用户登录标记，作为sid的前缀
	 */
	public final static String THIRD_PART_FLAG = "ThirdPart.";
	
	public static final String FLAG_CACHE_LOG_FILE="/home/work/local/tomcat/logs/newbehavior/flag.cache.log";
	
	public static final String USER_DEFAULT_HEAD_IMAGE = "http://youxi.baidu.com/images/anonymous.jpg";
	
	public static String PROFILE_URL = IYOUXI_URL + "/i/my_info.xhtml";
	
	public static String IYOUXI_MAIN_URL = IYOUXI_URL + "/user_center.xhtml";
	
	public static String USER_MAIN_URL = IYOUXI_URL+"/i/user_main.xhtml?id=";
	
	public static String FRIEND_INVITE_URL = IYOUXI_URL+"/i/user_main.xhtml?c=invite&id=";
	
	public static String FRIEND_GAME_INVITE_URL = IYOUXI_URL+"/i/user_main.xhtml?c=inviteForMiniGame&id=";
	
	public static String CLOSE_SERVER_URL = YX_URL+"/offline/?gid=";
}
