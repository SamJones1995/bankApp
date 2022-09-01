package com.revature.bankingApp.core.views;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.EmployeeAssignmentDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;

public class EmployeeTransactionMenu {
	
public static void employeeTransactionMenu(UserLoginDTO userLogDto) throws UserNotFoundException {
		
		EmployeeAssignmentDao eDao = new EmployeeAssignmentDao();
		
		AccountDao aDao = new AccountDao();
		UserLoginDao uDao = new UserLoginDao();
//		
//		UserLoginDTO userLogDto = uDao.getUserLogin(userLogId);
		
		Integer userType = userLogDto.getUserTypeId();
		
		
		
		System.out.println("Please enter the corresponding number to the below options");
		System.out.println("1 - Withdraw");
		System.out.println("2 - Deposit");
		System.out.println("3 - Transfer");
		System.out.println("4 - Return to previous menu");
		if (userType ==3) {
			System.out.println("5 - Delete Account");
		}
		
		
		Integer entry = Util.scanner.nextInt();
		
		if (entry.equals(1)) {
			System.out.println("Please enter the account number you would like to draw from");
			Integer accountToWithdraw = Util.scanner.nextInt();
			
			if (!(eDao.getEmployeeAssignment(userLogDto.getUserLoginId()).contains(accountToWithdraw)) && (userType == 2)){
				System.out.println("You can only withdraw from client accounts assigned to you");
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
			
			
			
			
			System.out.println("Please enter the amount you wish to withdraw");
			Double amountToWithdraw = Util.scanner.nextDouble();
			
			if (amountToWithdraw < 0) {
				System.out.println("Please enter a positive number");
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
			
			if (amountToWithdraw > aDao.getAccount(accountToWithdraw).getBalance()) {
				System.out.println("Please enter an amount less than the total balance of account: " + accountToWithdraw + "balance: " + aDao.getAccount(accountToWithdraw).getBalance());
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
			
			System.out.println("You wish to withdraw " + amountToWithdraw + "from account number " + accountToWithdraw + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.next();
			
			if (entry2.equals("CONFIRM")) {
//				AccountDao aDao = new AccountDao();
				
				aDao.subtractFromAccountBalance(accountToWithdraw, amountToWithdraw);
				TransactionMenu.transactionMenu(userLogDto);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(userLogDto);
			}
		}
		

		if (entry.equals(2)) {
			System.out.println("Please enter the account number you would like to deposit to");
			Integer accountToDeposit = Util.scanner.nextInt();
			
			System.out.println("Please enter the amount you wish to deposit");
			Double amountToDeposit = Util.scanner.nextDouble();
			
			if (amountToDeposit < 0) {
				System.out.println("Please enter a positive number");
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
			
			System.out.println("You wish to deposit " + amountToDeposit + "to account number " + accountToDeposit + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.next();
			
			if (entry2.equals("CONFIRM")) {
//				AccountDao aDao = new AccountDao();
				
				aDao.addToAccounBalance(accountToDeposit, amountToDeposit);
			} 
			
			if (entry2.equals("CANCEL")){
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
		}
		
		if (entry.equals(3)) {
			System.out.println("Please enter the account number you would like to deposit to");
			Integer accountToDepositTo = Util.scanner.nextInt();
			System.out.println("Please enter the account you wish to withdraw from");
			Integer accountToWithdrawFrom = Util.scanner.nextInt();
			
			if (!(eDao.getEmployeeAssignment(userLogDto.getUserLoginId()).contains(accountToWithdrawFrom)) && (userType == 2)){
				System.out.println("You can only withdraw from client accounts assigned to you");
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
			
			System.out.println("Please enter the ammount you wish to transfer");
			Double amountToTransfer = Util.scanner.nextDouble();
			if (amountToTransfer < 0) {
				System.out.println("Please enter a positive number");
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);			
				}
			
			if (amountToTransfer > aDao.getAccount(accountToWithdrawFrom).getBalance()) {
				System.out.println("Please enter an amount less than the total balance of account: " + accountToWithdrawFrom + "balance: " + aDao.getAccount(accountToWithdrawFrom).getBalance());
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
			
			
			System.out.println("You wish to deposit " + amountToTransfer + "to account number " + accountToDepositTo + "from account number " + accountToWithdrawFrom + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.next();
			
			if (entry2.equals("CONFIRM")) {
//				AccountDao aDao = new AccountDao();
				
				aDao.transferToAnotherAccount(accountToWithdrawFrom, accountToDepositTo, amountToTransfer);
			} 
			
			if (entry2.equals("CANCEL")){
				EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
			}
		}
		if (entry.equals(4)) {
			EmployeeMenu.employeeMenu(userLogDto);
		}
		
		if (userType == 3) {
			if (entry.equals(5)) {
				System.out.println("Please enter the account ID you would like to delete");
				Integer accountToDelete = Util.scanner.nextInt();
				
				System.out.println("Enter CONFIRM to permenantly delete account ID " + accountToDelete);
				
				String confirmDelete = Util.scanner.next();
				
				if (confirmDelete.equals("CONFIRM")) {
					aDao.deleteAccount(accountToDelete);
					EmployeeTransactionMenu.employeeTransactionMenu(userLogDto);
				}
			}
		}
	}
}
