package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.Constant;
import com.baidu.gameqa.iat.common.MutilPlatUtil;
import com.baidu.gameqa.iat.steps.common.CacheFlush;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.baidu.gameqa.iat.steps.common.SetupSteps;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class PreByamountSteps {

	@AssertStepMethodDesc(description = "query_getpre_byamount", owner = "yajuan.li")
	public void queryGetpreByamount(String parameterID, String expectresult,
			String actualresult) throws Exception {

		this.Elementbalance("balance", parameterID, actualresult);

		this.ElementexpireBalance("expireBalance", parameterID, actualresult);

	}

	/*
	 * */
	public List<List<String>> getDBData(String parameterID,
			String connectionString, String user, String password,
			String commandText) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		requestParameter.put("connectionString",
				parameter.getValue(connectionString));
		requestParameter.put("user", parameter.getValue(user));
		requestParameter.put("password", parameter.getValue(password));
		requestParameter.put("commandText", parameter.getValue(commandText));

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);

		return sqlresult;
	}

	public String getActualresultElement(String Element, String actualresult) {

		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);
		String actualresultElement = actualresultJSON.getString(Element);
		return actualresultElement;

	}

	public void Elementbalance(String element, String parameterID,
			String actualresult) throws Exception {
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:assert "
				+ element + "======");
		List<List<String>> sqlresult_element = this.getDBData(parameterID,
				"ConnectionString_newyouxi", "user", "password",
				"CommandText_balance");

		ResultCompare rc = new ResultCompare();
		String expectresult_element = rc.getListValue(1, sqlresult_element,
				"sum(balance)");
		if (expectresult_element == null) {
			expectresult_element = "0";
		}
		String actualresult_element = this.getActualresultElement(element,
				actualresult);
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:" + element
				+ " expectresult:" + expectresult_element + "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:" + element
				+ " actualresult:" + actualresult_element + "======");
		Assert.assertEquals(actualresult_element, expectresult_element);

	}

	public void ElementexpireBalance(String element, String parameterID,
			String actualresult) throws Exception {
		List<List<String>> sqlresult_element = this.getDBData(parameterID,
				"ConnectionString_newyouxi", "user", "password",
				"CommandText_expireBalance");

		ResultCompare rc = new ResultCompare();
		String expectresult_element = rc.getListValue(1, sqlresult_element,
				"sum(balance)");
		if (expectresult_element == null) {
			expectresult_element = "0";
		}
		String actualresult_element = this.getActualresultElement(element,
				actualresult);
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:" + element
				+ " expectresult:" + expectresult_element + "======");
		SimpleLogger.logInfo(this.getClass(), "======[YaJuan-log]:" + element
				+ " actualresult:" + actualresult_element + "======");
		Assert.assertEquals(actualresult_element, expectresult_element);

	}

	@SetupStepMethodDesc(description = "queryGetpreSetupCookieDB_delete", owner = "wangjing01")
	public void queryGetpreSetupCookieDB_delete(String parameterID)
			throws Exception {
		SetupSteps ss = new SetupSteps();

		ss.setCookie(parameterID);

		
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("deleteyouxi_preferential_card"));
		
		SimpleLogger.logInfo(this.getClass(), "connectionString::"+parameter.ConnectiongString);
		SimpleLogger.logInfo(this.getClass(), "deleteyouxi_preferential_card::"+parameter.getValue("deleteyouxi_preferential_card"));
		
		proxy.executeNoneQuery(requestParameter);
		
		SimpleLogger.logInfo(this.getClass(), "deleteyouxi_preferential_card ok");
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}

	@SetupStepMethodDesc(description = "queryGetpreSetupCookieDB_insert", owner = "wangjing01")
	public void queryGetpreSetupCookieDB_insert(String parameterID)
			throws Exception {
		SetupSteps ss = new SetupSteps();

		ss.setCookie(parameterID);

		this.queryGetpreSetupCookieDB_delete(parameterID);
		
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("insertyouxi_preferential_card"));
		proxy.executeNoneQuery(requestParameter);
		
SimpleLogger.logInfo(this.getClass(), "insertyouxi_preferential_card ok");
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}

	
	
	@SetupStepMethodDesc(description = "queryGetpreSetupCookieDB_select", owner = "wangjing01")
	public void queryGetpreSetupCookieDB_update(String parameterID)
			throws Exception {
		SetupSteps ss = new SetupSteps();

		ss.setCookie(parameterID);
		
		this.queryGetpreSetupCookieDB_delete(parameterID);
		this.queryGetpreSetupCookieDB_insert(parameterID);
		
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("updateyouxi_preferential_card"));
		proxy.executeNoneQuery(requestParameter);
		
		SimpleLogger.logInfo(this.getClass(), "updateyouxi_preferential_card ok");
		
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}
}
