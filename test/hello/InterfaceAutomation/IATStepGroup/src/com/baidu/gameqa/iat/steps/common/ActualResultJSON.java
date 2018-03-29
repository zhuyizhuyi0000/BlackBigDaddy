package com.baidu.gameqa.iat.steps.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.baidu.gameqa.Gat.dataobject.SetupStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Gat.util.StepValueHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.Lib.httpunitService.HttpUnitHelper;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public  class  ActualResultJSON {

	public ActualResultJSON()
	{
		// TODO Auto-generated constructor stub
	}
		
	
	@StepMethodDesc(description = "get Actualresult Element", owner = "xiuping.qi")
	public String getActualresultElement(String Element, String actualresult){
		
		JSONObject actualresultJSON = JSONObject.fromObject(actualresult);
		String actualresultElement = actualresultJSON.getString(Element);
		return actualresultElement;
		
	}
	
}
