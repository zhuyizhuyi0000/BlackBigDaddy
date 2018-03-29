package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.ConfigReader;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.CacheClean;
import com.baidu.gameqa.iat.common.Constant;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.common.RandomUtil;
import com.baidu.gameqa.iat.steps.common.CacheFlush;
import com.baidu.gameqa.iat.steps.common.DomainNameSteps;
import com.baidu.gameqa.iat.steps.common.GoDoubiSecurityUtil;
import com.baidu.gameqa.iat.steps.common.GoDoubiSignatureUtil;
import com.baidu.gameqa.iat.steps.common.RandomString;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class GoDoubiCreateOrderJsp {
	private static String actualresult = null;
	private static List<List<String>> sqlresult = null;

	@StepMethodDesc(description = "step1_CreateOrderJsp_v3", owner = "wangjing01")
	public void step1_CreateOrderJsp_v3(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("user_ip", "");
		urlParameters.put("product_code", "");
		urlParameters.put("product_number", "");

		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}

	@StepMethodDesc(description = "Step2_ExpectedResult result", owner = "wangjing01")
	public void step2_ExpectedResultJsp(String parameterID) throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		SimpleLogger.logInfo(this.getClass(), "connectionString:"
				+ parameter.ConnectiongString);
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		// requestParameter.put("commandText", parameter.CommandText);
		String commandText = "";

		if (actualresult.contains("orderid")) {
			commandText = parameter
					.getValue("CommandText_youxi_order_pay_20141");
			commandText = commandText.replace("$orderid",
					JSONUtil.getStrFromJson(actualresult, "orderid"));
		} else {
			commandText = parameter.CommandText;
		}

		SimpleLogger.logInfo("step2_ExpectedResultJsp  CommandText:"
				+ commandText);

		
		requestParameter.put("commandText", commandText);
		
		Sleeper.sleepTight(100);
		sqlresult = proxy.executeQuery(requestParameter);
		SimpleLogger.logInfo("step2_ExpectedResultJsp sqlresult:" + sqlresult);
	}

	@AssertStepMethodDesc(description = "Step3_Assert", owner = "wangjing01")
	public void step3_AssertJsp(String parameterID) throws Exception {
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		ResultCompare rc = new ResultCompare();

		if (actualresult.contains("orderid")) {
			Assert.assertEquals(
					JSONUtil.getStrFromJson(actualresult, "orderid"),
					rc.getListValue(1, sqlresult, "orderId"));
		}

		if (actualresult.contains("return_url")) {
			Assert.assertEquals(
					JSONUtil.getStrFromJson(actualresult, "return_url"),
					parameter.getValue("ok_return_url"));
		}

		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
				parameter.getValue("ok_code"));

		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "msg"),
				parameter.getValue("ok_msg"));
	}

	@AssertStepMethodDesc(description = "step4_AssertJsp_FF14", owner = "wangjing01")
	public void step4_AssertJsp_FF14(String parameterID) throws Exception {
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		ResultCompare rc = new ResultCompare();

		MysqlProxy proxy = new MysqlProxy();
		SimpleLogger.logInfo(this.getClass(), "connectionString:"
				+ parameter.ConnectiongString);
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		String commandText = "";
		if (actualresult.contains("orderid")) {
			commandText = parameter
					.getValue("CommandText_youxi_order_product_record");
			
			SimpleLogger.logInfo(this.getClass(), "commandText1:"
					+ commandText);
			
			commandText = commandText.replace("$orderid",
					JSONUtil.getStrFromJson(actualresult, "orderid"));
			
			SimpleLogger.logInfo(this.getClass(), "commandText2:"
					+ commandText);
		} else {
			commandText = parameter
					.getValue("CommandText_youxi_order_product_record_bak");
		}
		
		SimpleLogger.logInfo(this.getClass(), "commandText3:"
				+ commandText);

		requestParameter.put("commandText", commandText);

		Sleeper.sleepTight(100);
		
		List sqlresult_FF14 = proxy.executeQuery(requestParameter);

		SimpleLogger.logInfo(
				this.getClass(),
				"sqlresult_FF14 orderid:"
						+ rc.getListValue(1, sqlresult_FF14, "orderId"));

		SimpleLogger
				.logInfo(
						this.getClass(),
						"sqlresult orderid:"
								+ rc.getListValue(1, sqlresult, "orderId"));

		Assert.assertEquals(rc.getListValue(1, sqlresult_FF14, "orderId"),
				rc.getListValue(1, sqlresult, "orderId"));
	}

	@StepMethodDesc(description = "step1_CreateOrderJsp_v2", owner = "wangjing01")
	public void step1_CreateOrderJsp_v2(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		Random rand = new Random();
		String store_oid = "BDtest" + rand.nextInt(1000000);
		SimpleLogger.logInfo("store_oid:" + store_oid);

		urlParameters.put("user_ip", "");
		urlParameters.put("product_code", "");
		urlParameters.put("product_number", "");
		urlParameters.put("game_id", "108");
		urlParameters.put("server_id", "1");
		urlParameters.put("store_oid", store_oid);
		urlParameters.put("return_url", "http://");
		urlParameters.put("return_attach", "passtest|1|1539879009");
		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}

	@StepMethodDesc(description = "step1_CreateOrderJsp_ff14", owner = "wangjing01")
	public void step1_CreateOrderJsp_ff14(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("game_id", "892");
		urlParameters.put("server_id", "1");
		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

		urlParameters.put("sign", signString);
		urlParameters.put("user_ip", "192.168.1.34");
		urlParameters.put("product_code", "a892");
		urlParameters.put("product_number", "");

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}
		SimpleLogger.logInfo("urlParameters new :" + urlParameters);

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}

	@StepMethodDesc(description = "step1_CreateOrderJsp_wrong_para_1.3", owner = "wangjing01")
	public void step1_CreateOrderJsp_wrong_para_v3(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		// 普通1.3接口不传改参数
		urlParameters.put("user_ip", "");
		urlParameters.put("product_code", "");
		urlParameters.put("product_number", "");
		urlParameters.put("store_oid", "");
		urlParameters.put("return_url", "");
		urlParameters.put("return_attach", "");

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

				SimpleLogger.logInfo(this.getClass(), "urlParametersnew"
						+ urlParametersnew);

				signString = GoDoubiSecurityUtil
						.getPlatAJspPara(urlParametersnew);

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

				if (paraNames[i].equals("store_oid")
						|| paraNames[i].equals("return_url")
						|| paraNames[i].equals("return_attach")
						|| paraNames[i].equals("product_code")
						|| paraNames[i].equals("product_number")
						|| paraNames[i].equals("user_ip")) {
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "code"),
							parameter.getValue("ok_code"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "return_url"),
							parameter.getValue("ok_return_url"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "msg"),
							parameter.getValue("ok_msg"));
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

	// 1.2老游戏校验
	@StepMethodDesc(description = "step1_CreateOrderJsp_wrong_para_v2", owner = "wangjing01")
	public void step1_CreateOrderJsp_wrong_para_v2(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("user_ip", "");
		urlParameters.put("product_code", "");
		urlParameters.put("product_number", "");
		urlParameters.put("game_id", "108");
		urlParameters.put("server_id", "1");
		urlParameters.put("store_oid", RandomUtil.randomOid());
		urlParameters.put("return_url", "http://");
		urlParameters.put("return_attach", "passtest|1|1539879009");
		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		HashMap<String, String> urlParametersnew = new HashMap<String, String>();
		HttpUnitHelper.setParameters(currentRequest, urlParameters);

		String[] paraNames = currentRequest.getRequestParameterNames();
		String signString = "";

		SimpleLogger.logInfo(this.getClass(), "paraNames:" + paraNames);

		if (paraNames.length > 0) {

			for (int i = 0; i < paraNames.length; i++) {
				urlParametersnew = (HashMap<String, String>) urlParameters
						.clone();

				SimpleLogger.logInfo(this.getClass(), "paraNames[i]:"
						+ paraNames[i]);

				urlParametersnew.put(paraNames[i], "");
				if (!paraNames[i].equals("store_oid")) {
					urlParametersnew.put("store_oid", RandomUtil.randomOid());
				}

				SimpleLogger.logInfo(this.getClass(), "urlParametersnew"
						+ urlParametersnew);

				signString = GoDoubiSecurityUtil
						.getPlatAJspPara(urlParametersnew);

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

				if (paraNames[i].equals("product_code")
						|| paraNames[i].equals("product_number")
						|| paraNames[i].equals("user_ip")) {
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "code"),
							parameter.getValue("ok_code"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "return_url"),
							parameter.getValue("ok_return_url"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "msg"),
							parameter.getValue("ok_msg"));
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

	// 1.2老游戏校验
	@StepMethodDesc(description = "step1_CreateOrderJsp_ddt_wrong_storeoid", owner = "wangjing01")
	public void step1_CreateOrderJsp_ddt_wrong_storeoid(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		Random rand = new Random();
		String store_oid = "BDtest" + rand.nextInt(1000000);
		SimpleLogger.logInfo("store_oid:" + store_oid);

		urlParameters.put("user_ip", "");
		urlParameters.put("product_code", "");
		urlParameters.put("product_number", "");
		urlParameters.put("game_id", "108");
		urlParameters.put("server_id", "1");
		urlParameters.put("store_oid", store_oid);
		urlParameters.put("return_url", "http://");
		urlParameters.put("return_attach", "passtest|1|1539879009");
		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
		Sleeper.sleepTight(500);

		WebResponse response2 = currentConversation.getResponse(currentRequest);

		String actualresult2 = response2.getText();
		SimpleLogger.logInfo(this.getClass(), "actualresult2:" + actualresult2);

		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult2, "code"),
				parameter.getValue("wrong_ddt_storeoid_code"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult2, "msg"),
				parameter.getValue("wrong_ddt_storeoid_msg"));

	}

	// FF14游戏校验
	public void step1_CreateOrderJsp_wrong_para_ff14(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("game_id", "892");
		urlParameters.put("server_id", "1");
		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = "";

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		HttpUnitHelper.setParameters(currentRequest, urlParameters);

		HashMap<String, String> urlParametersnew = new HashMap<String, String>();

		String[] paraNames = currentRequest.getRequestParameterNames();

		SimpleLogger.logInfo(this.getClass(), "paraNames:" + paraNames);

		if (paraNames.length > 0) {

			for (int i = 0; i < paraNames.length; i++) {
				urlParametersnew = (HashMap<String, String>) urlParameters
						.clone();
				SimpleLogger.logInfo(this.getClass(), "paraNames[i]:"
						+ paraNames[i]);

				urlParametersnew.put(paraNames[i], "");

				SimpleLogger.logInfo(this.getClass(), "urlParametersnew"
						+ urlParametersnew);

				signString = GoDoubiSecurityUtil
						.getPlatAJspPara(urlParametersnew);

				urlParametersnew.put("sign", signString);
				urlParameters.put("user_ip", "192.168.1.34");
				urlParameters.put("product_code", "a892");
				urlParameters.put("product_number", "");

				if (urlParametersnew.size() != 0) {
					HttpUnitHelper.setParameters(currentRequest,
							urlParametersnew);
				}

				WebResponse response = currentConversation
						.getResponse(currentRequest);
				actualresult = response.getText();
				SimpleLogger.logInfo(this.getClass(), "actualresult:"
						+ actualresult);

				if (paraNames[i].equals("store_oid")
						|| paraNames[i].equals("return_url")
						|| paraNames[i].equals("return_attach")
						|| paraNames[i].equals("product_code")
						|| paraNames[i].equals("product_number")
						|| paraNames[i].equals("user_ip")) {
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "code"),
							parameter.getValue("ok_code"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "return_url"),
							parameter.getValue("ok_return_url"));
					Assert.assertEquals(
							JSONUtil.getStrFromJson(actualresult, "msg"),
							parameter.getValue("ok_msg"));
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

	@StepMethodDesc(description = "step1_CreateOrderJsp_wrong_sign", owner = "wangjing01")
	public void step1_CreateOrderJsp_wrong_sign(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

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

	@StepMethodDesc(description = "step1_CreateOrderJsp_wrong_ff14_product", owner = "wangjing01")
	public void step1_CreateOrderJsp_wrong_ff14_product(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("game_id", "892");
		urlParameters.put("server_id", "1");
		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

		urlParameters.put("sign", signString);
		urlParameters.put("user_ip", "192.168.1.34");
		urlParameters.put("product_code", "a892111");
		urlParameters.put("product_number", "");

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

	@StepMethodDesc(description = "step1_CreateOrderJsp_wrong_amount", owner = "wangjing01")
	public void step1_CreateOrderJsp_wrong_amount(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();

		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("amount", "123123");

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

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

	@StepMethodDesc(description = "step1_CreateOrderJsp_quickUser", owner = "wangjing01")
	public void step1_CreateOrderJsp_quickUser(String parameterID)
			throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(
				parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();

		urlParameters.put("user_ip", "");
		urlParameters.put("product_code", "");
		urlParameters.put("product_number", "");
		urlParameters.put("userid", "1200000189");
		urlParameters.put("uu_id", "1200000189");
		urlParameters.put("username", "#test1231");

		SimpleLogger.logInfo("urlParameters:" + urlParameters);

		String signString = GoDoubiSecurityUtil.getPlatAJspPara(urlParameters);

		urlParameters.put("sign", signString);

		if (urlParameters.size() != 0) {
			HttpUnitHelper.setParameters(currentRequest, urlParameters);
		}

		WebResponse response = currentConversation.getResponse(currentRequest);
		actualresult = response.getText();
		SimpleLogger.logInfo("actualresult:" + actualresult);
	}

	@AssertStepMethodDesc(description = "step3_AssertJsp_quickUser", owner = "wangjing01")
	public void step3_AssertJsp_quickUser(String parameterID) throws Exception {
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		ResultCompare rc = new ResultCompare();
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "orderid"),
				rc.getListValue(1, sqlresult, "orderId"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "code"),
				parameter.getValue("ok_code"));
		Assert.assertEquals(
				JSONUtil.getStrFromJson(actualresult, "return_url"),
				parameter.getValue("ok_return_url"));
		Assert.assertEquals(JSONUtil.getStrFromJson(actualresult, "msg"),
				parameter.getValue("ok_msg"));

		String data_useridActual = rc.getListValue(1, sqlresult, "userId");
		String data_uuidActual = rc.getListValue(1, sqlresult, "uuid");
		Assert.assertEquals(data_useridActual, "1200000189");
		Long expectuuidLong = (long) 1200000189 * 1001;

		Assert.assertEquals(data_uuidActual, expectuuidLong + "");
	}

	@StepMethodDesc(description = "step0_ff14_active", owner = "wangjing01")
	public void step0_ff14_active(String parameterID) throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		SimpleLogger.logInfo(this.getClass(), "connectionString:"
				+ parameter.ConnectiongString);
		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("del_active_code_use_history"));
		SimpleLogger.logInfo(this.getClass(), "del:"+requestParameter.get("commandText"));
		
		proxy.executeNoneQuery(requestParameter);
		requestParameter.put("commandText",
				parameter.getValue("insert_active_code_use_history"));
		
		SimpleLogger.logInfo(this.getClass(), "insert:"+requestParameter.get("commandText"));
		
		proxy.executeNoneQuery(requestParameter);
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}

	public static void main(String[] args) {

		Long expectuuidLong = (long) 1200000189 * 1001;

		System.out.println("store_oid:" + expectuuidLong + "");
	}
}
