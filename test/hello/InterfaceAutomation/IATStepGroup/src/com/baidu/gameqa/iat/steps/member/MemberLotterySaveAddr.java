package com.baidu.gameqa.iat.steps.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.openqa.selenium.browserlaunchers.Sleeper;
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

public class MemberLotterySaveAddr { 
	
	@StepMethodDesc(description = "Pay for a real lottery gift (not virtual)", owner = "Guo, Lin")
	public void lotteryGift(String parameterID) throws Exception{
		//run the pay interface
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	         
	    }	   
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
		int responsecode =currentResponse.getResponseCode();
		JSONObject actualresult = JSONObject.fromObject(currentResponse.getText());
		SimpleLogger.logInfo(this.getClass(), "actualresult :"+actualresult);
	    Assert.assertEquals(responsecode, 200);
	    Assert.assertEquals(actualresult.getString("result"), "200");
	    String recordid = actualresult.getString("recordId");
		StepValueHelper.putStepOutputValue("recordId", recordid);
		SimpleLogger.logInfo(this.getClass(), "recordId is " + recordid);
		
	}
	
	@StepMethodDesc(description = "Save address for this  real lottery gift (not virtual)", owner = "Guo, Lin")
	public void saveAddress_ok_200(String parameterID) throws Exception{
		//run the save address interface
		InterfaceStepParameter parameter1 = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		
		WebConversation currentConversation1=HttpUnitHelper.createConversation();
		WebRequest currentRequest1 = HttpUnitHelper.createWebRequest(parameter1.getValue("url"), parameter1.getValue("httpmethod"));
		HashMap<String, String> urlParameters1=parameter1.getURLParametersMap();
	    //put recordid in url.		
		String recordId1 = StepValueHelper.getStepOutputValue("recordId").toString();
		SimpleLogger.logInfo(this.getClass(), "recordId always " + recordId1);
	    urlParameters1.put("id",recordId1); 
	    if(urlParameters1.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest1,urlParameters1);
	         
	    }	   
	    SimpleLogger.logInfo(this.getClass(), "currentRequest :"+currentRequest1.getURL());
		WebResponse currentResponse1=currentConversation1.getResponse(currentRequest1);
		int responsecode1 =currentResponse1.getResponseCode();
		JSONObject actualresult1 = JSONObject.fromObject(currentResponse1.getText());
		SimpleLogger.logInfo(this.getClass(), "actualresult :"+actualresult1);
	    Assert.assertEquals(responsecode1, 200);
	    Assert.assertEquals(actualresult1.getString("result"), "200");
	    //Assert.assertEquals(actualresult1.getString("msg"), "成功");
		
	}	

	public void saveAddress_ok_noinput(String parameterID) throws Exception{
		//run the save address interface
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    //put recordid in url.
		String recordId = StepValueHelper.getStepOutputValue("recordId").toString();
		SimpleLogger.logInfo(this.getClass(), "recordId always " + recordId);
	    urlParameters.put("id",recordId); 
	    if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	         
	    }	   
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
		int responsecode =currentResponse.getResponseCode();
		JSONObject actualresult = JSONObject.fromObject(currentResponse.getText());
		SimpleLogger.logInfo(this.getClass(), "actualresult :"+actualresult);
	    Assert.assertEquals(responsecode, 200);
	    Assert.assertEquals(actualresult.getString("result"), "200");
	    //Assert.assertEquals(actualresult.getString("msg"), "成功");
		
	}		
	
}
