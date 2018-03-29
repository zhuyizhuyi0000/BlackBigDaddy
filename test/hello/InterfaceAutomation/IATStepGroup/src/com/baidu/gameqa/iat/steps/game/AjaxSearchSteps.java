package com.baidu.gameqa.iat.steps.game;

import java.util.HashMap;
import java.util.List;
import net.sf.json.JSONObject;
import org.testng.Assert;
import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.*;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class AjaxSearchSteps {
	@AssertStepMethodDesc(description = "search for game", owner = "tingwei.zhu")
	public void ajaxSearch(String parameterID, String expectresult,
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
		
		expectresult = rc.getListValue(1,sqlresult, "id");
		
		String actualrs = rc.getJsonStringValue(0,"result",actualresult, "id");
		
		Assert.assertEquals(actualrs, expectresult);

	}
}
