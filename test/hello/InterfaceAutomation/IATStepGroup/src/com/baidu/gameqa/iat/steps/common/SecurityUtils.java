package com.baidu.gameqa.iat.steps.common;

import java.nio.charset.Charset;

/**
 * 加密解密工具
 * 
 * @author yinchunlei
 * @date 2014年1月17日
 */
public class SecurityUtils {
	private static final Charset charset = Charset.forName("UTF-8");

	/**
	 * 默认DES加密KEY
	 */
	public static final String DEFAULT_SEC_KEY = "BDYX@2014_MOMODA";

	/**
	 * 数据加密
	 * 
	 * @param msg
	 * @param secKey
	 * @return
	 */
	public static String encrypt(String msg, String secKey) {
		byte[] encyptBytes = DES3Utils.encryptMode(msg.getBytes(charset), secKey);
		return BASE64Utils.encode(encyptBytes);
	}

	/**
	 * 数据解密
	 * 
	 * @param msg
	 * @param secKey
	 * @return
	 */
	public static String decrypt(String msg, String secKey) {
		byte[] base64Dec = BASE64Utils.decode(msg);
		byte[] decryptMsg = DES3Utils.decryptMode(base64Dec, secKey);
		return new String(decryptMsg, charset);
	}
}
