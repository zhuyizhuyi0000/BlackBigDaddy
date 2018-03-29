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
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class queryGetpreByamountSteps {
	private String element;
	private String actualresult;
	@AssertStepMethodDesc(description = "query_getpre_byamount", owner = "yajuan.li")
	public void queryGetpreByamount(String parameterID, String expectresult,
			String actualresult) throws Exception {
		
		SimpleLogger.logInfo(this.getClass(), "======queryGetpreByamount start=====");
		
		//校验balance
		this.AssertElementbalance("balance", parameterID, actualresult);
		
		//校验expireBalance
		this.AssertElementexpireBalance("expireBalance", parameterID, actualresult);	

	  }
		
	public List<List<String>> getDBData(String parameterID, String connectionString, 
					String user, String password, String commandText ) throws Exception{
						
			MysqlProxy proxy = new MysqlProxy();
			HashMap<String, String> requestParameter = new HashMap<String, String>();
			InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
			requestParameter.put("connectionString",parameter.getValue(connectionString));
			requestParameter.put("user", parameter.getValue(user));
			requestParameter.put("password", parameter.getValue(password));
			requestParameter.put("commandText", parameter.getValue(commandText));
			
			List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
			
			return sqlresult;
		}	

		
	public String getActualresultElement(String Element, String actualresult){
		
		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);
		String actualresultElement = actualresultJSON.getString(Element);
		return actualresultElement;
		
	}
		
	
	public void AssertElementbalance(String element, String parameterID, String actualresult) throws Exception{
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
	    List<List<String>> sqlresult_element = this.getDBData(parameterID, "ConnectionString_newyouxi", "user", "password", "CommandText_balance"); 

		ResultCompare rc = new ResultCompare();	
		String expectresult_element = rc.getListValue(1,sqlresult_element, "sum(balance)");
		
		String actualresult_element = this.getActualresultElement(element, actualresult);
		
		Assert.assertEquals(actualresult_element, expectresult_element);
	        
    }
	
	public void AssertElementexpireBalance(String element, String parameterID, String actualresult) throws Exception{
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
	    List<List<String>> sqlresult_element = this.getDBData(parameterID, "ConnectionString_newyouxi", "user", "password", "CommandText_expireBalance"); 

		ResultCompare rc = new ResultCompare();	
		String expectresult_element = rc.getListValue(1,sqlresult_element, "sum(balance)");
		
		String actualresult_element = this.getActualresultElement(element, actualresult);
		
		Assert.assertEquals(actualresult_element, expectresult_element);
	        
    }
}	
	