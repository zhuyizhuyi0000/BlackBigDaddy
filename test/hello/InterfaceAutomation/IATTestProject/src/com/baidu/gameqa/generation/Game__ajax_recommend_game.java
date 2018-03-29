package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Game__ajax_recommend_game {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void recommend01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_recommend_game.recommend01");
		executor.execute();
	}
	
	@Test
	public void recommend02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_recommend_game.recommend02");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

