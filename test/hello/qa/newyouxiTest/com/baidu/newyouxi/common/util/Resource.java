package com.baidu.newyouxi.common.util;

import com.csvreader.CsvReader;
import java.nio.charset.Charset;

public class Resource {

	private String loginName;
	private String password;
	private CsvReader loginlistreader = null;

	public void loginListData() {

		try {

			loginlistreader = new CsvReader(
					"common/com/baidu/newyouxi/util/a.csv", ',', Charset.forName("UTF-8"));
			loginlistreader.readHeaders();
			
			while (loginlistreader.readRecord()) {
				loginName = loginlistreader.get("loginName");
				password = loginlistreader.get("password");
//				System.out.println(loginName);
//				System.out.println(password);
			}
		} catch (Exception e) {
			System.out.println("读取文件出错");
		} finally {
			if (loginlistreader != null) {
				loginlistreader.close();
			}
		}
	}

		public String getLoginName() {
			Resource re = new Resource();
			re.loginListData();		
			return re.loginName;			
		}

		public String getPassword() {
			Resource re = new Resource();
			re.loginListData();		
			return re.password;			
		}
}

