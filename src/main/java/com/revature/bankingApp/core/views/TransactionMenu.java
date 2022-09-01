package com.revature.bankingApp.core.views;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.EmployeeAssignmentDao;
import com.revature.bankingApp.repository.UserLoginDao;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;
import com.revature.bankingApp.services.ValidateAccountOwner;

public class TransactionMenu {
	
	public static void transactionMenu(UserLoginDTO uDto) throws UserNotFoundException {
		
		EmployeeAssignmentDao eDao = new EmployeeAssignmentDao();
		
		AccountDao aDao = new AccountDao();
		Integer userType = uDto.getUserTypeId();
		System.out.println(uDto.toString());
		
		
		System.out.println("Please enter the corresponding number to the below options");
		System.out.println("1 - Withdraw");
		System.out.println("2 - Deposit");
		System.out.println("3 - Transfer");
		System.out.println("4 - GO BACK");
		
		Integer entry = Util.scanner.nextInt();
		
		if (entry.equals(1)) {
			System.out.println("Please enter the account number you would like to draw from");
			Integer accountToWithdraw = Util.scanner.nextInt();
			
			if (((ValidateAccountOwner.validateAccountOwner(accountToWithdraw, uDto.getUserId())) == false) && (userType == 1)){
				System.out.println("You can only withdraw from approved accounts that you own");
				TransactionMenu.transactionMenu(uDto);
			}
			
			
			
			
			System.out.println("Please enter the amount you wish to withdraw");
			Double amountToWithdraw = Util.scanner.nextDouble();
			
			if (amountToWithdraw < 0) {
				System.out.println("Please enter a positive number");
				TransactionMenu.transactionMenu(uDto);
			}
			
			if (amountToWithdraw > aDao.getAccount(accountToWithdraw).getBalance()) {
				System.out.println("Please enter an amount less than the total balance of account: " + accountToWithdraw + "balance: " + aDao.getAccount(accountToWithdraw).getBalance());
				TransactionMenu.transactionMenu(uDto);
			}
			
			System.out.println("You wish to withdraw " + amountToWithdraw + "from account number " + accountToWithdraw + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.next();
			
			if (entry2.equals("CONFIRM")) {
//				AccountDao aDao = new AccountDao();
				
				aDao.subtractFromAccountBalance(accountToWithdraw, amountToWithdraw);
				TransactionMenu.transactionMenu(uDto);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(uDto);
			}
		}
		

		if (entry.equals(2)) {
			System.out.println("Please enter the account number you would like to deposit to");
			Integer accountToDeposit = Util.scanner.nextInt();
			
			System.out.println("Please enter the amount you wish to deposit");
			Double amountToDeposit = Util.scanner.nextDouble();
			
			if (amountToDeposit < 0) {
				System.out.println("Please enter a positive number");
				TransactionMenu.transactionMenu(uDto);
			}
			
			System.out.println("You wish to deposit " + amountToDeposit + "to account number " + accountToDeposit + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.next();
			
			if (entry2.equals("CONFIRM")) {
//				AccountDao aDao = new AccountDao();
				
				aDao.addToAccounBalance(accountToDeposit, amountToDeposit);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(uDto);
			}
		}
		
		if (entry.equals(3)) {
			System.out.println("Please enter the account number you would like to deposit to");
			Integer accountToDepositTo = Util.scanner.nextInt();
			System.out.println("Please enter the account you wish to withdraw from");
			Integer accountToWithdrawFrom = Util.scanner.nextInt();
			if (((ValidateAccountOwner.validateAccountOwner(accountToWithdrawFrom, uDto.getUserId())) == false) && (userType == 1)){
				System.out.println("You can only withdraw from approved accounts that you own");
				TransactionMenu.transactionMenu(uDto);
			}
			System.out.println("Please enter the ammount you wish to transfer");
			Double amountToTransfer = Util.scanner.nextDouble();
			if (amountToTransfer < 0) {
				System.out.println("Please enter a positive number");
				TransactionMenu.transactionMenu(uDto);
			}
			
			if (amountToTransfer > aDao.getAccount(accountToWithdrawFrom).getBalance()) {
				System.out.println("Please enter an amount less than the total balance of account: " + accountToWithdrawFrom + "balance: " + aDao.getAccount(accountToWithdrawFrom).getBalance());
				TransactionMenu.transactionMenu(uDto);
			}
			
			
			System.out.println("You wish to deposit " + amountToTransfer + "to account number " + accountToDepositTo + "from account number " + accountToWithdrawFrom + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.next();
			
			if (entry2.equals("CONFIRM")) {
//				AccountDao aDao = new AccountDao();
				
				aDao.transferToAnotherAccount(accountToWithdrawFrom, accountToDepositTo, amountToTransfer);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(uDto);
			}
		}
		
		if (entry.equals(4)) {
			UserMenu.Menu(uDto.getUserLoginId());
		}
	}

}
