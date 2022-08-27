package com.revature.bankingApp.core.views;

import com.revature.bankingApp.controller.ApplicationEntries;
import com.revature.bankingApp.core.Validation;
import com.revature.bankingApp.core.util.Util;

public class ApplyAccount {
	
	
	
	
	
	public static void applyAccount() {
		System.out.println("Would you like to apply to open an account? Enter YES or NO");
		String application = Util.scanner.next();
		if (application.equals("YES")) {
			
			String firstName = ApplicationEntries.firstNameEntry();
			
			
			
			String lastName = ApplicationEntries.lastNameEntry();
			
			String address = ApplicationEntries.addressEntry();
			
			String addressLineTwo = ApplicationEntries.addressEntry();
			
			String city = ApplicationEntries.addressEntry();
			
			String state = ApplicationEntries.addressEntry();
			
			String zip = ApplicationEntries.addressEntry();
			
			System.out.println(firstName + lastName);
			System.out.println(address + " " + addressLineTwo);
			System.out.println(city + " " + state + " " + zip);
//
//			if (Validation.nameValidate() == true) {
//				
//			}
			
					
//					if (firstName.length() > 15) {
//						System.out.println("Do not exceed 15 characters");
//						applyAccount();
//					}
//					if (firstName.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
//						System.out.println("Please use only alphanumeric characters");
//						applyAccount();
//					} else 
//					
//					System.out.println("Please enter Last Name");
//					String lastName = Util.scanner.next();
//					if (lastName.length() > 15) {
//						System.out.println("Do not exceed 15 characters");
//						applyAccount();
//					}
//					if (lastName.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
//						System.out.println("Please use only alphanumeric characters");
//						applyAccount();
//					} else {
//		//				writeFirstNameToDB(username);
//						System.out.println("Last Name accepted");
//						
//					}
//					{
//		//				writeFirstNameToDB(username);
//						
//						
//					}
			
		if (application.equals("NO")) {
			System.out.println("Would you like to return to main menu?");
			String backToMain = Util.scanner.next();
			if (backToMain.equals("NO")) {
				System.out.println("Terminal End");
			}
			if (backToMain.equals("YES")) {
				LogReg.loginReg();
			}
		}
	}
		

	}

	private void appNameEntry() {
		// TODO Auto-generated method stub
		
	}
}
