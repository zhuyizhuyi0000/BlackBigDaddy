package com.baidu.gameqa.iat.steps.common;

import java.util.UUID;

public class UUIDUtils {

	/**
	 * 获取UUID
	 * 
	 * @date 2014-1-9
	 * @author yinchunlei
	 * @return
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 获取固定长度的随机字符串
	 * 
	 * @param len
	 * @return
	 */
	public static String getRandomCode(int len) {
		long mil = System.nanoTime();
		StringBuilder params = new StringBuilder(String.valueOf(mil));
		final int offset = len - params.length();
		// 补位
		if (offset > 0) {
			for (int i = 0; i < offset; i++) {
				params.append((int) (Math.random() * 10));
			}
		}
		// 截断
		if (offset < 0) {
			params = new StringBuilder(params.substring(0, len));
		}
		return params.toString();
	}
}
