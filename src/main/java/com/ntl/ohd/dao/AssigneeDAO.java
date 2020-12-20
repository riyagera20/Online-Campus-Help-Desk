package com.ntl.ohd.dao;

import com.ntl.ohd.model.Assignee;

public interface AssigneeDAO {
	public Assignee getAssigneeDetailsByEmailAndPassword(int userId,String password);

}
