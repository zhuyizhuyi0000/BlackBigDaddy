package com.baidu.gameqa.iat.steps.sso;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValueHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.ClearCache;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.common.MD5;
import com.baidu.gameqa.iat.constant.MemcacheYun1FlushUrl;
import com.baidu.gameqa.iat.steps.common.ActualResultJSON;
import com.baidu.gameqa.iat.steps.common.BASE64Utils;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.baidu.gameqa.iat.steps.common.SqlResult;
import com.google.gson.Gson;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class GetLoginLockStatusSteps {
	
	@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void doGetLoginLockStatus(String parameterID) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
				
		if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);	         
	    }
		
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);		
		String actualResult = currentResponse.getText();
		SimpleLogger.logInfo(this.getClass(), "actualResult is : "+actualResult);
		
		String expectedResult = parameter.getValue("expectedResult");
		SimpleLogger.logInfo(this.getClass(), "expectedResult is : "+expectedResult);
		
		Assert.assertEquals(actualResult, expectedResult);		
		
	}
	

}
