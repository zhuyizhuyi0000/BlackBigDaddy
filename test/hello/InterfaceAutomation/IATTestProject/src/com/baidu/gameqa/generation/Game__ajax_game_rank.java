package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Game__ajax_game_rank {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void Test01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_game_rank.Test01");
		executor.execute();
	}
	
	@Test
	public void Test02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_game_rank.Test02");
		executor.execute();
	}
	
	@Test
	public void Test03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.ajax_game_rank.Test03");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

