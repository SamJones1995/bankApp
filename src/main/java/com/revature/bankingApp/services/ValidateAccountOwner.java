package com.revature.bankingApp.services;

import java.util.ArrayList;

import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.DTO.AccountDTO;

public class ValidateAccountOwner {
	
	public static boolean validateAccountOwner(Integer accountId, Integer userId) {
		
		UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
		
		ArrayList<Integer> accountsList = uDao.getUserAccountBridge(userId);
		
		for (int i = 0; i < accountsList.size(); i++) {
				if (accountId == accountsList.get(i)) {
					return true;
				}

				
			
		}
		return false;
		
		
		
	}

}
