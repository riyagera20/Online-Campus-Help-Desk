package com.ntl.ohd.model;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateRequestDetails {

	private int requestorId;
	@NotEmpty
	private String facility;
	@NotEmpty
	private String severiety;
	@NotEmpty
	private String description;
	public int getRequestorId() {
		return requestorId;
	}
	public void setRequestorId(int requestorId) {
		this.requestorId = requestorId;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getSeveriety() {
		return severiety;
	}
	public void setSeveriety(String severiety) {
		this.severiety = severiety;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
