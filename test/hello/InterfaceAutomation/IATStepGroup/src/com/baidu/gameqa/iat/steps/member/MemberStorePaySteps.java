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

public class MemberStorePaySteps { 
	
	
	@StepMethodDesc(description = "get pre scores", owner = "xiuping.qi")
	public void getPreScore(String parameterID) throws Exception{
		SqlResult sr = new SqlResult();
		int preScore = Integer.valueOf(sr.getSqlResultElement(parameterID, "score"));
	    StepValueHelper.putStepOutputValue("preScore", preScore);
	}
	
	@StepMethodDesc(description = "do store pay", owner = "xiuping.qi")
	public void doStorePay(String parameterID) throws Exception{
		//get xml parameter
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
		SimpleLogger.logInfo(this.getClass(), "actualresult :"+actualresult);
		StepValueHelper.putStepOutputValue("actualresult", actualresult);
		
	}
	

	@StepMethodDesc(description = "get now scores", owner = "xiuping.qi")
	public void getNowScore(String parameterID) throws Exception{
		SqlResult sr = new SqlResult();
		int nowScore = Integer.valueOf(sr.getSqlResultElement(parameterID, "score"));
		StepValueHelper.putStepOutputValue("nowScore", nowScore);

	}
	
	@StepMethodDesc(description = "compare scores", owner = "xiuping.qi")
	public void compareScore(String parameterID) throws Exception{
		int preScore = (Integer) StepValueHelper.getStepOutputValue("preScore");
		int nowScore = (Integer) StepValueHelper.getStepOutputValue("nowScore");
		int diffScore =  preScore - nowScore;
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		int productPrice = Integer.valueOf(parameter.getValue("productPrice"));

		SimpleLogger.logInfo(this.getClass(), "======[koko-log]: diffScore " + diffScore + "======");
		SimpleLogger.logInfo(this.getClass(), "======[koko-log]: productPrice " + productPrice + "======");
		Assert.assertEquals(diffScore,productPrice);

	}
	
	@StepMethodDesc(description = "assert interface output parameters", owner = "xiuping.qi")
	public void assertOutputParameters(String parameterID) throws Exception {
		
		String actualresult = (String) StepValueHelper.getStepOutputValue("actualresult");
		
		AssertOutputSingleParameter assertParameter  = new AssertOutputSingleParameter();
		//assert result
		assertParameter.assertOutputSingleParameter_XML(parameterID, "result", actualresult);
		//asset msg
		assertParameter.assertOutputSingleParameter_XML(parameterID, "msg", actualresult);	
		//assert cate
		assertParameter.assertOutputSingleParameter_DATABASE(parameterID, "cate", actualresult);
		//assert name
		assertParameter.assertOutputSingleParameter_DATABASE(parameterID, "name", actualresult);
		//assert type
		assertParameter.assertOutputSingleParameter_DATABASE(parameterID, "type", actualresult);
		//assert inGame
		assertParameter.assertOutputSingleParameter_DATABASE(parameterID, "inGame", actualresult);
		//assert redirectUrl
		assertParameter.assertOutputSingleParameter_XML(parameterID, "redirectUrl", actualresult);
		
		//StepValueHelper.RemoveStepOutputValue("actualresult");
		
		//如下为对应的激活码信息，暂不校验
		//assert validTime
		//assert gameId
		//assert code
		//assert gameName	
		
	}
	
	
	@StepMethodDesc(description = "clear member_product_record", owner = "xiuping.qi")
	public void clearRecord(String parameterID) throws Exception {
		String actualresult = (String) StepValueHelper.getStepOutputValue("actualresult");
		ActualResultJSON arj = new ActualResultJSON();
		String recordId = arj.getActualresultElement("recordId", actualresult);
		
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		System.out.println(parameter.CommandText);
		parameter.CommandText = parameter.CommandText + recordId;
		System.out.println(parameter.CommandText);
		
		
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password")); 
		requestParameter.put("commandText", parameter.CommandText);
		proxy.executeNoneQuery(requestParameter);
		
	}
	
	@StepMethodDesc(description = "", owner = "wangjing01")
	public void clearCache(String parameterID) throws Exception {

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
	
	@StepMethodDesc(description = "browse Newyouxi to add cookie", owner = "xiuping.qi")
	public void browseNewyouxi(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper.createConversation();
		//browser newyouxi
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url_1"), parameter.getValue("httpmethod_1"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse responseStep1 = currentConversation.getResponse(currentRequest);
		//browser member
		currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url_2"), parameter.getValue("httpmethod_2"));
		urlParameters = parameter.getURLParametersMap();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse responseStep2 = currentConversation.getResponse(currentRequest);
		
		

	}
	
	@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void clearStepValueHelper(String parameterID) throws Exception{
		StepValueHelper.RemoveStepOutputValue("preScore");
		StepValueHelper.RemoveStepOutputValue("actualresult");
		StepValueHelper.RemoveStepOutputValue("nowScore");

	}
		
	
}
