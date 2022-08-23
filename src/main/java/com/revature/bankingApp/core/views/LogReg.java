package com.revature.bankingApp.core.views;


import com.revature.bankingApp.core.util.Util;

import com.revature.bankingApp.core.UserSetup;


public class LogReg {
	
	public void loginReg() {
		
		
		
System.out.println("Thank you for using RevBank if you do not have an account please enter REGISTER or enter LOGIN");
		
		
			
		
			
			String input = Util.scanner.next();
			
			
			
			
		
		
		if (input.equals("LOGIN")) {
			System.out.println("you're ready to log in");
			
			// LOGIN instructions
		}
		if (input.equals("REGISTER")){
			System.out.println("Please enter Username do not exceed 12 characters");
			UserSetup newUser = new UserSetup();
			
			newUser.userSetup();
			
			ApplyAccount apply = new ApplyAccount();
			apply.applyAccount();
			
		
			
		} else if (!(input.equals("REGISTER")) || !(input.equals("LOGIN"))) {
			System.out.println("Please enter REGISTER or LOGIN");
		}
//			
			}
}
