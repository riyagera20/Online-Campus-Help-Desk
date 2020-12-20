package com.ntl.ohd.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ntl.ohd.model.Facility;
@Repository
public class FacilityDAOImpl implements FacilityDAO{
		@Autowired
		private HibernateTemplate hibernateTemplate;
		
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

	@Override
	public Facility getFacilityDetailsByIdAndPassword(int userId, String password) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Facility.class);
		detachedCriteria.add(Restrictions.eq("facilityHeadId", userId));
		detachedCriteria.add(Restrictions.eq("password", password));
		@SuppressWarnings("unchecked")
		List<Facility> findByCriteria = (List<Facility>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	
	}

}
