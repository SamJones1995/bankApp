package com.revature.bankingApp.repository;

import java.util.ArrayList;

import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.DTO.UserDTO;

public interface UserAccountsBridgeDaoInterface {

	void createUserAccountBridge(Integer userId, Integer accountId);

	ArrayList<Integer> getUserAccountBridge(Integer userId);

	void updateUserAccountBridge(Integer userId, Integer accountId);

	void deleteUserAccountBridge(Integer userId, Integer accountId);
}









