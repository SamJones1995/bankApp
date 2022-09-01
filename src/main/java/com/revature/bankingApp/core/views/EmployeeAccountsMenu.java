package com.revature.bankingApp.core.views;

import java.util.ArrayList;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;

public class EmployeeAccountsMenu {
	
public static void employeeAccountsMenu(UserLoginDTO uDto2, Integer userId) throws UserNotFoundException {
		
			AccountDao aDao = new AccountDao();
			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
			
			ArrayList<Integer> accountIds = uDao.getUserAccountBridge(userId);
			
			System.out.println(accountIds);
			
			for (int i = 0; i < accountIds.size(); i++) {
				AccountDTO aDto = aDao.getAccount(accountIds.get(i));

				System.out.println(aDto.toString());
				
			}
			
			System.out.println("Please choose from the options below:");
			System.out.println("1 - Make a transaction");
			System.out.println("2 - Approve/Deny applications");
			System.out.println("3 - Return to previous menu");
			
			Integer entry2 = Util.scanner.nextInt();
			
			if (entry2.equals(1)) { 
				System.out.println();
				EmployeeTransactionMenu.employeeTransactionMenu(uDto2);
				
			}
			
			if (entry2.equals(2)) {
				ApproveDenyMenu.approveDeny(uDto2, userId);
			}
			
			if (entry2.equals(3)) {
				EmployeeMenu.employeeMenu(uDto2);
			}
			
			
			
		}
		
	
		
	}


