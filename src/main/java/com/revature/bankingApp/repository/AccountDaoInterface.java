package com.revature.bankingApp.repository;

import com.revature.bankingApp.repository.DTO.AccountDTO;

public interface AccountDaoInterface {
	
	

	AccountDTO createAccount(Integer userId, Integer balance, Integer accountTypeId);



	AccountDTO createAccount(Integer userId, AccountDTO aDto);

	AccountDTO getAccount(Integer accountId);

	

	void addToAccounBalance(Integer accountId, Double additive);

	AccountDTO createAccount(AccountDTO aDto, Integer userId);

	

	AccountDTO updateAccount(Integer accountId, String column, Double value);

	boolean deleteAccount(Integer accountId);
}
