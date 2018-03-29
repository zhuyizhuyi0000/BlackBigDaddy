package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi__query_mypre {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void Mypre01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre01");
		executor.execute();
	}
	
	@Test
	public void Mypre02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre02");
		executor.execute();
	}
	
	@Test
	public void Mypre03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre03");
		executor.execute();
	}
//	
//	@Test
//	public void Mypre04() throws Exception{
//		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre04");
//		executor.execute();
//	}
//	
//	@Test
//	public void Mypre05() throws Exception{
//		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre05");
//		executor.execute();
//	}
//	
//	@Test
//	public void Mypre06() throws Exception{
//		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre06");
//		executor.execute();
//	}
//	
//	@Test
//	public void Mypre07() throws Exception{
//		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre07");
//		executor.execute();
//	}
//	
//	@Test
//	public void Mypre08() throws Exception{
//		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre08");
//		executor.execute();
//	}
//	
//	@Test
//	public void Mypre09() throws Exception{
//		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi.query_mypre.Mypre09");
//		executor.execute();
//	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

