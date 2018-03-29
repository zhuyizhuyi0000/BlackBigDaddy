package com.baidu.gameqa.iat.steps.member;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class AjaxMyGrowthDetail {
	/**
	 * SELECT * FROM `member_growth_log` WHERE username = '#lyj04' ORDER BY `id`
	 * DESC limit 10
	 * 
	 * @param parameterID
	 * @throws Exception
	 */

	@StepMethodDesc(description = "Copy from ajaxMyScoreDetail", owner = "guolin02")
	public List myGrowthSqlConn(String parameterID) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		SimpleLogger.logInfo(this.getClass(), "connectionString:"
				+ parameter.ConnectiongString);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		String commandText = parameter.CommandText;

		requestParameter.put("commandText", commandText);

		List adResultList = proxy.executeQuery(requestParameter);
		return adResultList;

	}

	@StepMethodDesc(description = "Copy from ajaxMyScoreDetail", owner = "guolin02")
	public void assertSqlresultToJson(List sqlResultList, String actualresult)
			throws Exception {

		// expect
		ResultCompare rc = new ResultCompare();

		// actual
		JSONObject actualJO = JSONObject.fromObject(actualresult);
		SimpleLogger.logInfo(this.getClass(), "======actual pageSize:======"
				+ actualJO.getString("pageSize"));
		SimpleLogger.logInfo(this.getClass(), "======actual pageSize:======"
				+ actualJO.getString("pageNum"));

		Assert.assertEquals(actualJO.getString("pageSize"), "10");
		Assert.assertEquals(actualJO.getString("pageNum"), "1");

		JSONArray actualJA = JSONArray.fromObject(actualJO
				.getString("elements"));

		for (int i = 0; i < actualJA.size(); i++) {

			actualJO = JSONObject.fromObject(actualJA.get(i));

			SimpleLogger
					.logInfo(
							this.getClass(),
							"======expect totalSqlResult taskName:======"
									+ rc.getListValue(i + 1, sqlResultList,
											"taskName"));
			SimpleLogger.logInfo(this.getClass(), "======actual type:======"
					+ actualJO.getString("type"));

			Assert.assertEquals(actualJO.getString("type"),
					rc.getListValue(i + 1, sqlResultList, "taskName"));
			Integer totalSqlResult = Integer.parseInt(rc.getListValue(i + 1,
					sqlResultList, "curGrowth"))
					+ Integer.parseInt(rc.getListValue(i + 1, sqlResultList,
							"addGrowth"));

			SimpleLogger.logInfo(this.getClass(),
					"======expect totalSqlResult:======" + totalSqlResult);
			SimpleLogger.logInfo(
					this.getClass(),
					"======actual totalResult:======"
							+ actualJO.getString("total"));
			Assert.assertEquals(actualJO.getString("total").toString(),
					totalSqlResult.toString());
		}
	}

	@StepMethodDesc(description = "Copy from ajaxMyScoreDetail", owner = "guolin02")
	public void ajaxMyGrowthDetai4(String parameterID, String expectresult,
			String actualresult) throws Exception {

		List myGrowthDetailResultList = this
				.myGrowthSqlConn(parameterID);
		SimpleLogger.logInfo(this.getClass(),
				"======myGrowthDetailResultList:======"
						+ myGrowthDetailResultList);
		SimpleLogger.logInfo(this.getClass(), "======actualresult:======"
				+ actualresult);
		this.assertSqlresultToJson(myGrowthDetailResultList, actualresult);

	}

	public static void main(String[] args) {
		String jsonString = "{\"elements\":[{\"adId\":1,\"tagtype\":1},{\"adId\":2,\"tagtype\":1}],\"pageSize\":10}";

		JSONObject a1 = JSONObject.fromObject(jsonString);
		System.out.println("111111111111" + a1.getString("elements"));

		JSONArray actualrs = JSONArray.fromObject(a1.getString("elements"));

		System.out.println("123123:" + actualrs.getString(0));

		JSONObject actObject = JSONObject.fromObject(actualrs.getString(0));
		System.out.println("11111 adid 0 111:" + actObject.getString("adId"));

		Integer aInteger = Integer.parseInt("12") + Integer.parseInt("5");
		System.out.println("1231231:::::" + aInteger);

	}
}