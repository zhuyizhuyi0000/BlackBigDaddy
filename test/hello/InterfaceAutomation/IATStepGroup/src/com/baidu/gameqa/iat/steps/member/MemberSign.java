package com.baidu.gameqa.iat.steps.member;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValuePool;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class MemberSign {

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void memberSign(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}
		
		SimpleLogger.logInfo(this.getClass(),"=====usercooke:"+currentConversation.getCookieValue("wanba_cookies"));

		//-3 no cookie; -2 expire member; -1 not member;  1 sign success; -4 sign duplicate
		// sign success {"result":"1","addScore":2,"addGrowth":1}
		WebResponse responseStep1 = currentConversation
				.getResponse(currentRequest);
		SimpleLogger.logInfo(this.getClass(),"actualStep1:"+responseStep1.getText());
		
		JSONObject actualStep1 = JSONObject.fromObject(responseStep1.getText());

		Assert.assertEquals(actualStep1.getString("result"), "1");

		// sign duplicate{"result":"-4","addScore":0,"addGrowth":0}
		WebResponse responseStep2 = currentConversation
				.getResponse(currentRequest);
		SimpleLogger.logInfo(this.getClass(),"actualStep2:"+responseStep2.getText());
		JSONObject actualStep2 = JSONObject.fromObject(responseStep2.getText());

		Assert.assertEquals(actualStep2.getString("result"), "-4");

	}
	
	@StepMethodDesc(description = "", owner = "wangjing01")
	public void clearCache(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		//  Flush 10.48.57.61:11211:newyouxi:OK
		WebResponse responseStep1 = currentConversation
				.getResponse(currentRequest);
		
		

	}

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void jdbcConnect(String parameterID) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		SimpleLogger.logInfo(this.getClass(),"connectionString:"+parameter.ConnectiongString);
		
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.CommandText);

		proxy.executeNoneQuery(requestParameter);
		//
		// System.out.println(sqlresult.toString());

	}

}
