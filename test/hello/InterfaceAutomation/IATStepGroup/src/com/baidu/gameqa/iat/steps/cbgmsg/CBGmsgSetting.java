package com.baidu.gameqa.iat.steps.cbgmsg;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CBGmsgSetting {


	public String getSettingValue(String parameterID) throws Exception {
		MysqlProxy proxy = new MysqlProxy();
		HashMap<String, String> requestParameter = new HashMap<String, String>();
		InterfaceStepParameter parameter = (InterfaceStepParameter) ParameterHelper.getInterfaceStepParameter(parameterID);
		
		requestParameter.put("connectionString",parameter.getValue("settingDB"));
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password"));
		requestParameter.put("commandText", parameter.getValue("select_message_client_setting"));
		
		List<List<String>> sqlresult = proxy.executeQuery(requestParameter);
		
		ResultCompare rc = new ResultCompare();	
		String value = rc.getListValue(1,sqlresult, "value");
		
		return value;
	}
	@AssertStepMethodDesc(description = "setting_AssertDB", owner = "wangjing01")
	public void setting_AssertDB(String parameterID, String expectresult,
			String actualresult) throws Exception {
		
		
		
		
		SimpleLogger.logInfo(this.getClass(), "actualresult code:::"+JSONUtil.getStrFromJson(actualresult, "code"));
		
			Assert.assertEquals("200", JSONUtil.getStrFromJson(actualresult, "code"));

		String actualValueString =this.getSettingValue(parameterID);
		String expectValueString=expectresult.split("=")[1];
		Assert.assertEquals(expectValueString, actualValueString);
	}
	
	public static void main(String[] args) {
		String dataString="{\"code\":200},value=5";
		
		System.out.println(dataString.split("=")[1]);
	}

}
