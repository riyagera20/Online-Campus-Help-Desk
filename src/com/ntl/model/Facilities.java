package com.ntl.model;

public class Facilities {

	String facilityId;
	String facilityname;
	String facilityDescription;
	public Facilities() {
		super();
	}
	public Facilities(String facilityId, String facilityname, String facilityDescription) {
		super();
		this.facilityId = facilityId;
		this.facilityname = facilityname;
		this.facilityDescription = facilityDescription;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityname() {
		return facilityname;
	}
	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}
	public String getFacilityDescription() {
		return facilityDescription;
	}
	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}
	
	
}
