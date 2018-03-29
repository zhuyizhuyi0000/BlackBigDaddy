package com.baidu.gameqa.iat.steps.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValueHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ActualResultJSON;
import com.baidu.gameqa.iat.steps.common.AssertOutputSingleParameter;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.baidu.gameqa.iat.steps.common.SqlResult;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.thoughtworks.xstream.mapper.Mapper.Null;

public class MemberOrderApplyQuickOrderSteps { 	
	
	@StepMethodDesc(description = "do ApplyQuickOrder.json", owner = "xiuping.qi")
	public void doApplyQuickOrder(String parameterID) throws Exception{
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);	         
	    }	   
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
		
		String actualresult = currentResponse.getText();
		StepValueHelper.putStepOutputValue("actualresult", actualresult);
	
	}
	
	@StepMethodDesc(description = "assert Order Exist", owner = "xiuping.qi")
	public void assertOrderExist(String parameterID) throws Exception {
		String actualresult = (String) StepValueHelper.getStepOutputValue("actualresult");
		ActualResultJSON arj = new ActualResultJSON();
		String actual_orderId = arj.getActualresultElement("order_no", actualresult);
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		String commandText = parameter.CommandText + actual_orderId + "'";
		
		SqlResult  sr = new SqlResult();
		List<List<String>> sqlresult = sr.getSqlResultFromModifiedCommandText(parameterID, commandText);
		
		Assert.assertNotEquals(sqlresult, null);	
		
	}
	
	
		
	
}
