package com.baidu.gameqa.iat.steps.sso; 

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.iat.steps.common.ClientLoginRequest;
import com.baidu.gameqa.iat.steps.common.GsonUtils;
import com.baidu.gameqa.iat.steps.common.SecurityUtils;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/** 
 * 九鼎客户端登录接口TestCase
 * API: /sso/client/setCookies.json
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月22日 上午11:00:50 
 */
public class JDSetCookies_QA {
	
	static Map<String, String> descryString = null;
	static String actualResult = null;
	static Map<String, String> tokenMap = null;

	/**
	 * 获取step多步的参数 不想每次都写这个方法，所以提出来一个公用的吧
	 * 
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月20日 上午10:59:00
	 */
	private static InterfaceStepParameter getParameters(String parameterID)
			throws Exception {
		@SuppressWarnings("deprecation")
		InterfaceStepParameter parameters = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		return parameters;
	}

	/**
	 * 获取加密内容：desWords,securityKey
	 * 
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月20日 下午12:02:13
	 */
	@StepMethodDesc(description = "get descry word", owner = "lei.yang")
	public static Map<String, String> getDescryString(String parameterID)
			throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("key_qa_url"),
				getParameters(parameterID).getValue("key_httpmethod"));
		WebResponse currResponse = webConversation.getResponse(currRequest);

		JSONObject json = JSONObject.fromObject(currResponse.getText());
		JSONObject body = json.getJSONObject("body");
		descryString = new HashMap<String, String>();
		descryString.put("desWords", body.getString("desWords"));
		descryString.put("securityKey", body.getString("securityKey"));
		return descryString;
	}

	/**
	 * 计算加密reqBody
	 * 
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月20日 下午4:05:14
	 */
	@StepMethodDesc(description = "get encrypt request body", owner = "lei.yanglei")
	public static String encryptReqBody(String parameterID) throws Exception {
		ClientLoginRequest clr = new ClientLoginRequest();
		clr.setLoginName(getParameters(parameterID).getValue("loginName"));
		clr.setPassword(getParameters(parameterID).getValue("password"));

		return SecurityUtils.encrypt(GsonUtils.serialize(clr),
				descryString.get("desWords"));
	}

	/**
	 * 九鼎客户端登录接口：真正需要测试的接口，好恶心，算了一大堆东西才开始真正的主题！！ api: /sso/client/login.json
	 * 
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月20日 下午6:12:34
	 */
	@StepMethodDesc(description = "client login method", owner = "lei.yanglei")
	public static Map<String, String> clientLogin(String parameterID) throws Exception {
		String encryptReqBody = encryptReqBody(parameterID);

		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("login_qa_url"),
				getParameters(parameterID).getValue("login_httpmethod"));

		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		urlParameters.put("reqBody", encryptReqBody);
		urlParameters.put("securityKey", descryString.get("securityKey"));
		urlParameters.put("gameId",
				getParameters(parameterID).getValue("login_gameId"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		
		JSONObject json = JSONObject.fromObject(currResponse.getText());
		JSONObject body = json.getJSONObject("body");
		tokenMap = new HashMap<String, String>();
		tokenMap.put("userId", body.getString("userId"));
		tokenMap.put("loginToken", body.getString("loginToken"));
		return tokenMap;
	}

	/**
	 * 九鼎客户端setCookies接口
	 * api: /sso/client/setCookies.json
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 上午11:20:04
	 */
	@StepMethodDesc(description= "client login and set cookies method", owner = "lei.yang")
	public String setCookies(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest curReq = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("set_cookie_qa_url"),
				getParameters(parameterID).getValue("set_cookie_httpmethod"));
		
		HashMap<String, String> urlPara = new HashMap<String, String>();
		urlPara.put("userId", tokenMap.get("userId"));
		urlPara.put("loginToken", tokenMap.get("loginToken"));
		
		if(urlPara.size() != 0) {
			HttpUnitHelper.setParameters(curReq, urlPara);
		}
		WebResponse curResp = webConversation.getResource(curReq);
		actualResult = curResp.getText();
		return actualResult;
	}
	
	/**
	 * 九鼎客户端setCookies接口-case-使用错误的userId请求接口
	 * api: /sso/client/setCookies.json
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午3:54:30
	 */
	@StepMethodDesc(description="TestCase : set cookies with wrong userid", owner="lei.yang")
	public String setCookiesWithWrongUserId(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest curReq = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("set_cookie_qa_url"),
				getParameters(parameterID).getValue("set_cookie_httpmethod"));
		
		HashMap<String, String> urlPara = new HashMap<String, String>();
		urlPara.put("userId", getParameters(parameterID).getValue("userId"));
		urlPara.put("loginToken", tokenMap.get("loginToken"));
		
		if(urlPara.size() != 0) {
			HttpUnitHelper.setParameters(curReq, urlPara);
		}
		WebResponse curResp = webConversation.getResource(curReq);
		actualResult = curResp.getText();
		return actualResult;
	}
	
	/**
	 * 我开始恶心了，好吧，先这样写吧，先跑起来，在抽象这个几个恶心的方法吧
	 * 每次都写同样的东西，确实会恶心 - -||
	 * 
	 * 九鼎客户端setCookies接口-case-使用错误的loginToken请求接口
	 * api: /sso/client/setCookies.json
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午5:00:29
	 */
	@StepMethodDesc(description="TestCase : set cookies with wrong login token", owner="lei.yang")
	public String setCookiesWithWrongLoginToken(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest curReq = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("set_cookie_qa_url"),
				getParameters(parameterID).getValue("set_cookie_httpmethod"));
		
		HashMap<String, String> urlPara = new HashMap<String, String>();
		urlPara.put("userId", tokenMap.get("userId"));
		urlPara.put("loginToken", getParameters(parameterID).getValue("loginToken"));
		
		if(urlPara.size() != 0) {
			HttpUnitHelper.setParameters(curReq, urlPara);
		}
		WebResponse curResp = webConversation.getResource(curReq);
		actualResult = curResp.getText();
		return actualResult;
	}
	
	/**
	 * 断言cookies信息字段是否正确的方法
	 * @param parameterID
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午1:42:35
	 */
	@StepMethodDesc(description="assert cookie method", owner="lei.yang")
	public void assertCookies(String parameterID) throws Exception {
		String result = setCookies(parameterID);

		JSONObject resultJson = JSONObject.fromObject(result);
		JSONObject body = resultJson.getJSONObject("body");
		Map<String, String> cookiesMap = new HashMap<String, String>();
		cookiesMap.put("wanba_cookies", body.getString("wanba_cookies"));
		cookiesMap.put("userid", body.getString("userid"));
		cookiesMap.put("bduss", body.getString("bduss"));
		
		if(getParameters(parameterID).getValue("wanba_cookies").equals("not null")) {
			Assert.assertNotNull(cookiesMap.get("wanba_cookies"));
		}else if(getParameters(parameterID).getValue("userid").equals("not null")) {
			Assert.assertNotNull(cookiesMap.get("userid"));
		}else if(getParameters(parameterID).getValue("bduss").equals("not null")) {
			Assert.assertNotNull(cookiesMap.get("bduss"));
		}else{
			Assert.assertFalse(true);
		}
	}
	
	/**
	 * 断言方法，每次我都可以对parameterID里的assertType，expectedResult的参数做不同的断言方法
	 * 
	 * 对于每次请求可能接口返回结果不同做了稍微的判定处理，避免其他重复代码
	 * 
	 * 虽然可能多次请求结果不同，但每次的返回结果都是正确的
	 * 
	 * @param parameterID
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月20日 下午6:11:25
	 */
	@StepMethodDesc(description = "assert method", owner = "lei.yanglei")
	public void assertResult(String parameterID) throws Exception {
		System.out.println("......" + actualResult);

		if (getParameters(parameterID).getValue("assertType")
				.equals("contains")) {
			String expectedResult = getParameters(parameterID).getValue(
					"expectedResult");
			String expectedResult_Many = getParameters(parameterID).getValue(
					"expectedResult_Many");
			if (!expectedResult_Many.isEmpty()) {
				if (actualResult.contains(expectedResult)) {
					Assert.assertTrue(actualResult.contains(expectedResult));
				} else if (actualResult.contains(expectedResult_Many)) {
					Assert.assertTrue(actualResult
							.contains(expectedResult_Many));
				} else {
					Assert.assertTrue(actualResult.contains(expectedResult));
				}
			} else {
				Assert.assertTrue(actualResult.contains(expectedResult));
			}
		} else {
			Assert.assertFalse(true);
		}
	}
}
 