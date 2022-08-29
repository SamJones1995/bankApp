package com.revature.bankingApp.repository.DTO;

import java.util.Objects;

public class AccountDTO implements AccountDTOInterface{
	
	protected Integer accountId;
	
	protected Double balance;
	
	protected Integer accountTypeId;
	
	protected boolean approved;
	
	

	public AccountDTO(Integer accountId, Double balance, Integer accountTypeId, boolean approved) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.accountTypeId = accountTypeId;
		this.approved = approved;
	}



	public AccountDTO(Double balance, Integer accountTypeId, boolean approved) {
		super();
		this.balance = balance;
		this.accountTypeId = accountTypeId;
		this.approved = approved;
	}
	
	

	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}



	public AccountDTO(Integer accountId) {
		super();
		this.accountId = accountId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(accountId, accountTypeId, approved, balance);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDTO other = (AccountDTO) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(accountTypeId, other.accountTypeId)
				&& approved == other.approved && Objects.equals(balance, other.balance);
	}

	

	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountId + ", balance=" + balance + ", accountTypeId=" + accountTypeId
				+ ", approved=" + approved + "]";
	}



	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(double d) {
		this.balance = d;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}



	@Override
	public void addToAccount() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void removeFromAccount() {
		// TODO Auto-generated method stub
		
	}



	



	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setAccountBalance(Double double1) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setAccountBalance() {
		// TODO Auto-generated method stub
		
	}
	
	
}
