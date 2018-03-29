package com.baidu.gameqa.iat.steps.common;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;

public class CacheFlush {

	@StepMethodDesc(description = "", owner = "wangjing01")
	public static void cacheFlush(String cacheStr) throws Exception {

		WebConversation currentConversation = HttpUnitHelper
				.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(cacheStr,
				"GET");

		currentConversation.sendRequest(currentRequest);

		SimpleLogger.logInfo("=====cacheFlush ok:" + cacheStr);
	}

}
