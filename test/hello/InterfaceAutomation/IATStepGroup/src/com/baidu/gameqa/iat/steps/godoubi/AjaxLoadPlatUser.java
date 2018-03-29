package com.baidu.gameqa.iat.steps.godoubi;


import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.iat.common.JSONUtil;

public class AjaxLoadPlatUser {
	private InterfaceStepParameter parameter = null;
	private String actualResult = "";

	@AssertStepMethodDesc(description = "LoadProduct_assert", owner = "wangjing01@")
	public void load_plat_user_assert(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.actualResult = actualresult;
		parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);

		// assert

		// assert platLogo
		String expect = parameter.getValue("platLogo");
		String actual = JSONUtil.getStrFromJson(actualResult,
				"platLogo");

		Assert.assertEquals(actual, expect);

		expect = parameter.getValue("gameMsg");
		actual = JSONUtil.getStrFromJson(actualResult,
				"gameMsg");

		Assert.assertEquals(actual, expect);
		
		expect = parameter.getValue("gamePage");
		actual = JSONUtil.getStrFromJson(actualResult,
				"gamePage");

		Assert.assertEquals(actual, expect);
		
		expect = parameter.getValue("ratioDesc");
		actual = JSONUtil.getStrFromJson(actualResult,
				"ratioDesc");

		Assert.assertEquals(actual, expect);
		
		expect = parameter.getValue("platDesc");
		actual = JSONUtil.getStrFromJson(actualResult,
				"platDesc");

		Assert.assertEquals(actual, expect);
		
		
		// assert code
		String codeActual = JSONUtil.getStrFromJson(actualResult, "code");
		Assert.assertEquals(codeActual, "0");

	}
}
