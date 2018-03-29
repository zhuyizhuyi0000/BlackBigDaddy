package com.baidu.gameqa.iat.steps.sso;

import java.util.HashMap;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class LoginSteps {

	static String actualResult = null;

	// 获取xml中的所有参数信息,公共方法,使用时直接调用方法
	// getParameters(parameterID).getValue("*****")
	private InterfaceStepParameter getParameters(String parameterID)
			throws Exception {
		InterfaceStepParameter parameters = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		return parameters;
	}

	// 开始调用接口请求
	@StepMethodDesc(description = "sso_login", owner = "yajuan,li")
	public String Login(String parameterID) throws Exception {

		// 创建一个会话
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		// 直接执行http对应的url并带上请求模式
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("url"),
				getParameters(parameterID).getValue("httpmethod"));
		// 对xml中的参数进行hashmap解析
		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		// 请求url有参数的时候需要把第一次请求的url加上参数&
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		
			// 真正执行接口url的请求
		WebResponse  currentResponse = currentConversation
					.getResponse(currentRequest);
		
		actualResult = currentResponse.getText();
		return actualResult;
	}

	@StepMethodDesc(description = "assert method", owner = "yajuan,li")
	public void assertResult(String parameterID) throws Exception {
		String expectedResult1 = getParameters(parameterID).getValue(
				"expectedResult1");
		String expectedResult2 = getParameters(parameterID).getValue(
				"expectedResult2");
		String expectedResult3 = getParameters(parameterID).getValue(
				"expectedResult3");
		String expectedResult4 = getParameters(parameterID).getValue(
				"expectedResult4");
		
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:assert " + actualResult + "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:expectedResult1 " + expectedResult1 + "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:expectedResult2 " + expectedResult2 + "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:expectedResult3 " + expectedResult3 + "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:expectedResult3 " + expectedResult4 + "======");
		if(actualResult.contains(getParameters(parameterID).getValue("expectedResult1"))){
			Assert.assertEquals(actualResult, expectedResult1);
			SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:gogogogogo11111 " +  actualResult.equals(getParameters(parameterID).getValue("expectedResult1"))+ "======");
			
		} else if(actualResult.contains(getParameters(parameterID).getValue("expectedResult2"))){
			Assert.assertTrue(actualResult.contains(getParameters(parameterID).getValue("expectedResult2")));
			SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:gogogogogo22222 " +  actualResult.equals(getParameters(parameterID).getValue("expectedResult2"))+ "======");

		}else if(actualResult.contains(getParameters(parameterID).getValue("expectedResult3"))){
		Assert.assertTrue(actualResult.contains(getParameters(parameterID).getValue("expectedResult3")));
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:gogogogogo33333 " +  actualResult.equals(getParameters(parameterID).getValue("expectedResult3"))+ "======");
		}else {
		Assert.assertTrue(actualResult.contains(getParameters(parameterID).getValue("expectedResult4")));
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:gogogogogo444443 " +  actualResult.equals(getParameters(parameterID).getValue("expectedResult4"))+ "======");

		}
   }
}

