package com.baidu.newyouxi.seleniumTest.page;

public  abstract class BasePage {

	protected WebDriver driver;
	protected UIWebDriverWait wait;
	protected WebDriverBackedSelenium selenium;

	public BasePage(WebDriver driver) {
		DriverFactory driverFactory=new DriverFactory();
		driverFactory.getDriver();
		
	
		
	}
}
