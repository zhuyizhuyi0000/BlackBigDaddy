package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Member__Query_Personal_Growth {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void TestCase01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.Query_Personal_Growth.TestCase01");
		executor.execute();
	}
	
	@Test
	public void TestCase02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.Query_Personal_Growth.TestCase02");
		executor.execute();
	}
	
	@Test
	public void TestCase03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.Query_Personal_Growth.TestCase03");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

