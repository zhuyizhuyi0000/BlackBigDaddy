package com.baidu.gameqa.generation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;

/** 
 * 客户端加密获取securityKey接口
 * API: /sso/client/security/securityKey.json
 * @author yanglei12
 * @version V1.0 
 * @createTime 2014-05-23
 */
public class ClientSecurityKey__ClientSecurityKeyQa {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void testClientSecurityKeyQa() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("ClientSecurityKey.ClientSecurityKeyQa.testClientSecurityKeyQa");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}

