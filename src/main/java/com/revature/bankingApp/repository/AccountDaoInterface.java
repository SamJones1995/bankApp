package com.revature.bankingApp.repository;

import com.revature.bankingApp.repository.DTO.AccountDTO;

public interface AccountDaoInterface {
	
	



	AccountDTO getAccount(Integer accountId);

	

	void addToAccounBalance(Integer accountId, Double additive);

	AccountDTO createAccount(AccountDTO aDto, Integer userId);

	

	AccountDTO updateAccount(Integer accountId, String column, Double value);

	boolean deleteAccount(Integer accountId);



	
}
