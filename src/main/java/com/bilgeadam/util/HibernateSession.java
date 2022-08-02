package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Admin;
import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.Student;
import com.bilgeadam.entity.User;

public class HibernateSession {

	private static SessionFactory sessionFactory = sessionFactory() ;
	
	private static SessionFactory sessionFactory() {
		
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Student.class);
	//	configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Admin.class);
		configuration.addAnnotatedClass(Book.class);
		configuration.addAnnotatedClass(BookDetail.class);
		configuration.addAnnotatedClass(Author.class);


		
		SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
