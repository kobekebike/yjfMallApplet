package com.bl.base;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private static final long serialVersionUID = -2459968472011079917L;

	public static final String UserLoginKey = "userLoginKey";

	private Integer userId;
	private String userAccount;
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
