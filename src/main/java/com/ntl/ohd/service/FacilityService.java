package com.ntl.ohd.service;

import com.ntl.ohd.model.Facility;

public interface FacilityService {
	public abstract Facility validateFacilityHeadCredential(int userId,String password);

}
