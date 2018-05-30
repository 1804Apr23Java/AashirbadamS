package com.revature.main;

import java.util.List;

import org.hibernate.Session;

import com.revature.Util.HibernateUtil;
import com.revature.beans.Commenter;
import com.revature.dao.CommenterDao;
import com.revature.dao.CommenterDaoImpl;

public class Driver {

	public static void main(String[] args) {

	/*	
		 Session s = HibernateUtil.getSession();
		 System.out.println(s.getStatistics()); 
		 System.out.println(s.isOpen());
		 s.close(); 
		 System.out.println(s.isOpen());*/
		 
		

		CommenterDao dc = new CommenterDaoImpl();
		
		Commenter c1 = new Commenter("Angela", "Wang", "a.wang@gmail.com");
		Commenter c2 = new Commenter("Kevin", "Magno", "k.magno@gmail.com");
		Commenter c3 = new Commenter("Shivam", "Aashir", "s.aashir@gmail.com");

		c1.setCommenterId(dc.addCommenter(c1));
		c2.setCommenterId(dc.addCommenter(c2));
		c3.setCommenterId(dc.addCommenter(c3));

		List<Commenter> cm = dc.getAllCommenter();

		for (Commenter s : cm) {
			System.out.println(s.toString());

		}
		
		System.out.println("-------------------------");
		
		List<Commenter> cm2 = dc.getAllFilteredByW();

		for (Commenter s : cm2) {
			System.out.println(s.toString());

		}
		
	System.out.println("-------------------------");
		
		List<Commenter> cm3 = dc.orderAllByLastname();

		for (Commenter s : cm3) {
			System.out.println(s.toString());

		}
		
//		
//		CommenterDao cd = new CommenterDaoImpl();
//		cd.getAllCommenter();

	}
	public static void saveVsPersists(CommenterDao d) {
		System.out.println(d.addCommenter(new Commenter("Danny","seo", "danny.seo@gmail.com")));
		//Haven't ran yet, after creating a commenter persist method
	//		System.out.println(d.addCommenter(new Commenter("Danny","seo", "danny.seo@gmail.com")));
		//Here transcation is happening bu not that we are controlling
	}
/*	public static void getVsLoad(CommenterDao cd) {
		Commenter c = cd.getCommenterById(2);
		if(c!=null) {
			System.out.println("Commenter 2 exists");
			System.out.println(c.getFirstName());
			System.out.println(c.getFirstName());
		}
	}*/
}
