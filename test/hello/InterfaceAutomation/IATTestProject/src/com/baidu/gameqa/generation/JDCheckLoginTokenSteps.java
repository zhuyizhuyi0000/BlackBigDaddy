package com.baidu.gameqa.generation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

/**
 * 九鼎客户端checkLoginToken Steps Executor
 * @author yanglei12
 *
 */
public class JDCheckLoginTokenSteps {
	
	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}
	
	@Test
	public void testClientLoginQA_Case1() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDCheckLoginTokenTestCase.xml", "JDCheckLoginToken_QACase1");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case2() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDCheckLoginTokenTestCase.xml", "JDCheckLoginToken_QACase2");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case3() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDCheckLoginTokenTestCase.xml", "JDCheckLoginToken_QACase3");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
