package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Game__ajax_search {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void ajaxsearch01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_search.ajaxsearch01");
		executor.execute();
	}
	
	@Test
	public void ajaxsearch02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_search.ajaxsearch02");
		executor.execute();
	}
	
	@Test
	public void ajaxsearch03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_search.ajaxsearch03");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

