package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.Constant;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.common.MutilPlatUtil;
import com.baidu.gameqa.iat.steps.common.CacheFlush;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class GoDoubiLoadServerSteps {

	MysqlProxy proxy = new MysqlProxy();
	HashMap<String, String> requestParameter = null;
	InterfaceStepParameter parameter = null;
	String parameterID = "";
	String actualResult = "";
	int platFlag = 0;
	String commandText = "";
	ResultCompare rc = new ResultCompare();

	@AssertStepMethodDesc(description = "GoDoubi_loadserver", owner = "xiuping.qi")
	public void goDoubiLoadServer(String parameterID, String expectresult,
			String actualresult) throws Exception {

		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);
		// 断言
		SimpleLogger.logInfo(this.getClass(), "======ratioDesc_actualresult:"
				+ actualresultJSON.getString("ratioDesc"));
		SimpleLogger.logInfo(this.getClass(), "======ratioDesc_expectresult:"
				+ parameter.getValue("ratioDesc"));
		Assert.assertEquals(actualresultJSON.getString("ratioDesc"),
				parameter.getValue("ratioDesc"));

		SimpleLogger.logInfo(
				this.getClass(),
				"======currencyDesc_actualresult:"
						+ actualresultJSON.getString("currencyDesc"));
		SimpleLogger.logInfo(
				this.getClass(),
				"======currencyDesc_expectresult:"
						+ parameter.getValue("currencyDesc"));
		Assert.assertEquals(actualresultJSON.getString("currencyDesc"),
				parameter.getValue("currencyDesc"));

		SimpleLogger.logInfo(this.getClass(), "======zoneFlag_actualresult:"
				+ actualresultJSON.getString("zoneFlag"));
		SimpleLogger.logInfo(this.getClass(), "======zoneFlag_expectresult:"
				+ parameter.getValue("zoneFlag"));
		Assert.assertEquals(actualresultJSON.getString("zoneFlag"),
				parameter.getValue("zoneFlag"));

		SimpleLogger.logInfo(this.getClass(), "======validFlag_actualresult:"
				+ actualresultJSON.getString("validFlag"));
		SimpleLogger.logInfo(this.getClass(), "======validFlag_expectresult:"
				+ parameter.getValue("validFlag"));
		Assert.assertEquals(actualresultJSON.getString("validFlag"),
				parameter.getValue("validFlag"));

		SimpleLogger.logInfo(this.getClass(), "======isFlag_actualresult:"
				+ actualresultJSON.getString("isFlag"));
		SimpleLogger.logInfo(this.getClass(), "======isFlag_expectresult:"
				+ parameter.getValue("isFlag"));
		Assert.assertEquals(actualresultJSON.getString("isFlag"),
				parameter.getValue("isFlag"));

		SimpleLogger.logInfo(this.getClass(), "======needRole_actualresult:"
				+ actualresultJSON.getString("needRole"));
		SimpleLogger.logInfo(this.getClass(), "======needRole_expectresult:"
				+ parameter.getValue("needRole"));
		Assert.assertEquals(actualresultJSON.getString("needRole"),
				parameter.getValue("needRole"));

	}

	public void sqlconnect_tieba() throws Exception {
		parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		requestParameter = new HashMap<String, String>();

		requestParameter.put("connectionString",
				parameter.getValue("conn_tiebayouxi"));
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password"));

	}

	public void sqlconnect_newyouxi() throws Exception {
		parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		requestParameter = new HashMap<String, String>();

		requestParameter.put("connectionString",
				parameter.getValue("conn_newyouxi"));
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password"));

	}

	public void sqlconnect_bplat() throws Exception {
		parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		requestParameter = new HashMap<String, String>();

		requestParameter.put("connectionString",
				parameter.getValue("conn_bplat"));
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password"));

	}

	public List selectgameCurrencyInfo_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter
				.getValue("selectgameCurrencyInfo").replace(
						"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameCurrencyInfo = proxy.executeQuery(requestParameter);
		return gameCurrencyInfo;

	}

	public List selectgameCurrencyInfo_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectgameCurrencyInfo"));

		List gameCurrencyInfo = proxy.executeQuery(requestParameter);
		return gameCurrencyInfo;

	}

	public List selectgameCurrencyInfo_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText",
				parameter.getValue("selectgameCurrencyInfo"));

		List gameCurrencyInfo = proxy.executeQuery(requestParameter);
		return gameCurrencyInfo;

	}

	public List selectYouxiInfo_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("selectYouxiInfo_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectYouxiInfo_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectYouxiInfo_tieba"));

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectYouxiInfo_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectYouxiInfo_bplat"));

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectYouxiServerInfo_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("selectYouxiServerInfo_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectYouxiServerInfo_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText",
				parameter.getValue("selectYouxiServerInfo_bplat"));

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectYouxiServerInfo_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectYouxiServerInfo_tieba"));

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectUserYouxiRecord_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("selectUserYouxiRecord_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectGamePlayerRecord_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText",
				parameter.getValue("selectGamePlayerRecord_bplat"));

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public List selectUserGameRecord_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectUserGameRecord_tieba"));

		List gameInfo = proxy.executeQuery(requestParameter);
		return gameInfo;

	}

	public void updateYouxiServerInfo_STATUS_HOT_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"updateYouxiServerInfo_STATUS_HOT_newyouxi").replace(
				"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_HOT_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("updateYouxiServerInfo_STATUS_HOT_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_HOT_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText",
				parameter.getValue("updateYouxiServerInfo_STATUS_HOT_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_ON_NOTINIT_newyouxi()
			throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"updateYouxiServerInfo_STATUS_ON_NOTINIT_newyouxi").replace(
				"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_ON_NOTINIT_tieba()
			throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText", parameter
				.getValue("updateYouxiServerInfo_STATUS_ON_NOTINIT_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_ON_NOTINIT_bplat()
			throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText", parameter
				.getValue("updateYouxiServerInfo_STATUS_ON_NOTINIT_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_MAINTAIN_newyouxi()
			throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"updateYouxiServerInfo_STATUS_MAINTAIN_newyouxi").replace(
				"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_MAINTAIN_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText", parameter
				.getValue("updateYouxiServerInfo_STATUS_MAINTAIN_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiServerInfo_STATUS_MAINTAIN_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText", parameter
				.getValue("updateYouxiServerInfo_STATUS_MAINTAIN_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void insertUserYouxiRecord_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("insertUserYouxiRecord_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);
		SimpleLogger.logInfo(
				this.getClass(),
				"insertUserYouxiRecord_newyouxi sql:"
						+ requestParameter.get("connectionString"));
		SimpleLogger.logInfo(
				this.getClass(),
				"insertUserYouxiRecord_newyouxi commandText"
						+ requestParameter.get("commandText"));
		proxy.executeNoneQuery(requestParameter);

	}

	public void insertUserYouxiRecord_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("insertUserYouxiRecord_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void insertUserYouxiRecord_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText",
				parameter.getValue("insertUserYouxiRecord_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void deleteUserYouxiRecord_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("deleteUserYouxiRecord_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);
		SimpleLogger.logInfo(
				this.getClass(),
				"deleteUserYouxiRecord_newyouxi sql:"
						+ requestParameter.get("connectionString"));
		SimpleLogger.logInfo(
				this.getClass(),
				"deleteUserYouxiRecord_newyouxi commandText"
						+ requestParameter.get("commandText"));
		proxy.executeNoneQuery(requestParameter);

	}

	public void deleteUserYouxiRecord_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("deleteUserYouxiRecord_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void deleteUserYouxiRecord_bplat() throws Exception {
		this.sqlconnect_bplat();
		requestParameter.put("commandText",
				parameter.getValue("deleteUserYouxiRecord_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiInfonoLimit_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter
				.getValue("updateYouxiInfonoLimit_newyouxi").replace(
						"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiInfobjLimit_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter
				.getValue("updateYouxiInfobjLimit_newyouxi").replace(
						"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiInfoChinaLimit_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"updateYouxiInfoChinaLimit_newyouxi").replace("$platFlag",
				"" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiInforoleIsExisted_yes_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"updateYouxiInforoleIsExisted_yes_newyouxi").replace(
				"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateYouxiInforoleIsExisted_no_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"updateYouxiInforoleIsExisted_no_newyouxi").replace(
				"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);
		SimpleLogger.logInfo(
				this.getClass(),
				"updateYouxiInforoleIsExisted_no_newyouxi sql:"
						+ requestParameter.get("connectionString"));
		SimpleLogger.logInfo(
				this.getClass(),
				"updateYouxiInforoleIsExisted_no_newyouxi commandText:"
						+ requestParameter.get("commandText"));
		proxy.executeNoneQuery(requestParameter);

	}

	@AssertStepMethodDesc(description = "assert ratioDesc,currencyDesc", owner = "wangjing01")
	public void loadServer_assertratioDesc() throws Exception {

		List gameCurrencyInfo = null;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			gameCurrencyInfo = this.selectgameCurrencyInfo_tieba();
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			gameCurrencyInfo = this.selectgameCurrencyInfo_newyouxi();
		} else if (platFlag == 2) {
			gameCurrencyInfo = this.selectgameCurrencyInfo_bplat();
		}

		if (gameCurrencyInfo != null && actualResult != null) {
			String expectratioDesc = rc.getListValue(1, gameCurrencyInfo,
					"ratio").toString();
			String actualRatioDesc = JSONUtil.getStrFromJson(actualResult,
					"ratioDesc");

			SimpleLogger.logInfo(this.getClass(), "=====expectratioDesc:"
					+ expectratioDesc);
			SimpleLogger.logInfo(this.getClass(), "=====actualRatioDesc:"
					+ actualRatioDesc);
			Assert.assertEquals(actualRatioDesc, expectratioDesc);

			String expectcurrencyDesc = rc.getListValue(1, gameCurrencyInfo,
					"currency").toString();
			String actualcurrencyDesc = JSONUtil.getStrFromJson(actualResult,
					"currencyDesc");

			SimpleLogger.logInfo(this.getClass(), "=====expectcurrencyDesc:"
					+ expectcurrencyDesc);
			SimpleLogger.logInfo(this.getClass(), "=====actualcurrencyDesc:"
					+ actualcurrencyDesc);
			Assert.assertEquals(actualcurrencyDesc, expectcurrencyDesc);
		}

	}

	@AssertStepMethodDesc(description = "assert gamePage,zoneFlag,gameMsg,validFlag,isFlag,needRole", owner = "wangjing01")
	public void loadServer_assertgameDes() throws Exception {
		SimpleLogger.logInfo(this.getClass(),
				"=====loadServer_assertgameDes start:");

		List gameInfo = null;
		String expectStr = "";
		String actualStr = "";
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			gameInfo = this.selectYouxiInfo_tieba();
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			gameInfo = this.selectYouxiInfo_newyouxi();
		} else if (platFlag == 2) {
			gameInfo = this.selectYouxiInfo_bplat();
		}
		if (gameInfo != null && actualResult != null) {
			// needRole
			expectStr = rc.getListValue(1, gameInfo, "roleIsExisted")
					.toString();
			actualStr = JSONUtil.getStrFromJson(actualResult, "needRole");

			SimpleLogger.logInfo(this.getClass(), "=====expectResult needRole:"
					+ expectStr);
			SimpleLogger.logInfo(this.getClass(), "=====actualResult needRole:"
					+ actualStr);
			Assert.assertEquals(expectStr, actualStr);

			// gamePage

			// gameMsg
			expectStr = rc.getListValue(1, gameInfo, "description").toString();
			actualStr = JSONUtil.getStrFromJson(actualResult, "gameMsg");
			SimpleLogger.logInfo(this.getClass(), "=====expectResult gameMsg:"
					+ expectStr);
			SimpleLogger.logInfo(this.getClass(), "=====actualResult gameMsg:"
					+ actualStr);

			Assert.assertEquals(expectStr, actualStr);

			// validFlag
			if (rc.getListValue(1, gameInfo, "actionTitle").toString()
					.equals("go.xhtml")) {
				expectStr = "0";
			} else {
				expectStr = "1";
			}
			actualStr = JSONUtil.getStrFromJson(actualResult, "validFlag");
			SimpleLogger.logInfo(this.getClass(),
					"=====expectResult validFlag:" + expectStr);
			SimpleLogger.logInfo(this.getClass(),
					"=====actualResult validFlag:" + actualStr);
			Assert.assertEquals(expectStr, actualStr);

			// zoneFlag
			expectStr = "0";
			actualStr = JSONUtil.getStrFromJson(actualResult, "zoneFlag");
			SimpleLogger.logInfo(this.getClass(), "=====expectResult zoneFlag:"
					+ expectStr);
			SimpleLogger.logInfo(this.getClass(), "=====actualResult zoneFlag:"
					+ actualStr);
			Assert.assertEquals(expectStr, actualStr);

			// isFlag
			expectStr = rc.getListValue(1, gameInfo, "multiURLTag").toString();
			if (expectStr.contains("fb-all")) {
				expectStr = "1";
			} else if (expectStr.contains("fb")) {
				expectStr = "0";
			} else {
				expectStr = "-1";
			}
			actualStr = JSONUtil.getStrFromJson(actualResult, "isFlag");
			SimpleLogger.logInfo(this.getClass(), "=====expectResult isFlag:"
					+ expectStr);
			SimpleLogger.logInfo(this.getClass(), "=====actualResult isFlag:"
					+ actualStr);
			Assert.assertEquals(expectStr, actualStr);
		}

	}

	@AssertStepMethodDesc(description = "assert loadServer_assertserverList", owner = "wangjing01")
	public void loadServer_assertserverList() throws Exception {
		SimpleLogger.logInfo(this.getClass(),
				"=====loadServer_assertserverList start:");
		List serverList = null;
		String expectStr = "";
		String actualStr = "";
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			serverList = this.selectYouxiServerInfo_tieba();
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			serverList = this.selectYouxiServerInfo_newyouxi();
		} else if (platFlag == 2) {
			serverList = this.selectYouxiServerInfo_bplat();
		}

		int expctNum = 0;
		int actualNum = 0;
		SimpleLogger.logInfo(this.getClass(), "=====expect serverList :"
				+ serverList);
		// assert youxi number
		if (serverList != null) {
			expctNum = serverList.size() - 1;
		}
		if (actualResult != null || actualResult != "") {
			actualNum = JSONUtil.getSizeofJson(actualResult, "serverList");
		}
		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);
		Assert.assertEquals(actualNum, expctNum);
	}

	@AssertStepMethodDesc(description = "assert loadServer_assertplayedServerList", owner = "wangjing01")
	public void loadServer_assertplayedServerList() throws Exception {
		SimpleLogger.logInfo(this.getClass(),
				"=====loadServer_assertplayedServerList start:");
		List serverList = null;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			serverList = this.selectUserGameRecord_tieba();
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			serverList = this.selectUserYouxiRecord_newyouxi();
		} else if (platFlag == 2) {
			serverList = this.selectGamePlayerRecord_bplat();
		}
		int expctNum = 0;
		int actualNum = 0;
		SimpleLogger.logInfo(this.getClass(),
				"=====expect play game srever list:" + serverList);
		// assert youxi server number
		if (serverList != null) {
			expctNum = serverList.size() - 1;

		}
		if (actualResult != null || actualResult != "") {
			actualNum = JSONUtil
					.getSizeofJson(actualResult, "playedServerList");
		}

		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);
		Assert.assertEquals(actualNum, expctNum);

	}

	@AssertStepMethodDesc(description = "loadServer_assert", owner = "wangjing01")
	public void loadServer_assert(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		this.loadServer_assertratioDesc();

		this.loadServer_assertserverList();
		this.loadServer_assertplayedServerList();
		this.loadServer_assertgameDes();

	}

	@AssertStepMethodDesc(description = "loadServer_assert_nohistory", owner = "wangjing01")
	public void loadServer_assert_nohistory(String parameterID,
			String expectresult, String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		loadServer_assertplayedServerList_noRecord(parameterID, expectresult,
				actualresult);
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertgameDes();
	}

	@AssertStepMethodDesc(description = "assert loadServer_assertplayedServerList_noRecord", owner = "wangjing01")
	public void loadServer_assertplayedServerList_noRecord(String parameterID,
			String expectresult, String actualresult) throws Exception {

		int expctNum = 0;
		int actualNum = 0;
		// assert youxi number
		if (actualResult != null || actualResult != "") {
			actualNum = JSONUtil
					.getSizeofJson(actualResult, "playedServerList");
		}

		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);
		Assert.assertEquals(actualNum, expctNum);

	}
	
	
	@AssertStepMethodDesc(description = "loadserver_assert_roleIsExisted_no", owner = "wangjing01")
	public void loadserver_assert_roleIsExisted_no(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		
		String needroleActual = JSONUtil.getStrFromJson(actualResult, "needRole");

		SimpleLogger.logInfo(this.getClass(), "needroleActual::::"+needroleActual);
		Assert.assertEquals("0", needroleActual);
		
		
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertplayedServerList();
		this.loadServer_assertgameDes();

	}

	@AssertStepMethodDesc(description = "loadserver_assert_bjLimit", owner = "wangjing01")
	public void loadserver_assert_bjLimit(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		
		String isFlagActual = JSONUtil.getStrFromJson(actualResult, "isFlag");
		
		SimpleLogger.logInfo(this.getClass(), "isFlagActual::::"+isFlagActual);
		Assert.assertEquals("0", isFlagActual);
		
		
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertplayedServerList();
		this.loadServer_assertgameDes();

	}
	
	@AssertStepMethodDesc(description = "loadserver_assert_ChinaLimit", owner = "wangjing01")
	public void loadserver_assert_ChinaLimit(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		
		String isFlagActual = JSONUtil.getStrFromJson(actualResult, "isFlag");
		
		SimpleLogger.logInfo(this.getClass(), "isFlagActual::::"+isFlagActual);
		Assert.assertEquals("1", isFlagActual);
		
		
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertplayedServerList();
		this.loadServer_assertgameDes();

	}
	
	@AssertStepMethodDesc(description = "loadserver_assert_noLimit", owner = "wangjing01")
	public void loadserver_assert_noLimit(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		
		String isFlagActual = JSONUtil.getStrFromJson(actualResult, "isFlag");
		
		SimpleLogger.logInfo(this.getClass(), "isFlagActual::::"+isFlagActual);
		Assert.assertEquals("-1", isFlagActual);
		
		
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertplayedServerList();
		this.loadServer_assertgameDes();

	}
	
	
	@AssertStepMethodDesc(description = "loadserver_assert_online", owner = "wangjing01")
	public void loadserver_assert_online(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		
		String serverListActual = JSONUtil.getStrFromJson(actualResult, "serverList");
		String playedServerListActual = JSONUtil.getStrFromJson(actualResult, "playedServerList");
		
		SimpleLogger.logInfo(this.getClass(), "serverListActual::::"+serverListActual);
		SimpleLogger.logInfo(this.getClass(), "playedServerListActual::::"+playedServerListActual);
		Assert.assertTrue(serverListActual.contains("\"1001\""));
		Assert.assertTrue(playedServerListActual.contains("\"1001\""));
		
		
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertgameDes();

	}
	
	@AssertStepMethodDesc(description = "loadserver_assert_offline", owner = "wangjing01")
	public void loadserver_assert_offline(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		
		String serverListActual = JSONUtil.getStrFromJson(actualResult, "serverList");
		String playedServerListActual = JSONUtil.getStrFromJson(actualResult, "playedServerList");
		
		SimpleLogger.logInfo(this.getClass(), "serverListActual::::"+serverListActual);
		SimpleLogger.logInfo(this.getClass(), "playedServerListActual::::"+playedServerListActual);
		Assert.assertFalse(serverListActual.contains("\"1001\""));
		Assert.assertFalse(playedServerListActual.contains("\"1001\""));
		
		
		this.loadServer_assertratioDesc();
		this.loadServer_assertserverList();
		this.loadServer_assertgameDes();

	}
	
	@SetupStepMethodDesc(description = "loadServer_STATUS_HOT", owner = "wangjing01")
	public void loadServer_STATUS_HOT(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiServerInfo_STATUS_HOT_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiServerInfo_STATUS_HOT_newyouxi();
			this.insertUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiServerInfo_STATUS_HOT_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_STATUS_ON_NOTINIT", owner = "wangjing01")
	public void loadServer_STATUS_ON_NOTINIT(String parameterID)
			throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiServerInfo_STATUS_ON_NOTINIT_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiServerInfo_STATUS_ON_NOTINIT_newyouxi();
			this.insertUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiServerInfo_STATUS_ON_NOTINIT_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_STATUS_MAINTAIN", owner = "wangjing01")
	public void loadServer_STATUS_MAINTAIN(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiServerInfo_STATUS_MAINTAIN_tieba();
			this.insertUserYouxiRecord_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiServerInfo_STATUS_MAINTAIN_newyouxi();
			this.insertUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiServerInfo_STATUS_MAINTAIN_bplat();
			this.insertUserYouxiRecord_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_history", owner = "wangjing01")
	public void loadServer_history(String parameterID) throws Exception {
		SimpleLogger.logInfo(this.getClass(),
				"============loadServer_history======================");
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.deleteUserYouxiRecord_tieba();
			this.insertUserYouxiRecord_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.deleteUserYouxiRecord_newyouxi();
			this.insertUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.deleteUserYouxiRecord_bplat();
			this.insertUserYouxiRecord_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_nohistory", owner = "wangjing01")
	public void loadServer_nohistory(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.deleteUserYouxiRecord_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.deleteUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.deleteUserYouxiRecord_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_roleIsExisted_no", owner = "wangjing01")
	public void loadServer_roleIsExisted_no(String parameterID)
			throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiInforoleIsExisted_no_newyouxi();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiInforoleIsExisted_no_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiInforoleIsExisted_no_newyouxi();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_roleIsExisted_yes", owner = "wangjing01")
	public void loadServer_roleIsExisted_yes(String parameterID)
			throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiInforoleIsExisted_yes_newyouxi();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiInforoleIsExisted_yes_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiInforoleIsExisted_yes_newyouxi();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_bjLimit", owner = "wangjing01")
	public void loadServer_bjLimit(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiInfobjLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiInfobjLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiInfobjLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_ChinaLimit", owner = "wangjing01")
	public void loadServer_ChinaLimit(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiInfoChinaLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiInfoChinaLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiInfoChinaLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadServer_noLimit", owner = "wangjing01")
	public void loadServer_noLimit(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateYouxiInfonoLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateYouxiInfonoLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateYouxiInfonoLimit_newyouxi();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}
}
