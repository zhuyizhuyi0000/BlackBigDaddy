package com.baidu.gameqa.FF14;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class FF14HistoryTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}	
	
	@Test
	public void FF14HistoryPostTest() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14HistoryTestCase.xml","ff14_history_post");
		executor.execute();
	}
	
	@Test
	public void FF14HistoryGetTest() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14HistoryTestCase.xml","ff14_history_get");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

