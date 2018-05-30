package com.revature.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
private static SessionFactory sessionFactory;
	
	private static SessionFactory getSessionFactory(String filename) {
		
		if (HibernateUtil.sessionFactory == null) {
			Configuration c = new Configuration().configure(filename);
			/*c.setProperty("Hibernate.connection.username","username");
			c.setProperty("Hibernate.connection.password", "password");
			c.setProperty("Hibernate.connection.url", "url");*/
			
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			HibernateUtil.sessionFactory = c.buildSessionFactory(sr);
		}
		return HibernateUtil.sessionFactory;
		
	}
	
	public static Session getSession() {
		
		return getSessionFactory("hibernate.cfg.xml").openSession();
		
	}

}
