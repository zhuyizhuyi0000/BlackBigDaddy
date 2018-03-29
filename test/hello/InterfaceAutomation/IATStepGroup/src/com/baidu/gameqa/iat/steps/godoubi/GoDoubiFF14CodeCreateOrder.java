package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.ConfigReader;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.steps.common.DomainNameSteps;
import com.baidu.gameqa.iat.steps.common.GoDoubiSecurityUtil;
import com.baidu.gameqa.iat.steps.common.GoDoubiSignatureUtil;
import com.baidu.gameqa.iat.steps.common.RandomString;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class GoDoubiFF14CodeCreateOrder {
	private static String actualresult = null;
	private static List<List<String>> sqlresult = null;

	@StepMethodDesc(description = "createorder", owner = "wangjing01")
	public void step1_ff14CodeCreateOrder(String parameterID) throws Exception {

		SimpleLogger.logInfo(this.getClass(),
				"GoDoubiFF14CodeCreateOrder start parameterID:" + parameterID);
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		SimpleLogger.logInfo(this.getClass(),
				"GoDoubiFF14CodeCreateOrder start qqqqq:");
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		String signString = GoDoubiSecurityUtil.getFF14CodePara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}

	@StepMethodDesc(description = "Step2_ff14CodeExpectedResult result", owner = "wangjing01")
	public void step2_ff14CodeExpectedResult(String parameterID)
			throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		SimpleLogger.logInfo(this.getClass(), "connectionString:"
				+ parameter.ConnectiongString);
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.CommandText);
		sqlresult = proxy.executeQuery(requestParameter);
		SimpleLogger.logInfo("sqlresult:" + sqlresult);
	}

	@AssertStepMethodDesc(description = "Step3_ff14CodeAssert", owner = "wangjing01")
	public void step3_ff14CodeAssert(String parameterID) throws Exception {
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		ResultCompare rc = new ResultCompare();
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "order_id"),
				rc.getListValue(1, sqlresult, "orderId"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
				parameter.getValue("ok_code"));
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "return_url"),
				parameter.getValue("ok_return_url"));
	}

	@StepMethodDesc(description = "step1_ff14CodeCreateOrder_wrong_para", owner = "wangjing01")
	public void step1_ff14CodeCreateOrder_wrong_para(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		SimpleLogger.logInfo(this.getClass(), "urlParameters:" + urlParameters);
		HttpUnitHelper.setParameters(currentRequest, urlParameters);

		HashMap<String, String> urlParametersnew = new HashMap<String, String>();
		String signString = "";

		String[] paraNames = currentRequest.getRequestParameterNames();

		SimpleLogger.logInfo(this.getClass(), "paraNames:" + paraNames);

		if (paraNames.length > 0) {

			for (int i = 0; i < paraNames.length; i++) {
				urlParametersnew = (HashMap<String, String>) urlParameters
						.clone();

				SimpleLogger.logInfo(this.getClass(), "paraNames[i]:"
						+ paraNames[i]);

				urlParametersnew.put(paraNames[i], "");

				signString = GoDoubiSecurityUtil
						.getFF14CodePara(urlParametersnew);

				urlParametersnew.put("sign", signString);

				if (urlParametersnew.size() != 0) {
					HttpUnitHelper.setParameters(currentRequest,
							urlParametersnew);
				}

				WebResponse response = currentConversation
						.getResponse(currentRequest);
				actualresult = response.getText();
				SimpleLogger.logInfo(this.getClass(), "actualresult:"
						+ actualresult);

				if (paraNames[i].equals("server_id")) {
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "code"),
							parameter.getValue("ok_code"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "return_url"),
							parameter.getValue("ok_return_url"));
				} else if (paraNames[i].equals("pre_amount")) {
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "code"),
							parameter.getValue("wrong_preamount_code"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "msg"),
							parameter.getValue("wrong_preamount_msg"));
				} else {
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "code"),
							parameter.getValue("wrong_para_code"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "msg"),
							parameter.getValue("wrong_para_msg"));
				}

			}

		}

	}

	@StepMethodDesc(description = "step1_ff14CodeCreateOrder_wrong_sign", owner = "wangjing01")
	public void step1_ff14CodeCreateOrder_wrong_sign(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		String signString = GoDoubiSecurityUtil.getFF14CodePara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebRequest currentRequestnew = null;

		String[] paraNames = currentRequest.getRequestParameterNames();
		SimpleLogger.logInfo("paraNames:" + paraNames[1]);

		for (int i = 0; i < paraNames.length; i++) {
			currentRequestnew = currentRequest;
			currentRequestnew.setParameter(paraNames[i], "");
			WebResponse response = currentConversation
					.getResponse(currentRequestnew);
			actualresult = response.getText();
			SimpleLogger.logInfo("actualresult:" + actualresult);

			Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
					parameter.getValue("wrong_sign_code"));
			Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "msg"),
					parameter.getValue("wrong_sign_msg"));
		}

	}

	@StepMethodDesc(description = "step1_ff14CodeCreateOrder_wrong_product", owner = "wangjing01")
	public void step1_ff14CodeCreateOrder_wrong_product(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("product_code", "123123");

		String signString = GoDoubiSecurityUtil.getFF14CodePara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo(this.getClass(), "actualresult:" + actualresult);

		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
				parameter.getValue("wrong_product_code"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "msg"),
				parameter.getValue("wrong_product_msg"));

	}

	@StepMethodDesc(description = "step1_ff14CodeCreateOrder_wrong_amount", owner = "wangjing01")
	public void step1_ff14CodeCreateOrder_wrong_amount(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("amount", "123123");

		String signString = GoDoubiSecurityUtil.getFF14CodePara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo(this.getClass(), "actualresult:" + actualresult);

		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
				parameter.getValue("wrong_amount_code"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "msg"),
				parameter.getValue("wrong_amount_msg"));

	}
	
	@StepMethodDesc(description = "step1_ff14CodeCreateOrder_quickUser", owner = "wangjing01")
	public void step1_ff14CodeCreateOrder_quickUser(String parameterID) throws Exception {

		SimpleLogger.logInfo(this.getClass(),
				"GoDoubiFF14CodeCreateOrder start parameterID:" + parameterID);
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		SimpleLogger.logInfo(this.getClass(),
				"GoDoubiFF14CodeCreateOrder start qqqqq:");
		
		
		
		
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		
		urlParameters.put("user_id", "1200000189");
		urlParameters.put("uu_id", "1200000189");
		urlParameters.put("user_name", "#test1231");
		
		String signString = GoDoubiSecurityUtil.getFF14CodePara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}
	
	@AssertStepMethodDesc(description = "step3_AssertJsp_quickUser", owner = "wangjing01")
	public void step3_ff14CodeAssert_quickUser(String parameterID) throws Exception {
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		ResultCompare rc = new ResultCompare();
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "order_id"),
				rc.getListValue(1, sqlresult, "orderId"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
				parameter.getValue("ok_code"));
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "return_url"),
				parameter.getValue("ok_return_url"));
		
		String data_useridActual=rc.getListValue(1, sqlresult, "userId");
		String data_uuidActual=	rc.getListValue(1, sqlresult, "uuid");	
		Assert.assertEquals(data_useridActual,"1200000189");
		Long expectuuidLong= (long)1200000189 *1001;
		
		Assert.assertEquals(data_uuidActual,expectuuidLong+"");
	}
}
