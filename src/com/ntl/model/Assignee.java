package com.ntl.model;

public class Assignee {

	int assigneeId;
	String assigneeName;
	String facilityId;
	String designation;
	String qualification;
	String phone;
	String email;
	public Assignee() {
		super();
	}
	public Assignee(int assigneeId, String assigneeName, String facilityId, String designation, String qualification,
			String phone, String email) {
		super();
		this.assigneeId = assigneeId;
		this.assigneeName = assigneeName;
		this.facilityId = facilityId;
		this.designation = designation;
		this.qualification = qualification;
		this.phone = phone;
		this.email = email;
	}
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
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
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
	@Override
	public String toString() {
		return "Assignee [assigneeId=" + assigneeId + ", assigneeName=" + assigneeName + ", facilityId=" + facilityId
				+ ", designation=" + designation + ", qualification=" + qualification + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
	
}
