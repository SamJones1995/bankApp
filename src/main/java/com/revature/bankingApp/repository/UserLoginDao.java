package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.UserLoginDTO;

public class UserLoginDao implements UserLoginDaoInterface {

	static Logger consoleLogger;
	static Logger fileLogger;

	public UserLoginDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");

	}

	@Override
	public UserLoginDTO createUserLogin(UserLoginDTO userLogDto) {
//		consoleLogger.debug("creating user login with username: " + userLogDto.getUsername());
		fileLogger.debug("Add User " + userLogDto.toString() + " to Database");

		final String sql = "INSERT INTO user_login (username, password, user_type_id)" + "values ('"
				+ userLogDto.getUsername() + "','" + userLogDto.getPassword() + "' , '" + userLogDto.getUserTypeId()
				+ "')";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return userLogDto;
	}

	@Override
	public UserLoginDTO getUserLogin(UserLoginDTO userLogDto) {

//		consoleLogger.debug("Getting user login with username and password: " + userLogDto.getUsername() + " " + userLogDto.getPassword());
		fileLogger.debug("Getting user login with username and password: " + userLogDto.getUsername() + " "
				+ userLogDto.getPassword());

		final String sql = "SELECT * FROM user_login WHERE username =  '" + userLogDto.getUsername()
				+ "' AND password = '" + userLogDto.getPassword() + "'";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {

				userLogDto = new UserLoginDTO(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4),
						set.getInt(5));

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

	public ArrayList<Integer> getUserLoginsByType(Integer userType) {
//		
//		consoleLogger.debug("Getting user logins with type Id: " + userType);
		fileLogger.debug("Getting user logins with type Id: " + userType);

		final String sql = "SELECT * FROM user_login WHERE user_type_id =  '" + userType + "';";

		ArrayList<Integer> employees = new ArrayList<Integer>();
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			while (set.next()) {
				Integer result = set.getInt(1);
				employees.add(result);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return employees;

	}

	public static UserLoginDTO getUserLogin(String username, String password) {
		UserLoginDTO userLogDto = new UserLoginDTO();
//		consoleLogger.debug("Getting user login with username: " + username);
		fileLogger.debug("Getting user login with username: " + username + " and password " + password);

		final String sql = "SELECT * FROM user_login WHERE username =  '" + username + "' AND password = '" + password
				+ "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {

				userLogDto = new UserLoginDTO(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4),
						set.getInt(5));

			}

		} catch (SQLException e) {

			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return userLogDto;

	}

	public UserLoginDTO getUserLogin(Integer userId) {
		UserLoginDTO userLogDto = new UserLoginDTO();
//		consoleLogger.debug("Getting user login with userId: " + userId);
		fileLogger.debug("Getting user login with userId: " + userId);

		final String sql = "SELECT * FROM user_login WHERE user_id =  '" + userId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {

				userLogDto = new UserLoginDTO(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4),
						set.getInt(5));

			}

		} catch (SQLException e) {

			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return userLogDto;

	}

	public static UserLoginDTO getUserLoginById(Integer userLoginId) {
		UserLoginDTO userLogDto = new UserLoginDTO();
//		consoleLogger.debug("Getting user login with userloginId: " + userLoginId);
		fileLogger.debug("Get User login  with userloginId: " + userLoginId);

		final String sql = "SELECT * FROM user_login WHERE user_login_id =  '" + userLoginId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {

				userLogDto = new UserLoginDTO(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4),
						set.getInt(5));

			}

		} catch (SQLException e) {

			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return userLogDto;

	}

	@Override
	public UserLoginDTO updateUserLogin(String username, String column, String value) {
		UserLoginDTO userLogDto = new UserLoginDTO();
//		consoleLogger.debug("Getting userLogin: " + username);
		fileLogger.debug("Update " + column + " of userLogin with username: " + username + " to " + value);

		String columnFormatted = "\"" + column + "\"";

		final String sql = "UPDATE user_login SET " + columnFormatted + " = '" + value + "' WHERE username = '"
				+ username + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

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
//		consoleLogger.debug("Getting userLogin: " + username);
		fileLogger.debug("Update " + column + " of userLogin with username: " + username + " to " + value);

		String columnFormatted = "\"" + column + "\"";

		final String sql = "UPDATE user_login SET " + columnFormatted + " = '" + value + "' WHERE username = '"
				+ username + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);



		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return userLogDto;
	}

	public static UserLoginDTO updateUserLogin(Integer userLoginId, String column, Integer value) {
		UserLoginDTO userLogDto = new UserLoginDTO();
//		consoleLogger.debug("Getting userLogin with userLoginId: " + userLoginId);
		fileLogger.debug("Update " + column + " of userLogin with userLoginId: " + userLoginId + " to " + value);

		String columnFormatted = "\"" + column + "\"";

		final String sql = "UPDATE user_login SET " + columnFormatted + " = '" + value + "' WHERE user_login_id = '"
				+ userLoginId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);



		} catch (SQLException e) {
			e.printStackTrace();
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return userLogDto;
	}

	@Override
	public boolean deleteUserLogin(String username) {
//		consoleLogger.debug("deleting user with username: " + username);
		fileLogger.debug("Deleting userLogin with username: " + username);

		final String sql = "DELETE FROM user_login WHERE username = '" + username + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			set.next();

		} catch (SQLException e) {

			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return false;
	}

}
