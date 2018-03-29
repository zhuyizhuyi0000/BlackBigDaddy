package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class MemberStorePayTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void member_store_pay_jifenxuni_case01() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("MemberStorePayTestCase.xml","member_store_pay_jifenxuni_case01");
		executor.execute();
	}
	
	@Test
	public void member_store_pay_jifenshiwu_case02() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("MemberStorePayTestCase.xml","member_store_pay_jifenshiwu_case02");
		executor.execute();
	}
	
	@Test
	public void member_store_pay_youxitequan_case03() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("MemberStorePayTestCase.xml","member_store_pay_youxitequan_case03");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

