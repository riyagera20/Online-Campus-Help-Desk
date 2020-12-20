package com.ntl.ohd.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requestor")
public class Requestor {

	
//	REQUESTOR_ID int primary key auto_increment,
//	FIRST_NAME varchar(20),
//	LAST_NAME varchar(20),
//	DOB date,
//	ADDRESS varchar(50),
//	EMAIL varchar(50),
//	PASSWORD varchar(20),
//	PHONE varchar(20),
//	GENDER varchar(20),
//	PWDCHANGESTATUS varchar(5)
	
	@Id
	@Column(name = "REQUESTOR_ID")
	private int requestorId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "PWDCHANGESTATUS")
	private String pwdChangeStatus;

	public int getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(int requestorId) {
		this.requestorId = requestorId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwdChangeStatus() {
		return pwdChangeStatus;
	}

	public void setPwdChangeStatus(String pwdChangeStatus) {
		this.pwdChangeStatus = pwdChangeStatus;
	}
	
	
}
