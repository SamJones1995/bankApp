package com.revature.bankingApp.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankingApp.core.util.ConnectionFactory;
import com.revature.bankingApp.repository.DTO.EmployeeAssignmentsDTO;

public class EmployeeAssignmentDao implements EmployeeAssignmentDaoInterface {

	Logger consoleLogger;
	Logger fileLogger;

	public EmployeeAssignmentDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");

	}

	public void createEmployeeAssignment(Integer userId, Integer userLoginId) {

//		consoleLogger.debug("creating employee assignment with userId: " + userId + "and userLogintId: " + userLoginId);
		fileLogger.debug("creating employee assignment with client userId: " + userId + "and employee userLogintId: "
				+ userLoginId);

		final String sql = "INSERT INTO employee_assignments (user_id, user_login_id)" + "values ('" + userId + "','"
				+ userLoginId + "')";

		EmployeeAssignmentsDTO eDto = new EmployeeAssignmentsDTO();
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			if (set.next()) {
				eDto = new EmployeeAssignmentsDTO(set.getInt(1), set.getInt(2));

			}

			System.out.println();

			consoleLogger.info(eDto.toString());

		} catch (SQLException e) {
		
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

	}

	public ArrayList<Integer> getEmployeeAssignment(Integer userLoginId) {

		ArrayList<Integer> resultList = new ArrayList<Integer>();
//		consoleLogger.debug("Getting user accounts for employee: " + userLoginId);
		fileLogger.debug("Get Users assigned to employee " + userLoginId);

		final String sql = "SELECT * FROM employee_assignments WHERE user_login_id = '" + userLoginId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

			while (set.next()) {
				Integer result = set.getInt(1);
				resultList.add(result);
			}

		} catch (SQLException e) {
			
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

		return resultList;

	}

	public void updateEmployeeAssignment(Integer userId, Integer userLoginId) {

//		consoleLogger.debug("Updating user  " + userId + " with employee representative: " + userLoginId);
		fileLogger.debug("Updating user  " + userId + " with employee representative: " + userLoginId);

		final String sql = "UPDATE employee_assignments SET user_login_id = '" + userLoginId + "' WHERE user_id = '"
				+ userId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

		} catch (SQLException e) {
			
//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

	}

	public void deleteEmployeeAssignment(Integer userId) {
//		consoleLogger.debug("deleting employee assignment  with userId: " + userId);
		fileLogger.debug("Deleting employee assignment  with userId: " + userId);

		final String sql = "DELETE FROM employee_assignments WHERE user_id = '" + userId + "';";

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet set = statement.executeQuery(sql);

//			if(set.next()) {
//				uDto = new UserDTO(
//						set.getInt(1), set.getString(2),
//						set.getString(3),
//						set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getInt(8), set.getInt(9), set.getString(10));
//			}

		} catch (SQLException e) {

//			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}

	}

}
