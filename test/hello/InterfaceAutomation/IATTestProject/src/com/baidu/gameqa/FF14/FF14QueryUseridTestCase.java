package com.baidu.gameqa.FF14;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class FF14QueryUseridTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}	
	
	@Test
	public void FF14QueryUseridTest_enQuick() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14QueryUseridTestCase.xml","enQuick");
		executor.execute();
	}
	
	@Test(enabled = false)
	public void FF14QueryUseridTest_znQuick() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14QueryUseridTestCase.xml","znQuick");
		executor.execute();
	}
	
	@Test
	public void FF14QueryUseridTest_enPass() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14QueryUseridTestCase.xml","enPass");
		executor.execute();
	}
	
	@Test(enabled = false)
	public void FF14QueryUseridTest_znPass() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14QueryUseridTestCase.xml","znPass");
		executor.execute();
	}
	
	@Test
	public void FF14QueryUseridTest_201() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("FF14/FF14QueryUseridTestCase.xml","201");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}
