package com.baidu.gameqa.wuat.demo;




import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.baidu.gameqa.Gat.executor.CaseExecutor;
import com.baidu.gameqa.Gat.executor.WebUIStepsExecutor;
import com.baidu.gameqa.Gat.util.ProcessKiller;
import com.baidu.gameqa.Lib.common.SimpleLogger;


public class DemoTest {
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() throws Exception 
  {  

  // �ر� ChromeDriver �ӿ�
  //service.stop();
  }

  @AfterTest
  public void afterTest()
  {
	  try 
	  {
		ProcessKiller.killProcess("iexplore.exe");
	  } catch (Exception e) 
	  {
		SimpleLogger.logInfo(this.getClass(),e.getMessage());
	  }
  }

  @Test
  public void doubipaytest() throws Exception
  {
	  CaseExecutor executor=new WebUIStepsExecutor("DoubiPayTestCase.xml","Test01");
	  executor.execute();
  }
  
}
