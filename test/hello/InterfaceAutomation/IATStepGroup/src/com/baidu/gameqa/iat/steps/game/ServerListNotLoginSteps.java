package com.baidu.gameqa.iat.steps.game;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class ServerListNotLoginSteps {
		
	
	@AssertStepMethodDesc(description = "serverlist", owner = "tingwei.zhu")
	public void serverListNotLogin(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.CommandText);

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		ResultCompare rc = new ResultCompare();

		for (int i = 0; i < sqlresult.size() - 1; i++) {

			Assert.assertEquals(rc.getJsonStringValue(i, "serverList", actualresult, "serverName"),rc.getListValue(i + 1, sqlresult, "serverName")
					);
		}

	}
	
	public void getGameWindow(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.CommandText);

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		ResultCompare rc = new ResultCompare();
		JSONObject.fromObject(actualresult);

		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("title"),JSONObject.fromObject(actualresult).getString("title"));		
		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("targetUrl"),JSONObject.fromObject(actualresult).getString("targetUrl"));		

	}
	
	public void getGameMidWindow(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.CommandText);

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		ResultCompare rc = new ResultCompare();
		JSONObject.fromObject(actualresult);

		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("psTitle"),JSONObject.fromObject(actualresult).getString("psTitle"));		
		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("psTargetUrl"),JSONObject.fromObject(actualresult).getString("psTargetUrl"));		
		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("btn1Url"),JSONObject.fromObject(actualresult).getString("btn1Url"));		
		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("btn2Url"),JSONObject.fromObject(actualresult).getString("btn2Url"));		
		Assert.assertEquals(JSONObject.fromObject(actualresult).getString("btn3Url"),JSONObject.fromObject(actualresult).getString("btn3Url"));		

	}
	


}
