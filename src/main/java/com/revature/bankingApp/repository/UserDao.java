package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.UserDTO;
import com.revature.bankingApp.repository.exceptions.UserNotFoundException;

public class UserDao implements UserDaoInterface {

	static Logger consoleLogger;
	static Logger fileLogger;

	public UserDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");

	}

	@Override
	public UserDTO createUser(UserDTO uDto) {
//		consoleLogger.debug("creating user with username: " + uDto.getFirstName());
		fileLogger.debug("Add User " + uDto.toString() + " to Database");

		final String sql = "INSERT INTO users (first_name, last_name, address, address2, city, state, zip, ssn, email)"
				+ "values ('" + uDto.getFirstName() + "','" + uDto.getLastName() + "' , '" + uDto.getAddress() + "', '"
				+ uDto.getAddress2() + "', '" + uDto.getCity() + "', '" + uDto.getState() + "', '" + uDto.getZip()
				+ "', '" + uDto.getSsn() + "', '" + uDto.getEmail() + "')";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {

			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return uDto;
	}

	public static UserDTO getUserById(Integer userId) {
		UserDTO uDto = new UserDTO();
//		consoleLogger.debug("Getting user: " + userId);
		fileLogger.debug("Getting user with userId: " + userId);

		final String sql = "SELECT * FROM users WHERE user_id = '" + userId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {
				uDto = new UserDTO(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9),
						set.getString(10));
			}

		} catch (SQLException e) {
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return uDto;
	}

	public static UserDTO getUser(Integer ssn) {
		UserDTO uDto = new UserDTO();
//		consoleLogger.debug("Getting user: " + ssn);
		fileLogger.debug("Getting user with SSN: " + ssn);

		final String sql = "SELECT * FROM users WHERE ssn = '" + ssn + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {
				uDto = new UserDTO(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9),
						set.getString(10));
			}

		} catch (SQLException e) {
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return uDto;
	}

	public static UserDTO updateUser(Integer ssn, String column, Integer value) throws UserNotFoundException {
		UserDTO uDto = new UserDTO();
//		consoleLogger.debug("Getting user: " + ssn);
		fileLogger.debug("Update " + column + " of user with SSN " + ssn + " to " + value);

		String columnFormatted = "\"" + column + "\"";
		final String sql = "UPDATE users SET " + columnFormatted + " = '" + value + "' WHERE ssn = '" + ssn + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);
			System.out.println(set.getInt(1));
			{
				throw new UserNotFoundException("User not found with ssn: " + ssn);
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
//		consoleLogger.debug("deleting user with username: " + uDto.getFirstName());
		fileLogger.debug("Deleting user " + uDto.toString());

		final String sql = "DELETE FROM users WHERE ssn = '" + uDto.getSsn() + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {
				uDto = new UserDTO(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9),
						set.getString(10));
			}

		} catch (SQLException e) {
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return false;
	}

	public static UserDTO updateUser(Integer ssn, String column, String value) {
		UserDTO uDto = new UserDTO();
//		consoleLogger.debug("Getting user: " + ssn);
		fileLogger.debug("Update " + column + " of user with SSN " + ssn + " to " + value);

		String columnFormatted = "\"" + column + "\"";

		final String sql = "UPDATE users SET " + columnFormatted + " = '" + value + "' WHERE ssn = '" + ssn + "';";
		

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
				ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {
			consoleLogger.error(e.getMessage());
			UserDao.fileLogger.error(e.toString());
		}

		return uDto;
	}

}
