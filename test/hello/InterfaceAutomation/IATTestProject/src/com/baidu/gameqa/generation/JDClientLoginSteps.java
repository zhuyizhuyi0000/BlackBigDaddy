package com.baidu.gameqa.generation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

/**
 * 九鼎客户端登录接口Steps Executor
 * 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月19日 下午7:55:27
 */
public class JDClientLoginSteps {
	
	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void testClientLoginQA_Case1() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase1");
		executor.execute();
	}
	
	/*@Test
	public void testClientLoginQA_Case2() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase2");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case3() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase3");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case4() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase4");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case5() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase5");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case6() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase6");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case7() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase7");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case8() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase8");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case9() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase9");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case10() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase10");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case11() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase11");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case12() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase12");
		executor.execute();
	}

	@Test
	public void testClientLoginQA_Case13() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase13");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case14() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase14");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case15() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase15");
		executor.execute();
	}

	@Test
	public void testClientLoginQA_Case16() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase16");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case17() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase17");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case18() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase18");
		executor.execute();
	}
	
	@Test
	public void testClientLoginQA_Case19() throws Exception {
		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase19");
		executor.execute();
	}*/
	
//	@Test
//	public void testClientLoginQA_Case20() throws Exception {
//		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase20");
//		executor.execute();
//	}
	
//	@Test
//	public void testClientLoginQA_Case21() throws Exception {
//		CaseExecutor executor = new InterfaceStepsExecutor("JDClientLoginTestCase.xml", "JDClientLogin_QACase21");
//		executor.execute();
//	}
	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
