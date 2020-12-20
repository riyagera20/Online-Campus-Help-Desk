package com.ntl.ohd.service;

import com.ntl.ohd.model.Assignee;

public interface AssigneeService {
	public abstract Assignee validateAssigneeCredential(int userId,String password);
}
