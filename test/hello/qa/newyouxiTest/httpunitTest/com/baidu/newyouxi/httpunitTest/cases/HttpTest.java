package com.baidu.newyouxi.httpunitTest.cases;

import java.io.IOException;
import java.net.MalformedURLException;

import net.sf.json.JSONObject;

import org.xml.sax.SAXException;

import com.meterware.httpunit.*;

import junit.framework.TestCase;

public class HttpTest extends TestCase {

	public void testUser() throws MalformedURLException, IOException,
			SAXException {

		// 发送请求
		WebConversation webConversation = new WebConversation();
		WebRequest request = new GetMethodWebRequest(
				"http://youxi.baidu.com/user.xhtml");

		webConversation.addCookie("cookieId", "13346500025858745882");
		webConversation
				.addCookie(
						"wanba_cookies",
						"255cdfa44d97725d12f48c7b9e1a6606f237422532326c6f67696e4e616d6525323225334125323277616e676a696e6736393025343071712e636f6d253232253744");
		// webConversation.addCookie("BAIDUID",
		// "205474AB7D6EE7E37247089DCC0CAE82:FG=1");
		// webConversation.addCookie("JSESSIONID",
		// "211319C0D68FB027B40E779741239DF3");
		// webConversation
		// .addCookie(
		// "youxi_userinfo_cookies",
		// "255cdfa44d97725d12f48c7b9e1a6606f23742253232756e697175654964253232253341253232343064313030303038653334253232253744");
		// webConversation.addCookie("Hm_lvt_2a3105dc022f9cde460d70b199b6ddce",
		// "1335004183634");
		// webConversation.addCookie("youxi_sid", "uynXYg");
		// webConversation.addCookie("from", "wanba");
		webConversation
				.addCookie(
						"BDUSS",
						"DU1a3RuamtOfnNISVVhU1d-bHZNbDQtMlBnUWd5Q05DMHMyalQzNW56Qn4zWDlRQVFBQUFBJCQAAAAAAAAAAAoawyu1WRgJcmVud29tYWkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADg6qV8AAAAAODqpXwAAAAA-WZCAAAAAAAxMC4yMy4yNH-Pkk9~j5JPO");

		System.out.println(webConversation.getCookieValue("cookieId"));
		// 请求返回
		WebResponse response = webConversation.getResponse(request);
		String resText = response.getText();
		System.out.println(resText);

		JSONObject json = JSONObject.fromObject(resText);

		// assertTrue(json.get("uid").toString().startsWith("973876"));
		assertEquals("23000331", json.get("uid").toString());
	}

	public void testUsernocookie() throws MalformedURLException, IOException,
			SAXException {

		// 发送请求
		WebConversation webConversation = new WebConversation();
		WebRequest request = new GetMethodWebRequest(
				"http://youxi.baidu.com/user.xhtml");
		webConversation.addCookie("cookieId", "13346500025858745882");

		// 请求返回
		WebResponse response = webConversation.getResponse(request);
		// assertTrue(response.getText().startsWith("-1"));
		assertEquals("-1", response.getText());
	}

	// 快推登录
	public void testAjaxUserLoginQuick() throws MalformedURLException,
			IOException, SAXException {

		// 发送请求
		WebConversation webConversation = new WebConversation();
		WebRequest request = new PostMethodWebRequest(
				"http://youxi.baidu.com/ajax_user_login.xhtml");

		webConversation.addCookie("cookieId", "13346500025858745882");

		request.setParameter("c", "login");
		request.setParameter("loginName", "wangjing4@qq.com");
		request.setParameter("password", "wj112358");

		// 请求返回
		WebResponse response = webConversation.getResponse(request);
		String resText = response.getText();
		JSONObject json = JSONObject.fromObject(resText);

		assertEquals("2", json.get("result"));
		assertEquals("登录成功", json.get("msg"));
		// assertEquals("[]", json.get("loginAfter"));
	}

	// pass登录
	public void testAjaxUserLoginPass() throws MalformedURLException,
			IOException, SAXException {

		// 发送pass请求

		// 发送请求
		WebConversation webConversation = new WebConversation();
		WebRequest request = new PostMethodWebRequest(
				"http://youxi.baidu.com/ajax_user_login.xhtml");

		webConversation.addCookie("cookieId", "13346500025858745882");
		webConversation.addCookie("BAIDUID",
				"2F478C1BB277C169035F8A30267272ED123:FG=1");
		request.setParameter("c", "login");
		request.setParameter("loginName", "renwomai108");
		request.setParameter("password", "wj112358");

		// 请求返回
		WebResponse response = webConversation.getResponse(request);
		String resText = response.getText();
		JSONObject json = JSONObject.fromObject(resText);

		assertEquals("1", json.get("result"));
		assertEquals("用户名密码正确", json.get("msg"));
		// assertEquals("[]", json.get("loginAfter"));
		// assertEquals("[]", json.get("loginAfter"));
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(HttpTest.class);
	}
}
