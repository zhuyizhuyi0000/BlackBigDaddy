package com.baidu.gameqa.iat.common;

import java.util.Random;

import com.baidu.gameqa.Lib.common.SimpleLogger;

public class RandomUtil {

	public static String randomOid() {
		
		Random rand = new Random();
		String oidStr = "BDtest" + rand.nextInt(1000000);
		SimpleLogger.logInfo("store_oid:" + oidStr);
		return oidStr;
	}
}
