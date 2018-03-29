package com.baidu.gameqa.iat.steps.sso; 

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.iat.steps.common.AssertMultiResult;
import com.baidu.gameqa.iat.steps.common.SignVerfiy;
import com.baidu.gameqa.iat.steps.common.WebConversationUtils;

/** 
 * 类说明 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月27日 下午2:45:59 
 */
public class VerifyLoginToken {

	static InterfaceStepParameter testParameters = null;
	static Map<String, String> descryString = null;
	static String actualResult = null;
	static String encryptReqBody = null;
	static String loginResult = null;
	static Map<String, String> bodyMap = new HashMap<String, String>();

	/**
	 * 获取对应的StepParameters
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午2:49:19
	 */
	@StepMethodDesc(description = "get this class test parameters", owner = "lei.yang")
	public InterfaceStepParameter getParameter(String parameterID)
			throws Exception {
		testParameters = ClientSecurityLogin.getParameter(parameterID);
		return testParameters;
	}

	/**
	 * 获取返回的加密串
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午2:49:19
	 */
	@StepMethodDesc(description = "get descry string", owner = "lei.yang")
	public Map<String, String> getDescryString(String parameterID)
			throws Exception {
		descryString = ClientSecurityLogin.getDescryString(parameterID);
		return descryString;
	}

	/**
	 * 加密reqBody请求串
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午2:49:19
	 */
	@StepMethodDesc(description = "get encrypt request body", owner = "lei.yanglei")
	public String encryptReqBody(String parameterID) throws Exception {
		encryptReqBody = ClientSecurityLogin.encryptReqBody(parameterID);
		return encryptReqBody;
	}

	/**
	 * 客户端加密登录并返回body字段的内容
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午2:49:19
	 */
	@StepMethodDesc(description = "client login method", owner = "lei.yanglei")
	public Map<String, String> clientLogin(String parameterID) throws Exception {
		loginResult = ClientSecurityLogin.clientLogin(parameterID);
		JSONObject JsonResult = JSONObject.fromObject(loginResult);
		JSONObject body = JsonResult.getJSONObject("body");

		bodyMap.put("displayName", body.getString("displayName"));
		bodyMap.put("userId", body.getString("userId"));
		bodyMap.put("loginToken", body.getString("loginToken"));
		bodyMap.put("verifyCodeUrl", body.getString("verifyCodeUrl"));
		bodyMap.put("verifyToken", body.getString("verifyToken"));
		bodyMap.put("type", body.getString("type"));
		bodyMap.put("cm", body.getString("cm"));
		bodyMap.put("needGameActiveCode", body.getString("needGameActiveCode"));
		bodyMap.put("gameActiveCodeUrl", body.getString("gameActiveCodeUrl"));
		bodyMap.put("extra", body.getString("extra"));

		return bodyMap;
	}
	
	/**
	 * 获取verifyLoginToken接口返回结果
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午2:54:55
	 */
	@StepMethodDesc(description = "verify login token method", owner = "lei.yang")
	public String verifyLoginToken(String parameterID) throws Exception {
		String sign = SignVerfiy.getSign(
				bodyMap.get("userId"), 
				bodyMap.get("loginToken"), 
				testParameters.getValue("random"));
		
		HashMap<String, String> urlParameters = testParameters
				.getURLParametersMap();
		urlParameters.put("userId", bodyMap.get("userId"));
		urlParameters.put("loginToken", bodyMap.get("loginToken"));
		urlParameters.put("random", testParameters.getValue("random"));
		urlParameters.put("sign", sign);
		
		System.out.println(urlParameters.toString() + "=================================");
		actualResult = WebConversationUtils.getWebResponse(
				testParameters.getValue("verify_url"), 
				testParameters.getValue("verify_httpmethod"), 
				urlParameters).getText();
		System.out.println("verify login token result :::::: " + actualResult);
		return actualResult;
	}
	
	/**
	 * 断言方法
	 * @param parameterID
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午2:57:11
	 */
	@StepMethodDesc(description = "assert method", owner = "lei.yang")
	public void assertResult(String parameterID) throws Exception {
		AssertMultiResult.assertWithParameter(
				testParameters, 
				actualResult, 
				testParameters.getValue("verify_expected_result"));
	}
}
 