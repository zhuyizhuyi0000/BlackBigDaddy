package com.baidu.wanba.util;

import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.lang3.StringUtils;

import com.baidu.wanba.core.Constant;

/**
 * 加密解密工具
 * 
 * @author huicheng yang
 */
public class DesCryptUtil {
	public static byte[] desEncrypt(byte[] orgData, byte[] rawKey) throws InvalidKeyException,
					NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
					BadPaddingException, IllegalBlockSizeException {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(rawKey);

		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance("DES");

		// 用密匙初始化Cipher对象
		cipher.init(1, key, sr);

		// 正式执行加密操作
		return cipher.doFinal(orgData);

	}

	public static byte[] desDecrypt(byte[] encryptData, byte[] rawKey) throws InvalidKeyException,
					NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
					BadPaddingException, IllegalBlockSizeException {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(rawKey);

		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");

		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, key, sr);

		// 正式执行解密操作
		return cipher.doFinal(encryptData);
	}

	public static String encrypt(String orgStr, String key) throws Exception {
		String orgStr_hex = byteArr2HexStr(orgStr.getBytes());

		// System.out.println("orgStr_hex = " + orgStr_hex);

		String key_md5 = hashKey(key);

		// System.out.println("key_md5 = " + key_md5);

		// System.out.println("newStr_hex = " + newStr_hex);

		return orgStr_hex.substring(0, 2) + key_md5 + orgStr_hex.substring(2);

	}

	public static String dectrypt(String encStr, String key) throws Exception {
		int start = 2;
		String key_md5 = hashKey(key);

		String orgStr_hex = encStr.substring(0, start) + encStr.substring(key_md5.length() + start);
		// System.out.println("orgStr_hex = " + orgStr_hex);

		String key_hex_md5 = encStr.substring(start, key_md5.length() + start);
		if (key_hex_md5.equalsIgnoreCase(key_hex_md5)) {
			return new String(hexStr2ByteArr(orgStr_hex),"UTF-8");
		}
		return null;
	}

	private static String hashKey(String key) {
		MD5 md5 = new MD5();
		return md5.md5(key);
	}

	/**
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 * 
	 * @param arrB
	 *            需要转换的byte数组
	 * @return 转换后的字符串
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 * 
	 * @param strIn
	 *            需要转换的字符串
	 * @return 转换后的byte数组
	 * @throws Exception
	 *             本方法不处理任何异常，所有异常全部抛出
	 */
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}
	
	public static void main(String args[]) {
		try {
			System.out.println(DesCryptUtil.dectrypt("4a586ec05990ebeac3d53431363518022465737365353230",Constant.USERNAME_PASSWORD));
			System.out.println(DesCryptUtil.encrypt("12345678901234567890123456789012",Constant.USERNAME_PASSWORD));
			int hash = HashAlgorithms.FNVHash1("xdx@live.cn");
			if (hash < 0) {
				hash = hash * -1;
			}
			System.out.println( hash % 30);
			String check = "\\w+";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher("abcde@baidu.com");
			boolean matchFlag = matcher.matches();
			if(matchFlag){
				System.out.println( "true");
			}
			else{
				System.out.println( "false");
			}
		
		String t ="status=0&need_reset_cookie=0&session_id=Wl2bHRSVnNtfmdEYzc3eUtwNFhyS0llNlhoTkhkZlc0M01CQlZrYm1xdDVqbWxQQVFBQUFBJCQAAAAAAAAAAAomjxVruGMidGVzdLCu087PtzM3AAAAAAAAAAAAAAAAAAAAAAAAAADg6qV8AAAAAODqpXwAAAAAuWZCAAAAAAAxMC42NS4yNHoBQk95AUJPV&uid=576960619&created_time=1329725817&last_login_time=1329725817&access_count=0&last_updated_time=0&global_access_time=1329727140&private_access_time=1329727140&pwd_flag=1&reserved=0&secureemail=&securemobil=&username=%74%65%73%74%B0%AE%D3%CE%CF%B7%33%37&global_data=%70%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00&private_data=%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00%00";
		String key = "securemobil="; 
		if (t.indexOf(key) != -1) {
			int p = t.indexOf(key) + key.length();
			System.out.println("t="+URLDecoder.decode(t.substring(p, t.indexOf('&', p)), "iso-8859-1"));
		} 
		} catch (Exception ex) {

		}
	}
}
