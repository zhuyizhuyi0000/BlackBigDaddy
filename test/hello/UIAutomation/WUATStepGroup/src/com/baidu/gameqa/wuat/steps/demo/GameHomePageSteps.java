package com.baidu.gameqa.wuat.steps.demo;

import javax.swing.border.Border;

import com.baidu.gameqa.Gat.dataobject.WUATStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.WebUIStepParameter;
import com.baidu.gameqa.Gat.uia.webautomation.WebBrowser;
import com.baidu.gameqa.Gat.uia.webautomation.WebPage;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;

public class GameHomePageSteps 
{
	
	@WUATStepMethodDesc
	public void login(WebBrowser browser,WebPage webPage,String parameterID) throws Exception
	{
		WebUIStepParameter parameter=(WebUIStepParameter)ParameterHelper.getWebUIStepParameter(parameterID);
		browser.navigateTo("http://www.baidu.com",180);
		
		webPage.getWebControll("Test01").action("inputText").exec(parameter.getValue("searchkeyword"));
		if(parameter.parameters.contains("click"))
		{
		  webPage.getWebControll("Test02").action("click").exec();
		}
	}
	

}
