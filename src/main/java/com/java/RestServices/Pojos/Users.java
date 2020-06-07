package com.java.RestServices.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "Fist_NAME", nullable = false, length = 255, unique = true)	
	private String firstName;
	
	@Column(name = "Last_NAME", nullable = false, length = 255, unique = true)	
	private String lastName;
	
	@Column(name = "USET_NAME", nullable = false, length = 25, unique = true)
	private String userName;
	
	@Column(name = "ADDRESS", nullable = false, length = 255, unique = true)
	private String address;
	
	@Column(name = "SSN", nullable = false, length = 255, unique = true)
	private String ssn;

	public Users() {
	}

	public Users(Long id, String firstName, String lastName, String userName, String address, String ssn) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.address = address;
		this.ssn = ssn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", address=" + address + ", ssn=" + ssn + "]";
	}
	
}