package com.baidu.gameqa.iat.steps.FF14;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValueHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.ClearCache;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.constant.MemcacheYun1FlushUrl;
import com.baidu.gameqa.iat.steps.common.ActualResultJSON;
import com.baidu.gameqa.iat.steps.common.BASE64Utils;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.baidu.gameqa.iat.steps.common.SqlResult;
import com.google.gson.Gson;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class FF14QueryUseridSteps {
	
	@StepMethodDesc(description = "", owner = "xiuping.qi")
	public void getCaseData(String parameterID) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		StepValueHelper.putStepOutputValue("loginName", parameter.getValue("loginName"));
		StepValueHelper.putStepOutputValue("userId", parameter.getValue("userId"));
		StepValueHelper.putStepOutputValue("userType", parameter.getValue("userType"));
	}
	
	@StepMethodDesc(description = "set DB client_game_user_login_record", owner = "xiuping.qi")
	public void setDB(String parameterID) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);		
		String loginName = (String) StepValueHelper.getStepOutputValue("loginName");
		String userId = (String) StepValueHelper.getStepOutputValue("userId");
		String userType = (String) StepValueHelper.getStepOutputValue("userType");
		String sql = parameter.CommandText;
		sql = processInsertSql(sql, userId, loginName, userType);		
		parameter.CommandText = sql;
		
		SqlResult sr = new SqlResult();
		String str = sr.doSql(parameter);
		SimpleLogger.logInfo(this.getClass(),"dosql result:"+str);
		
		ClearCache.clearCache(MemcacheYun1FlushUrl.NEWYOUXI);
	}
	
	@StepMethodDesc(description = "doFF14QueryUseridWithWrongLoginName", owner = "xiuping.qi")
	public void doFF14QueryUserid_201(String parameterID) throws Exception{
		doFF14QueryUserid(parameterID, "201");
	}
	
	@StepMethodDesc(description = "doFF14QueryUserid", owner = "xiuping.qi")
	public void doFF14QueryUserid_200(String parameterID) throws Exception {
		doFF14QueryUserid(parameterID, "200");
	}
	
	@AssertStepMethodDesc(description = "assertResult", owner = "xiuping.qi")
	public void assertResult(String parameterID) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		String actualResult = (String) StepValueHelper.getStepOutputValue("actualResult");
		System.out.println("actualResult is : "+actualResult);
		String actualStatus = JSONUtil.getJsonElement("status", actualResult);
		if(actualStatus.equals("200")){
			SimpleLogger.logInfo(this.getClass(),"message actualResult:"+JSONUtil.getJsonElement("message", actualResult));
			SimpleLogger.logInfo(this.getClass(),"message expectResult:ok");
			Assert.assertEquals(JSONUtil.getJsonElement("message", actualResult), "ok");
			
			SimpleLogger.logInfo(this.getClass(),"userId actualResult:"+JSONUtil.getJsonElement("body.userId", actualResult));
			SimpleLogger.logInfo(this.getClass(),"userId expectResult:" + StepValueHelper.getStepOutputValue("userId"));
			Assert.assertEquals(JSONUtil.getJsonElement("body.userId", actualResult), StepValueHelper.getStepOutputValue("userId"));
		}else if(actualStatus.equals("201")) {
			Assert.assertEquals(JSONUtil.getJsonElement("status", actualResult), "201");
			
		}else{
			SimpleLogger.logInfo(this.getClass(),"status is not 200 or 201");
			Assert.assertEquals(0, 1);
		}
	}
	
	private void doFF14QueryUserid(String parameterID, String status) throws Exception {
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation=HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
		HashMap<String, String> urlParameters=parameter.getURLParametersMap();
		
		if(status.equals("200")){
//			urlParameters.put("loginName", URLEncoder.encode((String) StepValueHelper.getStepOutputValue("loginName"), "UTF-8"));
			String loginName = (String)StepValueHelper.getStepOutputValue("loginName");
			loginName = BASE64Utils.encode(loginName.getBytes("UTF-8"));
			urlParameters.put("loginName", loginName);
		}else if (status.equals("201")){
			urlParameters.put("loginName", URLEncoder.encode("koko", "UTF-8"));
		}
				
		String sign = getFF14QueryUseridSign(
				URLEncoder.encode(urlParameters.get("loginName"),"UTF-8"), 
						urlParameters.get("appKey"), 
						urlParameters.get("random"));
		urlParameters.put("sign",sign);
		if(urlParameters.size()!=0)
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);	         
	    }	   
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);		
		String actualResult = currentResponse.getText();
				
		StepValueHelper.putStepOutputValue("actualResult", actualResult);
	}
	
	private String processInsertSql(String sql, String userId, String loginName,String userType ) throws Exception{
		sql = sql.replace("{userId}", userId);
		sql = sql.replace("{loginName}", loginName);
		sql = sql.replace("{userType}", userType);
		return sql;

	}
	
	private String getFF14QueryUseridSign(String loginName, String appKey, String random ) throws Exception{
		 String[] params = new String[] {loginName, appKey, random, "ff14_bdyx_goon"};
		 Arrays.sort(params);
		 String paramStr = "";
		 for(int i=0; i < params.length; i++) {
			 paramStr += params[i];
		 }
		 String sign = DigestUtils.shaHex(paramStr);
		 
		 return sign;
	}
}
