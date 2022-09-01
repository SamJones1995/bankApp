package com.revature.bankingApp.services;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.core.views.UserMenu;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;

public class CreateBankAccountService {
	
	public static void createBankAccount(Integer userId, Integer userLoginId) throws UserNotFoundException {
		
		String checking = "Checking";
		String savings = "Savings";
		String cD = "Certificate of Deposit";
		String accountTypeString = "";
		
		System.out.println("Please enter one of the bank account types below or CANCEL to go back");
		
	
		
		System.out.println("1 - " + checking);
		System.out.println("2 - " + savings);
		System.out.println("3 - " + cD);
		
		Integer accountType = Util.scanner.nextInt();
			if (accountType.equals(1)) {
				accountTypeString = checking;
			}
			if (accountType.equals(2)) {
				accountTypeString = savings;
			}
			if (accountType.equals(3)) {
				accountTypeString = cD;
			}
		
		System.out.println("Please enter initial deposit (minimum $50)");
		
		Double balance = Util.scanner.nextDouble();
		
		System.out.println("You are applying for a " + accountTypeString + " account with an initial deposit of " + balance);
		System.out.println("Please enter CONFIRM to submit application or CANCEL to return to menu");
			String entry = Util.scanner.next();
			
			if (entry.equals("CONFIRM")) {
				
				AccountDao.createAccount(userId, balance, accountType);
				UserMenu.Menu(userLoginId);
				
			}
			if (entry.equals("CANCEL")) {
				
				UserMenu.Menu(userLoginId);
				
				
			}
			
	}

}
