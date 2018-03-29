package com.baidu.gameqa.iat.steps.game;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class ServerSelectSteps {
	@AssertStepMethodDesc(description = "server select", owner = "tingwei.zhu")
	public void serverSelect(String parameterID, String expectresult,
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
		
		for(int i=0;i<sqlresult.size()-1;i++){
			expectresult = rc.getListValue(i+1,sqlresult, "serverName");
			
			String actualrs = rc.getJsonStringValue(i,"serverList",actualresult, "serverName");
			
			Assert.assertEquals(actualrs, expectresult);
			
		}
		

		

		
	}

}
