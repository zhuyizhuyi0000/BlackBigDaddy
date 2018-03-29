package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi_FF14_code__ajaxLoadProduct {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	
	@Test
	public void ajax_load_product01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_product.ajax_load_product01");
		executor.execute();
	}
	
	@Test
	public void ajax_load_product02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_product.ajax_load_product02");
		executor.execute();
	}
	
	@Test
	public void ajax_load_product03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_product.ajax_load_product03");
		executor.execute();
	}
	
	@Test
	public void ajax_load_product04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_product.ajax_load_product04");
		executor.execute();
	}
	
	@Test
	public void ajax_load_product05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_product.ajax_load_product05");
		executor.execute();
	}
	
	@Test
	public void ajax_load_product06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_product.ajax_load_product06");
		executor.execute();
	}
//	
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

