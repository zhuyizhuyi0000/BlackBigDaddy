package com.baidu.gameqa.iat.steps.common;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

public class BASE64Utils {
	private static final Charset charset = Charset.forName("UTF-8");

	/**
	 * @param bytes
	 * @return
	 */
	public static byte[] decode(String encStr) {
		return Base64.decodeBase64(encStr.getBytes(charset));
	}

	/**
	 * 二进制数据编码为BASE64字符串
	 * 
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode(byte[] bytes) {
		return new String(Base64.encodeBase64(bytes), charset);
	}
}
