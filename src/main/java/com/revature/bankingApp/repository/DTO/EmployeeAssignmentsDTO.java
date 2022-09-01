package com.revature.bankingApp.repository.DTO;

import java.util.Objects;

public class EmployeeAssignmentsDTO {
	
	protected Integer userId;
	
	protected Integer userLoginId;
	
	

	@Override
	public String toString() {
		return "EmployeeAssignmentsDTO [userId=" + userId + ", userLoginId=" + userLoginId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userLoginId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeAssignmentsDTO other = (EmployeeAssignmentsDTO) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(userLoginId, other.userLoginId);
	}

	public EmployeeAssignmentsDTO(Integer userId, Integer userLoginId) {
		super();
		this.userId = userId;
		this.userLoginId = userLoginId;
	}

	public EmployeeAssignmentsDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
	}
	
	

}
