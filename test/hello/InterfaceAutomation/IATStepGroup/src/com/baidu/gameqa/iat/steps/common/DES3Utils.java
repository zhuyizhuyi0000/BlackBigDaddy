package com.baidu.gameqa.iat.steps.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 3DES加密解密的工具类
 * 
 * @author yinchunlei
 * @date 2014年1月17日
 */
public class DES3Utils {
	private static final Log LOG = LogFactory.getLog(DES3Utils.class);
	// 字符集
	public static final Charset charset = Charset.forName("UTF-8");

	// 定义加密算法，有DES、DESede(即3DES)、Blowfish
	private static final String Algorithm = "DESede";

	/**
	 * 字符串加密
	 * 
	 * @param src
	 *            加密字符串
	 * @param desKey
	 *            加密KEY
	 * @return
	 */
	public static byte[] encryptMode(byte[] src, String desKey) {
		try {
			SecretKey deskey = new SecretKeySpec(build3DesKey(desKey), Algorithm);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.lang.Exception e) {
			LOG.error("3des encrypt has exception", e);
		}
		return null;
	}

	/**
	 * 字符串解密
	 * 
	 * @param src
	 *            解密字符串
	 * @param desKey
	 *            解密key
	 * @return
	 */
	public static byte[] decryptMode(byte[] src, String desKey) {
		try {
			SecretKey deskey = new SecretKeySpec(build3DesKey(desKey), Algorithm);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (Exception e) {
			LOG.error("3desc decrypt has exception", e);
		}
		return null;
	}

	/**
	 * 根据字符串生成密钥字节数组
	 * 
	 * @param keyStr
	 * @return 24位长度key
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
		byte[] key = new byte[24];
		byte[] temp = keyStr.getBytes(charset);
		if (key.length > temp.length) {
			System.arraycopy(temp, 0, key, 0, temp.length);
		} else {
			System.arraycopy(temp, 0, key, 0, key.length);
		}
		return key;
	}
}