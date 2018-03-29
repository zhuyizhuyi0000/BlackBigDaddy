package com.baidu.gameqa.sso;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GetLoginLockStatusTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}	
	
	@Test
	public void GetLoginLockStatus_signed_Test() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("sso/GetLoginLockStatusTestCase.xml","signed");
		executor.execute();
	}
	
	@Test
	public void GetLoginLockStatus_notSign_Test() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("sso/GetLoginLockStatusTestCase.xml","notSign");
		executor.execute();
	}
		
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

