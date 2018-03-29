package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__query_myhistory_order {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void order01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order01");
		executor.execute();
	}
	
	@Test
	public void order02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order02");
		executor.execute();
	}
	
	@Test
	public void order03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order03");
		executor.execute();
	}
	
	@Test
	public void order04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order04");
		executor.execute();
	}
	
	@Test
	public void order05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order05");
		executor.execute();
	}
	
	@Test
	public void order06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order06");
		executor.execute();
	}
	
	@Test
	public void order07() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order07");
		executor.execute();
	}
	
	@Test
	public void order08() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_myhistory_order.order08");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

