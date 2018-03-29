package com.baidu.wanba.util;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

/**
 * MD5�㷨����
 * 
 * @author huicheng yang
 */
public class MD5 {
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
					'd', 'e', 'f' };

	/**
	 * ����content,key,��Ԥ���㷨����hashֵ.
	 * 
	 * @param text
	 * @param key
	 * @return ���ܽ��
	 */
	public static String hash(String text, String key) {
		// 0.��������Ϸ���
		if (text == null) {
			throw new IllegalArgumentException("text can't be null");
		}
		if (key == null) {
			throw new IllegalArgumentException("key can't be null");
		}

		// 1.��S=MD5(key);��textĩβ��0��16�ֽڵ�������(n),����0���text��16�ֽڷ���
		// Ϊc(1),c(2),...c(n);��b(1),b(2),...b(n)Ϊ�м����;�����ս��Ϊhash.
		String S = md5(key);
		byte[] textData = text.getBytes();
		int len = textData.length;
		int n = (len + 15) / 16;
		byte[] tempData = new byte[n * 16];
		for (int i = len; i < n * 16; i++) {
			tempData[i] = 0;
		}
		System.arraycopy(textData, 0, tempData, 0, len);
		textData = tempData;
		String[] c = new String[n];
		for (int i = 0; i < n; i++) {
			c[i] = new String(textData, 16 * i, 16);
		}
		// end c
		String[] b = new String[n];
		String hash;

		// 2.����b(i)
		// b(1)=MD5(S+c(1))
		// b(2)=MD5(b(1)+c(2))
		// ...
		// b(n)=MD5(b(n-1)+c(n))
		String temp = S;
		String target = "";
		for (int i = 0; i < n; i++) {
			b[i] = md5(temp + c[i]);
			temp = b[i];
			target += b[i];
		}

		// 3.hash=MD5(b(1)+b(2)+...+b(n))
		hash = md5(target);
		return hash;
	}

	/**
	 * Converts an array of bytes into an array of characters representing the
	 * hexidecimal values of each byte in order. The returned array will be
	 * double the length of the passed array, as it takes two characters to
	 * represent any given byte.
	 * 
	 * @param data
	 *            a byte[] to convert to Hex characters
	 * @return A char[] containing hexidecimal characters
	 */
	private static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

	private static MessageDigest getMD5Digest() {
		try {
			MessageDigest md5MessageDigest = MessageDigest.getInstance("MD5");
			md5MessageDigest.reset();
			return md5MessageDigest;
		} catch (NoSuchAlgorithmException nsaex) {
			throw new RuntimeException("Could not access MD5 algorithm, fatal error");
		}
	}

	/**
	 * ����content��md5ժҪ.
	 * 
	 * @param content
	 * @return md5���
	 */
	public static String md5(String content) {
		try {
			byte[] data = getMD5Digest().digest(content.getBytes());
			char[] chars = encodeHex(data);
			return new String(chars);
		} catch (Exception ex) {
			return null;
		}
	}
	
	public static String md5UTF8(String content) {
		try {
			byte[] data = getMD5Digest().digest(content.getBytes("UTF-8"));
			char[] chars = encodeHex(data);
			return new String(chars);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * ����content��md5ժҪ.
	 * 
	 * @param content
	 * @return md5���
	 */
	public static String md5GBK(String content) {
		try {
			byte[] data = getMD5Digest().digest(content.getBytes("GBK"));
			char[] chars = encodeHex(data);
			return new String(chars);
		} catch (Exception ex) {
			return null;
		}
	}

	public static void main(String args[]) {
		String url = "http://10.65.19.106:9999/ftxy/"+StringUtils.substringAfter("http://59.151.39.189:8080/union_mid/giveItem.do".substring(7),"/");
		System.out.println(url);
		if (Array.getLength(args) == 0) {
			System.out.println("MD5 Test suite:");
			System.out.println("MD5(\"\"):" + md5(""));
			System.out.println("MD5(\"a\"):" + md5("a"));
			System.out.println("MD5(\"123456\"):" + md5("123456"));
			System.out.println("MD5(\"message digest\"):" + md5("message digest"));
			System.out.println("MD5(\"abcdefghijklmnopqrstuvwxyz\"):" + md5("abcdefghijklmnopqrstuvwxyz"));
			System.out.println("MD5(\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789\"):"
							+ md5("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"));
		} else {
			System.out.println("MD5(" + args[0] + ")=" + md5(args[0]));
		}
	}

}