package com.revature.bankingApp.controller;

import java.util.ArrayList;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.EmployeeAssignmentDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;

public class EmployeeMenu {
	
	public static void employeeMenu(UserLoginDTO uDto2) {
		System.out.println("Please type a number corresponding to the options below and hit ENTER"); 
		System.out.println("1 - Accounts and Balances");
		System.out.println("2 - User Information");
		Integer entry = Util.scanner.nextInt();

		EmployeeAssignmentDao eDao = new EmployeeAssignmentDao();
		UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
		ArrayList<Integer> userList = eDao.getEmployeeAssignment(uDto2.getUserLoginId());
		if (entry.equals(1)) {
			
			System.out.println("Your clients: ");
			
			
	
			System.out.println(userList);
			
			
			
			
			for (int i = 0; i < userList.size(); i++) {
				UserDTO uDto = UserDao.getUserById(userList.get(i));

				System.out.println(uDto.toString());
				
			}
			
			
			
				
				System.out.println("Please enter the userId of the user bank account you would like to view");
				
				Integer userIdEntry = Util.scanner.nextInt();
				ArrayList<Integer> arrInt = uDao.getUserAccountBridge(userIdEntry);
				System.out.println(arrInt);
				
				if (!userList.contains(userIdEntry) && uDto2.getUserTypeId() ==2) {
					System.out.println("You only have access to your assigned clients");
					EmployeeMenu.employeeMenu(uDto2);
				}
				
				if (arrInt.size() == 0) {
					System.out.println("No accounts please try again");
					EmployeeMenu.employeeMenu(uDto2);
				} 
					
				
				
				EmployeeAccountsMenu.employeeAccountsMenu(uDto2, userIdEntry);
				
			
			
			
			
		}
		
		if (entry.equals(2)) {
			System.out.println("Please enter the userId of the user account you would like to view");
			Integer userIdEntry = Util.scanner.nextInt();
			
			if (!userList.contains(userIdEntry) && uDto2.getUserTypeId() ==2) {
				System.out.println("You only have access to your assigned clients");
				EmployeeMenu.employeeMenu(uDto2);
			}
			
			UserDao userDao = new UserDao();
			UserDTO uDto = userDao.getUserById(userIdEntry);
			
			
			System.out.println(uDto.getFirstName() + " " + uDto.getLastName());
			System.out.println(uDto.getAddress() + " " + uDto.getAddress2());
			System.out.println(uDto.getCity() + " " + uDto.getState() + " " + uDto.getZip());
			System.out.println("SSN: " + uDto.getSsn());
			System.out.println("Email: " + uDto.getEmail());
			
			EmployeeMenu.employeeMenu(uDto2);
			
		}
		
	}


	
}
