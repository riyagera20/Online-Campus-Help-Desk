package com.ntl.ohd.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntl.ohd.dao.FacilityDAO;

import com.ntl.ohd.model.Facility;

@Service
public class FacilityServiceImpl implements FacilityService {
	@Autowired
	private FacilityDAO facilityDAO;

	public FacilityDAO getFacilityDAO() {
		return facilityDAO;
	}

	public void setFacilityDAO(FacilityDAO facilityDAO) {
		this.facilityDAO = facilityDAO;
	}

	@Override
	public Facility validateFacilityHeadCredential(int userId, String password) {
		// TODO Auto-generated method stub
		
			Facility facility = getFacilityDAO().getFacilityDetailsByIdAndPassword(userId, password);
			return facility;
		}
	}


	