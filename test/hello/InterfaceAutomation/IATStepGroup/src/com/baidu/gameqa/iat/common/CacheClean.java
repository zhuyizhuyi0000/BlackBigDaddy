package com.baidu.gameqa.iat.common;

import java.util.HashMap;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CacheClean {
	@StepMethodDesc(description = "", owner = "wangjing01")
	public static void clearCache(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		//  Flush 10.48.57.61:11211:newyouxi:OK
		WebResponse responseStep1 = currentConversation
				.getResponse(currentRequest);
		
		

	}
}
