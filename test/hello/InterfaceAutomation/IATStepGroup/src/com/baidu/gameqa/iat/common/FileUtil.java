package com.baidu.gameqa.iat.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {

	public String BufferedReader(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();

		temp = br.readLine();

//		System.out.println("temp111:" + temp);
		while (temp != null) {

			sb.append(temp + " ");
			temp = br.readLine();
//			System.out.println("temp222:" + temp);

		}
		return sb.toString();
	}

	public Map MapReader(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || file.isDirectory())
			throw new FileNotFoundException();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		HashMap fileMap = new HashMap();
		Integer mapKey = 0;

		temp = br.readLine();

//		System.out.println("temp111:" + temp);
		while (temp != null) {

			fileMap.put(mapKey, temp);
			mapKey++;
			temp = br.readLine();

		}
		return fileMap;
	}

	// public static void main(String[] args) throws IOException {
	// String path="D:\\download\\test\\member_info.csv";
	// FileUtil file=new FileUtil();
	// HashMap resultString=(HashMap) file.MapReader(path);
	// UserCookieParse userCookie = new UserCookieParse();
	// StringBuffer sBuffer= new StringBuffer();
	// String loginname="";
	//
	// for(int i=0; i<=resultString.size();i++){
	//
	// if (resultString != null && resultString.get(i) != null) {
	// System.out.println(i+"result:"+resultString.get(i));
	// loginname=resultString.get(i).toString();
	// System.out.println("loginname:"+loginname);
	// userCookie.setLoginName(loginname);
	// String cookieStr = userCookie.getCookieStrA(userCookie);
	// System.out.println("cookieStr:"+cookieStr);
	// sBuffer.append(cookieStr);
	// sBuffer.append("\r\n");
	// }
	//
	//
	//
	// }
	//
	// System.out.println("sBuffer:"+sBuffer.toString());
	//
	//
	// FileWriter fw = new FileWriter("D:\\cookie-member-info.txt");
	//
	// fw.write(sBuffer.toString(),0,sBuffer.length());
	// fw.flush();
	//
	// }

	public static void main(String[] args) throws IOException {
		String path = "D:\\工作\\项目\\点券切换\\ids.txt";
		FileUtil file = new FileUtil();
		HashMap gameidMap = (HashMap) file.MapReader(path);
		StringBuffer sBuffer = new StringBuffer();
		String gameDes = "";
		String gameId = "";
		String gamename = "";
		HashMap resultMap = new HashMap();

		for (int i = 0; i <= gameidMap.size(); i++) {

			if (gameidMap != null && gameidMap.get(i) != null) {
				gameDes = gameidMap.get(i).toString();
				String[] strArr =  gameDes.split("\\.");
				gameId = strArr[0];
				if (resultMap.get(gameId) == null) {
//					System.out.println("gameId:" + gameId);
					resultMap.put(gameId, gameDes);
				}

			}
		}
		

		String platpath="D:\\工作\\项目\\点券切换\\youxi_info_a.csv";
		
		HashMap platgameidMap = (HashMap) file.MapReader(platpath);
		HashMap resultdiffMap = new HashMap();
		
		for (int i = 0; i <= platgameidMap.size(); i++) {

			if (platgameidMap != null && platgameidMap.get(i) != null) {
				gameDes = platgameidMap.get(i).toString();
				String[] strArr =  gameDes.split("\\,");
				gameId = strArr[0];
				gamename = strArr[1];
				if (resultMap.get(gameId)==null) {
					System.out.println("gameId:" + gameId +","+ gamename);
					resultdiffMap.put(gameId, gameDes);
				}

			}
		}
		
	}
}
