package com.baidu.gameqa.iat.steps.common;

import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public  class  SetupSteps {

	public SetupSteps()
	{
		// TODO Auto-generated constructor stub
	}
	
	@SetupStepMethodDesc(description="set cookie before invoke interface",owner="tiande.zhang")
	public void setCookie(String parameterID) throws Exception
	{
		InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getParameter(parameterID);
	    WebConversation	 conversion=HttpUnitHelper.createConversation();
	    conversion.putCookie(parameter.parameters.get(0).key,parameter.parameters.get(0).value);
	}
	
	@SetupStepMethodDesc(description="set Multiple cookie before invoke interface",owner="xiuping.qi")
	public void setCookies(String parameterID) throws Exception
	{
		InterfaceStepParameter parameter=(InterfaceStepParameter)ParameterHelper.getParameter(parameterID);
	    WebConversation	 conversion=HttpUnitHelper.createConversation();
	    for(int i=0; i < parameter.parameters.size(); i++){
	    	conversion.putCookie(parameter.parameters.get(i).key,parameter.parameters.get(i).value);
	    }
	    
	}
	
	@SetupStepMethodDesc(description="login before invoke interface",owner="tiande.zhang")
	public void login(String parameterID) throws Exception
	{
		InterfaceStepParameter parameter=(InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
	    WebConversation	 conversion=HttpUnitHelper.createConversation();
		WebRequest currentRequest=new PostMethodWebRequest(parameter.getValue("url"));
		currentRequest.setParameter("loginName",parameter.getValue("loginName"));
		currentRequest.setParameter("password",parameter.getValue("password"));
		WebResponse response=conversion.getResponse(currentRequest);
		SimpleLogger.logInfo(this.getClass(),"login result:"+response.getText());
	}

}
