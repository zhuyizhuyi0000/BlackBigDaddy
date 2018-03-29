package baba;

import org.testng.Assert;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class NewTest {
  @Test(dataProvider = "testData1")
  public void gogogo(String testName,int a,int b,int expected) {
	  System.out.println(testName);
	  Assert.assertEquals(a+b, expected);
  }
  @Test
  public void gogo() throws URISyntaxException, ClientProtocolException, IOException{
	 URI uri=new URIBuilder()
	 		.setScheme("http")
	 		.setHost("game.skycn.com")
	 		.setPath("ajax_login.xhtml")
	 		.setParameter("loginName", "zhuyi0001")
	 		.setParameter("Password", "soldier22")
	 		.build();
	 System.out.println(uri);
	 CloseableHttpClient httpClient = HttpClients.createDefault();
	         HttpGet httpGet = new HttpGet(uri);
	 CloseableHttpResponse response = httpClient.execute(httpGet);
	         System.out.println("响应码:" + response.getStatusLine().getStatusCode());
             String returnStr = EntityUtils.toString(response.getEntity());
	         System.out.println("响应内容:" + returnStr);
  }
  
  @DataProvider(name="testData1")
  public Object[][] shuju(){
	  return new Object[][]{
			  {"test1",1,2,3},
			  {"test2",2,8,10},
			  {"test3",3,4,7}
	  };
  }
  @DataProvider(name="testData2")

  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after");
  }

}
