package com.baidu.newyouxi.seleniumTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baidu.beidou.common.WebDriverFactory;
 

public class YouxiHome extends BasePage{
	
	public WebElement getInputByIdEContactPhone(){
		WebElement webElement = getWebElement(By.id("eContactPhone"));
		return webElement;
	} 
	
}