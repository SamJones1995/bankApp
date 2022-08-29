package com.revature.bankingApp.repository.DTO;

import java.util.Objects;

public class UserAccountsBridgeDTO {
	
	protected Integer userId;
	
	protected Integer accountId;
	
	

	public UserAccountsBridgeDTO(Integer userId, Integer accountId) {
		super();
		this.userId = userId;
		this.accountId = accountId;
	}
	
	

	public UserAccountsBridgeDTO() {
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
		UserAccountsBridgeDTO other = (UserAccountsBridgeDTO) obj;
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
