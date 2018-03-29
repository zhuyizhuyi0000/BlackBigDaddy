package com.baidu.gameqa.iat.steps.common;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public  class  AssertOutputSingleParameter {

	public AssertOutputSingleParameter()
	{
		// TODO Auto-generated constructor stub
	}
	
	@StepMethodDesc(description = "assert interface output single parameter,expectresult from XML", owner = "xiuping.qi")
	public void assertOutputSingleParameter_XML(String parameterID,String element, String actualresult) throws Exception {
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		ActualResultJSON arj = new ActualResultJSON();
		
		//assert single parameter		
		String expectresult_element = parameter.getValue(element);
		String actualresult_element = arj.getActualresultElement(element, actualresult);
		SimpleLogger.logInfo(this.getClass(), element + " expectresult:" + expectresult_element + "======");		
		SimpleLogger.logInfo(this.getClass(), element + " actualresult:" + actualresult_element + "======");

		Assert.assertEquals(actualresult_element,expectresult_element);		
		
	}
	
	@StepMethodDesc(description = "assert interface output single parameter,expectresult from DATABASE", owner = "xiuping.qi")
	public void assertOutputSingleParameter_DATABASE(String parameterID,String element, String actualresult) throws Exception {
		
		ActualResultJSON arj = new ActualResultJSON();
		
		//assert single parameter	
		SqlResult sr = new SqlResult();
		String expectresult_element = sr.getSqlResultElement(parameterID, element);
		String actualresult_element = arj.getActualresultElement(element, actualresult);
		SimpleLogger.logInfo(this.getClass(), element + " expectresult:" + expectresult_element + "======");		
		SimpleLogger.logInfo(this.getClass(), element + " actualresult:" + actualresult_element + "======");

		Assert.assertEquals(actualresult_element,expectresult_element);		
		
	}

}
