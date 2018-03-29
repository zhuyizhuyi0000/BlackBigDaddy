package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Game__youxicard_article {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	/*Author Guo,Lin, created on 11/19/2014*/
	@Test
	public void Test01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase01");
		executor.execute();
	}
	@Test
	public void Test02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase02");
		executor.execute();
	}	
	@Test
	public void Test03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase03");
		executor.execute();
	}
	@Test
	public void Test04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase04");
		executor.execute();
	}
	@Test
	public void Test05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase05");
		executor.execute();
	}
	@Test
	public void Test06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase06");
		executor.execute();
	}		
	@Test
	public void Test07() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase07");
		executor.execute();
	}
	@Test
	public void Test08() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase08");
		executor.execute();
	}
	@Test
	public void Test09() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase09");
		executor.execute();
	}	
	@Test
	public void Test10() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Game.youxicard_article.TestCase10");
		executor.execute();
	}	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

