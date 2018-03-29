package com.baidu.gameqa.generation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

/**
 * 九鼎客户端LogM接口Steps Executor
 * 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月19日 下午7:55:27
 */
public class JDLogMSteps {
	
	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}
	
	@Test
	public void logMTestCase01() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDLogMTestCase.xml", "JDLogM_QACase01");
		executor.execute();
	}
	
	@Test
	public void logMTestCase02() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDLogMTestCase.xml", "JDLogM_QACase02");
		executor.execute();
	}
	
	@Test
	public void logMTestCase03() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDLogMTestCase.xml", "JDLogM_QACase03");
		executor.execute();
	}
	
	@Test
	public void logMTestCase04() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDLogMTestCase.xml", "JDLogM_QACase04");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
