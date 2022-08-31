package com.revature.bankingApp.repository.DTO;

import java.util.Objects;

import com.revature.bankingApp.services.models.UserLogin;

public class UserLoginDTO implements UserLoginDTOInterface{
	
	protected Integer userLoginId;
	
	protected String username;
	
	protected String password;
	
	protected Integer userId;
	
	protected Integer userTypeId;

	@Override
	public UserLogin login(UserLogin username, UserLogin password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserLogin logout() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserLoginDTO(Integer userLoginId, String username, String password, Integer userId, Integer userTypeId) {
		super();
		this.userLoginId = userLoginId;
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.userTypeId = userTypeId;
	}
	
	
	

	

	public UserLoginDTO(Integer userLoginId) {
		super();
		this.userLoginId = userLoginId;
		
	}

	public UserLoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public UserLoginDTO(String username, String password, Integer userTypeId) {
		super();
		this.username = username;
		this.password = password;
		this.userTypeId = userTypeId;
	}

	public UserLoginDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userId, userLoginId, userTypeId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLoginDTO other = (UserLoginDTO) obj;
		return Objects.equals(password, other.password) && Objects.equals(userId, other.userId)
				&& Objects.equals(userLoginId, other.userLoginId) && Objects.equals(userTypeId, other.userTypeId)
				&& Objects.equals(username, other.username);
	}

	
	
	@Override
	public String toString() {
		return "UserLoginDTO [userLoginId=" + userLoginId + ", username=" + username + ", password=" + password
				+ ", userId=" + userId + ", userTypeId=" + userTypeId + "]";
	}

	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
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
	
	

	



}
