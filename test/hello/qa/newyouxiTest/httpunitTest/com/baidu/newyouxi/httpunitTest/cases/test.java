package com.baidu.newyouxi.httpunitTest.cases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import net.sf.json.JSONObject;
import org.xml.sax.SAXException;
import com.meterware.httpunit.*;
import junit.framework.TestCase;
import com.baidu.newyouxi.util.*;
import com.csvreader.CsvReader;

public class test extends TestCase {

	// pass登录
	public void testAjaxUserLoginPass() throws MalformedURLException,
			IOException, SAXException {
		Resource data = new Resource();
		

		// 发送请求
		WebConversation webConversation = new WebConversation();
		WebRequest request = new PostMethodWebRequest(
				"http://youxi.baidu.com/ajax_user_login.xhtml");

		webConversation.addCookie("cookieId", "13346500025858745882");
		webConversation.addCookie("BAIDUID",
				"F040E2490B6380C36BC2151817C04DD5:FG=1");
		request.setParameter("c", "login");
		request.setParameter("loginName",data.getLoginName());
		request.setParameter("password",data.getPassword());
		//System.out.println(data.getLoginName() + ":" + data.getPassword());
		

		// 请求返回
		WebResponse response = webConversation.getResponse(request);
		String resText = response.getText();
		JSONObject json = JSONObject.fromObject(resText);

		assertEquals("1", json.get("result"));
		assertEquals("用户名密码正确", json.get("msg"));
	}


}
