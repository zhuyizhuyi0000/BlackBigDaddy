package com.baidu.newyouxi.util.page;
;


/**
 * driver factory
 * @author liumiao
 * @version 1.0.0	
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class DriverFactory {
	
	
	public static  WebDriver getDriver()  {
		
		
		WebDriver driver = null;
		switch (driverType) {
			case InternetExplorerDriver:
				driver = new InternetExplorerDriver();
				break;
			case FirefoxDriver:
				driver = new FirefoxDriver();
				break;
			case ChromeDriver:
				driver = new ChromeDriver();
				break;
			case HtmlUnitDriver:
				driver = new HtmlUnitDriver();
				break;
			default:
				driver = new FirefoxDriver();
				break;
			}
		

		return driver;
	}


	public static DriverTypeEnum driverType = DriverTypeEnum.FirefoxDriver;
}
