package com.zensar.cb.entity;

public class Users {
	private long userId;
	private String userName;
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Users(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + "]";
	}

}
