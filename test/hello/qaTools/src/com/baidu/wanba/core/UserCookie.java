package com.baidu.wanba.core;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baidu.wanba.util.CookieUtils;
import com.baidu.wanba.util.DateUtils;
import com.baidu.wanba.util.DesCryptUtil;

/**
 * 存储用户cookie的对象
 * 
 * @author huicheng yang
 */
public class UserCookie {

	private static final Log logger = LogFactory.getLog(UserCookie.class);

	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * 百度游戏用户id
	 */
	private long id;
	/**
	 * 百度passport id
	 */
	private long uid;
	/**
	 * passport session server里保存的sessionId
	 */
	private String sid;
	/**
	 * 百度passport username
	 */
	private String loginName;
	private String password;
	private String refererUrl;
	private String loginTime;
	private String cmFlag;
	private String nickName;
	private String enterCode;
	/**
	 * 消息数
	 */
	private long msgNum;
	private Long msgId;

	/**
	 * 开发者状态
	 */
	private int developerFlag;

	private String yxLoginName;

	public UserCookie() {
	}

	public UserCookie(long id, long uid, String sid, String loginName,
			String password) {
		this.id = id;
		this.uid = uid;
		this.sid = sid;
		this.loginName = loginName;
		this.password = password;
		this.refererUrl = "default";
		this.developerFlag = -1;
		this.cmFlag = "y";
		this.msgNum = 0;
		this.nickName = loginName;
		this.loginTime = DateUtils.getTimeStr(new Date());
		this.msgId = 0l;
		this.yxLoginName = loginName;
	}

