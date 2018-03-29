package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;
import com.beust.testng.TestNG;

public class Member__lottery_ajaxGetPrize {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void lottery01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase01");
		executor.execute();
	}
	
	@Test
	public void lottery02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase02");
		executor.execute();
	}
	
	@Test
	public void lottery03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase03");
		executor.execute();
	}
	
	@Test
	public void lottery04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase04");
		executor.execute();
	}
	
	@Test
	public void lottery05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase05");
		executor.execute();
	}
	
	@Test
	public void lottery06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase06");
		executor.execute();
	}
	
	@Test
	public void lottery07() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase07");
		executor.execute();
	}
	
	@Test
	public void lottery08() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase08");
		executor.execute();
	}
	
	@Test
	public void lottery09() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase09");
		executor.execute();
	}
	
	@Test
	public void lottery10() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase10");
		executor.execute();
	}
	
	@Test
	public void lottery11() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase11");
		executor.execute();
	}
	
	@Test
	public void lottery12() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase12");
		executor.execute();
	}
	
	@Test
	public void lottery13() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase13");
		executor.execute();
	}	

	@Test
	public void lottery14() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.lottery_ajaxGetPrize.TestCase14");
		Thread.sleep(5000);
		executor.execute();
	}
	
	private void Sleeper(int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

