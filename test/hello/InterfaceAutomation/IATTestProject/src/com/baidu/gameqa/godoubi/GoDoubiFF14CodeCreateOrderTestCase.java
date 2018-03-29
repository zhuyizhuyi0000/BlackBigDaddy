package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubiFF14CodeCreateOrderTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void ff14Codecreateorder_case01() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiFF14CodeCreateOrderTestCase.xml","ff14Codecreateorder_case01");
		executor.execute();
	}
	

	@Test
	public void ff14Codecreateorder_case02() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiFF14CodeCreateOrderTestCase.xml","ff14Codecreateorder_case02");
		executor.execute();
	}
	
	@Test
	public void ff14Codecreateorder_case03() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiFF14CodeCreateOrderTestCase.xml","ff14Codecreateorder_case03");
		executor.execute();
	}
	@Test
	public void ff14Codecreateorder_case04() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiFF14CodeCreateOrderTestCase.xml","ff14Codecreateorder_case04");
		executor.execute();
	}
	@Test
	public void ff14Codecreateorder_case05() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiFF14CodeCreateOrderTestCase.xml","ff14Codecreateorder_case05");
		executor.execute();
	}
	
	@Test
	public void ff14Codecreateorder_case06() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiFF14CodeCreateOrderTestCase.xml","ff14Codecreateorder_case06");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

