package com.baidu.gameqa.iat.common;

import bsh.This;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	
	public static String getStrFromJson(String jsonString,String dataStr){
		JSONObject jsonObject=null;
		JSONArray jsonArray=null;
		String tmpStr=jsonString;
		
		String[] strArr=dataStr.split("\\|");
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].equals("_all_")){
				jsonArray = JSONArray.fromObject(tmpStr);
				if (strArr[i+1].startsWith("$")) {
					
					Integer id=Integer.parseInt(strArr[i+1].substring(1));
					tmpStr= jsonArray.getString(id);
					i++;
				}
				
			}else{
				jsonObject = JSONObject.fromObject(tmpStr);
				tmpStr= jsonObject.getString(strArr[i]);
			}
		}
		return tmpStr;
	} 
	
	
	public static int getSizeofJson(String jsonString,String dataStr){
		String jsonStr=JSONUtil.getStrFromJson(jsonString, dataStr);
		int size=0;
		JSONObject jsonObject=null;
		JSONArray jsonArray=null;
		
		if (jsonStr.startsWith("{")) {
			jsonObject = JSONObject.fromObject(jsonStr);
			if (jsonObject != null) {
				size = jsonObject.size();
			}else {
				size=0;
			}
			
		} else if (jsonStr.startsWith("[")){
			jsonArray = JSONArray.fromObject(jsonStr);
			if (jsonArray != null) {
				size = jsonArray.size();
			}else {
				size=0;
			}
			
		}
		
		return size;
	}
	
	/**
	 * 
	 * @param elementKey
	 * @param actualresult
	 * @return
	 * @author  xiuping.qi
	 */
	public static String getJsonElement(String elementKey, String json){
		String elementValue = json;
		String elementKeys[] = elementKey.split("\\.");
		for (String key:elementKeys) {
			JSONObject jo = JSONObject.fromObject(elementValue);
			elementValue = jo.getString(key);
		}
		return elementValue;
	}
	 
	
	public static void main(String[] args) {
//		String jsonString = "{gamelist:{ABC:[{id:478,name:\"热血战记\"},{id:4755,name:\"但大头www\"}],DEF:[{id:108,name:\"弹弹堂\"}],DEFfff:[{id:108,name:\"弹弹堂\"}],YZ:[]},recomlist:[{id:888,name:\"发发发\"},{id:999,name:\"九九九\"}],ratio:\"123\"}";
//		String jsonString = "{gamelist:{id:478,name:\"热血战记\"},{id:4755,name:\"但大头www\"}],DEF:[{id:108,name:\"弹弹堂\"}],DEFfff:[{id:108,name:\"弹弹堂\"}],YZ:[]},recomlist:[{id:888,name:\"发发发\"},{id:999,name:\"九九九\"}],ratio:\"123\"}";
//		
		
//		String dataStr="gamelist|ABC|_all_|id";
//		String dataStr1="gamelist|ABC";
//		String dataStr2="gamelist|YZ";
//		String dataStr2="recomlist";
//		String dataStr3="recomlist|_all_|";
//		String dataStr4="recomlist|_all_|$1|name";
//		String dataStr5="gamelist|DEF|";
//		
//		
////		JSONUtil jsonUtil = new JSONUtil();
//		System.out.println("str:"+JSONUtil.getStrFromJson(jsonString, dataStr2));
////		
//		System.out.println("size"+JSONUtil.getSizeofJson(jsonString, dataStr2));
//		JSONObject jsObject=JSONObject.fromObject(jsonString);
//		System.out.println("111111111111 gamelist:" + jsObject.get("gamelist"));
//		
//		
//		
//		JSONObject jsObject2=JSONObject.fromObject(jsObject.get("gamelist"));
//		System.out.println("111111111111 ABC :" + jsObject2.get("ABC"));
//		
//		
//		JSONArray jsArray = JSONArray.fromObject(jsObject2.get("ABC"));
//		System.out.println("111111111111 id=478 :" + jsArray.get(0));
//		System.out.println("111111111111 id=4755 :" + jsArray.get(1));
//		JSONArray actualrs = JSONArray.fromObject(jsonString);
//
//		System.out.println("111111111111" + actualrs.getString(0));
//		System.out.println("222222222222" + actualrs.getString(1));
//
//		JSONObject actObject = JSONObject.fromObject(actualrs.getString(0));
//		System.out.println("111111111111 adId" + actObject.getString("adId"));
//		System.out.println("111111111111 tagtype"
//				+ actObject.getString("tagtype"));
//		JSONObject actObject2 = JSONObject.fromObject(actualrs.getString(1));
//		System.out.println("2222222222 adId" + actObject2.getString("adId"));
//		System.out.println("2222222222 tagtype"
//				+ actObject2.getString("tagtype"));

		// System.out.println("11111 adid 0 111"+actualrs.getJSONArray(0).getString("adId"));
		// System.out.println("11111 adid 1 111"+actualrs.getJSONArray(1).getString("adId"));
	}
}
