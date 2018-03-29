package com.baidu.wanba.core.tool;

import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class createbackurl 
{
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
		'd', 'e', 'f' };

//	public void createNoticeUrl() {
	public static void main(String args[]){
	String sql = "select game_id,pay_name,store_oid,coin_oid,amount,currency,order_status from wanba_order_info where store_oid=?";
	String oid ="347a1ed01f8939b44";
	
	Connection conn =null;
	PreparedStatement pstmt =null;
	ResultSet result =null;
	Statement stmt =null;
	try{
		conn=ConnectTool.getConnection();
//		Class.forName("com.mysql.jdbc.Driver");
//		conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/game","root","1234");

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, oid);
	
		
		result = pstmt.executeQuery();

		if(result.next()){
			String game_id = String.valueOf(result.getInt(1));
			String pay_name = result.getString(2);
			String store_oid =result.getString(3);
			String coin_oid =result.getString(4);
			String amount =String.valueOf((int)(result.getInt(5)*0.01));
			String currency=result.getString(6);
			String order_status =result.getString(7);
//			System.out.print(game_id+pay_name+store_oid+coin_oid+amount+currency+order_status);
		
			String back_send ="Y";
			String baseUrl = "http://youxi.baidu.com/receive_order_new.xhtml?";
			StringBuffer sb = new StringBuffer();
			sb.append("oid=").append(coin_oid);
			sb.append("&store_oid=").append(store_oid);
			sb.append("&pay_oid=").append(coin_oid);
			sb.append("&amount=").append(amount);
			sb.append("&currency=").append("CNY");
			sb.append("&store_name=").append("baidu_wanba");
			sb.append("&pay_name=").append(pay_name);
			sb.append("&order_status=").append("30");
			sb.append("&back_send=").append(back_send);
			sb.append("&key=").append("41135Aa5d7Dbb2a2");
		
			String sgStr = md5(sb.toString());
			String url = sb.toString();
			url = baseUrl + url.substring(0, url.indexOf("key="))
					+ "return_attach=hand&sig=" + sgStr;
		
		
			System.out.println(url);
//			System.out.print("http://youxi.baidu.com/receive_order_new.xhtml?oid=134580271884566162&store_oid=347a1ed01f8939b44&pay_oid=134580271884566162&amount=1&currency=CNY&store_name=baidu_wanba&pay_name=BaiduCoin.&order_status=30&back_send=Y&return_attach=hand&sig=045bbf918845e667a7a435d5ede26c63");
		
			stmt =conn.createStatement();
			stmt.executeUpdate("UPDATE wanba_order_info SET order_status ='20' WHERE store_oid="+"'"+oid+"'");
			
			
			
		}else{
			System.out.println("没有此订单");
		}
		
		
		
		
		
		
		
		result.close();
		pstmt.close();
		conn.close();
	}catch (Exception e) {
		e.printStackTrace();
	}

	}
	public static String md5(String content) {
		byte[] data = getMD5Digest().digest(content.getBytes());
		char[] chars = encodeHex(data);
		return new String(chars);
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
}
