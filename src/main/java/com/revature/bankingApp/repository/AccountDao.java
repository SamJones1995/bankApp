package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.AccountDTO;
import com.revature.bankingApp.repository.DTO.UserDTO;

public class AccountDao implements AccountDaoInterface{
	
	Logger consoleLogger;
	Logger fileLogger;
	
	public AccountDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		
		
	}

	@Override
	public AccountDTO createAccount(AccountDTO aDto, Integer userId) {
		consoleLogger.debug("creating bank account with typeId: " + aDto.getAccountTypeId());
		fileLogger.debug("Add bank account to Database");
		
		final String sql = "INSERT INTO accounts (balance, account_type_id, approved)"
				+ "values ('"+aDto.getBalance()+"','"+aDto.getAccountTypeId()+"' , FALSE) returning account_id, balance, account_type_id, approved;";
		
		
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				aDto = new AccountDTO(
						set.getInt(1), set.getDouble(2),
						set.getInt(3),
						set.getBoolean(4));
				
				
				
			}
			
			
			
			UserAccountsBridgeDao uDao = new UserAccountsBridgeDao();
			
			uDao.createUserAccountBridge(userId, aDto.getAccountId());
			
			consoleLogger.info(aDto.toString());
		
		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		
		
		
		
		return aDto;
		
	}

	@Override
	public AccountDTO getAccount(Integer accountId) {
		AccountDTO aDto = new AccountDTO();
		consoleLogger.debug("Getting account: " + accountId);
		fileLogger.debug("Get User from Database");
		
		final String sql = "SELECT * FROM accounts WHERE account_id = '"+accountId+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				
				if(set.next()) {
					aDto = new AccountDTO(
							set.getInt(1), set.getDouble(2),
							set.getInt(3),
							set.getBoolean(4));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return aDto;
	
	}

	@Override
	public void addToAccounBalance(Integer accountId, Double additive) {
		AccountDTO aDto = new AccountDTO();		
		
		consoleLogger.debug("Adding " + additive + "account balance: " + accountId);
		fileLogger.debug("Adding to Account from Database");
		
		aDto = getAccount(accountId);
		
		additive += aDto.getBalance();
		
		
		final String sql = "UPDATE accounts SET balance = '"+additive+"' WHERE account_id = '"+accountId+"';";
		
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
//				if(set.next()) {
//					uDto = new UserDTO(
//							set.getInt(1), set.getString(2),
//							set.getString(3),
//							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
//				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		System.out.println(aDto.getBalance());
		
	}
	
	public void subtractFromAccountBalance(Integer accountId, Double subtractor) {
		
AccountDTO aDto = new AccountDTO();		
		
		consoleLogger.debug("Subtracting " + subtractor + "account balance: " + accountId);
		fileLogger.debug("subtracting from Account from Database");
		
		aDto = getAccount(accountId);
		
		Double newBalance = aDto.getBalance() - subtractor;
		
		
		final String sql = "UPDATE accounts SET balance = '"+newBalance+"' WHERE account_id = '"+accountId+"';";
		
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
//				if(set.next()) {
//					uDto = new UserDTO(
//							set.getInt(1), set.getString(2),
//							set.getString(3),
//							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
//				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		System.out.println(aDto.getBalance());
		
	}
	
	public void transferToAnotherAccount(Integer accountId1, Integer accountId2, Double amount) {
		consoleLogger.debug("Removing " + amount + " from account balance: " + accountId1 + "and adding to " + accountId2);
		fileLogger.debug("Adding to Account from Database");
		AccountDTO aDto = new AccountDTO();	
		
		aDto = getAccount(accountId2);
	
		subtractFromAccountBalance(accountId1, amount);
		
		amount += aDto.getBalance();
		
		
		final String sql = "UPDATE accounts SET balance = '"+amount+"' WHERE account_id = '"+accountId2+"';";
		
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
//				if(set.next()) {
//					uDto = new UserDTO(
//							set.getInt(1), set.getString(2),
//							set.getString(3),
//							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
//				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		System.out.println(aDto.getBalance());
	}
		
	

	@Override
	public boolean deleteAccount(Integer accountId) {
		consoleLogger.debug("deleting account with accountId: " + accountId);
		fileLogger.debug("Remove Account from Database");
		
		final String sql = "DELETE FROM accounts WHERE account_id = '"+accountId+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
//			if(set.next()) {
//				uDto = new UserDTO(
//						set.getInt(1), set.getString(2),
//						set.getString(3),
//						set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
//			}
			
		
		} catch (SQLException e) {
			
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		
		
		return false;
		
	}


	@Override
	public AccountDTO createAccount(Integer userId, Integer balance, Integer accountTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDTO createAccount(Integer userId, AccountDTO aDto) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public AccountDTO updateAccount(Integer accountId, String column, Double value) {
		AccountDTO aDto = new AccountDTO();	
		consoleLogger.debug("Updating account: " + accountId);
		fileLogger.debug("Update account from Database");
		
		String columnFormatted = "\"" + column + "\"";
		
		final String sql = "UPDATE accounts SET "+columnFormatted+" = '"+value+"' WHERE account_id = '"+accountId+"';";
		System.out.println(sql);
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					aDto = new AccountDTO(
							set.getInt(1), set.getDouble(2),
							set.getInt(3),
							set.getBoolean(4));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return aDto;
		
	}







}
