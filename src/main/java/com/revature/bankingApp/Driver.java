package com.revature.bankingApp;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Thank you for using RevBank if you do not have an account please enter REGISTER or enter LOGIN");
			String input = scanner.next();
			
			LogReg logReg = new LogReg();
			
			logReg.loginReg(input);
			
		}

	}

}