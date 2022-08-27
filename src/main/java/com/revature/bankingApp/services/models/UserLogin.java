package com.revature.bankingApp.services.models;

import java.util.Objects;

public abstract class UserLogin {
	protected String username;
	
	protected String password;
	
	protected Integer userId;
	
	protected Integer userTypeId;
	
	

	public UserLogin(String username, String password, Integer userId, Integer userTypeId) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.userTypeId = userTypeId;
	}
	
	



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(password, userId, userTypeId, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(password, other.password) && Objects.equals(userId, other.userId)
				&& Objects.equals(userTypeId, other.userTypeId) && Objects.equals(username, other.username);
	}
	
	



	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + ", userId=" + userId + ", userTypeId="
				+ userTypeId + "]";
	}

	

	
	
}
