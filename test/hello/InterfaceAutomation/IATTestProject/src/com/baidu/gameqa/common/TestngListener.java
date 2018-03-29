package com.baidu.gameqa.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;

public class TestngListener extends TestListenerAdapter {
	private static Logger logger = Logger.getLogger(TestngListener.class);
	public static final String CONFIG = "config.properties";

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
//		takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
//		takeScreenShot(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
	}

//	/** * �Զ���ͼ������ͼƬ�������Լ�html����ļ��� * * @param tr */
//	private void takeScreenShot(ITestResult tr) {
//
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//		String mDateTime = formatter.format(new Date());
//		String fileName = mDateTime + "_" + tr.getName();
//		String filePath = OrangeiOS.driver.getScreenshotAs(fileName);
//		Reporter.setCurrentTestResult(tr);
//		Reporter.log(filePath);
//
//		// ����ʵ�ְ�ͼƬ����ֱ�����������ļ��У�ͨ���ʼ����ͽ�������ֱ����ʾͼƬ
//		Reporter.log("<img src=\"../" + filePath + "\"/>");
//	}
}
