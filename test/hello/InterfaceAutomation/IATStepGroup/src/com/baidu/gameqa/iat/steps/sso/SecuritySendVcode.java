package com.baidu.gameqa.iat.steps.sso; 

import java.util.HashMap;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.iat.steps.common.AssertMultiResult;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/** 
 * 短信加密登录获取动态码
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月29日 下午1:44:03 
 */
public class SecuritySendVcode {

	static InterfaceStepParameter testParameters = null;
	static String vcodeResult = null;
	
	@StepMethodDesc(description = "get interface step parameter", owner="lei.yang")
	@SuppressWarnings("deprecation")
	public static InterfaceStepParameter getParameter(String parameterID) throws Exception {
		testParameters = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		System.out.println("param:::" + testParameters);
		return testParameters;
	}
	
	@StepMethodDesc(description = "get vcode with right parameters", owner="lei.yang")
	public static String getVcode(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				testParameters.getValue("api_rd_url"),
				testParameters.getValue("api_httpmethod"));
		HashMap<String, String> urlParameters = testParameters.getURLParametersMap();
		urlParameters.put("phoneNumber", testParameters.getValue("phoneNumber"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		vcodeResult = currResponse.getText();
		System.out.println("/////////////////////" + vcodeResult);
		return vcodeResult;
	}
	
	@StepMethodDesc(description = "get vcode with clienIp parameters", owner="lei.yang")
	public static String getVcodeWithClientIp(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				testParameters.getValue("api_rd_url"),
				testParameters.getValue("api_httpmethod"));
		HashMap<String, String> urlParameters = testParameters.getURLParametersMap();
		urlParameters.put("phoneNumber", testParameters.getValue("phoneNumber"));
		urlParameters.put("clientIp", testParameters.getValue("clientIp"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		vcodeResult = currResponse.getText();
		System.out.println("/////////////////////" + vcodeResult);
		return vcodeResult;
	}
	
	@StepMethodDesc(description = "get vcode with clientIp & pid parameters", owner = "lei.yang")
	public static String getVcodeWithPid(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				testParameters.getValue("api_rd_url"),
				testParameters.getValue("api_httpmethod"));
		HashMap<String, String> urlParameters = testParameters.getURLParametersMap();
		urlParameters.put("phoneNumber", testParameters.getValue("phoneNumber"));
		urlParameters.put("clientIp", testParameters.getValue("clientIp"));
		urlParameters.put("pid", testParameters.getValue("pid"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		vcodeResult = currResponse.getText();
		System.out.println("/////////////////////" + vcodeResult);
		return vcodeResult;
	}
	
	@StepMethodDesc(description = "assert result", owner = "lei.yang")
	public void assertResult(String parameterID) throws Exception {
		AssertMultiResult.assertResult(testParameters, vcodeResult);
	}
}
 