package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import junit.framework.Assert;
import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;



public class queryMypreAmountSteps {
	@AssertStepMethodDesc(description = "query_mypre_amount", owner = "yajuan.li")
	public void queryMypreAmount(String parameterID,String expectresult,
			String actualresult) throws Exception{
		
		this.totalAmountAssert("total_amount", parameterID, actualresult);
		this.useAmountAssert("use_amount", parameterID, actualresult);
		this.wdAmountAssert("wd_amount", parameterID, actualresult);
		this.outtimeAmountAssert("outtime_amount", parameterID, actualresult);
		
	}
	
	
	/*
	 * */
	
	public List<List<String>> getDBData(String parameterID, String connectionString, 
			String user, String password, String commandText ) throws Exception{
		
		MysqlProxy proxy = new MysqlProxy(); 
		HashMap<String,String> requestParameter = new HashMap<String,String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		
		requestParameter.put("connectionString", parameter.getValue(connectionString));
		requestParameter.put("user", parameter.getValue(user));
		requestParameter.put("password", parameter.getValue(password));
		requestParameter.put("commandText", parameter.getValue(commandText));
		
		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		return sqlresult;
		
	}
	
	
	
	public String getActualresultElement(String Element,String actualresult){
		JSONObject actualresultjson = JSONObject.fromObject(actualresult);
		String actualresultElement = actualresultjson.getString(Element);
		return actualresultElement;
	}
	
	
	public void totalAmountAssert(String element,String parameterID,String actualresult) throws Exception{
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		List<List<String>> sqlresult_element = this.getDBData("parameterID", "ConnectionString_newyouxi", "user", "password", "CommandText_ total_amount"); 
		
		ResultCompare rc = new ResultCompare();
		String expectresult_element = rc.getListValue(1, sqlresult_element,"sum(amount)" );
		String actualresult_element = this.getActualresultElement(element, actualresult);
		Assert.assertEquals(actualresult_element, expectresult_element);			
	}
	
	
	public void useAmountAssert(String element,String parameterID,String actualresult) throws Exception{
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		List<List<String>> sqlresult_element = this.getDBData("parameterID", "ConnectionString_newyouxi", "user", "password", "CommandText_use_amount"); 
		
		ResultCompare rc = new ResultCompare();
		String expectresult_element = rc.getListValue(1, sqlresult_element,"sum(amount)-sum(balance)" );
		String actualresult_element = this.getActualresultElement(element, actualresult);
		Assert.assertEquals(actualresult_element, expectresult_element);			
	}
	
	public void wdAmountAssert(String element,String parameterID,String actualresult) throws Exception{
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		List<List<String>> sqlresult_element = this.getDBData("parameterID", "ConnectionString_newyouxi", "user", "password", "CommandText_ wd_amount"); 
		
		ResultCompare rc = new ResultCompare();
		String expectresult_element = rc.getListValue(1, sqlresult_element,"sum(balance)" );
		String actualresult_element = this.getActualresultElement(element, actualresult);
		Assert.assertEquals(actualresult_element, expectresult_element);			
	}
	
	public void outtimeAmountAssert(String element,String parameterID,String actualresult) throws Exception{
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		List<List<String>> sqlresult_element = this.getDBData("parameterID", "ConnectionString_newyouxi", "user", "password", "outtime_amount"); 
		
		ResultCompare rc = new ResultCompare();
		String expectresult_element = rc.getListValue(1, sqlresult_element,"sum(balance)" );
		String actualresult_element = this.getActualresultElement(element, actualresult);
		Assert.assertEquals(actualresult_element, expectresult_element);			
	}
}
