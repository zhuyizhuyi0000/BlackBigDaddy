package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Sso__innerLoginQa {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void loginQa01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa01");
		executor.execute();
	}
	
	@Test
	public void loginQa02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa02");
		executor.execute();
	}
	
	@Test
	public void loginQa03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa03");
		executor.execute();
	}
	
	@Test
	public void loginQa04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa04");
		executor.execute();
	}
	
	@Test
	public void loginQa05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa05");
		executor.execute();
	}
	
	@Test
	public void loginQa06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa06");
		executor.execute();
	}
	
	@Test
	public void loginQa07() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa07");
		executor.execute();
	}
	
	@Test
	public void loginQa08() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa08");
		executor.execute();
	}
	
	@Test
	public void loginQa09() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Sso.innerLoginQa.loginQa09");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

