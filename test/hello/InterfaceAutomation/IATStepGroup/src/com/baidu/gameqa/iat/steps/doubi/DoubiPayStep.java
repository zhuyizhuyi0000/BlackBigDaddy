package com.baidu.gameqa.iat.steps.doubi;

import java.util.HashMap;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.GlobalConfig;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValuePool;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class DoubiPayStep 
{
	  
	 @StepMethodDesc(description="",owner="tiande.zhang")
	 public void Step1(String parameterID) throws Exception
	 {
		 InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getParameter(parameterID);
		 WebConversation currentConversation=HttpUnitHelper.createConversation();
	     WebRequest currentRequest=HttpUnitHelper.createWebRequest(parameter.getValue("url"),parameter.getValue("httpmethod"));
	     HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	     if(urlParameters.size()!=0)
	     {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);
	     }
	      WebResponse response=currentConversation.getResponse(currentRequest);
	      System.out.println(response.getText());
	      StepValuePool.createInstance().getValueDic().put("doubiToken",response.getText());
	 }
	 
	 @StepMethodDesc(description="",owner="tiande.zhang")
	 public void Step2(String parameterID) throws Exception
	 {
		System.out.println(parameterID+StepValuePool.createInstance().getValueDic().get("doubiToken").toString());
	 }
    
}
