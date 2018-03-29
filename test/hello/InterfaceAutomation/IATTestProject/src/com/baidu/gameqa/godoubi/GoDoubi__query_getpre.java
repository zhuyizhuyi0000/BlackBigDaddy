package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__query_getpre {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void queryGetpre01() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.queryGetpre.queryGetpre01");
		executor.execute();
	}

	@Test
	public void queryGetpre02() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.queryGetpre.queryGetpre02");
		executor.execute();
	}

	@Test
	public void queryGetpre03() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.queryGetpre.queryGetpre03");
		executor.execute();
	}

	@Test
	public void queryGetpre04() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.queryGetpre.queryGetpre04");
		executor.execute();
	}


	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
