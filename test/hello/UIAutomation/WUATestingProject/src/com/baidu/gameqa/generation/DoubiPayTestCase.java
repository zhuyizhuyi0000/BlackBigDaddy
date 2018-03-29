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

public class DoubiPayTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void nihao() throws Exception{
		CaseExecutor executor = new WebUIStepsExecutor("DoubiPayTestCase.xml","Test01");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	@AfterTest
	public void afterTest()
	{
	   try 
	  {
		ProcessKiller.killProcess("iexplore.exe");
	  } catch (Exception e) 
	  {
		SimpleLogger.logInfo(this.getClass(),e.getMessage());
	  }
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

