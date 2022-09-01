package com.revature.bankingApp.core.views;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.UserDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;
import com.revature.bankingApp.services.Validation;

public class UserDetailsEntry {
	static String regexName = "^[A-Za-z]{1,15}$";

	protected String firstName;
	
	protected String lastName;
	
	protected String address;

	protected String address2;
	
	protected String city;
	
	protected String state;
	
	protected String zip;
	
	protected String ssn;
	
	protected String email;
	
	

	
	public void newUserSetup(Integer userLoginId) throws UserNotFoundException {
		System.out.println("Would you like to apply to open an account? Enter YES or NO");
		String application = Util.scanner.next();
		if (application.equals("YES")) {

			System.out.println("Please enter First Name");

			firstName = Util.scanner.next();

			while (!Validation.isValidName(firstName)) {
				System.out.println("Invalid entry please try again");
				firstName = Util.scanner.next();

			}
			
			System.out.println("Please enter Last Name");

			lastName = Util.scanner.next();
			
			while (!Validation.isValidName(lastName)) {
				System.out.println("Invalid entry please try again");
				lastName = Util.scanner.next();

			}
			Util.scanner.nextLine();
			System.out.println("Pleae enter address");
			
			address = Util.scanner.nextLine();
			
			while (Validation.isValidAddress(address)) {
				System.out.println("Invalid entry please try again");
				address = Util.scanner.nextLine();

			}
			
			
			
			System.out.println("Do you have a second address line? Enter YES or NO");
			
			String entry = Util.scanner.next();
			if (entry.equals("YES")) {
				Util.scanner.nextLine();
				System.out.println("Please enter address line 2");
				address2 = Util.scanner.nextLine();
			
				
				while (Validation.isValidAddress(address2)) {
					System.out.println("Invalid entry please try again");
					address2 = Util.scanner.nextLine();

				}
				
				
			}
			
			if (entry.equals("NO")) {
				String address2 = null;
				
			}
			
			
			System.out.println("Pleae enter city");
			
			city = Util.scanner.next();
			
			while (!Validation.isValidName(city)) {
				System.out.println("Invalid entry please try again");
				city = Util.scanner.next();

			}

			System.out.println("Pleae enter state");
			
			state = Util.scanner.next();
			
			while (!Validation.isValidState(state)) {
				System.out.println("Invalid entry please try again");
				state = Util.scanner.next();

			}

			System.out.println("Pleae enter zip");
			
			zip = Util.scanner.next();
			
			while (!Validation.isValidZip(zip)) {
				System.out.println("Invalid entry please try again");
				zip = Util.scanner.next();

			}

			System.out.println("Pleae enter SSN");
			
			ssn = Util.scanner.next();
			
			while (!Validation.isValidSsn(ssn)) {
				System.out.println("Invalid entry please try again");
				ssn = Util.scanner.next();

			}

			System.out.println("Pleae enter email");
			
			email = Util.scanner.next();
			
			while (Validation.isValidEmail(email)) {
				System.out.println("Invalid entry please try again");
				email = Util.scanner.next();

			}

			System.out.println(
					"Please enter CONFIRM with the following information is correct. Or enter CANCEL to try again");
			
			if (address2 == null) {
				address2 = " ";
			}

			System.out.println("Name: " + firstName + " " + lastName);
			System.out.println("Address: " + address + " " + address2 + " " + city + " " + state + " " + zip);
			System.out.println("SSN: " + ssn);
			System.out.println("Email: " + email);

			String confirmation = Util.scanner.next();

				if (confirmation.equals("CONFIRM")) {
					UserDao uDao = new UserDao();
					UserDTO uDto = new UserDTO(firstName, lastName, address, address2, city, state, Integer.valueOf(zip), Integer.valueOf(ssn), email);
					uDao.createUser(uDto);
	
					UserLoginDao.updateUserLogin(userLoginId, "user_id", UserDao.getUser(Integer.valueOf(ssn)).getUserId());
	
					UserMenu.Menu(userLoginId);
	
				}
	
				if (confirmation.equals("CANCEL")) {
					UserDetailsEntry uD = new UserDetailsEntry();
					uD.newUserSetup(userLoginId);
				}


			if (application.equals("NO")) {
				System.out.println("Would you like to return to main menu?");
				String backToMain = Util.scanner.next();
				if (backToMain.equals("NO")) {
					newUserSetup(userLoginId);
				}
				if (backToMain.equals("YES")) {
					UserMenu.Menu(userLoginId);
				}
			}
		}

	}


}
