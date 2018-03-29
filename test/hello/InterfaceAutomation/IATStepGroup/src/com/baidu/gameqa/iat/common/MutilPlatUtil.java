package com.baidu.gameqa.iat.common;

import bsh.This;

import com.baidu.gameqa.Lib.common.ConfigReader;
import com.baidu.gameqa.Lib.common.SimpleLogger;

public class MutilPlatUtil {

	public static int getPlatFlag() {
		int platFlag = 0;
		
		if (ConfigReader.GetValue("gatConfig.properties", "domainName").equals(
				"http://youxi.baidu.com/")) {
			platFlag = 1;
		} else if (ConfigReader.GetValue("gatConfig.properties", "domainName")
				.equals("http://wanba.baidu.com/")) {
			platFlag = 4;
		} else if (ConfigReader.GetValue("gatConfig.properties", "domainName")
				.equals("http://wanhao123.baidu.com/")) {
			platFlag = 10;
		} else if (ConfigReader.GetValue("gatConfig.properties", "domainName")
				.equals("http://hao123qipai.baidu.com/")) {
			platFlag = 8;
		} else if (ConfigReader.GetValue("gatConfig.properties", "domainName")
				.equals("http://chuanqi.baidu.com/")) {
			platFlag = 6;
		} else if (ConfigReader.GetValue("gatConfig.properties", "domainName")
				.equals("http://game.skycn.com/")) {
			platFlag = 2;
		}

		return platFlag;
	}

}
