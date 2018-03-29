package com.baidu.gameqa.iat.steps.game;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class AjaxYouxiSteps {
	@AssertStepMethodDesc(description = "ajax youxi", owner = "tingwei.zhu")
	public void ajaxYouxi(String parameterID, String expectresult,
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

			Assert.assertEquals(rc.getJsonStringValue(i, "game", actualresult, "name"),rc.getListValue(i + 1, sqlresult, "name")
					);
		}

	}

}
