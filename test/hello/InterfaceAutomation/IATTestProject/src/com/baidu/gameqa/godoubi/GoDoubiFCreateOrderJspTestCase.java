package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubiFCreateOrderJspTestCase {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void createorderJsp_case01() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case01");
		executor.execute();
	}
	

	@Test
	public void createorderJsp_case02() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case02");
		executor.execute();
	}
	
	@Test
	public void createorderJsp_case03() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case03");
		executor.execute();
	}
	@Test
	public void createorderJsp_case04() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case04");
		executor.execute();
	}
	@Test
	public void createorderJsp_case05() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case05");
		executor.execute();
	}
	
	@Test
	public void createorderJsp_case06() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case06");
		executor.execute();
	}
	
	@Test
	public void createorderJsp_case07() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case07");
		executor.execute();
	}
	
	@Test
	public void createorderJsp_case08() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case08");
		executor.execute();
	}
	
	@Test
	public void createorderJsp_case09() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case09");
		executor.execute();
	}
	
	@Test
	public void createorderJsp_case10() throws Exception{
		CaseExecutor executor = new InterfaceStepsExecutor("GoDoubi/GoDoubiCreateOrderJspTestCase.xml","createorderJsp_case10");
		executor.execute();
	}
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

