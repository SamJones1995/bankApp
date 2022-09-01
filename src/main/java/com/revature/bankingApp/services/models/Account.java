package com.revature.bankingApp.services.models;

import java.util.Objects;

public class Account {
	
		
		protected Integer accountId;
		
		protected Double balance;
		
		protected Integer accountTypeId;
		
		protected boolean approved;
		
		

		public Account(Integer accountId, Double balance, Integer accountTypeId, boolean approved) {
			super();
			this.accountId = accountId;
			this.balance = balance;
			this.accountTypeId = accountTypeId;
			this.approved = approved;
		}



		public Account(Double balance, Integer accountTypeId, boolean approved) {
			super();
			this.balance = balance;
			this.accountTypeId = accountTypeId;
			this.approved = approved;
		}
		
		

		public Account() {
			// TODO Auto-generated constructor stub
		}



		public Account(Integer accountId) {
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
			Account other = (Account) obj;
			return Objects.equals(accountId, other.accountId) && Objects.equals(accountTypeId, other.accountTypeId)
					&& approved == other.approved && Objects.equals(balance, other.balance);
		}

		

		@Override
		public String toString() {
			return "Account [accountId=" + accountId + ", balance=" + balance + ", accountTypeId=" + accountTypeId
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



}
