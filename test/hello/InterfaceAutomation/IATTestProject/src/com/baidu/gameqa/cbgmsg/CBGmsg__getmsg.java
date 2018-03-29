package com.baidu.gameqa.cbgmsg;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class CBGmsg__getmsg {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void getmsg01() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.getmsg.getmsg01");
		executor.execute();
	}

//	@Test
//	//测试环境无法完成
//	public void getmsg02() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"CBGmsg.getmsg.getmsg02");
//		executor.execute();
//	}

	@Test
	public void getmsg03() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.getmsg.getmsg03");
		executor.execute();
	}

	@Test
	public void getmsg04() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.getmsg.getmsg04");
		executor.execute();
	}
	
//	@Test
	//测试环境无法完成
//	public void getmsg05() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"CBGmsg.getmsg.getmsg05");
//		executor.execute();
//	}
	
	@Test
	public void getmsg06() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.getmsg.getmsg06");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
