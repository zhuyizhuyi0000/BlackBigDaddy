package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__loadserver {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	 @Test
	 public void Test01() throws Exception{
	 CaseExecutor executor = new
	 InterfaceSingleStepExecutor("GoDoubi.loadserver.Test01");
	 executor.execute();
	 }
	
	 @Test
	 public void Test02() throws Exception{
	 CaseExecutor executor = new
	 InterfaceSingleStepExecutor("GoDoubi.loadserver.Test02");
	 executor.execute();
	 }
	
	 @Test
	 public void Test03() throws Exception{
	 CaseExecutor executor = new
	 InterfaceSingleStepExecutor("GoDoubi.loadserver.Test03");
	 executor.execute();
	 }

	@Test
	public void loadserverTest04() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest04");
		executor.execute();
	}
	
	@Test
	public void loadserverTest05() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest05");
		executor.execute();
	}
	@Test
	public void loadserverTest06() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest06");
		executor.execute();
	}
	@Test
	public void loadserverTest07() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest07");
		executor.execute();
	}

	@Test
	public void loadserverTest08() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest08");
		executor.execute();
	}
	
	@Test
	public void loadserverTest09() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest09");
		executor.execute();
	}
	

	
	@Test
	public void loadserverTest11() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest11");
		executor.execute();
	}
	
	@Test
	public void loadserverTest12() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest12");
		executor.execute();
	}
	
	@Test
	public void loadserverTest14() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest14");
		executor.execute();
	}
	
	
	@Test
	public void loadserverTest15() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest15");
		executor.execute();
	}
	
	@Test
	public void loadserverTest16() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest16");
		executor.execute();
	}
	
	@Test
	public void loadserverTest17() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.loadserver.loadserverTest17");
		executor.execute();
	}
	
	
//	@Test //Œ¥ µœ÷
//	public void loadserverTest10() throws Exception {
//		CaseExecutor executor = new InterfaceSingleStepExecutor(
//				"GoDoubi.loadserver.loadserverTest10");
//		executor.execute();
//	}
	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
