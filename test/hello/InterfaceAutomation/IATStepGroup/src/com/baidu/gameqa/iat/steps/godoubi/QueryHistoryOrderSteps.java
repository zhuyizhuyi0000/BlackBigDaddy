package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class QueryHistoryOrderSteps {

	@AssertStepMethodDesc(description = "query order", owner = "tingwei.zhu")
	public void queryOrder(String parameterID, String expectresult,
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

	}
	
	@AssertStepMethodDesc(description = "queryOrder_nostartTime order", owner = "wangjing01")
	public void queryOrder_nostartTime(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.getValue("nostartTime"));

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);

	}

	@AssertStepMethodDesc(description = "queryOrder_noendTime order", owner = "wangjing01")
	public void queryOrder_noendTime(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.getValue("noendTime"));

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);

	}
	
	@AssertStepMethodDesc(description = "queryOrder_noTime order", owner = "wangjing01")
	public void queryOrder_noTime(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.getValue("noTime"));

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);

	}
	public void assert_orderlist(String actualresult,
			List<List<String>> sqlresult) {
		ResultCompare rc = new ResultCompare();

		for (int i = 0; i < sqlresult.size() - 1; i++) {

			SimpleLogger.logInfo(
					this.getClass(),
					"======[YaJuan-log]: expectresult:"
							+ rc.getListValue(i + 1, sqlresult, "amount")
							+ "======");
			Assert.assertEquals(rc.getJsonStringValue(i, "orderList",
					actualresult, "amount"), rc.getListValue(i + 1, sqlresult,
					"amount"));

			// Assert.assertEquals(rc.getListValue(i + 1, sqlresult,
			// "createTime"),
			// rc.getJsonStringValue(i, "orderList", actualresult,
			// "create_time"));

			Assert.assertEquals(rc.getJsonStringValue(i, "orderList",
					actualresult, "orderid"), rc.getListValue(i + 1, sqlresult,
					"orderId"));

			Assert.assertEquals(rc.getJsonStringValue(i, "orderList",
					actualresult, "order_status"), rc.getListValue(i + 1,
					sqlresult, "orderStatus"));

			Assert.assertEquals(rc.getJsonStringValue(i, "orderList",
					actualresult, "pay_name"), rc.getListValue(i + 1,
					sqlresult, "payName"));

		}
	}

}
