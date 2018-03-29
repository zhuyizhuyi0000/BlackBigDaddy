package com.baidu.gameqa.iat.steps.sso; 

import java.util.HashMap;
import java.util.Map;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.iat.steps.common.AssertMultiResult;
import com.baidu.gameqa.iat.steps.common.WebConversationUtils;

/** 
 * 客户端logM接口
 * API: /sso/client/logM.xhtml 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月22日 下午5:15:11 
 */
public class JDLogM_QA {
	
	static InterfaceStepParameter testParameters = null;
	static Map<String, String> descryString = null;
	static String encryptReqBody = null;
	static Map<String, String> loginRespBody = null;
	static HashMap<String, String> urlParams = new HashMap<String, String>();
	static String actualResult = null;
	
	/**
	 * 获取当前类的测试parameter
	 * PS：
	 * 恶心了两次之后，实在不想每次都写这个方法了，那就直接调赋值吧。
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午5:20:21
	 */
	@StepMethodDesc(description = "get this class test parameters", owner="lei.yang")
	@SuppressWarnings({ "deprecation" })
	public InterfaceStepParameter getParameter(String parameterID) throws Exception {
		testParameters = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		System.out.println("param:::" + testParameters);
		return testParameters;
	}
	
	/**
	 * 获取加密内容：desWords,securityKey
	 * PS:
	 * 偷懒的办法，我就直接复用以前的类中的这个方法了，因为确实没啥改变
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午7:46:24
	 */
	@StepMethodDesc(description = "get descry string from JDSetCookies_QA class", owner="lei.yang")
	public Map<String, String> getDesString(String parameterID) throws Exception {
		descryString = JDSetCookies_QA.getDescryString(parameterID);
		System.out.println("\n\n descryString" + descryString + "\n\n");
		return descryString;
	}
	
	/**
	 * 获取reqBody
	 * PS:
	 * 继续复用以前的方法吧
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午7:54:47
	 */
	@StepMethodDesc(description = "get encrypt request body", owner="lei.yang")
	public String encryptReqBody(String parameterID) throws Exception {
		encryptReqBody = JDSetCookies_QA.encryptReqBody(parameterID);
		System.out.println("\n\n descryString" + encryptReqBody + "\n\n");
		return encryptReqBody;
	}
	
	/**
	 * 获取登录成功后的body内容
	 * PS:
	 * 继续复用
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午7:58:39
	 */
	@StepMethodDesc(description = "get client login response body", owner="lei.yang")
	public Map<String, String> clientLogin(String parameterID) throws Exception {
		loginRespBody = JDSetCookies_QA.clientLogin(parameterID);
		System.out.println("\n\n loginRespBody" + loginRespBody + "\n\n");
		return loginRespBody;
	}
	
	/**
	 * 真正需要测试的接口-case1-passport账号
	 * API：/sso/client/logM.xhtml
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午8:18:13
	 */
	@StepMethodDesc(description = "get logM response with passport", owner="lei.yang")
	public String testLogMPass(String parameterID) throws Exception {
		
		urlParams.put("userId", loginRespBody.get("userId"));
		urlParams.put("loginToken", loginRespBody.get("loginToken"));
		urlParams.put("backUrl", testParameters.getValue("backUrl"));
		
		actualResult = WebConversationUtils.getWebResponse(
				testParameters.getValue("logM_url"), 
				testParameters.getValue("logM_httpmethod"), 
				urlParams).getNewCookieValue("BDUSS");
		System.out.println("bduss::::" + actualResult);
		return actualResult;
	}
	
	/**
	 * 真正需要测试的接口-case2-快推账号
	 * API：/sso/client/logM.xhtml
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午1:36:24
	 */
	@StepMethodDesc(description = "get logM response with quick user", owner="lei.yang")
	public String testLogMQuick(String parameterID) throws Exception {
		
		urlParams.put("userId", loginRespBody.get("userId"));
		urlParams.put("loginToken", loginRespBody.get("loginToken"));
		urlParams.put("backUrl", testParameters.getValue("backUrl"));
		
		actualResult = WebConversationUtils.getWebResponse(
				testParameters.getValue("logM_url"), 
				testParameters.getValue("logM_httpmethod"), 
				urlParams).getNewCookieValue("wanba_cookies");
		return actualResult;
	}
	
	
	/**
	 * 真正需要测试的接口-case3-快推账号使用错误的userId
	 * API：/sso/client/logM.xhtml
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午3:21:05
	 */
	@StepMethodDesc(description = "get logM response with wrong userid", owner = "lei.yang")
	public String testLogMWithWrongUid(String parameterID) throws Exception {
		urlParams.put("userId", testParameters.getValue("userId"));
		urlParams.put("loginToken", loginRespBody.get("loginToken"));
		urlParams.put("backUrl", testParameters.getValue("backUrl"));
		
		actualResult = WebConversationUtils.getWebResponse(
				testParameters.getValue("logM_url"), 
				testParameters.getValue("logM_httpmethod"), 
				urlParams).getNewCookieValue("wanba_cookies");
		return actualResult;
	}
	
	/**
	 * 真正需要测试的接口-case4-passport账号使用错误的loginToken
	 * @param parameterID
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 下午4:04:39
	 */
	@StepMethodDesc(description = "get logM response with wrong loginToken", owner = "lei.yanglei")
	public String testLogMWithWrongToken(String parameterID) throws Exception {
		urlParams.put("userId", loginRespBody.get("userId"));
		urlParams.put("loginToken", testParameters.getValue("loginToken"));
		urlParams.put("backUrl", testParameters.getValue("backUrl"));
		
		actualResult = WebConversationUtils.getWebResponse(
				testParameters.getValue("logM_url"), 
				testParameters.getValue("logM_httpmethod"), 
				urlParams).getNewCookieValue("BDUSS");
		return actualResult;
	}
	
	/**
	 * 断言方法
	 * @param parameterID
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月23日 上午11:14:35
	 */
	public void assertResult(String parameterID) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("BDUSS", actualResult);
		map.put("wanba_cookies", actualResult);
		AssertMultiResult.assertCookieResult(testParameters, map);
	}
}
 