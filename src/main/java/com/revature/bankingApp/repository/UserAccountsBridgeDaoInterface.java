package com.revature.bankingApp.repository;

import java.util.ArrayList;

import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.DTO.UserDTO;

public interface UserAccountsBridgeDaoInterface {
	
	void createUserAccountBridge();
	
	ArrayList<Integer> getUserAccountBridge(UserDTO userId);
	
	void updateUserAccountBridge(UserDTO userId, AccountDTO accountId);
	
	void deleteUserAccountBridge(UserDTO userId, AccountDTO accountId);

	void createUserAccountBridge(UserDTO userId, AccountDTO accountId);

	void createUserAccountBridge(Integer userId, Integer accountId);

	ArrayList<Integer> getUserAccountBridge(Integer userId);

	void updateUserAccountBridge(Integer userId, Integer accountId);

	void deleteUserAccountBridge(Integer userId, Integer accountId);
}
