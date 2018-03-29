package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__calculatePreferentialAmount {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void calculatePreferentialAmount01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.calculatePreferentialAmount.calculatePreferentialAmount01");
		executor.execute();
	}
	
	@Test
	public void calculatePreferentialAmount02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.calculatePreferentialAmount.calculatePreferentialAmount02");
		executor.execute();
	}
	
	@Test
	public void calculatePreferentialAmount03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.calculatePreferentialAmount.calculatePreferentialAmount03");
		executor.execute();
	}
	
	@Test
	public void calculatePreferentialAmount04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.calculatePreferentialAmount.calculatePreferentialAmount04");
		executor.execute();
	}
	
	@Test
	public void calculatePreferentialAmount05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.calculatePreferentialAmount.calculatePreferentialAmount05");
		executor.execute();
	}
	
	@Test
	public void calculatePreferentialAmount06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.calculatePreferentialAmount.calculatePreferentialAmount06");
		executor.execute();
	}
	
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

