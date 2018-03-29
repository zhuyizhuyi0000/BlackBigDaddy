package com.baidu.gameqa.iat.steps.sso; 

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.iat.steps.common.AssertMultiResult;
import com.baidu.gameqa.iat.steps.common.ClientLoginRequest;
import com.baidu.gameqa.iat.steps.common.GsonUtils;
import com.baidu.gameqa.iat.steps.common.SecurityUtils;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/** 
 * 客户端登录加密接口类
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月23日 下午5:03:52 
 * 
 */
public class ClientSecurityLogin {

	static InterfaceStepParameter testParameters = null;
	static Map<String, String> descryString = null;
	static String actualResult = null;
	
	/**
	 * 通用获取StepParameters参数方法
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午5:04:50
	 */
	@StepMethodDesc(description = "get this class test parameters", owner="lei.yang")
	@SuppressWarnings({ "deprecation" })
	public static InterfaceStepParameter getParameter(String parameterID) throws Exception {
		testParameters = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		System.out.println("param:::" + testParameters);
		return testParameters;
	}
	
	/**
	 * 获取desWords，securityKey
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午5:07:28
	 */
	@StepMethodDesc(description = "get descry string", owner="lei.yang")
	public static Map<String, String> getDescryString(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				testParameters.getValue("key_url"),
				testParameters.getValue("key_httpmethod"));
		WebResponse currResponse = webConversation.getResponse(currRequest);

		JSONObject json = JSONObject.fromObject(currResponse.getText());
		JSONObject body = json.getJSONObject("body");
		descryString = new HashMap<String, String>();
		descryString.put("desWords", body.getString("desWords"));
		descryString.put("securityKey", body.getString("securityKey"));
		descryString.put("extra", body.getString("extra"));
		System.out.println("step2 :: " + descryString.toString());
		return descryString;
	}
	
	/**
	 * 计算加密的reqBody，根据拿到的loginName和password
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午5:15:02
	 */
	@StepMethodDesc(description = "get encrypt request body", owner = "lei.yanglei")
	public static String encryptReqBody(String parameterID) throws Exception {
		ClientLoginRequest clr = new ClientLoginRequest();
		clr.setLoginName(testParameters.getValue("loginName"));
		clr.setPassword(testParameters.getValue("password"));

		String decDesWords = SecurityUtils.decrypt(descryString.get("desWords"), SecurityUtils.DEFAULT_SEC_KEY);
		return SecurityUtils.encrypt(GsonUtils.serialize(clr), decDesWords);
	}
	
	/**
	 * 通过加密的reqBody和获取的securityKey进行登录
	 * API：/sso/client/security/login.json
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午5:16:54
	 */
	@StepMethodDesc(description = "client login method", owner = "lei.yanglei")
	public static String clientLogin(String parameterID) throws Exception {
		String encryptReqBody = encryptReqBody(parameterID);

		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				testParameters.getValue("login_url"),
				testParameters.getValue("login_httpmethod"));

		HashMap<String, String> urlParameters = testParameters.getURLParametersMap();
		urlParameters.put("reqBody", encryptReqBody);
		urlParameters.put("platform", testParameters.getValue("platform"));
		urlParameters.put("appKey", testParameters.getValue("appKey"));
		urlParameters.put("securityKey", descryString.get("securityKey"));
		urlParameters.put("mergeType", testParameters.getValue("mergeType"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		actualResult = currResponse.getText();
		System.out.println("step4 :: " + actualResult);
		System.out.println("expected result :: " + testParameters.getValue("expectedResult"));
		return actualResult;
	}
	
	/**
	 * 结果的断言方法
	 * @param parameterID
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月26日 下午3:03:19
	 */
	public void assertResult(String parameterID) throws Exception {
		AssertMultiResult.assertResult(testParameters, actualResult);
	}
}
 