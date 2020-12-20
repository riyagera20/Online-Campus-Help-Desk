package com.ntl.ohd.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "FacilityHead")
public class Facility {
	//FacilityHeadId varchar(20),
		//FacilityId varchar(20),
		//FacilityHeadName varchar(20),
		//Email varchar(20),
		//Phone varchar(20),
		//Password varchar(20),
		//Image blob
		
		
		@Id
		@Column(name = "FacilityHeadId")
		private int facilityHeadId;
		
		@Column(name = "FacilityId")
		private String facilityId;
		
		@Column(name = "FacilityHeadName")
		private String facilityHeadName;
		
		@Column(name = "Email")
		private String email;
		
		@Column(name = "Phone")
		private String phone;
		
		@Column(name = "password")
		private String password;

		public int getFacilityHeadId() {
			return facilityHeadId;
		}

		public void setFacilityHeadId(int facilityHeadId) {
			this.facilityHeadId = facilityHeadId;
		}

		public String getFacilityId() {
			return facilityId;
		}

		public void setFacilityId(String facilityId) {
			this.facilityId = facilityId;
		}

		public String getFacilityHeadName() {
			return facilityHeadName;
		}

		public void setFacilityHeadName(String facilityHeadName) {
			this.facilityHeadName = facilityHeadName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		
		
		
		
		
		

	}

	


