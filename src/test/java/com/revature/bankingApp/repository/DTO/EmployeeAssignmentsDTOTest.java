package com.revature.bankingApp.repository.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.bankingApp.repository.EmployeeAssignmentDao;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class EmployeeAssignmentsDTOTest {
	
private static List<EmployeeAssignmentsDTO> employees;
	
	@BeforeAll
	
	public static void setUp() {
		employees = new ArrayList<>(); {
			employees.add(new EmployeeAssignmentsDTO(9, 1));
			employees.add(new EmployeeAssignmentsDTO(2, 2));
		}
		
		
		
		

	}
	
	@Test
	public void createEmployeeAssignment() {
		
		EmployeeAssignmentsDTO eDto = new EmployeeAssignmentsDTO(2, 19);
		
		employees.add(eDto);
		
		boolean newEmployeeAssignment = employees.contains(eDto);
		
		assertTrue(newEmployeeAssignment);
	}
	
	public void deleteEmployeeAssignment() {
		EmployeeAssignmentsDTO eDto = new EmployeeAssignmentsDTO(2, 19);
		
		employees.remove(eDto);
		
		boolean newEmployeeAssignment = !employees.contains(eDto);
		
		assertTrue(newEmployeeAssignment);
	}

	
	@Test
	public void getUserId() {
		
	
		
		assertEquals(employees.get(0).getUserId(), 9);
	}
	
	@Test
	public void getUserLoginId() {
		
		assertEquals(employees.get(0).getUserLoginId(), 1);
	}
	
	@Test
	public void setUserId() {
		
		employees.get(0).setUserId(10);
		
		assertEquals(employees.get(0).getUserId(), 10);
	}
	
	@Test
	public void setUserLoginId(Integer userLoginId) {
		employees.get(0).setUserLoginId(10);
		
		assertEquals(employees.get(0).getUserLoginId(), 10);
	}

}
