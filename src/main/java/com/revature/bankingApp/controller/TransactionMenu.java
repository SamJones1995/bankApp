package com.revature.bankingApp.controller;

import com.revature.bankingApp.core.util.Util;
import com.revature.bankingApp.repository.AccountDao;

public class TransactionMenu {
	
	public static void transactionMenu(Integer userId) {
		System.out.println("Please enter the corresponding number to the below options");
		System.out.println("1 - Withdraw");
		System.out.println("2 - Deposit");
		System.out.println("3 - Transfer");
		
		Integer entry = Util.scanner.nextInt();
		
		if (entry.equals(1)) {
			System.out.println("Please enter the account number you would like to draw from");
			Integer accountToWithdraw = Util.scanner.nextInt();
			System.out.println("Please enter the amount you wish to withdraw");
			Double amountToWithdraw = Util.scanner.nextDouble();
			
			System.out.println("You wish to withdraw " + amountToWithdraw + "from account number " + accountToWithdraw + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.nextLine();
			
			if (entry2.equals("CONFIRM")) {
				AccountDao aDao = new AccountDao();
				
				aDao.subtractFromAccountBalance(accountToWithdraw, amountToWithdraw);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(userId);
			}
		}
		

		if (entry.equals(2)) {
			System.out.println("Please enter the account number you would like to deposit to");
			Integer accountToDeposit = Util.scanner.nextInt();
			System.out.println("Please enter the amount you wish to deposit");
			Double amountToDeposit = Util.scanner.nextDouble();
			
			System.out.println("You wish to deposit " + amountToDeposit + "to account number " + accountToDeposit + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.nextLine();
			
			if (entry2.equals("CONFIRM")) {
				AccountDao aDao = new AccountDao();
				
				aDao.addToAccounBalance(accountToDeposit, amountToDeposit);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(userId);
			}
		}
		
		if (entry.equals(3)) {
			System.out.println("Please enter the account number you would like to deposit to");
			Integer accountToDepositTo = Util.scanner.nextInt();
			System.out.println("Please enter the account you wish to withdraw from");
			Integer accountToWithdrawFrom = Util.scanner.nextInt();
			System.out.println("Please enter the ammount you wish to transfer");
			Double amountToTransfer = Util.scanner.nextDouble();
			
			System.out.println("You wish to deposit " + amountToTransfer + "to account number " + accountToDepositTo + "from account number " + accountToWithdrawFrom + "?");
			System.out.println("Enter CONFIRM to continue or enter CANCEL");
			
			String entry2 = Util.scanner.nextLine();
			
			if (entry2.equals("CONFIRM")) {
				AccountDao aDao = new AccountDao();
				
				aDao.transferToAnotherAccount(accountToWithdrawFrom, accountToDepositTo, amountToTransfer);
			} 
			
			if (entry2.equals("CANCEL")){
				TransactionMenu.transactionMenu(userId);
			}
		}
	}

}
