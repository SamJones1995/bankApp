package com.revature.bankingApp.controller;

import java.util.Scanner;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.DTO.UserDTO;

public class UserMenu implements UserMenuInterface{
	
	
	
	
	

	
	public static void Menu(Integer userId) {
		
		String firstName = "";
		
		if (userId ==0) {
			System.out.println("Please enter personal information");
			Scanner sc = new Scanner(System.in);	
			System.out.println("Please enter first name");
			
	
			FirstNameInput.firstNameInput(sc.next());
			
			
			System.out.println("First name :" + firstName);
			
			System.out.println("Please enter last name");
			String lastName = Util.scanner.nextLine();		
			System.out.println("Last name :" + lastName);
			
			System.out.println("Please enter address line one");
			String address = Util.scanner.nextLine();		
			System.out.println("Address :" + address);
			
			System.out.println("Please enter address line two (Press enter if not applicable");
			String address2 = Util.scanner.nextLine();		
			System.out.println("Address2 :" + address2);
			
			System.out.println("Please enter city");
			String city = Util.scanner.nextLine();		
			System.out.println("City :" + city);
			
			System.out.println("Please enter state");
			String state = Util.scanner.nextLine();		
			System.out.println("State :" + state);
			
			System.out.println("Please enter zip code");
			String zipString = Util.scanner.nextLine();		
			Integer zip = Integer.valueOf(zipString);
			System.out.println("Zip :" + zipString);
			
			System.out.println("Please enter SSN");
			String ssnString = Util.scanner.nextLine();		
			System.out.println("SSN :" + ssnString);
			Integer ssn = Integer.valueOf(ssnString);
			
			System.out.println("Please enter email");
			String email = Util.scanner.nextLine();		
			System.out.println("Email : " + email);
			
				
			
			System.out.println("Please confirm below information is correct");
			
			System.out.println("First name :" + firstName);
			
			System.out.println("Last name :" + lastName);
			
			System.out.println("Address :" + address);
			
			System.out.println("Address2 :" + address2);
			
			System.out.println("City :" + city);
			
			System.out.println("State :" + state);
			
			System.out.println("Zip :" + zip);
			
			System.out.println("SSN :" + ssn);
			
			System.out.println("Email : " + email);
			
			
			
			System.out.println("If above information is correct please enter CONFIRM, if you need to make changes enter CHANGE");
			
			String entry = Util.scanner.nextLine();	
			
			if (entry.equals("CONFIRM")) {
				UserDTO uDto = new UserDTO(firstName, lastName, address, address2, city, state,
						zip, ssn, email);
				
				UserDao uDao = new UserDao();
				
				uDao.createUser(uDto);
				System.out.println("User information saved");
			}
			if (entry.equals("CHANGE")) {
				UserMenu.Menu(0);
			}
			
			
			
		} else {
			System.out.println("Please type a number corresponding to the options below and hit ENTER"); 
			System.out.println("1 - Accounts and Balances");
			System.out.println("2 - Personal Information");
			String entry = Util.scanner.next();
			
			if (entry.equals("1")) {
				
				AccountsMenu.accountsMenu(userId);
				
			}
			
			if (entry.equals("2")) {
				
				
				
			}
			
			
		}
		
		
		
		
		
	}
	
	

	@Override
	public void viewAccounts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewUserInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawFromAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositToAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferToAccount() {
		// TODO Auto-generated method stub
		
	}

}
