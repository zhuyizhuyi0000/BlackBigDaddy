package com.baidu.gameqa.cbgmsg;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class CBGmsg__setting {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

//	@Test
//	public void setting01() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"CBGmsg.setting.setting01");
//		executor.execute();
//	}

	@Test
	public void setting02() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.setting.setting02");
		executor.execute();
	}

//	@Test
//	public void setting03() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"CBGmsg.setting.setting03");
//		executor.execute();
//	}
//
//	@Test
//	public void setting04() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"CBGmsg.setting.setting04");
//		executor.execute();
//	}
//	
//	@Test
//	public void setting05() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"CBGmsg.setting.setting05");
//		executor.execute();
//	}
	

	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
