package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValuePool;
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

public class GoDoubiCreateOrder {

	private static String actualresult = null;
	private static List<List<String>> sqlresult = null;

	@StepMethodDesc(description = "createorder", owner = "tingwei.zhu")
	public void Step1_CreateOrder(String parameterID) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();				
		
		DomainNameSteps dn = new DomainNameSteps();
		parameter = dn.updateDomainName(parameter, "${DOMAIN_NAME}", "domainName");
		
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		GoDoubiCreateOrder storeoid = new GoDoubiCreateOrder();
		String store_oid = storeoid.getStoreoid();
		GoDoubiSignatureUtil signature = new GoDoubiSignatureUtil();
		String sign = GoDoubiSecurityUtil.geyMd5();
		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}
		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}

	public String getStoreoid() {
		RandomString storeoid = new RandomString();
		String store_oid = storeoid.radomStoreOid(18);
		return store_oid;
	}

	@StepMethodDesc(description = "expected result", owner = "tingwei.zhu")
	public void Step2_ExpectedResult(String parameterID) throws Exception {
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

	@StepMethodDesc(description = "assert json", owner = "tingwei.zhu")
	public void Step3_Assert(String parameterID) throws Exception {

		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);
		ResultCompare rc = new ResultCompare();
		Assert.assertEquals(actualresultJSON.getString("orderid"),
				rc.getListValue(1, sqlresult, "orderId"));
		Assert.assertEquals(actualresultJSON.getString("code"),
				"1");
//		Assert.assertEquals(actualresultJSON.getString("msg"),
		Assert.assertEquals(actualresultJSON.getString("return_url"),
				ConfigReader.GetValue("gatConfig.properties", "domainName")+"receive_doubi.xhtml");
	}
	
	@StepMethodDesc(description = "step1_CreateOrder_wrong_para", owner = "wangjing01")
	public void step1_CreateOrder_wrong_para(String parameterID)
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
						.getPara(urlParametersnew);

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

	@StepMethodDesc(description = "step1_CreateOrder_wrong_sign", owner = "wangjing01")
	public void step1_CreateOrder_wrong_sign(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		String signString = GoDoubiSecurityUtil.getPara(urlParameters);

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

	@StepMethodDesc(description = "step1_CreateOrder_wrong_product", owner = "wangjing01")
	public void step1_CreateOrder_wrong_product(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("product_code", "123123");

		String signString = GoDoubiSecurityUtil.getPara(urlParameters);

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

	@StepMethodDesc(description = "step1_CreateOrder_wrong_amount", owner = "wangjing01")
	public void step1_CreateOrder_wrong_amount(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("amount", "123123");

		String signString = GoDoubiSecurityUtil.getPara(urlParameters);

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

}
