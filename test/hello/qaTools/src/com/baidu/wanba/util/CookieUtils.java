package com.baidu.wanba.util;

/**
 * 处理cookie的工具
 * @author huicheng yang
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.wanba.core.Constant;

public class CookieUtils {

	public static Cookie getCookie(Cookie cookies[], String name) {

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}

		return null;
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		return getCookie(cookies, name);
	}

	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		//cookie.setDomain(Constant.BAIDU_DOMAIN);
		if (maxAge != 0) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}
	
	public static void addCookie(HttpServletResponse response, String domain,String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setDomain(domain);
		if (maxAge != 0) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}

	public static void removeCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath("/");
		//cookie.setDomain(Constant.BAIDU_DOMAIN);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	public static void removeCookie(HttpServletResponse response, String domain,String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath("/");
		cookie.setDomain(domain);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
}
