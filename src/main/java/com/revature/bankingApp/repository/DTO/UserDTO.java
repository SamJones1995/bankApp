package com.revature.bankingApp.repository.DTO;

import java.util.Objects;

public class UserDTO {
	
	protected Integer userId;
	
	protected String firstName;
	
	protected String lastName;
	
	protected String address;
	
	protected String address2;
	
	protected String city;
	
	protected String state;
	
	protected Integer zip;
	
	protected Integer ssn;
	
	protected String email;

	public UserDTO(Integer userId, String firstName, String lastName, String address, String address2, String city,
			String state, Integer zip, Integer ssn, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ssn = ssn;
		this.email = email;
	}
	
	

	public UserDTO(String firstName, String lastName, String address, String address2, String city, String state,
			Integer zip, Integer ssn, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ssn = ssn;
		this.email = email;
	}

	

	public UserDTO(String firstName, String lastName, String address, String city, String state, Integer zip,
			Integer ssn, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ssn = ssn;
		this.email = email;
	}



	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, address2, city, email, firstName, lastName, ssn, state, userId, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(address2, other.address2)
				&& Objects.equals(city, other.city) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(ssn, other.ssn) && Objects.equals(state, other.state)
				&& Objects.equals(userId, other.userId) && Objects.equals(zip, other.zip);
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", ssn="
				+ ssn + ", email=" + email + "]";
	}
	
	

}
