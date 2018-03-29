package com.baidu.gameqa.generation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.WebUIStepsExecutor;
import com.baidu.gameqa.Gat.util.ProcessKiller;
import com.baidu.gameqa.Lib.common.SimpleLogger;

public class CreateLandingPageTestCase {
	@BeforeTest
	public void beforeTestMethod(){
	}
		
	@Test
	public void nihao() throws Exception{
		CaseExecutor executor = new WebUIStepsExecutor("CreateLandingPageTestCase.xml","Test01");
		executor.execute();
	}
	
	@AfterTest
	public void afterTest()
	{
	  /* try 
	  {
		ProcessKiller.killProcess("iexplore.exe");
	  } catch (Exception e) 
	  {
		SimpleLogger.logInfo(this.getClass(),e.getMessage());
		*/
	 }
	
}
