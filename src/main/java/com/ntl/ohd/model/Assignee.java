package com.ntl.ohd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignee")
public class Assignee {
	@Id
	@Column(name= "AssigneeId")
	private int assigneeId;
	
	@Column(name= "AssigneeName")
	private String assigneeName;
	
	@Column(name= "Facility_id")
	private String  facility_id;
	
	@Column(name= "Designation")
	private String designation;
	
	@Column(name= "Qualification")
	private String qualifications;
	
	@Column(name= "Phone")
	private String phone;

	@Column(name= "email")
	private String email;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "passwordChangeStatus")
	private String passwordChangeStatus;
	public int getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}
	public String getAssigneeName() {
		return assigneeName;
	}
	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	public String getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getPasswordChangeStatus() {
		return passwordChangeStatus;
	}
	public void setPasswordChangeStatus(String passwordChangeStatus) {
		this.passwordChangeStatus = passwordChangeStatus;
	}
	@Override
	public String toString() {
		return "Assignee [assigneeId=" + assigneeId + ", assigneeName=" + assigneeName + ", facility_id=" + facility_id
				+ ", designation=" + designation + ", qualifications=" + qualifications + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", passwordChangeStatus=" + passwordChangeStatus
				+ "]";
	}
	
	
	


}
