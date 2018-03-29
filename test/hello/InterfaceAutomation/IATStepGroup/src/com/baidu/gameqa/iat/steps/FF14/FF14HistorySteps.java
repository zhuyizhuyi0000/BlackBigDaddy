package com.baidu.gameqa.iat.steps.FF14;

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

public class FF14HistorySteps {
	
	@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void doFF14History(String parameterID) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
		
		String appId = urlParameters.get("appId");
		String areaId = urlParameters.get("areaId");
		String thirdId = urlParameters.get("thirdId");
		String signature = getSign(appId, areaId, thirdId);//计算sign
		
		urlParameters.put("signature", signature);
		
		if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);	         
	    }
		
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);		
		String actualResult = currentResponse.getText();
		SimpleLogger.logInfo(this.getClass(), "actualResult is : "+actualResult);
		
		StepValueHelper.putStepOutputValue("appId", appId);
		StepValueHelper.putStepOutputValue("areaId", areaId);
		StepValueHelper.putStepOutputValue("thirdId", thirdId);
		StepValueHelper.putStepOutputValue("actualResult", actualResult);
		
	}
	
	@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void assertResponse(String parameterID) {
		String actualResult = (String) StepValueHelper.getStepOutputValue("actualResult");
		Assert.assertEquals(JSONUtil.getJsonElement("returnCode", actualResult), "0");
		
	}
	
	@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void assertData(String parameterID) throws Exception {
		String appId = (String) StepValueHelper.getStepOutputValue("appId");
		String areaId = (String) StepValueHelper.getStepOutputValue("areaId");
		String thirdId = (String) StepValueHelper.getStepOutputValue("thirdId");
		
		SqlResult sr = new 	SqlResult();
		String count = sr.getSqlResultElement(parameterID, "count");
		SimpleLogger.logInfo(this.getClass(), "selectData sql return: count= "+count);
		Assert.assertEquals(count, "1");
		
	}
	
		@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void deleteData(String parameterID) throws Exception {		
		
		SqlResult sr = new 	SqlResult();
		String str = sr.doSql(parameterID);
		SimpleLogger.logInfo(this.getClass(), "deleteData sql return: "+str);
		
		ClearCache.clearCache(MemcacheYun1FlushUrl.NEWYOUXI);
	}
	
	private String getSign(String appId, String areaId, String thirdId) {
		
		String toSign = "appId="+appId+"areaId="+areaId+"thirdId="+thirdId+"8aa6dc8b4705cab401470fe00581257b";
		SimpleLogger.logInfo(this.getClass(), "toSign is : "+toSign);
		String signature = MD5.md5(toSign, 32);
		SimpleLogger.logInfo(this.getClass(), "signature is : "+signature);
		return signature;
		
	}

}
