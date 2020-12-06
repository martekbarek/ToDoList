package com.paka.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.paka.Entity.Task;

public class createQuery {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
	
			session.beginTransaction();
			
			List<Task> tasks= session.createQuery("from Task").getResultList();
			
			for (Task tempTask : tasks)
			{
				System.out.println(tempTask+" ");
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		} finally {
			
			factory.close();
			
		}
		
		session.disconnect();
		
	}
	
}
