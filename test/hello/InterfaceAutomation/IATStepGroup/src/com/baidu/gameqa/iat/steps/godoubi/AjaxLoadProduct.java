package com.baidu.gameqa.iat.steps.godoubi;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.testng.Assert;

import com.baidu.gameqa.Gat.dataobject.AssertStepMethodDesc;
import com.baidu.gameqa.Gat.dataobject.stepparameter.InterfaceStepParameter;
import com.baidu.gameqa.Gat.util.ParameterHelper;
import com.baidu.gameqa.Lib.common.SimpleLogger;
import com.baidu.gameqa.dboProxyClient.MysqlProxy;
import com.baidu.gameqa.iat.common.JSONUtil;
import com.baidu.gameqa.iat.steps.common.ResultCompare;

public class AjaxLoadProduct {
	private MysqlProxy proxy = new MysqlProxy();
	private HashMap<String, String> requestParameter = null;
	private InterfaceStepParameter parameter = null;
	private String parameterID = "";
	private String actualResult = "";
	private ResultCompare rc = new ResultCompare();
	
	public List<List<String>> select_youxi_gift_product() throws Exception {
		parameter = (InterfaceStepParameter) ParameterHelper
				.getParameter(parameterID);
		requestParameter = new HashMap<String, String>();

		requestParameter.put("connectionString",
				parameter.getValue("conn_iyouxi"));
		requestParameter.put("user", parameter.getValue("user"));
		requestParameter.put("password", parameter.getValue("password"));
		
		requestParameter.put("commandText",
				parameter.getValue("select_youxi_gift_product"));

		List<List<String>> gameCurrencyInfo = proxy.executeQuery(requestParameter);
		return gameCurrencyInfo;

	}
	
	@AssertStepMethodDesc(description = "LoadProduct_assert", owner = "wangjing01@")
	public void loadProduct_assert(String parameterID, String expectresult,
			String actualresult) throws Exception {
		this.parameterID = parameterID;
		this.actualResult = actualresult;
		List<List<String>> productList = null;
		productList=this.select_youxi_gift_product();
		
		// assert
		if (productList != null) {
			
			// assert productDesc
			String productDescExpect=rc.getListValue(1, productList, "giftContent").toString();
			String productDescActual = JSONUtil.getStrFromJson(actualResult, "productDesc");
			
			System.out.println("productDescExpect:::"+productDescExpect);
			System.out.println("productDescActual:::"+productDescActual);
			
			Assert.assertEquals(productDescActual, productDescExpect);
			
			
			// assert productLimitNumber
			int personLimitNumExpect=Integer.parseInt(rc.getListValue(1, productList, "personLimitNum"));
			if (personLimitNumExpect == 0) {
				personLimitNumExpect=-1;
			}
			
			int personLimitNumActual =Integer.parseInt(JSONUtil.getStrFromJson(actualResult, "productLimitNumber"));
			
			System.out.println("personLimitNumExpect:::"+personLimitNumExpect);
			System.out.println("personLimitNumActual:::"+personLimitNumActual);
			
			Assert.assertEquals(personLimitNumActual, personLimitNumExpect);
			
			
			// assert productMiddlePage productBigPage productSmallPage
			String productMiddlePageExpect=rc.getListValue(1, productList, "middleImagePath").toString();
			String productMiddlePageActual = JSONUtil.getStrFromJson(actualResult, "productMiddlePage");
			
			String productBigPageExpect=rc.getListValue(1, productList, "bigImagePath").toString();
			String productBigPageActual = JSONUtil.getStrFromJson(actualResult, "productBigPage");
			
			String productSmallPageExpect=rc.getListValue(1, productList, "smallImagePath").toString();
			String productSmallPageActual = JSONUtil.getStrFromJson(actualResult, "productSmallPage");
			

			
			Assert.assertEquals(productMiddlePageActual, productMiddlePageExpect);
			Assert.assertEquals(productBigPageActual, productBigPageExpect);
			Assert.assertEquals(productSmallPageActual, productSmallPageExpect);
			
			// assert productPrice
			String productPriceExpect=rc.getListValue(1, productList, "price").toString();
			String productPriceActual = JSONUtil.getStrFromJson(actualResult, "productPrice");
			
			Assert.assertEquals(productPriceActual, productPriceExpect);
			// assert productName
			String productNameExpect=rc.getListValue(1, productList, "giftName").toString();
			String productNameActual = JSONUtil.getStrFromJson(actualResult, "productName");
			
			Assert.assertEquals(productNameActual, productNameExpect);
			
			// assert code
			String codeActual = JSONUtil.getStrFromJson(actualResult, "code");
			Assert.assertEquals(codeActual, "0");
			
		}

		
		
        
		
		
		
		

	}
}
