package com.baidu.gameqa.generation;

import org.junit.Ignore;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class MemberStoreSaveAddrTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void member_store_pay_saveaddress_pass() throws Exception{
		Sleeper.sleepTight(5000);
		CaseExecutor executor = new InterfaceStepsExecutor("MemberStoreSaveAddrTestCase.xml","TestCase01");
		executor.execute();
	}
	
	@Test
	public void member_store_pay_saveaddress_ok() throws Exception{
		Sleeper.sleepTight(5000);
		CaseExecutor executor = new InterfaceStepsExecutor("MemberStoreSaveAddrTestCase.xml","TestCase02");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

