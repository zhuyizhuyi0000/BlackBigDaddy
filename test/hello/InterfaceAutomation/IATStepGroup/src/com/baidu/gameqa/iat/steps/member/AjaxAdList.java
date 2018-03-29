package com.baidu.gameqa.iat.steps.member;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.testng.Assert;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class AjaxAdList {
	
	/**
	 * SELECT t2.adId, t2.tagtype, t2.adname AS adName, t2.adcontent AS adContent, adTitle, adDesc, t2.pageUrl, t2.imageUrl, t2.titletype AS titleType  FROM (  SELECT t1.adId, t1.tagtype, t1.adname AS adName, t1.adcontent AS adContent, t1.name AS adTitle, t1.descrit AS adDesc, t1.pageUrl, t1.imageUrl, t1.titletype AS titleType FROM admin_ad_info t1 WHERE t1.tagtype = 1 and uptime <= 1399175717773  ORDER BY t1.adId ASC, t1.updateTime DESC )t2  GROUP BY t2.adId, t2.tagtype
	 * @param parameterID
	 * @throws Exception
	 */
	
	@StepMethodDesc(description = "", owner = "wangjing01")
	public List adTypeSqlConn(String parameterID,String tagType,Long time) throws Exception {
		
		
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		SimpleLogger.logInfo(this.getClass(),"connectionString:"+parameter.ConnectiongString);
		
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		String commandText = parameter.CommandText;
		SimpleLogger.logInfo(this.getClass(),"commandText old:"+commandText);
		
		commandText=commandText.replace("tagtypePar", tagType);
		commandText=commandText.replace("uptimePar", time.toString());
		
		SimpleLogger.logInfo(this.getClass(),"commandText new:"+commandText);
		requestParameter.put("commandText", commandText);

		List<List<String>> adResultList = proxy.executeQuery(requestParameter);
		return adResultList;
		
				
		

	}
	
	@StepMethodDesc(description = "", owner = "wangjing01")
	public void assertSqlresultToJson(List sqlResultList,String actualresult) throws Exception {

		// expect
		ResultCompare rc = new ResultCompare();

		// actual
		JSONArray actualJA = JSONArray.fromObject(actualresult);
		JSONObject actualJO;

		for (int i = 0; i < actualJA.size(); i++) {

			actualJO = JSONObject.fromObject(actualJA.get(i));
			Assert.assertEquals(actualJO.getString("adId"),
					rc.getListValue(i + 1, sqlResultList, "adId"));
			Assert.assertEquals(actualJO.getString("adName"),
					rc.getListValue(i + 1, sqlResultList, "adName"));
			Assert.assertEquals(actualJO.getString("adTitle"),
					rc.getListValue(i + 1, sqlResultList, "adTitle"));

			SimpleLogger.logInfo(
					this.getClass(),
					"======expect:======"
							+ rc.getListValue(i + 1, sqlResultList, "adId"));
			SimpleLogger.logInfo(this.getClass(), "======actual:======"
					+ actualJO.getString("adId"));

		}
	}
	
		
	
	/**
	 * SELECT t2.adId, t2.tagtype, t2.adname AS adName, t2.adcontent AS adContent, adTitle, adDesc, t2.pageUrl, t2.imageUrl, t2.titletype AS titleType  FROM (  SELECT t1.adId, t1.tagtype, t1.adname AS adName, t1.adcontent AS adContent, t1.name AS adTitle, t1.descrit AS adDesc, t1.pageUrl, t1.imageUrl, t1.titletype AS titleType FROM admin_ad_info t1 WHERE t1.tagtype = 1 and uptime <= 1399175717773  ORDER BY t1.adId ASC, t1.updateTime DESC )t2  GROUP BY t2.adId, t2.tagtype
	 * @param parameterID
	 * @throws Exception
	 */
	@StepMethodDesc(description = "", owner = "wangjing01")
	public void adType1(String parameterID, String expectresult,
			String actualresult) throws Exception {
		String tagtype="1";
		Long time = System.currentTimeMillis();
	
		
		List<List<String>> adResultList= this.adTypeSqlConn(parameterID, tagtype, time);
		
		this.assertSqlresultToJson(adResultList, actualresult);
		

	}

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void adType2(String parameterID, String expectresult,
			String actualresult) throws Exception {
		String tagtype="2";
		Long time = System.currentTimeMillis();
	
		
		List<List<String>> adResultList= this.adTypeSqlConn(parameterID, tagtype, time);
		
		this.assertSqlresultToJson(adResultList, actualresult);
	}

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void adType3(String parameterID, String expectresult,
			String actualresult) throws Exception {
		String tagtype="3";
		Long time = System.currentTimeMillis();
	
		
		List<List<String>> adResultList= this.adTypeSqlConn(parameterID, tagtype, time);
		
		this.assertSqlresultToJson(adResultList, actualresult);
	}

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void adType4(String parameterID, String expectresult,
			String actualresult) throws Exception {
		String tagtype="4";
		Long time = System.currentTimeMillis();
	
		
		List<List<String>> adResultList= this.adTypeSqlConn(parameterID, tagtype, time);
		
		this.assertSqlresultToJson(adResultList, actualresult);
	}

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void adType5(String parameterID, String expectresult,
			String actualresult) throws Exception {
		String tagtype="5";
		Long time = System.currentTimeMillis();
	
		
		List<List<String>> adResultList= this.adTypeSqlConn(parameterID, tagtype, time);
		
		this.assertSqlresultToJson(adResultList, actualresult);
	}

	@StepMethodDesc(description = "", owner = "wangjing01")
	public void adType6(String parameterID, String expectresult,
			String actualresult) throws Exception {
		String tagtype="6";
		Long time = System.currentTimeMillis();
	
		
		List<List<String>> adResultList= this.adTypeSqlConn(parameterID, tagtype, time);
		
		this.assertSqlresultToJson(adResultList, actualresult);
	}
	
	public static void main(String[] args) { 
		String jsonString="[{\"adId\":1,\"tagtype\":1},{\"adId\":2,\"tagtype\":1}]";
		
		JSONArray  actualrs = JSONArray.fromObject(jsonString);	
		
		System.out.println("111111111111"+actualrs.getString(0));
		System.out.println("222222222222"+actualrs.getString(1));
		
		
		
		JSONObject actObject=JSONObject.fromObject(actualrs.getString(0));
		System.out.println("111111111111 adId"+actObject.getString("adId"));
		System.out.println("111111111111 tagtype"+actObject.getString("tagtype"));
		JSONObject actObject2=JSONObject.fromObject(actualrs.getString(1));
		System.out.println("2222222222 adId"+actObject2.getString("adId"));
		System.out.println("2222222222 tagtype"+actObject2.getString("tagtype"));
		
//		System.out.println("11111 adid 0 111"+actualrs.getJSONArray(0).getString("adId"));
//		System.out.println("11111 adid 1 111"+actualrs.getJSONArray(1).getString("adId"));
	}
}
