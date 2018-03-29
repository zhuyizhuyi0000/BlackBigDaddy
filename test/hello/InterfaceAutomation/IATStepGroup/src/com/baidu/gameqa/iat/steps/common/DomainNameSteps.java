package com.baidu.gameqa.iat.steps.common;

import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Lib.common.ConfigReader;
import com.baidu.gameqa.Lib.common.SimpleLogger;


public  class  DomainNameSteps {

	public DomainNameSteps()
	{
		// TODO Auto-generated constructor stub
	}
	
	@SetupStepMethodDesc(description="update DomainName",owner="xiuping")
	public InterfaceStepParameter updateDomainName(InterfaceStepParameter parameter, String parameterStr, String configStr) throws Exception
	{
		if(parameter.getValue("url").startsWith(parameterStr)){
	
			parameter.updateParameters("url", parameter.getValue("url").replace(parameterStr, ConfigReader.GetValue("gatConfig.properties",configStr)));
			SimpleLogger.logInfo(this.getClass(), "url is: " + parameter.getValue("url"));
		}		
		
		return parameter;
	}

}
