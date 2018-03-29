package com.baidu.gameqa.iat.steps.gameRolePost;


import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.iat.common.MD5;
import com.baidu.gameqa.iat.steps.common.SqlResult;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class gameRolePostSteps {

	@StepMethodDesc(description = "do game_role_post.xhtml", owner = "xiuping.qi")
	public void doGameRolePost(String parameterID) throws Exception {

		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		WebConversation currentConversation = HttpUnitHelper.createConversation();
		WebRequest currentRequest = HttpUnitHelper.createWebRequest(parameter.getValue("url"), parameter.getValue("httpmethod"));
				
		// role_name url.encode
		String role_name = URLEncoder.encode(parameter.getURLParametersMap().get("role_name"),"utf-8").toLowerCase();
		parameter.updateURLParameters("role_name", role_name);
				
		// sign
		String sign = this.getSign(parameter);
		parameter.updateURLParameters("sign", sign);

		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
	    if(urlParameters.size()!=0)	
	    {
	         HttpUnitHelper.setParameters(currentRequest,urlParameters);	         
	    }	   
		WebResponse currentResponse=currentConversation.getResponse(currentRequest);
		System.out.println(currentResponse.getText());
		
		Assert.assertEquals("recive ok", currentResponse.getText());

	}

	@StepMethodDesc(description = "get post sign", owner = "xiuping.qi")
	public String getSign(InterfaceStepParameter parameter) throws Exception {
		
		HashMap<String, String> urlParameters = parameter.getURLParametersMap();
		//get app_secret
		String app_secret = this.getAppSecretWithApikey(parameter);
		String toSign = app_secret + this.getToSignTmp(urlParameters);
		SimpleLogger.logInfo(this.getClass(),"toSign is:"+toSign );
		
		String sign = MD5.md5(toSign,32).toUpperCase();
		SimpleLogger.logInfo(this.getClass(),"sign is:"+sign );
		
		return sign;
	}
	
	@StepMethodDesc(description = "get tosign", owner = "xiuping.qi")
	public String getToSignTmp(HashMap<String, String> urlParameters) {

		String toSignTmp = "";
		Collection<String> keyset = urlParameters.keySet();
		List<String> list = new ArrayList<String>(keyset);
		// 对key键值按字典升序排序
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			toSignTmp = toSignTmp + list.get(i) + urlParameters.get(list.get(i)).trim();   //trim 去掉前后空格
		}

		return toSignTmp;
	}
	
	@StepMethodDesc(description = "get app_secret ", owner = "xiuping.qi")
	public String getAppSecretWithApikey(InterfaceStepParameter parameter) throws Exception {

		String api_key = parameter.getURLParametersMap().get("api_key");
		parameter.CommandText = parameter.CommandText + api_key + "'";
		
		SqlResult sr = new SqlResult();
		String app_secret = sr.getSqlResultElement(parameter, "app_secret");

		return app_secret;
	}

}
