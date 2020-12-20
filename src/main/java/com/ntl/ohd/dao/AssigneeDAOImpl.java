package com.ntl.ohd.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ntl.ohd.model.Assignee;

@Repository
public class AssigneeDAOImpl implements AssigneeDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Assignee getAssigneeDetailsByEmailAndPassword(int userId, String password) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Assignee.class);
		detachedCriteria.add(Restrictions.eq("assigneeId", userId));
		detachedCriteria.add(Restrictions.eq("password", password));
		@SuppressWarnings("unchecked")
		List<Assignee> findByCriteria = (List<Assignee>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		{
		return findByCriteria.get(0);
		}
		else
			return null;
	}



}
