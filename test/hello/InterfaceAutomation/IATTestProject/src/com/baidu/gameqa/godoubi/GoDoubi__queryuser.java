package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__queryuser {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void queryuserTest01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.queryuser.queryuserTest01");
		executor.execute();
	}

	@Test
	public void queryuserTest02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.queryuser.queryuserTest02");
		executor.execute();
	}
	
	@Test
	public void queryuserTest03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.queryuser.queryuserTest03");
		executor.execute();
	}
	
	@Test
	public void queryuserTest04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.queryuser.queryuserTest04");
		executor.execute();
	}


	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

