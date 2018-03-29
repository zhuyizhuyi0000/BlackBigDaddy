package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;

import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.Constant;
import com.baidu.gameqa.iat.steps.common.CacheFlush;
import com.baidu.gameqa.iat.steps.common.SetupSteps;

public class GoDoubiCalculatePreferentialAmount {

	@SetupStepMethodDesc(description = "calPreAmountSetupCookieDB_vipCharge", owner = "wangjing01")
	public void calPreAmountSetupCookieDB_vipCharge(String parameterID)
			throws Exception {
		SetupSteps ss = new SetupSteps();

		ss.setCookie(parameterID);

		this.deleteyouxi_youxi_vip_user(parameterID);
		this.insertyouxi_youxi_vip_user(parameterID);
		this.updateyouxi_youxi_vip_user(parameterID);

	}

	@SetupStepMethodDesc(description = "calPreAmountSetupCookieDB_firstCharge", owner = "wangjing01")
	public void calPreAmountSetupCookieDB_firstCharge(String parameterID)
			throws Exception {
		SetupSteps ss = new SetupSteps();

		ss.setCookie(parameterID);

		this.deleteyouxi_youxi_vip_user(parameterID);
	}

	@SetupStepMethodDesc(description = "calPreAmountSetupCookieDB_commonCharge", owner = "wangjing01")
	public void calPreAmountSetupCookieDB_commonCharge(String parameterID)
			throws Exception {
		SetupSteps ss = new SetupSteps();

		ss.setCookie(parameterID);
		
		this.deleteyouxi_youxi_vip_user(parameterID);
		this.insertyouxi_youxi_vip_user(parameterID);

	}

	public void deleteyouxi_youxi_vip_user(String parameterID) throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("deleteyouxi_youxi_vip_user"));

		SimpleLogger.logInfo(this.getClass(), "connectionString::"
				+ parameter.ConnectiongString);
		SimpleLogger.logInfo(this.getClass(), "deleteyouxi_youxi_vip_user::"
				+ parameter.getValue("deleteyouxi_youxi_vip_user"));

		proxy.executeNoneQuery(requestParameter);

		SimpleLogger.logInfo(this.getClass(), "deleteyouxi_youxi_vip_user ok");
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}

	public void insertyouxi_youxi_vip_user(String parameterID) throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("insertyouxi_youxi_vip_user"));

		SimpleLogger.logInfo(this.getClass(), "connectionString::"
				+ parameter.ConnectiongString);
		SimpleLogger.logInfo(this.getClass(), "insertyouxi_youxi_vip_user::"
				+ parameter.getValue("insertyouxi_youxi_vip_user"));

		proxy.executeNoneQuery(requestParameter);

		SimpleLogger.logInfo(this.getClass(), "insertyouxi_youxi_vip_user ok");
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}

	public void updateyouxi_youxi_vip_user(String parameterID) throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText",
				parameter.getValue("updateyouxi_youxi_vip_user"));

		SimpleLogger.logInfo(this.getClass(), "connectionString::"
				+ parameter.ConnectiongString);
		SimpleLogger.logInfo(this.getClass(), "updateyouxi_youxi_vip_user::"
				+ parameter.getValue("updateyouxi_youxi_vip_user"));

		proxy.executeNoneQuery(requestParameter);

		SimpleLogger.logInfo(this.getClass(), "updateyouxi_youxi_vip_user ok");
		CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);

	}

}
