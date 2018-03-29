package com.baidu.gameqa.generation;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class Member__store_kind {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void storekind01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.store_kind.storekind01");
		executor.execute();
	}
	
	@Test
	public void storekind02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.store_kind.storekind02");
		executor.execute();
	}
	
	@Test
	public void storekind03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.store_kind.storekind03");
		executor.execute();
	}
	
	@Test
	public void storekind04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.store_kind.storekind04");
		executor.execute();
	}
	
	@Test
	public void storekind05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("Member.store_kind.storekind05");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

