package com.baidu.gameqa.iat.steps.common;

/**
 * 客户端登录请求
 * 
 * @author yinchunlei
 * @date 2014-1-17
 */
public class ClientLoginRequest implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String loginName;

	private String password;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ClientLoginRequest [loginName=" + loginName + ", password=" + password + "]";
	}
}