	public UserCookie(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	/**
	 * 获取用户的登录信息
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @return UserCookie
	 */
	public UserCookie getCookieUser() {
		Cookie cookie = CookieUtils.getCookie(request, Constant.COOKIE_KEY);
		if (cookie != null && !StringUtils.isBlank(cookie.getValue())) {
			String result = null;
			try {
				result = URLDecoder.decode(cookie.getValue(), "UTF-8");
				result = DesCryptUtil
						.dectrypt(result, Constant.COOKIE_PASSWORD);
				result = URLDecoder.decode(result, "UTF-8");
				System.out.println("=========usercookie:" + result);
				JSONObject json = JSONObject.fromObject(result);
				String id = json.getString("id");
				String uid = json.getString("uid");
				String sid = json.getString("sid");
				String loginName = json.getString("loginName");
				String nickName = "";
				String msgNum = "0";
				String msgId = "0";
				String enterCode = "false";
				String yxLoginName = json.getString("loginName");
				if (json.has("msgNum")) {
					msgNum = json.getString("msgNum");
				}
				if (json.has("msgId")) {
					msgId = json.getString("msgId");
				}
				if (json.has("nickName")) {
					nickName = json.getString("nickName");
				}
				String password = "";
				if (json.has("password")) {
					password = json.getString("password");
				}
				String refererUrl = "default";
				if (json.has("refererUrl")) {
					refererUrl = json.getString("refererUrl");
				}
				String developerFlag = "-1";
				if (json.has("developerFlag")) {
					developerFlag = json.getString("developerFlag");
				}
				String cmFlag = "y";
				if (json.has("cmFlag")) {
					cmFlag = json.getString("cmFlag");
				}
				String loginTime = DateUtils.getTimeStr(new Date());
				if (json.has("loginTime")) {
					loginTime = json.getString("loginTime");
				}
				if (json.has("yxLoginName")) {
					yxLoginName = json.getString("yxLoginName");
				}
				if (json.has("enterCode")) {
					enterCode = json.getString("enterCode");
				}
				UserCookie userCookie = new UserCookie();
				userCookie.setId(NumberUtils.toLong(id));
				userCookie.setUid(NumberUtils.toLong(uid));
				userCookie.setSid(sid);
				userCookie.setLoginName(loginName);
				userCookie.setPassword(password);
				userCookie.setRefererUrl(refererUrl);
				userCookie.setDeveloperFlag(NumberUtils.toInt(developerFlag));
				userCookie.setCmFlag(cmFlag);
				userCookie.setLoginTime(loginTime);
				userCookie.setNickName(nickName);
				userCookie.setMsgNum(NumberUtils.toLong(msgNum));
				userCookie.setMsgId(NumberUtils.toLong(msgId));
				userCookie.setYxLoginName(yxLoginName);
				userCookie.setEnterCode(enterCode);
				result = null;
				return userCookie;
			} catch (Exception e) {
				logger.error("get cookie from user error:" + e.getMessage());
			}
		}
		return new UserCookie(Constant.RADIO_NO_VALUE, Constant.RADIO_NO_VALUE,
				Constant.WANBA_GUEST, Constant.WANBA_GUEST,
				Constant.WANBA_GUEST);
	}

	public void setCookieUser(UserCookie userCookie) {
		String value = null;
		try {
			value = URLEncoder.encode(userCookie.toString(), "UTF-8");
			value = DesCryptUtil.encrypt(value, Constant.COOKIE_PASSWORD);
			value = URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int oneMonth = 3600 * 24 * 30;
		CookieUtils.addCookie(response, Constant.COOKIE_KEY, value, oneMonth);
	}

	public void setCookieUser(UserCookie userCookie, int cookieTime) {
		String value = null;
		try {
			value = URLEncoder.encode(userCookie.toString(), "UTF-8");
			value = DesCryptUtil.encrypt(value, Constant.COOKIE_PASSWORD);
			value = URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		CookieUtils.addCookie(response, Constant.COOKIE_KEY, value, cookieTime);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("uid", uid);
		json.put("sid", sid);
		json.put("loginName", loginName);
		json.put("password", password);
		json.put("refererUrl", refererUrl);
		json.put("developerFlag", developerFlag);
		json.put("cmFlag", cmFlag);
		json.put("loginTime", loginTime);
		json.put("nickName", nickName);
		json.put("msgNum", msgNum);
		json.put("msgId", msgId);
		json.put("yxLoginName", yxLoginName);
		json.put("enterCode", enterCode);
		return json.toString();
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getRefererUrl() {
		return refererUrl;
	}

	public void setRefererUrl(String refererUrl) {
		this.refererUrl = refererUrl;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getDeveloperFlag() {
		return developerFlag;
	}

	public void setDeveloperFlag(int developerFlag) {
		this.developerFlag = developerFlag;
	}

	public String getCmFlag() {
		return cmFlag;
	}

	public void setCmFlag(String cmFlag) {
		this.cmFlag = cmFlag;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public long getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(long msgNum) {
		this.msgNum = msgNum;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getYxLoginName() {
		return yxLoginName;
	}

	public void setYxLoginName(String yxLoginName) {
		this.yxLoginName = yxLoginName;
	}

	public String getEnterCode() {
		return enterCode;
	}

	public void setEnterCode(String enterCode) {
		this.enterCode = enterCode;
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
//		JSONObject json = JSONObject.fromObject(result);
//		String id = json.getString("id");

	}

	public String getCookieStr(UserCookie userCookie) {
		String value = null;
		try {
			value = URLEncoder.encode(userCookie.toString(), "UTF-8");
			value = DesCryptUtil.encrypt(value, Constant.COOKIE_PASSWORD);
			value = URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		
		
		//根据cookie串解析cookie字段-pass
		UserCookie userCookie = new UserCookie();
		userCookie
				.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f237422532326964253232253341333838383137352532432532327569642532322533413137343338323938362532432532327369642532322533412532326a46504d6b73355245703463475244544870454e6e3536526e4a494d5835316143314a596d777855544d79596c4a4f5245395161306c31533278365357525151564642515546424a435141414141414141414141416f755351794b3332514b3038375074374c6979745266595745784d514141414141414141414141414141414141414141414141414467616d6d584b674141414f4271615a63714141414175575a4341414141414141784d4334324e5334794e4b5525374559452d6c50324250662532322532432532326c6f67696e4e616d652532322533412532322545362542382542382545362538382538462545362542352538422545382541462539355f6161313125323225324325323270617373776f72642532322533412532322545372539392542452545352542412541362545372542442539312545352538462538422532322532432532327265666572657255726c25323225334125323264656661756c74253232253243253232646576656c6f706572466c616725323225334130253243253232636d466c61672532322533412532326e2532322532432532326c6f67696e54696d65253232253341253232323031322d30332d31342b313425334135302532322532432532326e69636b4e616d652532322533412532322545362542382542382545362538382538462545352541342541372545372538452538422532322532432532326d73674e756d253232253341302532432532326d736749642532322533412d3225324325323279784c6f67696e4e616d652532322533412532322545362542382542382545362538382538462545362542352538422545382541462539355f61613131253232253243253232656e746572436f646525323225334125323266616c7365253232253744");
		
		//根据cookie字段解析cookie串-pass
		userCookie.setCmFlag("y");
		userCookie.setDeveloperFlag(1);
		userCookie.setEnterCode("false");
		userCookie.setId(973876);
		userCookie.setYxLoginName("renwomai");
		userCookie.setLoginName("renwomai");
		userCookie.setUid(152590773);
		userCookie
				.setSid("sssidd");
		userCookie.setLoginTime("2012-03-12 16:30");
		userCookie.setMsgId(-2L);
		userCookie.setMsgNum(0L);
		userCookie.setNickName("天天向上online");
		userCookie.setPassword("百度网友");
		userCookie.setRefererUrl("http://www.baidu.com");
		String cookieStr = userCookie.getCookieStr(userCookie);
		System.out.println("++++++pass+usercookie:" + cookieStr);


		//根据cookie串解析cookie字段-快推
			userCookie
				.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f23742253232696425323225334134343532343835382532432532327569642532322533412d312532432532327369642532322533412532322534302532322532432532326c6f67696e4e616d6525323225334125323277616e676a696e673425343071712e636f6d25323225324325323270617373776f7264253232253341253232776a313132333538253232253243253232646576656c6f706572466c616725323225334130253243253232636d466c61672532322533412532326e2532322532432532326c6f67696e54696d65253232253341253232323031322d30332d31342b313425334134352532322532432532326e69636b4e616d65253232253341253232776a342534302545362542382542382545362538382538462532322532432532326d73674e756d253232253341302532432532326d736749642532322533413025324325323279784c6f67696e4e616d6525323225334125323277616e676a696e673425343071712e636f6d253232253744");
		
		
		//根据cookie字段解析cookie串-快推
		userCookie.setCmFlag("n");
		userCookie.setDeveloperFlag(0);
		userCookie.setEnterCode("false");
		userCookie.setId(23000331);
		userCookie.setYxLoginName("wangjing690@qq.com");
		userCookie.setLoginName("wangjing690@qq.com");
		userCookie.setUid(-1L);
		userCookie
				.setSid("@");
		userCookie.setLoginTime("2012-03-12 16:30");
		userCookie.setMsgId(-2L);
		userCookie.setMsgNum(0L);
		userCookie.setNickName("wj690改造前");
		userCookie.setPassword("wj112358");
		userCookie.setRefererUrl("http://www.baidu.com");
		String qkcookieStr = userCookie.getCookieStr(userCookie);
		System.out.println("+++++快推++qkusercookie:" + qkcookieStr);
		
		
		
		//根据cookie串解析cookie字段-第三方
		userCookie
			.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f237422532326964253232253341313530303030303032312532432532327569642532322533412d312532432532327369642532322533412532325468697264506172742e734f4e467678754667493149744b5776474f545174746d33323267305a6a767a4a4138356d336b4b666f7032314f6f6e676673553256384f366d33354875344a772532322532432532326c6f67696e4e616d65253232253341253232716979692534303130303031383331353225323225324325323270617373776f72642532322533412532322545392542442539302545392542442539302545352539302541372532322532432532327265666572657255726c253232253341253232687474702533412532462532467777772e62616964752e636f6d253232253243253232646576656c6f706572466c616725323225334130253243253232636d466c61672532322533412532326e2532322532432532326c6f67696e54696d65253232253341253232323031322d30332d31322b313625334133302532322532432532326e69636b4e616d65253232253341253232716979692545362539342542392545392538302541302545352538392538442532322532432532326d73674e756d253232253341302532432532326d736749642532322533412d3225324325323279784c6f67696e4e616d652532322533412532322d31253232253243253232656e746572436f646525323225334125323266616c7365253232253744");
	
		
		//根据cookie字段解析cookie串-第三方
		userCookie.setCmFlag("n");
		userCookie.setDeveloperFlag(0);
		userCookie.setEnterCode("false");
		userCookie.setId(1500000021);
		userCookie.setYxLoginName("-1");
		userCookie.setLoginName("qiyi@1000183152");
		userCookie.setUid(-1);
		userCookie
				.setSid("ThirdPart.sONFvxuFgI1ItKWvGOTQttm322g0ZjvzJA85m3kKfop21OongfsU2V8O6m35Hu4Jw");
		userCookie.setLoginTime("2012-03-12 16:30");
		userCookie.setMsgId(-2L);
		userCookie.setMsgNum(0L);
		userCookie.setNickName("qiyi改造前");
		userCookie.setPassword("齐齐吧");
		userCookie.setRefererUrl("http://www.baidu.com");
		String tpcookieStr = userCookie.getCookieStr(userCookie);
		System.out.println("++++++第三方+tpcookieStr:" + tpcookieStr);
		
		
		//根据cookie串解析cookie字段-快推绑定
		userCookie
			.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f2374225323269642532322533413233303030343333253243253232756964253232253341353334333636363833253243253232736964253232253341253232747459305a4d4e4664784e564977526b63344d5535725233684e536a42564e7a56336447553565544a584d47395153564e714e6c646e4e3030786232525151564642515546424a435141414141414141414141416f583772626279646b666447567a644c437530383750747a4979414141414141414141414141414141414141414141414141414144673267563841414141414f4461425877414141414175575a4341414141414141784d4334344d5334314d4d784a59452532322532432532326c6f67696e4e616d6525323225334125323277616e676a696e673225343069796f7578692e636f6d25323225324325323270617373776f72642532322533412532322545372539392542452545352542412541362545372542442539312545352538462538422532322532432532327265666572657255726c253232253341253232687474702533412532462532467777772e62616964752e636f6d253232253243253232646576656c6f706572466c616725323225334130253243253232636d466c61672532322533412532326e2532322532432532326c6f67696e54696d65253232253341253232323031322d30332d31322b313625334133302532322532432532326e69636b4e616d652532322533412532322545372542422539312545352541452539412545362539342542392545392538302541302545352538392538442532322532432532326d73674e756d253232253341302532432532326d736749642532322533412d3225324325323279784c6f67696e4e616d65253232253341253232746573742545372538382542312545362542382542382545362538382538463232253232253243253232656e746572436f646525323225334125323266616c7365253232253744");
	
		//根据cookie字段解析cookie串-快推绑定
		userCookie.setCmFlag("n");
		userCookie.setDeveloperFlag(0);
		userCookie.setEnterCode("false");
		userCookie.setId(23000433);
		userCookie.setYxLoginName("test爱游戏22");
		userCookie.setLoginName("wangjing2@iyouxi.com");
		userCookie.setUid(534366683);
		userCookie
				.setSid("ttY0ZMNFdxNVIwRkc4MU5rR3hNSjBVNzV3dGU5eTJXMG9QSVNqNldnN00xb2RQQVFBQUFBJCQAAAAAAAAAAAoX7rbbydkfdGVzdLCu087PtzIyAAAAAAAAAAAAAAAAAAAAAAAAAADg2gV8AAAAAODaBXwAAAAAuWZCAAAAAAAxMC44MS41MMxJYE");
		userCookie.setLoginTime("2012-03-12 16:30");
		userCookie.setMsgId(-2L);
		userCookie.setMsgNum(0L);
		userCookie.setNickName("绑定改造前");
		userCookie.setPassword("百度网友");
		userCookie.setRefererUrl("http://www.baidu.com");
		String qkBDpasscookieStr = userCookie.getCookieStr(userCookie);
		System.out.println("++++++快推绑定+qkBDpasscookieStr:" + qkBDpasscookieStr);
		
		//根据cookie串解析cookie字段-快推升级
		userCookie
			.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f2374225323269642532322533413233303030343333253243253232756964253232253341353334333636363833253243253232736964253232253341253232747459305a4d4e4664784e564977526b63344d5535725233684e536a42564e7a56336447553565544a584d47395153564e714e6c646e4e3030786232525151564642515546424a435141414141414141414141416f583772626279646b666447567a644c437530383750747a4979414141414141414141414141414141414141414141414141414144673267563841414141414f4461425877414141414175575a4341414141414141784d4334344d5334314d4d784a59452532322532432532326c6f67696e4e616d6525323225334125323277616e676a696e673225343069796f7578692e636f6d25323225324325323270617373776f72642532322533412532322545372539392542452545352542412541362545372542442539312545352538462538422532322532432532327265666572657255726c253232253341253232687474702533412532462532467777772e62616964752e636f6d253232253243253232646576656c6f706572466c616725323225334130253243253232636d466c61672532322533412532326e2532322532432532326c6f67696e54696d65253232253341253232323031322d30332d31322b313625334133302532322532432532326e69636b4e616d652532322533412532322545372542422539312545352541452539412545362539342542392545392538302541302545352538392538442532322532432532326d73674e756d253232253341302532432532326d736749642532322533412d3225324325323279784c6f67696e4e616d65253232253341253232746573742545372538382542312545362542382542382545362538382538463232253232253243253232656e746572436f646525323225334125323266616c7365253232253744");
	
		//根据cookie字段解析cookie串-快推升级
		userCookie.setCmFlag("n");
		userCookie.setDeveloperFlag(0);
		userCookie.setEnterCode("false");
		userCookie.setId(23000348);
		userCookie.setYxLoginName("wangjing84@qq.com");
		userCookie.setLoginName("renwomai102");
		userCookie.setUid(481204759);
		userCookie
				.setSid("JNR2dOfjc4M29Od01FNWNOYjg5ZnN4QW5PLUVySFlEM1NUWEhodjVaNjgzWWRQQVFBQUFBJCQAAAAAAAAAAAokOCAXmq4ccmVud29tYWkxMDIAAAAAAAAAAAAAAAAAAAAAAAAAAADgymV7AAAAAODKZXsAAAAAuWZCAAAAAAAxMC42NS4yMrxQYE8UGBPSm");
		userCookie.setLoginTime("2012-03-12 16:30");
		userCookie.setMsgId(-2L);
		userCookie.setMsgNum(0L);
		userCookie.setNickName("升级改造前");
		userCookie.setPassword("百度网友");
		userCookie.setRefererUrl("http://www.baidu.com");
		String qkUPpasscookieStr = userCookie.getCookieStr(userCookie);
		System.out.println("++++++快推升级+qkUPpasscookieStr:" + qkUPpasscookieStr);
		
	
		//根据cookie串解析cookie字段-改造后pass
		userCookie
			.getCookieFromStr("255cdfa44d97725d12f48c7b9e1a6606f237422532326c6f67696e4e616d6525323225334125323272656e776f6d6169253232253744");
		//根据cookie字段解析cookie串-改造后pass
		userCookie.setLoginName("");
		String newpasscookieStr = userCookie.getCookieStr(userCookie);
		System.out.println("++++++快推升级+newpasscookieStr:" + newpasscookieStr);
	}

}
