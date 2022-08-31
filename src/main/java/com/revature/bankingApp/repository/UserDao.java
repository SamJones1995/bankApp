package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.services.models.User;
import com.revature.bankingApp.services.models.UserLogin;

public class UserDao implements UserDaoInterface{
	
	static Logger consoleLogger;
	static Logger fileLogger;
	
	public  UserDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		
		
	}
	
	
//	final String sql = "INSERT INTO users (first_name, last_name, address, city, state, zip, ssn)"
//			+ "values ('bobby', 'belcher', 'newjoysy road', 'Jersey Shore', 'NJ', 44332, 111111111);";
	

	@Override
	public UserDTO createUser(UserDTO uDto) {
		consoleLogger.debug("creating user with username: " + uDto.getFirstName());
		fileLogger.debug("Add User to Database");
		
		final String sql = "INSERT INTO users (first_name, last_name, address, address2, city, state, zip, ssn, email)"
				+ "values ('"+uDto.getFirstName()+"','"+uDto.getLastName()+"' , '"+uDto.getAddress()+"', '"+uDto.getAddress2()+"', '"+uDto.getCity()+"', '"+uDto.getState()+"', '"+uDto.getZip()+"', '"+uDto.getSsn()+"', '"+uDto.getEmail()+"')";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				uDto = new UserDTO(
						set.getInt(1), set.getString(2),
						set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
			}
			
		
		} catch (SQLException e) {
			
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		return uDto;
	}
	
//	public static void main(String[] args) {
//		DBConnection connection = new DBConnection();
//		UserDao uDao = new UserDao();
//		
//		UserDTO uDto = new UserDTO();
//		uDto.setFirstName("bobby");
//		uDto.setLastName("beebee");
//		uDto.setAddress("111 Dog park");
//		uDto.setAddress2(null);
//		uDto.setCity("Roanoke");
//		uDto.setState("VA");
//		uDto.setZip(24112);
//		uDto.setSsn(111111111);
//		uDto.setEmail("email@email.com");
//		
//		
//		
//		
//		uDao.createUser(uDto);
//	}
	
	public static UserDTO getUserById(Integer userId) {
		UserDTO uDto = new UserDTO();
//		consoleLogger.debug("Getting user: " + userId);
//		fileLogger.debug("Get User from Database");
		
		final String sql = "SELECT * FROM users WHERE user_id = '"+userId+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					uDto = new UserDTO(
							set.getInt(1), set.getString(2),
							set.getString(3),
							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return uDto;
	}

	public static UserDTO getUser(Integer ssn) {
		UserDTO uDto = new UserDTO();
		consoleLogger.debug("Getting user: " + ssn);
		fileLogger.debug("Get User from Database");
		
		final String sql = "SELECT * FROM users WHERE ssn = '"+ssn+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					uDto = new UserDTO(
							set.getInt(1), set.getString(2),
							set.getString(3),
							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return uDto;
	}
		
		

	
	public static UserDTO updateUser(Integer ssn, String column, Integer value) {
		UserDTO uDto = new UserDTO();
		consoleLogger.debug("Getting user: " + ssn);
		fileLogger.debug("Get User from Database");
		
		
		String columnFormatted = "\"" + column + "\"";
		final String sql = "UPDATE users SET "+columnFormatted+" = '"+value+"' WHERE ssn = '"+ssn+"';";
		
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					uDto = new UserDTO(
							set.getInt(1), set.getString(2),
							set.getString(3),
							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
			}
		
		return uDto;
	}


	@Override
	public boolean deleteUser(UserDTO uDto) {
		consoleLogger.debug("deleting user with username: " + uDto.getFirstName());
		fileLogger.debug("Remove User to Database");
		
		final String sql = "DELETE FROM users WHERE ssn = '"+uDto.getSsn()+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				uDto = new UserDTO(
						set.getInt(1), set.getString(2),
						set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
			}
			
		
		} catch (SQLException e) {
			
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		
		
		return false;
	}


	public static UserDTO updateUser(Integer ssn, String column, String value) {
		UserDTO uDto = new UserDTO();
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		consoleLogger.debug("Getting user: " + ssn);
		fileLogger.debug("Get User from Database");
	
		String columnFormatted = "\"" + column + "\"";
		
		final String sql = "UPDATE users SET "+columnFormatted+" = '"+value+"' WHERE ssn = '"+ssn+"';";
		System.out.println(sql);
		
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					uDto = new UserDTO(
							set.getInt(1), set.getString(2),
							set.getString(3),
							set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				UserDao.consoleLogger.error(e.getMessage());
				UserDao.fileLogger.error(e.toString());
			}
		
		return uDto;
	}
	
	


	






	

}
