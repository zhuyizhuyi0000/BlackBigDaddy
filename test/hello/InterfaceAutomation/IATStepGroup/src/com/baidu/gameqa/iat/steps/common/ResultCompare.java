package com.baidu.gameqa.iat.steps.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.gameqa.Lib.common.SimpleLogger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ResultCompare {
	
	public String getListValue(int index, List<List<String>> list, String key) {
		Map<String, String> resultmap = new HashMap<String, String>();
		if (list.size() > 1) {
			for (int j = 0; j < list.get(0).size(); j++) {
				if (index < list.size() && index > 0) {
					resultmap.put(list.get(0).get(j), list.get(index).get(j));
				} else {
					SimpleLogger.logInfo("sqlresult is overflow");
				}
			}
		}

		return resultmap.get(key);
	}

	//针对此种格式json做处理，{"jsonKey":[{"key1":"value1","key2":"value2"}]}
	public String getJsonStringValue(int index, String jsonKey,
			String urlresult, String key) {
		String actualresult = null;
		JSONObject json = JSONObject.fromObject(urlresult);
		String a = json.getString(jsonKey);
		SimpleLogger.logInfo("a is ------"+a);
		if (a != null&& a !="[]") {
			JSONArray myJsonArray = JSONArray.fromObject(a);
			if (index < myJsonArray.size() && index >= 0) {
				actualresult = myJsonArray.getJSONObject(index).getString(key);
			} else {
				SimpleLogger.logInfo("actualresult is overflow or null");
			}
		}
		return actualresult;
	}

}
