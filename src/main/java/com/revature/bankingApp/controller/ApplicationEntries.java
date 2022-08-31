package com.revature.bankingApp.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.bankingApp.core.Validation;
import com.revature.bankingApp.core.util.Util;

public class ApplicationEntries {
	
	static String regexName = "^[A-Za-z]{1,15}$";
	
	static String regexAddress = "^[a-zA-Z0-9\\\\s]*{1,25}$"; 
	
	static String regexState = "^[A-Za-z]{1,2}$";
	
	static String regexZip = "^[0-9]{5}$";
	
	static String regexSsn = "^[0-9]{9}$";
	
	static String regexEmail = "^[A-Za-z0-9]{1,25}$";
	
	
	
	public static String firstNameEntry() {
		
		System.out.println("Please enter First Name");	
		
		String name = Util.scanner.next();
		
		
		
		 Pattern pattern = Pattern.compile(regexName);
	     Matcher matcher = pattern.matcher(name);
		
		if (matcher.matches() == true) {
		
			System.out.println("You entered " + name);
			return name;
		} else {
			System.out.println("Please enter valid name");
			
			return ApplicationEntries.firstNameEntry();
		}
		
		
	
	}
	
	public static String lastNameEntry() {
		
	
		
		System.out.println("Please enter Last Name \n");	
		
		String nameLast = Util.scanner.next();
		
		 Pattern pattern = Pattern.compile(regexName);
	     Matcher matcher = pattern.matcher(nameLast);
	        
		
		
		if (matcher.matches() == true) {
			
			
			System.out.println("You entered " + nameLast);
			return nameLast;
		} else {
			System.out.println("Please enter valid name");
	
			return ApplicationEntries.lastNameEntry();
		}
		
	
	}
	
	public static String addressEntry() {
		Util.scanner.nextLine();
		System.out.println("Please enter address \n");
		
		String address = Util.scanner.nextLine();
		
		 Pattern pattern = Pattern.compile(regexAddress, Pattern.CASE_INSENSITIVE);
	     Matcher matcher = pattern.matcher(address);
		
	     boolean isNotSpec = matcher.find();
	     
	     System.out.println(isNotSpec);
		
		if (isNotSpec == true) {
			
			System.out.println("Please enter valid address");
			
			return ApplicationEntries.addressEntry();
			
			
				
			
		} else {
			System.out.println("You entered " + address);
			return address;
		}
		
		
	}
	
	public static String address2Entry() {
		System.out.println("Do you have a second address line? Enter YES or NO");
		String address2 = null;
		String entry = Util.scanner.next();
		if (entry.equals("YES")) {
			
		
			Util.scanner.nextLine();
			System.out.println("Please enter address line 2");
			
			address2 = Util.scanner.nextLine();
			
			 Pattern pattern = Pattern.compile(regexAddress, Pattern.CASE_INSENSITIVE);
		     Matcher matcher = pattern.matcher(address2);
		     
		     boolean isNotSpec = matcher.find();
			
			
			if (isNotSpec == true) {
				
				System.out.println("Please enter valid address line 2");
				
				return ApplicationEntries.address2Entry();
				
			} else {
				System.out.println("You entered " + address2);
				return address2;
			}
			
			
		}
		
		if (entry.equals("NO")) {
			return null;
			
		}
		return null;
		
			
			
	}
	
	public static String cityEntry() {
		
		
		System.out.println("Please enter City");	
		
		String city = Util.scanner.next();
		
		 Pattern pattern = Pattern.compile(regexName);
	     Matcher matcher = pattern.matcher(city);
	     
	     
		
		if (matcher.matches() == true) {
			System.out.println("You entered " + city);
			return city;
			
		} else {
			
			
			System.out.println("Please enter valid city");
			
			return ApplicationEntries.cityEntry();
		}
		
	
	}
	
	public static String stateEntry() {
		
		System.out.println("Please enter State (2 letter abbreviation)");	
		
		String state = Util.scanner.next();
		
		Pattern pattern = Pattern.compile(regexState);
	     Matcher matcher = pattern.matcher(state);
	     
	     boolean isNotSpec = matcher.find();
		
		if (isNotSpec == true) {
			
			System.out.println("You entered " + state);
			return state;
			
		} else {
			
			
			System.out.println("Please enter valid state");
			
			return ApplicationEntries.stateEntry();
		}
		
	
	}
	
public static Integer zipEntry() {
	
		System.out.println("Please enter 5 digit zip code");	
		
		String zip = Util.scanner.next();
		
		Pattern pattern = Pattern.compile(regexZip);
	     Matcher matcher = pattern.matcher(zip);
	     
	     boolean isNotSpec = matcher.find();
		
		if (isNotSpec == true) {
			System.out.println("You entered " + zip);
			return Integer.valueOf(zip);
			
		} else {
			
			System.out.println("Please enter valid zip code");
			
			return ApplicationEntries.zipEntry();
		}
		
	
	}

public static Integer ssnEntry() {
	
	System.out.println("Please enter 9 digit SSN (no dashes) \n");	
	
	String ssn = Util.scanner.next();
	
	Pattern pattern = Pattern.compile(regexSsn);
    Matcher matcher = pattern.matcher(ssn);
    
    boolean isNotSpec = matcher.find();
	
	if (isNotSpec == true) {
		System.out.println("You entered " + ssn);
		return Integer.valueOf(ssn);
		
	} else {
		
		System.out.println("Please enter valid SSN");
		
		return ApplicationEntries.ssnEntry();
		
		
	}
	

}

public static String emailEntry() {
	
	
	System.out.println("Please enter email");	
	
	String email = Util.scanner.next();
	
	Pattern pattern = Pattern.compile(regexEmail);
    Matcher matcher = pattern.matcher(email);
    
    boolean isNotSpec = matcher.find();
	
	
	if (isNotSpec == true) {
		System.out.println("Please enter valid email");
		
		return ApplicationEntries.emailEntry();
	
		
	} else {
		System.out.println("You entered " + email);
		return email;
	}
	

}
	
}
