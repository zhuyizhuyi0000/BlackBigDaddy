package com.baidu.gameqa.iat.steps.common;


import java.util.HashMap;
import java.util.Map;

import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.iat.steps.common.*;
import com.baidu.gameqa.iat.steps.godoubi.GoDoubiCreateOrder;


public class GoDoubiSecurityUtil {

	public static Map<String,Object> paraMap = new HashMap<String,Object>();
	
	public static Map<String,Object> getPara(String parameterID) throws Exception{
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		GoDoubiCreateOrder store = new GoDoubiCreateOrder();
		paraMap.put("userid", parameter.getValue("userid"));
		paraMap.put("username", parameter.getValue("username"));
		paraMap.put("sp_no", parameter.getValue("sp_no"));
		paraMap.put("amount", parameter.getValue("amount"));
		paraMap.put("uu_id", parameter.getValue("uu_id"));
		paraMap.put("return_url", parameter.getValue("return_url"));
		paraMap.put("pre_amount", parameter.getValue("pre_amount"));
		paraMap.put("store_oid", store.getStoreoid());
		paraMap.put("bank_oid", parameter.getValue("bank_oid"));
		paraMap.put("pay_name", parameter.getValue("pay_name"));
		paraMap.put("return_attach", parameter.getValue("return_attach"));
		paraMap.put("server_id", parameter.getValue("server_id"));
		paraMap.put("game_id", parameter.getValue("game_id"));
		paraMap.put("create_time", parameter.getValue("create_time"));
	
		
		
		String sign = GoDoubiSignatureUtil.SignatureParams(paraMap,"890wqhbv6ftc5f3c","UTF-8");
		
		System.out.println("my sign is :" + sign );
		return paraMap;
	}
	

	public static String getFF14CodePara(Map paraMap) throws Exception{
		
		String sign = GoDoubiSignatureUtil.SignatureParams(paraMap,"890wqhbv6ftc5f3c","UTF-8");
		
		System.out.println("my sign is :" + sign );
		return sign;
	}
	
    public static String getPara(Map paraMap) throws Exception{
		
		String sign = GoDoubiSignatureUtil.SignatureParams(paraMap,"890wqhbv6ftc5f3c","UTF-8");
		
		System.out.println("my sign is :" + sign );
		return sign;
	}
	
    public static String getPlatAJspPara(Map paraMap) throws Exception{
    	
    	SimpleLogger.logInfo("paraMap:" + paraMap);
    	
    	//参数不参加签名
    	paraMap.remove("user_ip");
    	paraMap.remove("product_code");
    	paraMap.remove("product_number");
    	
    	SimpleLogger.logInfo("paraMap new :" + paraMap);
		
		String sign = GoDoubiSignatureUtil.SignatureParams(paraMap,"890wqhbv6ftc5f3c","UTF-8");
		
		System.out.println("my sign is :" + sign );
		return sign;
	}
	
	public static String geyMd5(){
		
		return GoDoubiSignatureUtil.SignatureParams(paraMap,"890wqhbv6ftc5f3c","UTF-8");
	}

}
