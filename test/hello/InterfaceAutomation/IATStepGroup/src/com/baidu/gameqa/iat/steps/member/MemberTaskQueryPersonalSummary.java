package com.baidu.gameqa.iat.steps.member;

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
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class MemberTaskQueryPersonalSummary {
	@AssertStepMethodDesc(description = "Member__Task_PersonalQueryScoreSummary", owner = "Lin Guo")
	public void MemberTaskQueryPersonalSummary(String parameterID, String expectresult,
			String actualresult) throws Exception {
		
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password")); 
		requestParameter.put("commandText", parameter.CommandText);
		
		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		ResultCompare rc = new ResultCompare();
		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);

		
		//assert elements
		for (int i = 1; i < sqlresult.get(0).size() - 1; i++) {
			
			String actualresult_element = rc.getJsonStringValue(0, "elements", actualresult, sqlresult.get(0).get(i));
			String expectresult_element = rc.getListValue(1, sqlresult, sqlresult.get(0).get(i));
			//时间戳 补位000
			if (sqlresult.get(0).get(i).equals("createTime") || sqlresult.get(0).get(i).equals("backTime")
					|| sqlresult.get(0).get(i).equals("updateTime")){
				expectresult_element = expectresult_element + "000";
			}
			SimpleLogger.logInfo(this.getClass(), "======[koko-log]:elements " + sqlresult.get(0).get(i) + " expectresult " + expectresult_element +"======");
			SimpleLogger.logInfo(this.getClass(), "======[koko-log]:elements " + sqlresult.get(0).get(i) + " actualresult " + actualresult_element +"======");

			Assert.assertEquals(actualresult_element,expectresult_element);

		}
			
		
		
		//assert lastPageNumber
		String actualresult_lastPageNumber = actualresultJSON.getString("lastPageNumber");

		//算页数
		Double lastPageNumberDouble =Math.ceil(	(Double.valueOf(rc.getListValue(1,sqlresult, "totalElements")))/10);
		//转integer
		Integer lastPageNumberInteger = Integer.valueOf(lastPageNumberDouble.intValue());
		//转string
		String expectresult_lastPageNumber =String.valueOf(lastPageNumberInteger);
		
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:lastPageNumber expectresult " + expectresult_lastPageNumber +"======");
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:lastPageNumber actualresult " + actualresult_lastPageNumber +"======");

		Assert.assertEquals(actualresult_lastPageNumber,expectresult_lastPageNumber);
				
		
		//assert pageSize
		String actualresult_pageSize = actualresultJSON.getString("pageSize");
		String expectresult_pageSize = parameter.getValue("pageSize");
		
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:pageSize expectresult " + expectresult_pageSize +"======");
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:pageSize actualresult " + actualresult_pageSize +"======");
		Assert.assertEquals(actualresult_pageSize,expectresult_pageSize);
		
		
		//assert totalElements
		String actualresult_totalElements = actualresultJSON.getString("totalElements");
		String expectresult_totalElements = rc.getListValue(1,sqlresult, "totalElements");
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:totalElements expectresult " + expectresult_totalElements +"======");
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]:totalElements actualresult " + actualresult_totalElements +"======");
		Assert.assertEquals(actualresult_totalElements,expectresult_totalElements);

	}
}
