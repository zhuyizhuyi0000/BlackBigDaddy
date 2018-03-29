package com.baidu.gameqa.iat.steps.member;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.steps.common.ResultCompare;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class MemberDuanyouSteps {
	@AssertStepMethodDesc(description = "duanyou", owner = "xiuping.qi")
	public void duanyouSearch(String parameterID, String expectresult,
			String actualresult) throws Exception {
	
		JSONObject actualStep1 = JSONObject.fromObject(actualresult);
		Assert.assertEquals(actualStep1.getString("result"), "1");
		
	}
}
