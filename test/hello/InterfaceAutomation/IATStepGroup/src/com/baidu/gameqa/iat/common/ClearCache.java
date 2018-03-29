package com.baidu.gameqa.iat.common;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class ClearCache {
	
	@StepMethodDesc(description = "clear cache", owner = "xiuping.qi")
	public static void  clearCache(String url) throws Exception {
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(url,"GET");
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
	}
	
}
