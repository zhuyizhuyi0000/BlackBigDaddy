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
 * ���ܽ��ܹ���
 * 
 * @author huicheng yang
 */
public class DesCryptUtil {
	public static byte[] desEncrypt(byte[] orgData, byte[] rawKey) throws InvalidKeyException,
					NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
					BadPaddingException, IllegalBlockSizeException {
		// DES�㷨Ҫ����һ�������ε������Դ
		SecureRandom sr = new SecureRandom();

		// ��ԭʼ�ܳ����ݴ���DESKeySpec����
		DESKeySpec dks = new DESKeySpec(rawKey);

		// ����һ���ܳ׹�����Ȼ��������DESKeySpecת����
		// һ��SecretKey����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);

		// Cipher����ʵ����ɼ��ܲ���
		Cipher cipher = Cipher.getInstance("DES");

		// ���ܳ׳�ʼ��Cipher����
		cipher.init(1, key, sr);

		// ��ʽִ�м��ܲ���
		return cipher.doFinal(orgData);

	}

	public static byte[] desDecrypt(byte[] encryptData, byte[] rawKey) throws InvalidKeyException,
					NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
					BadPaddingException, IllegalBlockSizeException {
		// DES�㷨Ҫ����һ�������ε������Դ
		SecureRandom sr = new SecureRandom();

		// ��ԭʼ�ܳ����ݴ���һ��DESKeySpec����
		DESKeySpec dks = new DESKeySpec(rawKey);

		// ����һ���ܳ׹�����Ȼ��������DESKeySpec����ת����
		// һ��SecretKey����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);

		// Cipher����ʵ����ɽ��ܲ���
		Cipher cipher = Cipher.getInstance("DES");

		// ���ܳ׳�ʼ��Cipher����
		cipher.init(Cipher.DECRYPT_MODE, key, sr);

		// ��ʽִ�н��ܲ���
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
	 * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]
	 * hexStr2ByteArr(String strIn) ��Ϊ�����ת������
	 * 
	 * @param arrB
	 *            ��Ҫת����byte����
	 * @return ת������ַ���
	 * @throws Exception
	 *             �������������κ��쳣�������쳣ȫ���׳�
	 */
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * ����ʾ16����ֵ���ַ���ת��Ϊbyte���飬 ��public static String byteArr2HexStr(byte[] arrB)
	 * ��Ϊ�����ת������
	 * 
	 * @param strIn
	 *            ��Ҫת�����ַ���
	 * @return ת�����byte����
	 * @throws Exception
	 *             �������������κ��쳣�������쳣ȫ���׳�
	 */
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
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
