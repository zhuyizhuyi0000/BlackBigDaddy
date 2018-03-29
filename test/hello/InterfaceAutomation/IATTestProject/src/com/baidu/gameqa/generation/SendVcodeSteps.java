package com.baidu.gameqa.generation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

/**
 * 短信登录获取验证码接口 API: /sso/sms/security/send_vcode.json
 * 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月29日 下午2:26:27
 */
public class SendVcodeSteps {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	// // send_vcode.json 使用正确手机号发送
	// @Test
	// public void testSendVcodeRD_Case1() throws Exception {
	// CaseExecutor executor = new InterfaceStepsExecutor(
	// "SendVcodeTestCase.xml", "SendVcode_Case01");
	// executor.execute();
	// }
	//
	// // send_vcode.json 使用格式错误的手机号发送
	// @Test
	// public void testSendVcodeRD_Case2() throws Exception {
	// CaseExecutor executor = new InterfaceStepsExecutor(
	// "SendVcodeTestCase.xml", "SendVcode_Case02");
	// executor.execute();
	// }
	//
	// // send_vcode.json 手机号为空
	// @Test
	// public void testSendVcodeRD_Case3() throws Exception {
	// CaseExecutor executor = new InterfaceStepsExecutor(
	// "SendVcodeTestCase.xml", "SendVcode_Case03");
	// executor.execute();
	// }
	//
	// // send_vcode.json 带正确的clientIp参数
	// @Test
	// public void testSendVcodeRD_Case4() throws Exception {
	// CaseExecutor executor = new InterfaceStepsExecutor(
	// "SendVcodeTestCase.xml", "SendVcode_Case04");
	// executor.execute();
	// }
	//
	// // send_vcode.json 带非法的clientIp参数
	// @Test
	// public void testSendVcodeRD_Case5() throws Exception {
	// CaseExecutor executor = new InterfaceStepsExecutor(
	// "SendVcodeTestCase.xml", "SendVcode_Case05");
	// executor.execute();
	// }
	//
	// // send_vcode.json clientIp参数为空
	// @Test
	// public void testSendVcodeRD_Case6() throws Exception {
	// CaseExecutor executor = new InterfaceStepsExecutor(
	// "SendVcodeTestCase.xml", "SendVcode_Case06");
	// executor.execute();
	// }

	// send_vcode.json 带pid参数
	@Test
	public void testSendVcodeRD_Case7() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor(
				"SendVcodeTestCase.xml", "SendVcode_Case07");
		executor.execute();
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
