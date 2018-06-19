package com.hql.all.HqlAll.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hql.all.HqlAll.StudentHQL;

public class StudentMain {

	public static Session s1;

	public static SessionFactory getsession() {

		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		return sf;
	}

	public static void select() {
		s1 = getsession().openSession();

		Query qry = s1.createQuery("from StudentHQL");

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Object o = (Object) it.next();
			StudentHQL p = (StudentHQL) o;
			System.out.println("----------------------");
			System.out.println("Student Name" + p.getFname() + "/n Last name" + p.getLname());
			System.out.println("Student Email" + p.getEmail());
			System.out.println("Student ID" + p.getId());
			System.out.println("----------------------");

		}

	}

	public static void selectmore() {
		/* Selecting partial objects(More than one object) start__________ */

		Query qry1 = s1.createQuery("select p.fname,p.lname from StudentHQL p");

		List l = qry1.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it1 = l.iterator();

		while (it1.hasNext()) {
			Object o[] = (Object[]) it1.next();

			System.out.println("Student name : " + o[0] + "Student Name : " + o[1]);

			System.out.println("----------------");
		}

	}

	public static void selectsingle() {
		// Selecting single object start_____________

		Query qry = s1.createQuery("select p.id from StudentHQL p");

		List l = qry.list();
		System.out.println("Total Number Of Records : " + l.size());
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println("Student id : " + i.intValue());
			System.out.println("---------------------------");

		}

	}

	public static void insert() {

		s1 = getsession().openSession();
		StudentHQL s = new StudentHQL();
		s.setId(1);
		s.setFname("Vinay1");
		s.setLname("sai");
		s.setEmail("ksvinaysai1@gmail.com");
/*		StudentHQL sr = new StudentHQL();
		sr.setId(1);
		sr.setFname("Vinay37");
		sr.setLname("sai28");
		sr.setEmail("ksvinaysai2837@gmail.com");
		s1.save(sr);
*/		s1.save(s);
		System.out.println("Pushed::::");
		Transaction t = s1.beginTransaction();
		t.commit();
		System.out.println("Inserted:::::");

	}

	public static void main(String[] args) {

		insert();
		System.out.println("Inserted::::");
		select();
		System.out.println("Select ID::::");

		selectmore();
		System.out.println("Select ALl::::");

		selectsingle();
		System.out.println("Selected::::");

	}
}
