package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Book;

import jakarta.persistence.TypedQuery;

public class BookDao implements IRepository<Book> {

	@Override
	public void create(Book entity) {
		
		Session session = null;
		
		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Book data is added to DB");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Some problem occured while adding Book data");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		
		Session session = null;
		try {
			Book deleteBook = find(id);
			if(deleteBook != null) {
				
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteBook);
				session.getTransaction().commit();
				
				System.out.println("Book data is deleted from DB");
			}
		} catch (Exception e) {
		System.out.println(e.getMessage()); 
		System.out.println("Some problem occured while Deleting Book");
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public void update(long id, Book entity) {
		Session session = null;
		
		try {
			Book book = find(id);
			if(book != null) {
				book.setAuthor(entity.getAuthor());
				book.setDetail(entity.getDetail());
				book.setStudentList(entity.getStudentList());
				
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(book);
				session.getTransaction().commit();
				System.out.println("Successful Book update ");
				
			}
		} catch (Exception e) {
			System.out.println("Some problem has occured while Book UPDATE.");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Book> listAll() {
		Session session = null;
		
			session = databaseConnectionHibernate();
			String query = "select book from Book as book";
			TypedQuery<Book> typedQuery = session.createQuery(query,Book.class);
			List<Book> bookList = typedQuery.getResultList();
			
		return bookList;				
	}

	@Override
	public Book find(long id) {
		
		Session session = databaseConnectionHibernate();
		Book book;
		
		try {
			book = session.find(Book.class, id);
			
			if(book != null) {
				System.out.println("book found: "+ book);
				return book;
			}else {
				System.out.println("book not found");
				return book;
			}
			
		} catch (Exception e) {
			System.out.println("Some problems has occured during Book find operation.");	

		}finally {
			session.close();
		}
		
		return null;
	}

}
