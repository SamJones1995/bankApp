package com.revature.bankingApp.services.models;

import java.util.Objects;

public class UserAccountsBridge {
	
	protected Integer userId;
	
	protected Integer accountId;
	
	

	public UserAccountsBridge(Integer userId, Integer accountId) {
		super();
		this.userId = userId;
		this.accountId = accountId;
	}
	
	

	public UserAccountsBridge() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		return Objects.hash(accountId, userId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccountsBridge other = (UserAccountsBridge) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(userId, other.userId);
	}

	

	@Override
	public String toString() {
		return "UserAccountBridgeDTO [userId=" + userId + ", accountId=" + accountId + "]";
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
