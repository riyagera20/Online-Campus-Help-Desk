package com.ntl.ohd.service;

import java.util.List;

import com.ntl.ohd.model.Facilities;
import com.ntl.ohd.model.Requestor;

public interface RequestorService {


	public abstract Requestor validateRequestorCredential(int userId,String password);
	public List<Facilities> getFacilitiesFromDAO();
	public void createRequest(int requestorId,String facility,String severiety,String desc);
}
