package com.baidu.gameqa.godoubi;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceStepsExecutor;

public class GoDoubi_FF14_code__ajaxLoadPlatUser {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	
	@Test
	public void ajax_load_plat_user01() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_plat_user.ajax_load_plat_user01");
		executor.execute();
	}
	
	@Test
	public void ajax_load_plat_user02() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_plat_user.ajax_load_plat_user02");
		executor.execute();
	}
	
	@Test
	public void ajax_load_plat_user03() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_plat_user.ajax_load_plat_user03");
		executor.execute();
	}
	
	@Test
	public void ajax_load_plat_user04() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_plat_user.ajax_load_plat_user04");
		executor.execute();
	}
	
	@Test
	public void ajax_load_plat_user05() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_plat_user.ajax_load_plat_user05");
		executor.execute();
	}
	
	@Test
	public void ajax_load_plat_user06() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("GoDoubi_FF14_code.ajax_load_plat_user.ajax_load_plat_user06");
		executor.execute();
	}
	
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

