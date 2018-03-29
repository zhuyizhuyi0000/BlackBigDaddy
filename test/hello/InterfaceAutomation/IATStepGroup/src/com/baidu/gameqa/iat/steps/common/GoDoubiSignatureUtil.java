package com.baidu.gameqa.iat.steps.common;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class GoDoubiSignatureUtil {
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();

	}

	public static String SignatureParams(Map params, String key, String charset) {

		StringBuffer strBuffer = new StringBuffer();
		Map treeMap = new TreeMap();
		treeMap.putAll(params);
		for (Iterator iter = treeMap.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			strBuffer.append(name).append("=").append(params.get(name));
			strBuffer.append("&");
		}
		strBuffer.append(key);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			String result = byte2hex(md.digest(strBuffer.toString().getBytes(
					charset)));
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
