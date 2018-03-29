package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Member__Task_InviteCode {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void MemberTask_Invitecode_Test01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.Task_InviteCode.MemberTask_Invitecode_Test01");
		executor.execute();
	}
	
	@Test
	public void MemberTask_Invitecode_Test02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.Task_InviteCode.MemberTask_Invitecode_Test02");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

