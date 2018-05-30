package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.Util.HibernateUtil;
import com.revature.beans.Commenter;

public class CommenterDaoImpl implements CommenterDao {

	@Override
	public List<Commenter> getCommenter() {
		// TODO Auto-generated method stub

		List<Commenter> commenter = new ArrayList<Commenter>();
		Session s = HibernateUtil.getSession();
		commenter = s.createQuery("from Commenter").list();
		s.close();
		return commenter;
	}

	@Override
	public int addCommenter(Commenter c) {
		// TODO Auto-generated method stub

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(c);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateCommenter(Commenter c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCommenter(Commenter c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commenter getCommenterById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Commenter cm = (Commenter) s.get(Commenter.class, id);
		//Above we can see the user of get, and need to careful with load and update
		s.close();
		return cm;
	}

	@Override
	public Commenter persistsCommenter(Commenter c) {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(c);
		tx.commit();//if we live this out, nothing will be persisted. Hence there would be no saving in the database.
		s.close();
		return c;
		
		//some concept of automatic dirty checking
	}
	
	@Override
	public List<Commenter> getAllCommenter() {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(Commenter.class);
		List<Commenter> cList = cr.list();
		return cList;
		}
	
	@Override
	public List<Commenter> getAllFilteredByW() {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(Commenter.class);
		cr.add(Restrictions.like("lastName","W%"));
		List<Commenter> cList = cr.list();
		return cList;
		}

	@Override
	public List<Commenter> orderAllByLastname() {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(Commenter.class);
		cr.addOrder(Order.desc("lastName"));
		List<Commenter> cList = cr.list();
		return cList;
		}
}
