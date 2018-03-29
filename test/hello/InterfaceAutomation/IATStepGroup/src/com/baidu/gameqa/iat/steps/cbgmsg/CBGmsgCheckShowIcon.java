package com.baidu.gameqa.iat.steps.cbgmsg;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CBGmsgCheckShowIcon {
	private String element;
	private String actualresult;

	@AssertStepMethodDesc(description = "checkShowIcon_bdussnotExist", owner = "wangjing01")
	public String checkShowIcon_again(String parameterID) throws Exception {
		SimpleLogger.logInfo(this.getClass(),
				"======checkShowIcon_bdussnotExist start=====");
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		String checkShowIconUrl=parameter.getValue("checkShowIconUrl");
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(checkShowIconUrl,"GET");
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
		actualresult=currentResponse.getText();
		
		return actualresult;

	}

	@AssertStepMethodDesc(description = "checkShowIcon_notTarge", owner = "wangjing01")
	public void checkShowIcon_notTarge(String parameterID, String expectresult,
			String actualresult) throws Exception {
		SimpleLogger.logInfo(this.getClass(), "actualresult code:::"+JSONUtil.getStrFromJson(actualresult, "code"));
		
		if (JSONUtil.getStrFromJson(actualresult, "code").equals("210")) {
			Sleeper.sleepTight(5);
			actualresult=checkShowIcon_again(parameterID);
			
		} 
		SimpleLogger.logInfo(this.getClass(), "actualresult code new:::"+JSONUtil.getStrFromJson(actualresult, "code"));
		// {"code":201,"uu_key":"10e3c97f6175e741a7d502ce5facd328"}
		
			Assert.assertEquals("201", JSONUtil.getStrFromJson(actualresult, "code"));
			Assert.assertTrue(JSONUtil.getStrFromJson(actualresult, "uu_key").length()>0);

	}

	@AssertStepMethodDesc(description = "checkShowIcon_targe", owner = "wangjing01")
	public void checkShowIcon_targe(String parameterID, String expectresult,
			String actualresult) throws Exception {
		SimpleLogger.logInfo(this.getClass(), "actualresult code:::"+JSONUtil.getStrFromJson(actualresult, "code"));
		
		if (JSONUtil.getStrFromJson(actualresult, "code").equals("210")) {
			Sleeper.sleepTight(5);
			actualresult=checkShowIcon_again(parameterID);
			
		} 
		SimpleLogger.logInfo(this.getClass(), "actualresult code new:::"+JSONUtil.getStrFromJson(actualresult, "code"));
		// {"code":201,"uu_key":"10e3c97f6175e741a7d502ce5facd328"}
		
			Assert.assertEquals("200", JSONUtil.getStrFromJson(actualresult, "code"));
			Assert.assertTrue(JSONUtil.getStrFromJson(actualresult, "uu_key").length()>0);
			Assert.assertTrue(JSONUtil.getStrFromJson(actualresult, "icon_url").length()>0);

	}

}
