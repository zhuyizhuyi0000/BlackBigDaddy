package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Member__memberInfo {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void Test01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.memberInfo.Test01");
		executor.execute();
	}
	
	@Test
	public void Test02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.memberInfo.Test02");
		executor.execute();
	}
	
	@Test
	public void Test03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.memberInfo.Test03");
		executor.execute();
	}
	
	@Test
	public void Test04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.memberInfo.Test04");
		executor.execute();
	}
	
	@Test
	public void Test05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.memberInfo.Test05");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

