package com.baidu.gameqa.iat.steps.sso;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import net.sf.json.JSONObject;

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
 * 九鼎客户端登录接口(多接口测试类) API: /sso/client/login.json
 * 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月16日 下午4:57:43
 */
public class JDClientLogin_QA {

	static Map<String, String> descryString = null;
	static String actualResult = null;

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
	public String encryptReqBody(String parameterID) throws Exception {
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
	public String clientLogin(String parameterID) throws Exception {
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
		actualResult = currResponse.getText();
		return actualResult;
	}

	/**
	 * loginWithWrongKey（请求参数securityKey自定义错误）
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月21日 下午3:19:28
	 */
	@StepMethodDesc(description = "client login with wrong securityKey", owner = "lei.yanglei")
	public String loginWithWrongKey(String parameterID) throws Exception {
		String encryptReqBody = encryptReqBody(parameterID);

		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("login_qa_url"),
				getParameters(parameterID).getValue("login_httpmethod"));

		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		urlParameters.put("reqBody", encryptReqBody);
		urlParameters.put("securityKey",
				getParameters(parameterID).getValue("securityKey"));
		urlParameters.put("gameId",
				getParameters(parameterID).getValue("login_gameId"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		actualResult = currResponse.getText();
		return actualResult;
	}
	
	/**
	 * loginWithWrongReqBody（请求参数reqBody自定义错误）
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月21日 下午5:09:14
	 */
	@StepMethodDesc(description = "client login with wrong reqBody", owner = "lei.yanglei")
	public String loginWithWrongReqBody(String parameterID) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest currRequest = HttpUnitHelper.createWebRequest(
				getParameters(parameterID).getValue("login_qa_url"),
				getParameters(parameterID).getValue("login_httpmethod"));

		HashMap<String, String> urlParameters = getParameters(parameterID)
				.getURLParametersMap();
		urlParameters.put("reqBody", getParameters(parameterID).getValue("reqBody"));
		urlParameters.put("securityKey", descryString.get("securityKey"));
		urlParameters.put("gameId",
				getParameters(parameterID).getValue("login_gameId"));

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currRequest, urlParameters);
		}
		WebResponse currResponse = webConversation.getResponse(currRequest);
		actualResult = currResponse.getText();
		return actualResult;
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
			Assert.assertFalse(false);
		}
	}
}
