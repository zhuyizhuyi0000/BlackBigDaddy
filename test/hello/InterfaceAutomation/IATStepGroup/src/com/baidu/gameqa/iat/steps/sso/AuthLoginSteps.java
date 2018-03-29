package com.baidu.gameqa.iat.steps.sso;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import junit.framework.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class AuthLoginSteps {

	static String authkey = null;
	static String actualResult1 = null;
	static String actualResult2 = null;

	// 获取xml中的所有参数信息,公共方法,使用时直接调用方法
	// getParameters(parameterID).getValue("*****")
	private InterfaceStepParameter getParameters(String parameterID)
			throws Exception {
		InterfaceStepParameter parameters = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		return parameters;
	}

	// 开始调用接口请求InnerLogin,便于后边使用anthkey
	@StepMethodDesc(description = "authInner_login", owner = "yajuan,li")
	public String getInnerLoginAuthkey(String parameterID) throws Exception {

		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("url_InnerLogin"),
				getParameters(parameterID).getValue("httpmethod_InnerLogin"));
		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse currentResponse = currentConversation
				.getResponse(currentRequest);

		JSONObject json = JSONObject.fromObject(currentResponse.getText());
		authkey = json.getString("authkey");
//		JSONObject body = json.getJSONObject("body");
//		descryString = new HashMap<String, String>();
//		descryString.put("desWords", body.getString("desWords"));
//		descryString.put("securityKey", body.getString("securityKey"));
		return authkey;
	}

	// 开始调用接口请求authInnerLogin
	@StepMethodDesc(description = " authInner_login", owner = "yajuan,li")
	public String doAuthInnerLogin(String parameterID) throws Exception {

		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("url_authInnerLogin"),
				getParameters(parameterID).getValue("httpmethod_authInnerLogin"));

		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		urlParameters.put("authkey", authkey);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse currentResponse = currentConversation
				.getResponse(currentRequest);
		actualResult1 = currentResponse.getText();
		return actualResult1;
	}
	
	// 开始调用接口请求authInnerLogin
	@StepMethodDesc(description = " authInner_login", owner = "yajuan,li")
	public String doAuthInnerLogin2(String parameterID) throws Exception {

		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("url_authInnerLogin"),
				getParameters(parameterID).getValue("httpmethod_authInnerLogin"));
        
		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		urlParameters.put("authkey", authkey);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}
		WebResponse currentResponse = currentConversation
				.getResponse(currentRequest);
		actualResult2 = currentResponse.getText();
		return actualResult2;
	}

	@StepMethodDesc(description = "assert method", owner = "yajuan,li")
	public void assertResult(String parameterID) throws Exception {
		String expectedResult1 = getParameters(parameterID).getValue(
				"expectedResult1");
		String expectedResult2 = getParameters(parameterID).getValue(
				"expectedResult2");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:actualResult1 " +  actualResult1+ "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:expectedResult1 " +  expectedResult1+ "======");
		Assert.assertEquals(actualResult1, expectedResult1);
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:actualResult2 " +  actualResult2+ "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:expectedResult2" +  expectedResult2+ "======");
		Assert.assertEquals(actualResult2, expectedResult2);
		
	}

}
