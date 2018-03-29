package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__query_zone_server {

	@BeforeTest
	public void beforeTestMethod() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void query_zone_server01() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.query_zone_server.query_zone_server01");
		executor.execute();
	}

	@Test
	public void query_zone_server02() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.query_zone_server.query_zone_server02");
		executor.execute();
	}

	@Test
	public void query_zone_server03() throws Exception {
		CaseExecutor executor = new InterfaceSingleStepExecutor(
				"GoDoubi.query_zone_server.query_zone_server03");
		executor.execute();
	}
	

	
	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClassMethod() {
	}
}
