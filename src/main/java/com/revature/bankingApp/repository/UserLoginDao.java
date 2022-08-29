package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;

public class UserLoginDao implements UserLoginDaoInterface{
	
	Logger consoleLogger;
	Logger fileLogger;
	
	public UserLoginDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		
		
	}

	@Override
	public UserLoginDTO createUserLogin(UserLoginDTO userLogDto) {
		consoleLogger.debug("creating user login with username: " + userLogDto.getUsername());
		fileLogger.debug("Add User login to Database");
		
		final String sql = "INSERT INTO user_login (username, password, user_type_id)"
				+ "values ('"+userLogDto.getUsername()+"','"+userLogDto.getPassword()+"' , '"+userLogDto.getUserTypeId()+"')";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				userLogDto = new UserLoginDTO(
						set.getInt(1), set.getString(2),
						set.getString(3),
						set.getInt(4), set.getInt(5));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		return userLogDto;
	}

	@Override
	public UserLoginDTO getUserLogin(UserLoginDTO userLogDto) {
		
		consoleLogger.debug("Getting user login with username and password: " + userLogDto.getUsername() + " " + userLogDto.getPassword());
		fileLogger.debug("Get User login from Database");
		
		final String sql = "SELECT * FROM user_login WHERE username =  '"+userLogDto.getUsername()+"' AND password = '"+userLogDto.getPassword()+"'";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			
			
			if(set.next()) {
				
				userLogDto = new UserLoginDTO(
						set.getInt(1), set.getString(2),
						set.getString(3),
						set.getInt(4), set.getInt(5));
				
			}
			
			if (userLogDto.getUserLoginId() == null) {
				userLogDto.setUsername(null);
				userLogDto.setPassword(null);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		return userLogDto;
		
		
		
		
		
	}

	@Override
	public UserLoginDTO updateUserLogin(String username, String column, String value) {
		UserLoginDTO userLogDto = new UserLoginDTO();
		consoleLogger.debug("Getting userLogin: " + username);
		fileLogger.debug("Get User from Database");
		
		String columnFormatted = "\"" + column + "\"";
		
		final String sql = "UPDATE user_login SET "+columnFormatted+" = '"+value+"' WHERE username = '"+username+"';";
		System.out.println(sql);
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					userLogDto = new UserLoginDTO(
							set.getInt(1), set.getString(2),
							set.getString(3),
							set.getInt(4), set.getInt(5));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return userLogDto;
	}
	
	@Override
	public UserLoginDTO updateUserLogin(String username, String column, Integer value) {
		UserLoginDTO userLogDto = new UserLoginDTO();
		consoleLogger.debug("Getting userLogin: " + username);
		fileLogger.debug("Get User from Database");
		
		String columnFormatted = "\"" + column + "\"";
		
		final String sql = "UPDATE user_login SET "+columnFormatted+" = '"+value+"' WHERE username = '"+username+"';";
		System.out.println(sql);
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					userLogDto = new UserLoginDTO(
							set.getInt(1), set.getString(2),
							set.getString(3),
							set.getInt(4), set.getInt(5));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return userLogDto;
	}

	@Override
	public boolean deleteUserLogin(String username) {
		consoleLogger.debug("deleting user with username: " + username);
		fileLogger.debug("Remove User to Database");
		
		final String sql = "DELETE FROM user_login WHERE username = '"+username+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			set.next();
			
//			if(set.next())set {
//				userLogDto = new UserLoginDTO(
//						set.getInt(1), set.getString(2),
//						set.getString(3),
//						set.getInt(4), set.getInt(5));
//			}
			
		
		} catch (SQLException e) {
			
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		
		
		return false;
	}
	


}
