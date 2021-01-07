package org.studyeasy.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		/* Listing all the records from a database with HQL
		
		try {
			
			//2-Start transaction
			session.beginTransaction();
			
			//3-Applying HQL
			List<Users> users = session.createQuery("from users").getResultList();
			
			for(Users temp : users) {
				System.out.println(temp);
			}

		}finally {
			session.close();
			factory.close();
		}
		
		*/
		
		/* List users from the database with where and like
		
		try {
			
			//2-Start transaction
			session.beginTransaction();
			
			//3-Applying HQL
			List<Users> users = session.createQuery("from users where firstName = 'noe'"
					+ "OR last_name = 'GONZALEZ' or lastName like '%rai%%'")
					.getResultList();
			
			for(Users temp : users) {
				System.out.println(temp);
			}

		}finally {
			session.close();
			factory.close();
		}	
		
			*/
		
		/*Update records using HQL
		
		try {
			session.beginTransaction();
			
			// change all the passwords to 123456
			session.createQuery("update users set password = '123456'").executeUpdate();
			
			session.createQuery("update users set password = 'mono' "
					+ "where firstName = 'noe'")
					.executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}

  		*/
		//delete a records from a database using HQL
		
		try {
			session.beginTransaction();
			
			session.createQuery("delete from users where userId = '6'")
					.executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}
		
		
	}
	
}
