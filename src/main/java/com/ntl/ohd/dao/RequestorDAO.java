package com.ntl.ohd.dao;

import java.util.List;

import com.ntl.ohd.model.Facilities;
import com.ntl.ohd.model.Requestor;

public interface RequestorDAO {


	public Requestor getRequestorDetailsByEmailAndPassword(int userId,String password);
	public List<Facilities> getFacilities();
	public void createRequest(int requestorId,String facility,String severiety,String desc);
}
