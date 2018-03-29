package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class MypreAmountSteps {
	@AssertStepMethodDesc(description = "query_mypre_amount", owner = "yajuan.li")
	public void queryMypreAmount(String parameterID, String expectresult,
			String actualresult) throws Exception {
		ResultCompare rc = new ResultCompare();
		MysqlProxy proxy = new MysqlProxy();
		List<List<String>> sqlresult = null;
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password"));

		// assert amount 未使用的优惠券
		requestParameter.put("commandText",
				parameter.getValue("CommandText_amount"));
		sqlresult = proxy.executeQuery(requestParameter);

		int amountExpect = Integer.parseInt(rc.getListValue(1, sqlresult,
				"amount"));

		
		int amountActual = Integer.parseInt(JSONUtil.getStrFromJson(
				actualresult, "amount"));
		
		SimpleLogger.logInfo(this.getClass(), "amountExpect:::"+amountExpect);
		SimpleLogger.logInfo(this.getClass(), "amountActual:::"+amountActual);
		
		Assert.assertEquals(amountExpect, amountActual);

		// assert total_amount 累计优惠券
		requestParameter.put("commandText",
				parameter.getValue("CommandText_total_amount"));
		sqlresult = proxy.executeQuery(requestParameter);

		int total_amountExpect = Integer.parseInt(rc.getListValue(1, sqlresult,
				"amount"));
		int total_amountActual = Integer.parseInt(JSONUtil.getStrFromJson(
				actualresult, "total_amount"));


		SimpleLogger.logInfo(this.getClass(), "total_amountExpect:::"+total_amountExpect);
		SimpleLogger.logInfo(this.getClass(), "total_amountActual:::"+total_amountActual);
		
		Assert.assertEquals(total_amountExpect, total_amountActual);

		// assert outtime_amount 过期的优惠券
		requestParameter.put("commandText",
				parameter.getValue("CommandText_outtime_amount"));
		sqlresult = proxy.executeQuery(requestParameter);

		int outtime_amountExpect = Integer.parseInt(rc.getListValue(1,
				sqlresult, "amount"));
		int outtime_amountActual = Integer.parseInt(JSONUtil.getStrFromJson(
				actualresult, "outtime_amount"));
		
		SimpleLogger.logInfo(this.getClass(), "outtime_amountExpect:::"+outtime_amountExpect);
		SimpleLogger.logInfo(this.getClass(), "outtime_amountActual:::"+outtime_amountActual);

		Assert.assertEquals(outtime_amountExpect, outtime_amountActual);

		// assert use_amount = total_amount- outtime_amount -amount 已经使用的优惠券

		int use_amountExpect = total_amountExpect - outtime_amountExpect
				- amountExpect;
		int use_amountActual = total_amountActual - outtime_amountActual
				- amountActual;

		SimpleLogger.logInfo(this.getClass(), "use_amountExpect:::"+use_amountExpect);
		SimpleLogger.logInfo(this.getClass(), "use_amountActual:::"+use_amountActual);
		
		Assert.assertEquals(use_amountExpect, use_amountActual);

		// assert wd_amount 即将过期的优惠券（7天）
		requestParameter.put("commandText",
				parameter.getValue("CommandText_wd_amount"));
		sqlresult = proxy.executeQuery(requestParameter);
		
		int wd_amountExpect=0;
		
		if (sqlresult ==null || rc.getListValue(1, sqlresult,"amount") == null) {
			wd_amountExpect=0;
		} else {
			wd_amountExpect = Integer.parseInt(rc.getListValue(1, sqlresult,
					"amount"));
		}
		
		int wd_amountActual = Integer.parseInt(JSONUtil.getStrFromJson(
				actualresult, "wd_amount"));

		SimpleLogger.logInfo(this.getClass(), "wd_amountExpect:::"+wd_amountExpect);
		SimpleLogger.logInfo(this.getClass(), "wd_amountActual:::"+wd_amountActual);
		
		Assert.assertEquals(wd_amountExpect, wd_amountActual);

		// assert preJson
		requestParameter.put("commandText", parameter.CommandText);
		sqlresult = proxy.executeQuery(requestParameter);

		for (int i = 0; i < sqlresult.size() - 1; i++) {

			Assert.assertEquals(rc.getJsonStringValue(i, "preJson",
					actualresult, "pre_amount"), rc.getListValue(i + 1,
					sqlresult, "amount"));

			Assert.assertEquals(rc.getJsonStringValue(i, "preJson",
					actualresult, "order_id"), rc.getListValue(i + 1,
					sqlresult, "linkId"));

			Assert.assertEquals(
					rc.getJsonStringValue(i, "preJson", actualresult, "amount"),
					rc.getListValue(i + 1, sqlresult, "orderAmount"));

		}

	}
}