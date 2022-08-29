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
import com.revature.bankingApp.repository.DTO.UserAccountsBridgeDTO;
import com.revature.bankingApp.repository.DTO.UserDTO;

public class UserAccountsBridgeDao implements UserAccountsBridgeDaoInterface{

	Logger consoleLogger;
	Logger fileLogger;
	
	public UserAccountsBridgeDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		
		
	}
	
	
	
	@Override
	public void createUserAccountBridge(Integer userId, Integer accountId) {
		
		consoleLogger.debug("creating user account bridge with userId: " + userId + "and accountId: " + accountId);
		fileLogger.debug("Add bank account to User Database");
		
//		AccountDao aDao = new AccountDao();
//		
//		AccountDTO aDto = aDao.getAccount(accountId);
		
		final String sql = "INSERT INTO user_accounts_bridge (user_id, account_id)"
				+ "values ('"+userId+"','"+accountId+"')";
		
		
		UserAccountsBridgeDTO uBridgeDto = new UserAccountsBridgeDTO();
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				uBridgeDto = new UserAccountsBridgeDTO(
						set.getInt(1), set.getInt(2));
				
			}
			
			
			System.out.println();
			
			
			consoleLogger.info(uBridgeDto.toString());
		
		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		
	
		
	
	}

	@Override
	public ArrayList<Integer> getUserAccountBridge(Integer userId) {
	
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		consoleLogger.debug("Getting user bank account bridge: " + userId);
		fileLogger.debug("Get User from Database");
		
		final String sql = "SELECT * FROM user_accounts_bridge WHERE user_id = '"+userId+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				
				while (set.next()) {
			        Integer result = set.getInt(2); 
			        resultList.add(result);
			    }
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return resultList;
		
	}

	@Override
	public void updateUserAccountBridge(Integer userId, Integer accountId) {
		
		consoleLogger.debug("Updating user bank account bridge: " + accountId);
		fileLogger.debug("Update account from Database");
		
		
		final String sql = "UPDATE user_accounts_bridge SET user_id = '"+userId+"' WHERE account_id = '"+accountId+"';";
		System.out.println(sql);
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
	
		
	}

	@Override
	public void deleteUserAccountBridge(Integer userId, Integer accountId) {
		consoleLogger.debug("deleting user-account bridge  with accountId: " + accountId + "and userId " + userId);
		fileLogger.debug("Remove Account from Database");
		
		final String sql = "DELETE FROM user_accounts_bridge WHERE account_id = '"+accountId+"' AND user_id =  '"+userId+"';";
		
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
		
		
		
		
		
	}



	@Override
	public void createUserAccountBridge() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void createUserAccountBridge(UserDTO userId, AccountDTO accountId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public ArrayList<Integer> getUserAccountBridge(UserDTO userId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateUserAccountBridge(UserDTO userId, AccountDTO accountId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteUserAccountBridge(UserDTO userId, AccountDTO accountId) {
		// TODO Auto-generated method stub
		
	}
	

}
