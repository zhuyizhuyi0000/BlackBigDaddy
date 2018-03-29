package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Member__sign {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void case01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.sign.case01");
		executor.execute();
	}
	
	@Test
	public void case02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.sign.case02");
		executor.execute();
	}
	
	@Test
	public void case03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.sign.case03");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

