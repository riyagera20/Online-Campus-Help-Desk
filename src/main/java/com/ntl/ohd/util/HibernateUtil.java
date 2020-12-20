package com.ntl.ohd.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public Session getSession()
	{
		return new Configuration().configure().buildSessionFactory().openSession();
	}
}
