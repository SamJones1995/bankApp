package com.revature.bankingApp.services;

import java.util.ArrayList;

import com.revature.bankingApp.repository.AccountDao;
import com.revature.bankingApp.repository.UserAccountsBridgeDao;

public class ValidateAccountOwner {

	public static boolean validateAccountOwner(Integer accountId, Integer userId) {

		UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
		AccountDao aDao = new AccountDao();

		boolean isApproved = aDao.getAccount(accountId).isApproved();
		ArrayList<Integer> accountsList = uDao.getUserAccountBridge(userId);

		if (isApproved == true) {
			for (int i = 0; i < accountsList.size(); i++) {
				if (accountId == accountsList.get(i)) {
					return true;
				}

			}
			return false;

		} else return false;

	}

}
