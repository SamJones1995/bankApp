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
		
		consoleLogger.debug("Getting user login with username: " + userLogDto.getUsername());
		fileLogger.debug("Get User login from Database");
		
		final String sql = "SELECT * FROM user_login WHERE username =  '"+userLogDto.getUsername()+"'";
		
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
	public UserLoginDTO updateUserLogin(Integer ssn, String column, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserLogin(UserLoginDTO uLogin) {
		// TODO Auto-generated method stub
		return false;
	}

}
