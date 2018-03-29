package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class RegisterwithInviteCodeTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void RegisterGameUser_success() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("RegisterwithInviteCodeTestCase.xml","Test01");
		executor.execute();
	}
	
	@Test
	public void RegisterGameUser_NoInviteCode() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("RegisterwithInviteCodeTestCase.xml","Test02");
		executor.execute();
	}
	
	@Test
	public void RegisterGameUser_existeduser() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("RegisterwithInviteCodeTestCase.xml","Test03");
		executor.execute();
	}
	
	@Test
	public void RegisterGameUser_differentrepass() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("RegisterwithInviteCodeTestCase.xml","Test04");
		executor.execute();
	}	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

