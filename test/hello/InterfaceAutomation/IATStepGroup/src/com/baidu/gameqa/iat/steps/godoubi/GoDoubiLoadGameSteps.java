package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.Constant;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.common.MutilPlatUtil;
import com.baidu.gameqa.iat.steps.common.CacheFlush;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class GoDoubiLoadGameSteps {

	private MysqlProxy proxy = new MysqlProxy();
	private HashMap<String, String> requestParameter = null;
	private InterfaceStepParameter parameter = null;
	private String parameterID = "";
	private String actualResult = "";
	private int platFlag = 0;
	private String commandText = "";

	// private List gameList;

	@AssertStepMethodDesc(description = "load game", owner = "tingwei.zhu")
	public void loadGame(String parameterID, String expectresult,
			String actualresult) throws Exception {

		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		requestParameter.put("connectionString", parameter.ConnectiongString);
		requestParameter.put("user", "game");
		requestParameter.put("password", "game");
		requestParameter.put("commandText", parameter.CommandText);

		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		ResultCompare rc = new ResultCompare();

		for (int i = 0; i < sqlresult.size() - 1; i++) {
			Assert.assertEquals(rc.getJsonStringValue(i, "playGameList",
					actualresult, "id"), rc.getListValue(i + 1, sqlresult,
					"gameId"));

		}

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

	public List selectYouxiInfo_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectWanbaGame_tieba"));

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public List selectUserGameRecord_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectUserGameRecord_tieba"));

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public void deleteUserGameRecord_tieba() throws Exception {

		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("deleteUserGameRecord_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void insertUserGameRecord_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("insertUserGameRecord_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public List selectRecommendGameList_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectrecommendGameList_tieba"));

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public void updateWanbaGameOffline_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("updateWanbaGameOffline_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateWanbaGameOnline_tieba() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("updateWanbaGameOnline_tieba"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void deleteUserYouxiRecord_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("deleteUserYouxiRecord_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);
		
		SimpleLogger.logInfo(this.getClass(), "connectionString:"+requestParameter.get("connectionString"));
		SimpleLogger.logInfo(this.getClass(), "commandText:"+requestParameter.get("commandText"));
		proxy.executeNoneQuery(requestParameter);

	}

	public void insertUserYouxiRecord_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("insertUserYouxiRecord_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public List selectUserYouxiRecord_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("selectUserYouxiRecord_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public List selectYouxiInfo_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("selectYouxiInfo_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public List selectrecommendGameList_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue(
				"selectrecommendGameList_newyouxi").replace("$platFlag",
				"" + platFlag);
		requestParameter.put("commandText", commandText);

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public void updateWanbaGameOffline_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter
				.getValue("updateWanbaGameOffline_newyouxi").replace(
						"$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateWanbaGameOnline_newyouxi() throws Exception {
		this.sqlconnect_newyouxi();
		this.commandText = parameter.getValue("updateWanbaGameOnline_newyouxi")
				.replace("$platFlag", "" + platFlag);
		requestParameter.put("commandText", commandText);

		proxy.executeNoneQuery(requestParameter);

	}

	public void deleteGamePlayerRecord_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("deleteGamePlayerRecord_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void insertGamePlayerRecord_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("insertGamePlayerRecord_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public List selectGamePlayerRecord_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectGamePlayerRecord_bplat"));

		List gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public List<List<String>> selectYouxiInfo_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectYouxiInfo_bplat"));

		List<List<String>> gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public List<List<String>> selectrecommendGameList_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("selectrecommendGameList_bplat"));

		List<List<String>> gameList = proxy.executeQuery(requestParameter);
		return gameList;

	}

	public void updateWanbaGameOffline_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("updateWanbaGameOffline_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	public void updateWanbaGameOnline_bplat() throws Exception {
		this.sqlconnect_tieba();
		requestParameter.put("commandText",
				parameter.getValue("updateWanbaGameOnline_bplat"));

		proxy.executeNoneQuery(requestParameter);

	}

	@AssertStepMethodDesc(description = "assert platdesc,platlogo,ratioDesc", owner = "wangjing01")
	public void loadGame_assertplatDesc() throws Exception {
		this.platFlag = MutilPlatUtil.getPlatFlag();
		String expectratioDesc = "";
		String expectplatDesc = "";
		String expectplatLogo = "";
		
		if (platFlag == 4) {
			expectratioDesc = parameter.getValue("ratioDesc_tieba");
			expectplatDesc = parameter.getValue("platDesc_tieba");
			expectplatLogo = parameter.getValue("platLogo_tieba");

		} else if (platFlag == 8) {
			expectratioDesc = parameter.getValue("ratioDesc_hao123qipai");
			expectplatDesc = parameter.getValue("platDesc_hao123qipai");
			expectplatLogo = parameter.getValue("platLogo_hao123qipai");
		} else if (platFlag == 10) {
			expectratioDesc = parameter.getValue("ratioDesc_wanhao123");
			expectplatDesc = parameter.getValue("platDesc_wanhao123");
			expectplatLogo = parameter.getValue("platLogo_wanhao123");
		} else if (platFlag == 6) {
			expectratioDesc = parameter.getValue("ratioDesc_chuanqi");
			expectplatDesc = parameter.getValue("platDesc_chuanqi");
			expectplatLogo = parameter.getValue("platLogo_chuanqi");
		} else if (platFlag == 2) {
			expectratioDesc = parameter.getValue("ratioDesc_bplat");
			expectplatDesc = parameter.getValue("platDesc_bplat");
			expectplatLogo = parameter.getValue("platLogo_bplat");
		} else if (platFlag == 1) {
			SimpleLogger.logInfo(this.getClass(), "=====platFlag =1 :");
			expectratioDesc = parameter.getValue("ratioDesc_newyouxi");
			expectplatDesc = parameter.getValue("platDesc_newyouxi");
			expectplatLogo = parameter.getValue("platLogo_newyouxi");
		}
		
		
		Assert.assertEquals(expectratioDesc,
				JSONUtil.getStrFromJson(actualResult, "ratioDesc"));
		Assert.assertEquals(expectplatDesc,
				JSONUtil.getStrFromJson(actualResult, "platDesc"));
		Assert.assertEquals(expectplatLogo,
				JSONUtil.getStrFromJson(actualResult, "platLogo"));
	}

	@AssertStepMethodDesc(description = "assert gameList", owner = "wangjing01")
	public void loadGame_assertgameList() throws Exception {
		List<List<String>> gameList = null;

		this.platFlag = MutilPlatUtil.getPlatFlag();
		
		if (platFlag == 4) {
			SimpleLogger.logInfo(this.getClass(), "platFlag == 4");
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			gameList = this.selectYouxiInfo_newyouxi();
		} else if (platFlag == 2) {
			
			gameList = this.selectYouxiInfo_bplat();
		}

		// expect
		int expctNum = 0;
		int actualNum = 0;

		SimpleLogger.logInfo(this.getClass(), "=====expect game list:"
				+ gameList);
		// assert youxi number
		if (gameList != null) {
			expctNum = gameList.size() - 1;
		}

		if (actualResult != null || actualResult != "") {

			if (MutilPlatUtil.getPlatFlag() == 4) {
				actualNum = JSONUtil
						.getSizeofJson(actualResult, "gameList|ABC")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|DEFG")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|HIJK")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|LMNO")
						+ JSONUtil
								.getSizeofJson(actualResult, "gameList|TPQRS")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|UVWX")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|YZ");
			} else {
				actualNum = JSONUtil
						.getSizeofJson(actualResult, "gameList|ABC")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|DEFG")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|HIJK")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|LMNO")
						+ JSONUtil
								.getSizeofJson(actualResult, "gameList|PQRST")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|UVWX")
						+ JSONUtil.getSizeofJson(actualResult, "gameList|YZ");
			}

		}
		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);
		// Assert.assertEquals(actualNum, expctNum);

		// assert youxi info

		if (actualNum != 0) {
			loadGame_assertgameList_youxiinfo(gameList);
		}

	}

	public void loadGame_assertgameList_youxiinfo(List gameList) {
		String[] strArr = new String[] { "ABC", "DEFG", "HIJK", "LMNO",
				"PQRST", "UVWX", "YZ" };
		String[] tiebastrArr = new String[] { "ABC", "DEFG", "HIJK", "LMNO",
				"TPQRS", "UVWX", "YZ" };
		ResultCompare rc = new ResultCompare();

		int expctNum = gameList.size() - 1;
		// assert youxi info
		HashMap<String, Integer> expectgameIdMap = new HashMap();
		if (gameList != null) {

			for (int i = 0; i < expctNum; i++) {
				String expectGameId = rc.getListValue(i + 1, gameList, "id")
						.toString();
				expectgameIdMap.put(expectGameId, 0);

			}
		}
		if (platFlag == 4) {
			strArr = tiebastrArr;
		}

		if (actualResult != null) {

			for (int strArrNum = 0; strArrNum < strArr.length; strArrNum++) {
				String str = "gameList|" + strArr[strArrNum];

				for (int i = 0; i < JSONUtil.getSizeofJson(actualResult, str); i++) {
					String actualGameId = JSONUtil.getStrFromJson(actualResult,
							str + "|_all_|$" + i + "|id");
					if (expectgameIdMap.containsKey(actualGameId)) {
						expectgameIdMap.remove(actualGameId);
					} else {
						expectgameIdMap.put(actualGameId, -1);
					}

				}
			}

		}

		SimpleLogger.logInfo(this.getClass(), "=====expectgameIdMap:"
				+ expectgameIdMap.toString());

	}

	@AssertStepMethodDesc(description = "assert recommendGameList", owner = "wangjing01")
	public void loadGame_assertrecommendGameList() throws Exception {
		List gameList = null;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			gameList = this.selectRecommendGameList_tieba();
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			gameList = this.selectrecommendGameList_newyouxi();
		} else if (platFlag == 2) {
			gameList = this.selectrecommendGameList_bplat();
		}

		int expctNum = 0;
		int actualNum = 0;
		SimpleLogger.logInfo(this.getClass(),
				"=====expect Recommend game list:" + gameList);
		// assert youxi number
		if (gameList != null) {
			expctNum = gameList.size() - 1;
		}
		if (actualResult != null || actualResult != "") {
			actualNum = JSONUtil.getSizeofJson(actualResult,
					"recommendGameList");
		}
		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);
		Assert.assertEquals(actualNum, expctNum);
		if (actualNum != 0) {
			// assert youxi info
			ResultCompare rc = new ResultCompare();
			for (int i = 0; i < expctNum; i++) {
				String actualGameId = JSONUtil.getStrFromJson(actualResult,
						"recommendGameList|_all_|$" + i + "|id");
				SimpleLogger.logInfo(this.getClass(), "=====actualGameId:"
						+ actualGameId);
				String expectGameId = rc.getListValue(i + 1, gameList, "id")
						.toString();
				SimpleLogger.logInfo(this.getClass(), "=====expectGameId:"
						+ expectGameId);
				Assert.assertEquals(actualGameId, expectGameId);
			}
		}
	}

	@AssertStepMethodDesc(description = "assert playGameList", owner = "wangjing01")
	public void loadGame_assertplayGameList_noRecord(String parameterID,
			String expectresult, String actualresult) throws Exception {

		int expctNum = 0;
		int actualNum = 0;
		// assert youxi number
		if (actualResult != null || actualResult != "") {
			actualNum = JSONUtil.getSizeofJson(actualResult, "playGameList");
		}

		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);
		Assert.assertEquals(actualNum, expctNum);

	}

	@AssertStepMethodDesc(description = "assert playGameList", owner = "wangjing01")
	public void loadGame_assertplayGameList() throws Exception {
		List<List<String>> gameList = null;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			gameList = this.selectUserGameRecord_tieba();
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			gameList = this.selectUserYouxiRecord_newyouxi();
		} else if (platFlag == 2) {
			gameList = this.selectGamePlayerRecord_bplat();
		}
		int expctNum = 0;
		int actualNum = 0;
		SimpleLogger.logInfo(this.getClass(), "=====expect play game list:"
				+ gameList);
		// assert youxi number
		if (gameList != null) {
			expctNum = gameList.size() - 1;

		}
		if (actualResult != null || actualResult != "") {
			actualNum = JSONUtil.getSizeofJson(actualResult, "playGameList");
		}

		SimpleLogger.logInfo(this.getClass(), "=====expectNum:" + expctNum);
		SimpleLogger.logInfo(this.getClass(), "=====actualNum:" + actualNum);

		Assert.assertEquals(actualNum, expctNum); ///bug，暂时未修复
		SimpleLogger.logInfo(this.getClass(),
				"=====gamelist:" + gameList.toString());
		ResultCompare rc = new ResultCompare();
		String actualGameId="";
		String expectGameId="";
		
		if (actualNum != 0) {
			// assert youxi info
			
			for (int i = 0; i < expctNum; i++) {
				if (i<actualNum) {
					actualGameId = JSONUtil.getStrFromJson(actualResult,
							"playGameList|_all_|$" + i + "|id");
					SimpleLogger.logInfo(this.getClass(), "=====actualGameId:"
							+ actualGameId);
				}
				
				expectGameId = rc
						.getListValue(i + 1, gameList, "gameId").toString();
				SimpleLogger.logInfo(this.getClass(), "=====expectGameId:"
						+ expectGameId);
				Assert.assertEquals(actualGameId, expectGameId);  

			}
		}

	}

	@AssertStepMethodDesc(description = "loadGame_noParameter", owner = "wangjing01")
	public void loadGame_assert(String parameterID, String expectresult,
			String actualresult) throws Exception {

		this.parameterID = parameterID;
		this.actualResult = actualresult;
		this.loadGame_assertgameList();
		this.loadGame_assertrecommendGameList();
		this.loadGame_assertplayGameList();
		this.loadGame_assertplatDesc();

	}

	@AssertStepMethodDesc(description = "loadGame_assert_offline", owner = "wangjing01")
	public void loadGame_assert_offline(String parameterID,
			String expectresult, String actualresult) throws Exception {
		Assert.assertFalse(actualresult.contains("478"));
		this.loadGame_assert(parameterID, expectresult, actualresult);

	}

	@AssertStepMethodDesc(description = "loadGame_assert_online", owner = "wangjing01")
	public void loadGame_assert_online(String parameterID, String expectresult,
			String actualresult) throws Exception {
		Assert.assertTrue(actualresult.contains("478"));
		this.loadGame_assert(parameterID, expectresult, actualresult);

	}

	@AssertStepMethodDesc(description = "loadGame_noParameter", owner = "wangjing01")
	public void loadGame_assert_nohistory(String parameterID,
			String expectresult, String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		loadGame_assertplayGameList_noRecord(parameterID, expectresult,
				actualresult);
		this.loadGame_assertgameList();
		this.loadGame_assertrecommendGameList();
		this.loadGame_assertplatDesc();
	}
	
	

	@SetupStepMethodDesc(description = "loadGame_nohistory", owner = "wangjing01")
	public void loadGame_nohistory(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.deleteUserGameRecord_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.deleteUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.deleteGamePlayerRecord_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}
	
	

	@SetupStepMethodDesc(description = "loadGame_history", owner = "wangjing01")
	public void loadGame_history(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.deleteUserGameRecord_tieba();
			this.insertUserGameRecord_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);
		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.deleteUserYouxiRecord_newyouxi();
			this.insertUserYouxiRecord_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.deleteGamePlayerRecord_bplat();
			this.insertGamePlayerRecord_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadGame_offline", owner = "wangjing01")
	public void loadGame_offline(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateWanbaGameOffline_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateWanbaGameOffline_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateWanbaGameOffline_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

	@SetupStepMethodDesc(description = "loadGame_online", owner = "wangjing01")
	public void loadGame_online(String parameterID) throws Exception {
		this.parameterID = parameterID;
		this.platFlag = MutilPlatUtil.getPlatFlag();
		if (platFlag == 4) {
			this.updateWanbaGameOnline_tieba();
			CacheFlush.cacheFlush(Constant.wanbaCacheFlush);

		} else if (platFlag == 8 || platFlag == 10 || platFlag == 6
				|| platFlag == 1) {
			this.updateWanbaGameOnline_newyouxi();
			CacheFlush.cacheFlush(Constant.newyouxiCacheFlush);
		} else if (platFlag == 2) {
			this.updateWanbaGameOnline_bplat();
			CacheFlush.cacheFlush(Constant.bplatCacheFlush);
		}

	}

}
