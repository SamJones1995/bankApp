package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.AccountDTO;

public class AccountDao implements AccountDaoInterface {

	Logger consoleLogger;
	Logger fileLogger;

	public AccountDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");

	}

	@Override
	public AccountDTO createAccount(AccountDTO aDto, Integer userId) {
//		consoleLogger.debug("creating bank account with typeId: " + aDto.getAccountTypeId());
		fileLogger.debug("Add bank account to Database: " + aDto.toString() + " for userId " + userId);

		final String sql = "INSERT INTO accounts (balance, account_type_id, approved)" + "values ('" + aDto.getBalance()
				+ "','" + aDto.getAccountTypeId()
				+ "' , FALSE) returning account_id, balance, account_type_id, approved;";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();

			uDao.createUserAccountBridge(userId, aDto.getAccountId());

		} catch (SQLException e) {
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return aDto;

	}

	@Override
	public AccountDTO getAccount(Integer accountId) {
		AccountDTO aDto = new AccountDTO();
//		consoleLogger.debug("Getting account: " + accountId);
		fileLogger.debug("Get account from Database with accountId " + accountId);

		final String sql = "SELECT * FROM accounts WHERE account_id = '" + accountId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {
				aDto = new AccountDTO(set.getInt(1), set.getDouble(2), set.getInt(3), set.getBoolean(4));
			}

		} catch (SQLException e) {

//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return aDto;

	}

	@Override
	public void addToAccounBalance(Integer accountId, Double additive) {
		AccountDTO aDto = new AccountDTO();

//		consoleLogger.debug("Adding " + additive + "account balance: " + accountId);
		fileLogger.debug("Adding " + additive + "to accountId: " + accountId);

		aDto = getAccount(accountId);

		additive += aDto.getBalance();

		final String sql = "UPDATE accounts SET balance = '" + additive + "' WHERE account_id = '" + accountId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {

//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		System.out.println("New balance: " + aDto.getBalance());

	}

	public void subtractFromAccountBalance(Integer accountId, Double subtractor) {

		AccountDTO aDto = new AccountDTO();

//		consoleLogger.debug("Subtracting " + subtractor + "account balance: " + accountId);
		fileLogger.debug("Subtracting " + subtractor + "from accountId: " + accountId);

		aDto = getAccount(accountId);

		Double newBalance = aDto.getBalance() - subtractor;

		final String sql = "UPDATE accounts SET balance = '" + newBalance + "' WHERE account_id = '" + accountId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {
//
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		System.out.println("New balance: " + aDto.getBalance());

	}

	public void transferToAnotherAccount(Integer accountId1, Integer accountId2, Double amount) {
//		consoleLogger.debug("Removing " + amount + " from account balance: " + accountId1 + "and adding to " + accountId2);
		fileLogger.debug("Removing " + amount + " from account balance: " + accountId1 + "and adding to " + accountId2);
		AccountDTO aDto = new AccountDTO();

		aDto = getAccount(accountId2);

		subtractFromAccountBalance(accountId1, amount);

		amount += aDto.getBalance();

		final String sql = "UPDATE accounts SET balance = '" + amount + "' WHERE account_id = '" + accountId2 + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {

//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		System.out.println("New balance: " +aDto.getBalance());
	}

	@Override
	public boolean deleteAccount(Integer accountId) {
//		consoleLogger.debug("deleting account with accountId: " + accountId);
		fileLogger.debug("Deleting account with accountId: " + accountId);

		final String sql = "DELETE FROM accounts WHERE account_id = '" + accountId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {

//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return false;

	}

	public static AccountDTO createAccount(Integer userId, Double balance, Integer accountTypeId) {
		Logger consoleLogger = LoggerFactory.getLogger("consoleLogger");
		Logger fileLogger = LoggerFactory.getLogger("fileLogger");
//		consoleLogger.debug("creating bank account with typeId: " + accountTypeId + "for userId: " + userId);
		fileLogger.debug("Creating bank account with typeId: " + accountTypeId + "for userId: " + userId
				+ " with an initial balance of " + balance);

		final String sql = "INSERT INTO accounts (balance, account_type_id, approved)" + "values ('" + balance + "','"
				+ accountTypeId + "' , FALSE) returning account_id, balance, account_type_id, approved;";

		AccountDTO aDto = new AccountDTO();

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);


			// assign user to bank account
			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();

			uDao.createUserAccountBridge(userId, aDto.getAccountId());

			// assign bank account to employee
			EmployeeAssignmentDao eDao = new EmployeeAssignmentDao();

			UserLoginDao uLogDao = new UserLoginDao();

			ArrayList<Integer> list = uLogDao.getUserLoginsByType(2);

			int indexTop = list.size() - 1;

			Integer index = (int) (Math.random() * (indexTop + 1));

			eDao.createEmployeeAssignment(userId, (Integer) list.get(index));

			consoleLogger.info(aDto.toString());

		} catch (SQLException e) {
		
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return aDto;
	}

	@Override
	public AccountDTO updateAccount(Integer accountId, String column, Double value) {
		AccountDTO aDto = new AccountDTO();
//		consoleLogger.debug("Updating account: " + accountId);
		fileLogger.debug("Update " + column + " of account " + accountId + " to " + value);

		String columnFormatted = "\"" + column + "\"";

		final String sql = "UPDATE accounts SET " + columnFormatted + " = '" + value + "' WHERE account_id = '"
				+ accountId + "';";
		System.out.println(sql);

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {
		
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return aDto;

	}

	public AccountDTO updateAccount(Integer accountId, String column, boolean value) {
		AccountDTO aDto = new AccountDTO();
//		consoleLogger.debug("Updating account: " + accountId);
		fileLogger.debug("Update " + column + " of account " + accountId + " to " + value);

		String columnFormatted = "\"" + column + "\"";

		final String sql = "UPDATE accounts SET " + columnFormatted + " = '" + value + "' WHERE account_id = '"
				+ accountId + "';";
		System.out.println(sql);

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {
		
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return aDto;

	}

}
