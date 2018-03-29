package com.baidu.gameqa.cbgmsg;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class CBGmsg__closemsg {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void closemsg01() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.closemsg.closemsg01");
		executor.execute();
	}

	@Test
	public void closemsg02() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.closemsg.closemsg02");
		executor.execute();
	}

	@Test
	public void closemsg03() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.closemsg.closemsg03");
		executor.execute();
	}

	@Test
	public void closemsg04() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.closemsg.closemsg04");
		executor.execute();
	}
	
	@Test
	public void closemsg05() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"CBGmsg.closemsg.closemsg05");
		executor.execute();
	}
	

	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
