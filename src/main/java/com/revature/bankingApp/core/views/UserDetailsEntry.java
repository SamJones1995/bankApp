package com.revature.bankingApp.core.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.bankingApp.controller.ApplicationEntries;
import com.revature.bankingApp.controller.UserMenu;
import com.revature.bankingApp.core.Validation;
import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserDTO;

public class UserDetailsEntry {
	static String regexName = "^[A-Za-z]{1,15}$";
	
	protected static String firstName = "";
	
	
	
	
	public static void newUserSetup(Integer userLoginId) {
		System.out.println("Would you like to apply to open an account? Enter YES or NO");
		String application = Util.scanner.next();
		if (application.equals("YES")) {
			
			String firstName = ApplicationEntries.firstNameEntry();
			
			
		
				
				
//				
//				System.out.println("Please enter First Name");	
//				
//				String name = Util.scanner.next();
//				
//				
//				
//				 Pattern pattern = Pattern.compile(regexName);
//			    Matcher matcher = pattern.matcher(name);
//			    
//			    boolean bool = true;
//				
//				while (bool) {    
//					if (matcher.matches() == true) {
//					
//						System.out.println("You entered " + name);
//						
//						firstName = name;;
//						bool = false;
//						
//					} else {
//						System.out.println("Please enter valid name");
//						ApplicationEntries.firstNameEntry();
//						
//					}
//				}
				
			
			
			
			
			String lastName = ApplicationEntries.lastNameEntry();
			
			String address = ApplicationEntries.addressEntry();
			
			String address2 = ApplicationEntries.address2Entry();
			
			String city = ApplicationEntries.cityEntry();
			
			String state = ApplicationEntries.stateEntry();
			
			Integer zip = ApplicationEntries.zipEntry();
			
			Integer ssn = ApplicationEntries.ssnEntry();
			
			String email = ApplicationEntries.emailEntry();
			
			System.out.println("Please enter CONFIRM with the following information is correct. Or enter CANCEL to try again");
			
			System.out.println(firstName + " " + lastName);
			System.out.println(address + " " + address2);
			System.out.println(city + " " + state + " " + zip);
			System.out.println("SSN: " + ssn);
			System.out.println("Email: " + email);
			
			String confirmation = Util.scanner.next();
			
			if (confirmation.equals("CONFIRM")) {
				UserDao uDao = new UserDao();
				UserDTO uDto = new UserDTO(firstName, lastName, address, address2, city, state,
						zip, ssn, email);
				uDao.createUser(uDto);
				
				
				UserLoginDao.updateUserLogin(userLoginId, "user_id", UserDao.getUser(ssn).getUserId());
				
				UserMenu.Menu(userLoginId);
				
				
			}
			
			if (confirmation.equals("CANCEL")) {
				UserDetailsEntry.newUserSetup(userLoginId);
			}
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
