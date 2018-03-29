package com.baidu.gameqa.iat.steps.sso;

import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValueHelper;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class InnerLoginSteps {

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
		@StepMethodDesc(description = "sso_innerLogin", owner = "yajuan,li")
		public String innerLogin(String parameterID) throws Exception {

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
			
			if(actualResult.equals(getParameters(parameterID).getValue("expectedResult1"))){
				Assert.assertEquals(actualResult, expectedResult1);
			} else if(actualResult.contains(getParameters(parameterID).getValue("expectedResult1"))){
				Assert.assertTrue(actualResult.contains(expectedResult2));
			}else
			Assert.assertTrue(actualResult.contains(expectedResult3));
		}
	}
