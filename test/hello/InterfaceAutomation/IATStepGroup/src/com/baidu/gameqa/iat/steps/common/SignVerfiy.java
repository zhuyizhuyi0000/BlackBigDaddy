package com.baidu.gameqa.iat.steps.common; 

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

/** 
 * 类说明 
 * @author yanglei12
 * @version V1.0 创建时间：2014年5月26日 下午6:15:08 
 */
public class SignVerfiy {

	public static String getSign(String userId, String loginToken, String random) {
		String[] params = new String[] { userId, loginToken, random, SecurityUtils.DEFAULT_SEC_KEY };
		// 字典排序
		Arrays.sort(params);
		String paramStr = "";
		for (int i = 0; i < params.length; i++) {
			paramStr += params[i];
		}
		// SHA1加密
		String sign = DigestUtils.shaHex(paramStr);
		System.out.println("getSign result :: " + sign);
		return sign;
	}
}
 