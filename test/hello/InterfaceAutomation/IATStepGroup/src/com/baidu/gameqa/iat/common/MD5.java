package com.baidu.gameqa.iat.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.baidu.gameqa.Gat.dataobject.StepMethodDesc;

public class MD5 {
	
	/**
	 * 
	 * @param plainText  明文
	 * @param digits  加密位数
	 * @return
	 */
	@StepMethodDesc(description = "md5", owner = "xiuping.qi")
	public static String md5(String plainText, int digits ) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
			if(digits == 32){				
				re_md5 = buf.toString();  // 32位的加密	
			}else if(digits == 16){			    
			    re_md5 = buf.toString().substring(8,24);  // 16位的加密
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}


}
