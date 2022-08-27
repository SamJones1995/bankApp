package com.revature.bankingApp.controller;

import com.revature.bankingApp.core.Validation;
import com.revature.bankingApp.core.util.Util;

public class ApplicationEntries {
	
	public static String firstNameEntry() {
	System.out.println("Please enter First Name");	
	String name = Util.scanner.nextLine();
	
	boolean isValid = Validation.isValidName(name);
	if (isValid = true) {
		System.out.println("You entered " + name);
		//save name to DB
	}
	if (isValid = false) {
		System.out.println("You're entry " + name + "is invalid, please try again");
		firstNameEntry();
	}
	
	return name;
	
	}
	
	public static String lastNameEntry() {
	
	System.out.println("Please enter Last Name");	
	
	
	String nameLast = Util.scanner.nextLine();
	
	boolean isValidLast = Validation.isValidName(nameLast);
	if (isValidLast = true) {
		System.out.println("You entered " + nameLast);
		
		return nameLast;
		//save name to DB
	}
	if (isValidLast = false) {
		System.out.println("You're entry " + nameLast + "is invalid, please try again");
		lastNameEntry();
	}
	return nameLast;
	
	}
	
	public static String addressEntry() {
		System.out.println("Please enter address");
		
		String address = Util.scanner.nextLine();
		
		boolean isValidAddress = Validation.isValidAddress(address);
		
		if (isValidAddress = true) {
			System.out.println("You entered " + address);
			
			return address;
			
		}
		
		if (isValidAddress = false) {
			System.out.println("You're entry " + address + "is invalid, please try again");
			addressEntry();
		}
		
		return address;
	}
	
}
