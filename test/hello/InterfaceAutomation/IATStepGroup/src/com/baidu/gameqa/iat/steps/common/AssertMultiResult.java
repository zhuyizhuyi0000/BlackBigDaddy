package com.baidu.gameqa.iat.steps.common;

import java.util.Map;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;

/**
 * 封装多个期望结果的断言方法
 * 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月22日 下午8:21:27
 */
public class AssertMultiResult {

	/**
	 * 常用多个expected结果的断言方法
	 * 
	 * @param parameters
	 * @param actualResult
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午10:16:19
	 */
	public static void assertResult(InterfaceStepParameter parameters,
			String actualResult) throws Exception {
		// for simple local debug
		System.out.println("......" + actualResult);

		if (parameters.getValue("assertType").equals("contains")) {
			String expectedResult = parameters.getValue("expectedResult");
			String expectedResult_Many = parameters
					.getValue("expectedResult_1");
			if (!expectedResult_Many.isEmpty()) {
				if (actualResult.contains(expectedResult)) {
					Assert.assertTrue(actualResult.contains(expectedResult));
				} else if (actualResult.contains(expectedResult_Many)) {
					Assert.assertTrue(actualResult
							.contains(expectedResult_Many));
				} else {
					Assert.assertTrue(actualResult.contains(expectedResult));
				}
			} else {
				Assert.assertTrue(actualResult.contains(expectedResult));
			}
		} else {
			Assert.assertFalse(true);
		}
	}

	/**
	 * 单个expected结果的断言，可以传入需要断言的预期结果和实际结果
	 * @param parameters
	 * @param actualResult
	 * @param expectedResult
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月27日 下午1:55:46
	 */
	public static void assertWithParameter(InterfaceStepParameter parameters,
			String actualResult, String expectedResult) throws Exception {

		// for simple local debug
		System.out.println("......" + actualResult);

		if (parameters.getValue("assertType").equals("contains")) {
			Assert.assertTrue(actualResult.contains(expectedResult));
		} else {
			Assert.assertFalse(true);
		}
	}

	/**
	 * 种植cookie的断言方法可以是多个cookie断言
	 * 
	 * @param parameters
	 * @param cookiesActualMap
	 * @throws Exception
	 * @author yanglei12
	 * @date 2014年5月22日 下午10:18:50
	 */
	public static void assertCookieResult(InterfaceStepParameter parameters,
			Map<String, String> cookiesActualMap) throws Exception {
		if (parameters.getValue("wanba_cookies").equals("not null")) {
			Assert.assertNotNull(cookiesActualMap.get("wanba_cookies"));
		} else if (parameters.getValue("USERID").equals("not null")) {
			Assert.assertNotNull(cookiesActualMap.get("USERID"));
		} else if (parameters.getValue("BDUSS").equals("not null")) {
			Assert.assertNotNull(cookiesActualMap.get("BDUSS"));
		} else if (parameters.getValue("wanba_cookies").equals("null")) {
			Assert.assertNull(cookiesActualMap.get("wanba_cookies"));
		} else if (parameters.getValue("BDUSS").equals("null")) {
			Assert.assertNull(cookiesActualMap.get("BDUSS"));
		} else if (parameters.getValue("USERID").equals("null")) {
			Assert.assertNull(cookiesActualMap.get("USERID"));
		} else {
			Assert.assertFalse(true);
		}
	}
}
