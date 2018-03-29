package com.baidu.gameqa.iat.steps.common;

import java.util.HashMap;

import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValueHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public  class  SendRequestSteps {

	public SendRequestSteps()
	{
		// TODO Auto-generated constructor stub
	}
	
	@StepMethodDesc(description = "send request ", owner = "xiuping.qi")
	public void sendRequest(String parameterID) throws Exception{
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
	    if(urlParameters.size()!=0)	
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);	         
	    }	   
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
		StepValueHelper.putStepOutputValue("currentResponse", currentResponse);
	
	}	

}
