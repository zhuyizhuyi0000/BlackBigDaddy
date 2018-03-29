package com.baidu.gameqa.iat.steps.common; 

import java.util.HashMap;

import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/** 
 * 封装一下常用的几个HttpUnit操作
 * PS：
 * 我实在不想每次在写请求时都要反复写同一段代码，so，我就这样写了
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月22日 下午8:03:23 
 */
public class WebConversationUtils {
	
	/**
	 * 获取WebResponse对象
	 * @param url
	 * @param httpMethod
	 * @param urlParamMap
	 * @return
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午8:08:23
	 */
	public static WebResponse getWebResponse(String url, 
			String httpMethod,
			HashMap<String, String> urlParamMap) throws Exception {
		WebConversation webConversation = HttpUnitHelper.createConversation();
		WebRequest curReq = HttpUnitHelper.createWebRequest(url, httpMethod);
		
		if(urlParamMap.size() != 0) {
			HttpUnitHelper.setParameters(curReq, urlParamMap);
		}
		WebResponse curResp = webConversation.getResource(curReq);
		
		return curResp;
	}
}
 