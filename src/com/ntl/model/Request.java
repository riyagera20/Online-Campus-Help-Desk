package com.ntl.model;

import java.util.Date;

public class Request {
	
	private int requestId;
	private int requestorId;
	private String facilityId;
	private String request;
	private Date requestDate;
	private String response;
	private String status;
	private String assigneeId;
	private String severiety;
	
	public Request() {
		super();
	}

	public Request(int requestId, int requestorId, String facilityId, String request, Date requestDate,
			String response, String status, String assigneeId, String severiety) {
		super();
		this.requestId = requestId;
		this.requestorId = requestorId;
		this.facilityId = facilityId;
		this.request = request;
		this.requestDate = requestDate;
		this.response = response;
		this.status = status;
		this.assigneeId = assigneeId;
		this.severiety = severiety;
	}

	public Request(int requestorId, String facilityId, String request, Date requestDate, String severiety) {
		super();
		this.requestorId = requestorId;
		this.facilityId = facilityId;
		this.request = request;
		this.requestDate = requestDate;
		this.severiety = severiety;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(int requestorId) {
		this.requestorId = requestorId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}

	public String getSeveriety() {
		return severiety;
	}

	public void setSeveriety(String severiety) {
		this.severiety = severiety;
	}
	
	
}
