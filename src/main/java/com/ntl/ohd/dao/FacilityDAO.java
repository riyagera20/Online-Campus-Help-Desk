package com.ntl.ohd.dao;

import com.ntl.ohd.model.Facility;

public interface FacilityDAO {
	public Facility getFacilityDetailsByIdAndPassword(int userId,String password);

}
