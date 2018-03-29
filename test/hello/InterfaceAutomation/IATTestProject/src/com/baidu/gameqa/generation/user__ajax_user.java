package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class user__ajax_user {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void ajaxuser01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("user.ajax_user.ajaxuser01");
		executor.execute();
	}
	
	@Test
	public void ajaxuser02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("user.ajax_user.ajaxuser02");
		executor.execute();
	}
	
	@Test
	public void ajaxuser03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("user.ajax_user.ajaxuser03");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

