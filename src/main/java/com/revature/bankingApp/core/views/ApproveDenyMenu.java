package com.revature.bankingApp.core.views;

import java.util.ArrayList;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.EmployeeAssignmentDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;

public class ApproveDenyMenu {
	public static void approveDeny(UserLoginDTO uDto, Integer userId) throws UserNotFoundException {
		
		
			System.out.println("Your accounts: ");
			
			
			EmployeeAssignmentDao eDao = new EmployeeAssignmentDao();
			
			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
			
			AccountDao aDao = new AccountDao();
			Integer userLoginId = uDto.getUserLoginId();
			System.out.println("userLoginId is " + userLoginId);
			ArrayList<Integer> userList = eDao.getEmployeeAssignment(userLoginId);
			System.out.println("userlist " + userList);
			
			
			
		
			
			
			ArrayList<Integer> accountList = uDao.getUserAccountBridge(userId);
			
			
			for (int i = 0; i < accountList.size(); i++) {
//				UserDTO userAccountQueryDto = UserDao.getUserById(userList.get(i));
//				System.out.println(userAccountQueryDto);
				
				AccountDTO aDto = aDao.getAccount(accountList.get(i));
	
				System.out.println(aDto.toString());
				
			}
			
		
		System.out.println("Please enter the accountId");
		
		Integer accountId = Util.scanner.nextInt();
		System.out.println(userList);
		if (!accountList.contains(accountId) && uDto.getUserTypeId() == 2) {
			System.out.println("You only have access to your assigned clients");
			EmployeeMenu.employeeMenu(uDto);
		}
		
		System.out.println("Please select from following options:");
		System.out.println("1 - Approve account");
		System.out.println("2 - Deny account");
		
		Integer entry = Util.scanner.nextInt();
		
	
		
		if (entry.equals(1)) {
			System.out.println("Please confirm the account number you wish to approve");
			Integer accountEntry = Util.scanner.nextInt();
			
			aDao.updateAccount(accountEntry, "approved", true);
			
			
		}
		
		if (entry.equals(2)) {
			System.out.println("Please confirm the account number you wish to deny");
			Integer accountEntry = Util.scanner.nextInt();
			
			aDao.deleteAccount(accountEntry);
		}
		
		EmployeeMenu.employeeMenu(uDto);
		
	}
}
