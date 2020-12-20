package com.ntl.ohd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntl.ohd.dao.AssigneeDAO;
import com.ntl.ohd.model.Assignee;

@Service
public class AssigneeServiceImpl implements AssigneeService {
	@Autowired
	private AssigneeDAO assigneeDAO;

	public AssigneeDAO getAssigneeDAO() {
		return assigneeDAO;
	}

	public void setAssigneeDAO(AssigneeDAO assigneeDAO) {
		this.assigneeDAO = assigneeDAO;
	}

	@Override
	public Assignee validateAssigneeCredential(int userId, String password) {
		// TODO Auto-generated method stub
		Assignee assignee = getAssigneeDAO().getAssigneeDetailsByEmailAndPassword(userId, password);
		return assignee;
	}

}
