package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Member__lottery {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void lottery01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery01");
		executor.execute();
	}
	
	@Test
	public void lottery02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery02");
		executor.execute();
	}
	
	@Test
	public void lottery03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery03");
		executor.execute();
	}
	
	@Test
	public void lottery04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery04");
		executor.execute();
	}
	
	@Test
	public void lottery05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery05");
		executor.execute();
	}
	
	@Test
	public void lottery06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery06");
		executor.execute();
	}
	
	@Test
	public void lottery07() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery07");
		executor.execute();
	}
	
	@Test
	public void lottery08() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery08");
		executor.execute();
	}
	
	@Test
	public void lottery09() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery09");
		executor.execute();
	}
	
	@Test
	public void lottery10() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery10");
		executor.execute();
	}
	
	@Test
	public void lottery11() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery11");
		executor.execute();
	}
	
	@Test
	public void lottery12() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery.lottery12");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

