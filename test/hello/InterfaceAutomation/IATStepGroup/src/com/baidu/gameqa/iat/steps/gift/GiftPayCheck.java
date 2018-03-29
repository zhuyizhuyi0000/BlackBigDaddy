package com.baidu.gameqa.iat.steps.gift; 

import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.iat.steps.common.AssertMultiResult;
import com.baidu.gameqa.iat.steps.common.SetupSteps;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/** 
 * API : http://youxi.baidu.com/i/ajax_gift_product.xhtml?c=check&id=3&count=1
 * 校验用户是否满足礼包领取条件接口，如果满足，返回领取token
 * @author yanglei12
 * @version V1.0 创建时间：2014年7月7日 下午4:14:05 
 */
public class GiftPayCheck {
	
	static InterfaceStepParameter stepParameters = null;
	static String actualResult = null;

	// Step1 - getParameters
	@SuppressWarnings("deprecation")
	public InterfaceStepParameter getParameters(String parameterID)
			throws Exception {
		stepParameters = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		return stepParameters;
	}

	// Step2 - userLogin
	public void userLogin(String parameterID) throws Exception {
		SetupSteps setUpSteps = new SetupSteps();
		setUpSteps.login(parameterID);
	}
	
	// Step3 - giftPayCheck
	public String giftPayCheck(String parameterID) throws Exception {
		WebConversation conversion = HttpUnitHelper.createConversation();
		WebRequest currentRequest = new PostMethodWebRequest(
				stepParameters.getValue("giftPayCheckUrl"));
		currentRequest.setParameter("c", stepParameters.getValue("c"));
		currentRequest.setParameter("id", stepParameters.getValue("id"));
		currentRequest.setParameter("count", stepParameters.getValue("count"));
		WebResponse response = conversion.getResponse(currentRequest);
		SimpleLogger.logInfo(GiftPayCheck.class, "gift check result:" + response.getText());
		actualResult = response.getText();
		return actualResult;
	}
	
	// Step4 - assertResult
	public void assertResult(String parameterID) throws Exception {
		SimpleLogger.logInfo(this.getClass(), "actualResult : " + actualResult);
		AssertMultiResult.assertWithParameter(stepParameters, actualResult, stepParameters.getValue("expectedResult"));
	}
}
 