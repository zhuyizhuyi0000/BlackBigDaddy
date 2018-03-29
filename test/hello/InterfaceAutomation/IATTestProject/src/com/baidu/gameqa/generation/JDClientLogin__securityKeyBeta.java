package com.baidu.gameqa.generation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.InterfaceSingleStepExecutor;

/** 
 * 九鼎客户端登录控制器安全密钥生成接口
 * api: /sso/client/sso/client  
 * @testEnvironment beta/RD
 * @author yanglei12
 * @version V1.0 
 * @createTime 2014-05-16
 */
public class JDClientLogin__securityKeyBeta {

	@BeforeTest
	public void beforeTestMethod(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	
	@Test
	public void testSecurityKeyBeta() throws Exception{
		CaseExecutor executor = new InterfaceSingleStepExecutor("JDClientLogin.securityKeyBeta.testSecurityKeyBeta");
		executor.execute();
	}
	
	
	@AfterMethod
	public void afterMethod(){
	}
	
	@AfterClass
	public void afterClassMethod(){
	}
}
