package com.ntl.ohd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ntl.ohd.dao.RequestorDAO;
import com.ntl.ohd.model.Facilities;
import com.ntl.ohd.model.Requestor;

@EnableTransactionManagement
@Service
public class RequestorServiceImpl implements RequestorService{

	@Autowired
	private RequestorDAO requestorDAO;

	public RequestorDAO getRequestorDAO() {
		return requestorDAO;
	}

	public void setRequestorDAO(RequestorDAO requestorDAO) {
		this.requestorDAO = requestorDAO;
	}

	@Transactional
	@Override
	public Requestor validateRequestorCredential(int userId, String password) {
		// TODO Auto-generated method stub
		Requestor requestor = getRequestorDAO().getRequestorDetailsByEmailAndPassword(userId, password);
		return requestor;
	}

	@Transactional
	@Override
	public List<Facilities> getFacilitiesFromDAO() {
		// TODO Auto-generated method stub
		List<Facilities> facilities =getRequestorDAO().getFacilities();
		return facilities;
	}

	@Transactional
	@Override
	public void createRequest(int requestorId, String facility, String severiety, String desc) {
		// TODO Auto-generated method stub
		getRequestorDAO().createRequest(requestorId,facility,severiety,desc);
	}
	
	
}
