package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__validaterole {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void validateroleTest01() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.validaterole.validateroleTest01");
		executor.execute();
	}

	@Test
	public void validateroleTest02() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.validaterole.validateroleTest02");
		executor.execute();
	}

	@Test
	public void validateroleTest03() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.validaterole.validateroleTest03");
		executor.execute();
	}

	@Test
	public void validateroleTest04() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.validaterole.validateroleTest04");
		executor.execute();
	}
	

	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}