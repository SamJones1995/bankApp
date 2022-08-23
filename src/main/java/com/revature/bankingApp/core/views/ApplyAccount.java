package com.revature.bankingApp.core.views;

import com.revature.bankingApp.core.util.Util;

public class ApplyAccount {
	
	
	
	public void applyAccount() {
		System.out.println("Would you like to apply to open an account? Enter YES or NO");
		String application = Util.scanner.next();
		if (application.equals("YES")) {
			System.out.println("Please enter First Name");
			String firstName = Util.scanner.next();
			if (firstName.length() > 15) {
				System.out.println("Do not exceed 15 characters");
			}
			if (firstName.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
				System.out.println("Please use only alphanumeric characters");
			} else {
//				writeFirstNameToDB(username);
				System.out.println("First Name accepted");
				
			}
			
			System.out.println("Please enter Last Name");
			String lastName = Util.scanner.next();
			if (lastName.length() > 15) {
				System.out.println("Do not exceed 15 characters");
			}
			if (lastName.matches(".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*")) {
				System.out.println("Please use only alphanumeric characters");
			} else {
//				writeFirstNameToDB(username);
				System.out.println("Last Name accepted");
				
			}
		}
		if (application.equals("NO")) {
			System.out.println("Would you like to return to main menu?");
			String backToMain = Util.scanner.next();
			if (backToMain.equals("NO")) {
				System.out.println("Terminal End");
			}
		}
	}

}
