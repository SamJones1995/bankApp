package com.revature.bankingApp.core.views;

import java.util.ArrayList;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;
import com.revature.bankingApp.services.CreateBankAccountService;

public class AccountsMenu {
	
	public static void accountsMenu(Integer userLoginId, Integer userId)  {
		
		System.out.println("Please enter 1 to view accounts and 2 to apply for new account");
		
		Integer entry = Util.scanner.nextInt();
		
		if (entry.equals(1)) {
			AccountDao aDao = new AccountDao();
			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
			
			ArrayList<Integer> accountIds = uDao.getUserAccountBridge(userId);
			
			for (int i = 0; i < accountIds.size(); i++) {
				AccountDTO aDto = aDao.getAccount(accountIds.get(i));

				System.out.println(aDto.toString());
				
			}
			
			
			System.out.println("To make a transaction enter 1 or to go back to User menu enter 2");
			
			Integer entry2 = Util.scanner.nextInt();
			
			if (entry2.equals(1)) { 
				
				try {
					TransactionMenu.transactionMenu(UserLoginDao.getUserLoginById(userLoginId));
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if (entry2.equals(2)) {
				try {
					UserMenu.Menu(userId);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("User not found");
				}
			}
			
			
			
		}
		
		if (entry.equals(2)) {
			try {
				CreateBankAccountService.createBankAccount(userId, userLoginId);
			} catch (UserNotFoundException e) {
				System.out.println("User not found");
			}
			
		}
		
	}

}
