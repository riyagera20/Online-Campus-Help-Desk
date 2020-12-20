package com.ntl.ohd.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

	
//	create table Request
//	(
//	REQUEST_ID int primary key auto_increment,
//	REQUESTOR_ID varchar(20),
//	FACILITY_ID varchar(20),
//	REQUEST varchar(200),
//	REQUEST_DATE date,
//	RESPONSE varchar(100),
//	STATUS varchar(20) default 'Unassigned',
//	ASSIGNEE_ID varchar(20), 
//	SEVERIETY varchar(20)
//	);
	
	@Id
	@Column(name = "REQUEST_ID")
	private int requestId;

	@Column(name = "REQUESTOR_ID")
	private String requestorId;

	@Column(name = "FACILITY_ID")
	private String facilityId;
	
	@Column(name = "REQUEST")
	private String request;
	
	@Column(name = "REQUEST_DATE")
	private Date requestDate;
	
	@Column(name = "RESPONSE")
	private String response;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ASSIGNEE_ID")
	private String assigneeId;
	
	@Column(name = "SEVERIETY")
	private String severiety;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(String requestorId) {
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
