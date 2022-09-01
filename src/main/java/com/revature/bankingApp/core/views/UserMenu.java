package com.revature.bankingApp.core.views;


import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;
import com.revature.bankingApp.services.Validation;

public class UserMenu {
	
	
	public static void Menu(Integer userLoginId) throws UserNotFoundException {
		
		UserLoginDTO uDto2 = UserLoginDao.getUserLoginById(userLoginId);
		
	
	
		
		Integer userId = uDto2.getUserId();
		if (uDto2.getUserTypeId() == 2) {
			EmployeeMenu.employeeMenu(uDto2);
		}
		if (userId == 0) {
			UserDetailsEntry uD = new UserDetailsEntry();
			uD.newUserSetup(userLoginId);
			
			
		} else {
			System.out.println("Please type a number corresponding to the options below and hit ENTER"); 
			System.out.println("1 - Accounts and Balances");
			System.out.println("2 - Personal Information");
			String entry = Util.scanner.next();
			
			if (entry.equals("1")) {
				
				AccountsMenu.accountsMenu(userLoginId, userId);
				
			}
			
			if (entry.equals("2")) {
				UserDTO uDto = UserDao.getUserById(UserLoginDao.getUserLoginById(userLoginId).getUserId());
				
				System.out.println("Name: " + uDto.getFirstName() + " " + uDto.getLastName());
				System.out.println("Address: " + uDto.getAddress() + " " + uDto.getAddress2() + " " + uDto.getCity() + " " + uDto.getState() + " " + uDto.getZip());

				System.out.println("SSN: " + uDto.getSsn());
				System.out.println("Email: " + uDto.getEmail());
				
				Util.scanner.nextLine();
				System.out.println("Would you like to update your information? Enter YES to update and NO to return to menu");
				String entry2 = Util.scanner.next();
					
				if (entry2.equals("YES")) {
					System.out.println("Which item would you like to update? Enter the corresponding number.");
					System.out.println("1 - First Name");
					System.out.println("2 - Last Name");
					System.out.println("3 - Address");
					System.out.println("4 - Address Line 2");
					System.out.println("5 - City");
					System.out.println("6 - State");
					System.out.println("7 - Zip code");
					System.out.println("8 - Email");
					
					String attrToUpdate = Util.scanner.next();
					
					if (attrToUpdate.equals("1")) {
						System.out.println("Enter new first name");
						String firstName = Util.scanner.next();
						
						while (!Validation.isValidName(firstName)) {
							System.out.println("Invalid entry please try again");
							firstName = Util.scanner.next();

						}
						
						UserDao.updateUser(uDto.getSsn(), "first_name", firstName);
						
						System.out.println("First Name now: " + firstName);
						UserMenu.Menu(userLoginId);
					}
					
					if (attrToUpdate.equals("2")) {
						System.out.println("Enter new last name");
						String lastName = Util.scanner.next();
						
						while (!Validation.isValidName(lastName)) {
							System.out.println("Invalid entry please try again");
							lastName = Util.scanner.next();

						}
						
						UserDao.updateUser(uDto.getSsn(), "last_name", lastName);
						
						System.out.println("Last Name now: " + lastName);
						UserMenu.Menu(userLoginId);
					}
					
					if (attrToUpdate.equals("3")) {
						System.out.println("Enter new address");
						String address = Util.scanner.nextLine();
						
						while (Validation.isValidAddress(address)) {
							System.out.println("Invalid entry please try again");
							address = Util.scanner.nextLine();

						}
						
						UserDao.updateUser(uDto.getSsn(), "address", address);
						System.out.println("Address now: " + address);
						UserMenu.Menu(userLoginId);
					}
					if (attrToUpdate.equals("4")) {
						System.out.println("Enter new address line 2");
						String address2 = Util.scanner.nextLine();
						
						while (Validation.isValidAddress(address2)) {
							System.out.println("Invalid entry please try again");
							address2 = Util.scanner.nextLine();

						}
						
						UserDao.updateUser(uDto.getSsn(), "address2", address2);
						System.out.println("Address line 2 now: " + address2);
						UserMenu.Menu(userLoginId);
					}
					
					if (attrToUpdate.equals("5")) {
						System.out.println("Enter new city");
						String city = Util.scanner.nextLine();
						while (!Validation.isValidName(city)) {
							System.out.println("Invalid entry please try again");
							city = Util.scanner.next();

						}
						
						UserDao.updateUser(uDto.getSsn(), "city", city);
						System.out.println("City now: " + city);
						UserMenu.Menu(userLoginId);
					}
					
					if (attrToUpdate.equals("6")) {
						System.out.println("Enter new state");
						String state = Util.scanner.next();
						
						while (!Validation.isValidState(state)) {
							System.out.println("Invalid entry please try again");
							state = Util.scanner.next();

						}
						
						
						UserDao.updateUser(uDto.getSsn(), "state", state);
						System.out.println("State now: " + state);
						UserMenu.Menu(userLoginId);
					}
					
					if (attrToUpdate.equals("7")) {
						System.out.println("Enter new zip code");
						String zip = Util.scanner.next();
						
						while (!Validation.isValidZip(zip)) {
							System.out.println("Invalid entry please try again");
							zip = Util.scanner.next();

						}
						
						UserDao.updateUser(uDto.getSsn(), "zip", Integer.valueOf(zip));
						System.out.println("Zip now: " + zip);
						UserMenu.Menu(userLoginId);
					}
					
					if (attrToUpdate.equals("8")) {
						System.out.println("Enter new email");
						String email = Util.scanner.next();
						while (Validation.isValidEmail(email)) {
							System.out.println("Invalid entry please try again");
							email = Util.scanner.next();

						}
						
						UserDao.updateUser(uDto.getSsn(), "email", email);
						System.out.println("Email now: " + email);
						UserMenu.Menu(userLoginId);
					}
					
					
					
				}
				
				if (entry2.equals("NO")) {
					System.out.println("Thank you for using RevBank");
					UserMenu.Menu(userLoginId);
				}
				
				
			}
			
			
		}
		
		
		
		
		
	}
	
	

	

}
