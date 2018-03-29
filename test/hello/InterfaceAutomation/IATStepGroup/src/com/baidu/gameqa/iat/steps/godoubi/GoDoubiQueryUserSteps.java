package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.common.MutilPlatUtil;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class GoDoubiQueryUserSteps {
	// modify by wangjing01,
	@AssertStepMethodDesc(description = "GoDoubi_queryUser", owner = "xiuping.qi")
	public void goDoubiQueryUser(String parameterID, String expectresult,
			String actualresult) throws Exception {
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		SimpleLogger.logInfo(this.getClass(), "=====usercooke:"
				+ currentConversation.getCookieValue("wanba_cookies"));
		SimpleLogger
				.logInfo(this.getClass(), "=====parameterID:" + parameterID);

		SimpleLogger.logInfo(this.getClass(), "=====actualresult:"
				+ actualresult);

		if (MutilPlatUtil.getPlatFlag() == 4) {
			this.goDoubiQueryUser_tieba(parameterID, expectresult, actualresult);
		} else if (MutilPlatUtil.getPlatFlag() == 8
				|| MutilPlatUtil.getPlatFlag() == 10) {
			this.goDoubiQueryUser_wanhao123(parameterID, expectresult,
					actualresult);
		} else if (MutilPlatUtil.getPlatFlag() == 6) {
			this.goDoubiQueryUser_chaunqi(parameterID, expectresult,
					actualresult);
		}

	}

	@AssertStepMethodDesc(description = "GoDoubi_queryUser wanhao123,hao123qipqi", owner = "wangjing01")
	public void goDoubiQueryUser_wanhao123(String parameterID,
			String expectresult, String actualresult) throws Exception {
		SimpleLogger
				.logInfo(this.getClass(), "=====parameterID:" + parameterID);

		SimpleLogger.logInfo(this.getClass(), "=====actualresult:"
				+ actualresult);

		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "expireBalance"), "0");
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "balance"),
				"0");
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "vipStatus"),
				"0");
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "activityStatus"),
				"false");

	}

	@AssertStepMethodDesc(description = "GoDoubi_queryUser tieba", owner = "wangjing01")
	public void goDoubiQueryUser_tieba(String parameterID, String expectresult,
			String actualresult) throws Exception {
		SimpleLogger
				.logInfo(this.getClass(), "=====parameterID:" + parameterID);

		SimpleLogger.logInfo(this.getClass(), "=====actualresult:"
				+ actualresult);
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "chargeAmount"), "0");
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "balance"),
				"0");
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "expireBalance"), "0");
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "vipStatus"),
				"0");
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "activityStatus"),
				"false");
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "vipLevel"),
				"0");

	}

	@AssertStepMethodDesc(description = "GoDoubi_queryUser tieba", owner = "xiuping.qi")
	public void goDoubiQueryUser_chaunqi(String parameterID,
			String expectresult, String actualresult) throws Exception {
		// 校验balance
		this.goDoubiQueryUserAssertElement("balance", parameterID, actualresult);

		// 校验vipLevel
		this.goDoubiQueryUserAssertElement("vipLevel", parameterID,
				actualresult);

		// 校验vipStatus
		this.goDoubiQueryUserAssertElement("vipStatus", parameterID,
				actualresult);

		// 校验chargeAmount
		this.goDoubiQueryUserAssertElement("chargeAmount", parameterID,
				actualresult);
	}

	/**
	 * 
	 * @throws Exception
	 */
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

	/**
	 */
	public String getActualresultElement(String Element, String actualresult) {

		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);
		String actualresultElement = actualresultJSON.getString(Element);
		return actualresultElement;

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void goDoubiQueryUserAssertElement(String element,
			String parameterID, String actualresult) throws Exception {

		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:assert "
				+ element + "======");
		List<List<String>> sqlresult_element = this.getDBData(parameterID,
				"ConnectionString_newyouxi", "user", "password", "CommandText_"
						+ element);

		ResultCompare rc = new ResultCompare();
		String expectresult_element = null;
		if (element == "balance") {
			expectresult_element = rc.getListValue(1, sqlresult_element,
					"sum(balance)");
			if (expectresult_element == null) {
				expectresult_element = "0";
			}
		} else if (element == "vipLevel") {
			expectresult_element = rc.getListValue(1, sqlresult_element,
					"vipLevel");
			if (expectresult_element == null) {
				expectresult_element = "-1";
			}
		} else if (element == "vipStatus") {
			expectresult_element = rc.getListValue(1, sqlresult_element,
					"count(*)");
			if (!expectresult_element.equals("0")) {
				expectresult_element = "1";
			}
		} else if (element == "chargeAmount") {

			InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
					.getParameter(parameterID);
			int vipAmount = Integer.valueOf(parameter.getValue("VIP1_AMOUNT"));

			String expectresult_chargeAmount_tmp = rc.getListValue(1,
					sqlresult_element, "sum(amount)");

			if (expectresult_chargeAmount_tmp == null) {
				expectresult_element = String.valueOf(vipAmount / 100);
			} else if (Integer.parseInt(expectresult_chargeAmount_tmp) > vipAmount) {
				expectresult_element = "-1";
			} else {
				expectresult_element = String.valueOf((vipAmount - Integer
						.parseInt(expectresult_chargeAmount_tmp)) / 100);
			}
		}

		String actualresult_element = this.getActualresultElement(element,
				actualresult);
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:" + element
				+ " expectresult:" + expectresult_element + "======");
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:" + element
				+ " actualresult:" + actualresult_element + "======");
		Assert.assertEquals(actualresult_element, expectresult_element);

	}

}
