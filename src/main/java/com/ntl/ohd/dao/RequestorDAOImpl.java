package com.ntl.ohd.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ntl.ohd.model.CreateRequestDetails;
import com.ntl.ohd.model.Facilities;
import com.ntl.ohd.model.Request;
import com.ntl.ohd.model.Requestor;

@EnableTransactionManagement
@Repository
public class RequestorDAOImpl implements RequestorDAO{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public Requestor getRequestorDetailsByEmailAndPassword(int userId, String password) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Requestor.class);
		detachedCriteria.add(Restrictions.eq("requestorId", userId));
		detachedCriteria.add(Restrictions.eq("password", password));
		@SuppressWarnings("unchecked")
		List<Requestor> findByCriteria = (List<Requestor>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}

	@Transactional
	@Override
	public List<Facilities> getFacilities() {
		// TODO Auto-generated method stub
//		HibernateUtil hUtil=new HibernateUtil();
//		String hql="from Facilities";
//		Session session=hUtil.getSession();
//		Query query=session.createQuery(hql);
//		List<Facilities> facilities=query.list();
		
		List<Facilities> facilities=(List<Facilities>) getHibernateTemplate().find("from Facilities");
		return facilities;
	}

	@Transactional
	@Override
	public void createRequest(int requestorId, String facility, String severiety, String desc) {
		// TODO Auto-generated method stub
		Request request=new Request();
		request.setRequestorId(String.valueOf(requestorId));
		request.setFacilityId(facility);
		request.setSeveriety(severiety);
		request.setRequest(desc);
		request.setStatus("Unassigned");
		request.setRequestDate(new Date(Calendar.getInstance().getTimeInMillis()));
		getHibernateTemplate().save(request);
	}

	
}
