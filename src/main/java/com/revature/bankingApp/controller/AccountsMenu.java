package com.revature.bankingApp.controller;

import java.util.ArrayList;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.core.views.ApplyAccount;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.DTO.AccountDTO;

public class AccountsMenu {
	
	public static void accountsMenu(Integer userId) {
		
		System.out.println("Please enter 1 to view accounts and 2 to apply for new account");
		
		Integer entry = Util.scanner.nextInt();
		
		if (entry.equals(1)) {
			AccountDao aDao = new AccountDao();
			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
			
			ArrayList<Integer> accountIds = uDao.getUserAccountBridge(userId);
			
			System.out.println(accountIds);
			
			for (int i = 0; i < accountIds.size(); i++) {
				AccountDTO aDto = aDao.getAccount(accountIds.get(i));

				System.out.println(aDto.toString());
				
			}
			
			System.out.println("To make a transaction enter 1 or to go back to User menu enter 2");
			
			Integer entry2 = Util.scanner.nextInt();
			
			if (entry2.equals(1)) { 
				
				TransactionMenu.transactionMenu(userId);
				
			}
			
			if (entry2.equals(2)) {
				UserMenu.Menu(userId);
			}
			
			
			
		}
		
		if (entry.equals(2)) {
			
			ApplyAccount.applyAccount(userId);
			
		}
		
	}

}
