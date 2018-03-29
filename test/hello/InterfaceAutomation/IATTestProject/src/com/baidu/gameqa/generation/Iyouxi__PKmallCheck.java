package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Iyouxi__PKmallCheck {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void check1() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Iyouxi.PKmallCheck.check1");
		executor.execute();
	}
	
	@Test
	public void check2() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Iyouxi.PKmallCheck.check2");
		executor.execute();
	}
	
	@Test
	public void check3() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Iyouxi.PKmallCheck.check3");
		executor.execute();
	}
	
	@Test
	public void check4() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Iyouxi.PKmallCheck.check4");
		executor.execute();
	}
	
	@Test
	public void check5() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Iyouxi.PKmallCheck.check5");
		executor.execute();
	}
	
	@Test
	public void check6() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Iyouxi.PKmallCheck.check6");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

