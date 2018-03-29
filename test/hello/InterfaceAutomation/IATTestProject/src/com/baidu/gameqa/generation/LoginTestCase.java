package com.baidu.gameqa.generation;


	import org.testng.annotations.Test;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import com.baidu.gameqa.Gat.executor.CaseExecutor;
	import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
	import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

	public class LoginTestCase {

		@BeforeTest
		public void beforeTestMethod(){
		}
		
		@BeforeMethod
		public void beforeMethod(){
		}
		
		
		@Test
		public void Login_Case01() throws Exception{
			CaseExecutor executor = new InterfaceStepsExecutor("LoginTestCase.xml","Login_Case01");
			executor.execute();
		}
		
		@Test
		public void Login_Case02() throws Exception{
			CaseExecutor executor = new InterfaceStepsExecutor("LoginTestCase.xml","Login_Case02");
			executor.execute();
		}
		
		@AfterMethod
		public void afterMethod(){
		}
		
		@AfterClass
		public void afterClassMethod(){
		}
	}

