package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.BookDetail;

import jakarta.persistence.TypedQuery;

public class BookDetailDao implements IRepository<BookDetail> {

	@Override
	public void create(BookDetail entity) {
		
		Session session = null;
		
		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("BookDetail data is added to DB");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Some problem occured while adding BookDetail data");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		
		Session session = null;
		try {
			BookDetail deleteBookDetail = find(id);
			if(deleteBookDetail != null) {
				
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteBookDetail);
				session.getTransaction().commit();
				
				System.out.println("BookDetail data is deleted from DB");
			}
		} catch (Exception e) {
		System.out.println(e.getMessage()); 
		System.out.println("Some problem occured while Deleting BookDetail");
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public void update(long id, BookDetail entity) {
		Session session = null;
		
		try {
			BookDetail bookDetail = find(id);
			if(bookDetail != null) {
				bookDetail.setBook(entity.getBook());
				bookDetail.setTitle(entity.getTitle());
				bookDetail.setBookBorrowDate(entity.getBookBorrowDate());
				bookDetail.setBorrowed(entity.isBorrowed());
				bookDetail.setBookReturnDate(entity.getBookReturnDate());
				
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(bookDetail);
				session.getTransaction().commit();
				System.out.println("Successful BookDetail update ");
				
			}
		} catch (Exception e) {
			System.out.println("Some problem has occured while BookDetail UPDATE.");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<BookDetail> listAll() {
		Session session = null;
		
			session = databaseConnectionHibernate();
			String query = "select bookDetail from BookDetail as bookDetail";
			TypedQuery<BookDetail> typedQuery = session.createQuery(query,BookDetail.class);
			List<BookDetail> bookDetailList = typedQuery.getResultList();
			
			for (BookDetail bookDetail : bookDetailList) {
				System.out.println(bookDetail);
			}	
		return bookDetailList;
	}

	@Override
	public BookDetail find(long id) {
		
		Session session = databaseConnectionHibernate();
		BookDetail bookDetail;
		
		try {
			bookDetail = session.find(BookDetail.class, id);
			
			if(bookDetail != null) {
				System.out.println("bookDetail found: "+ bookDetail);
				return bookDetail;
			}else {
				System.out.println("bookDetail not found");
				return bookDetail;
			}
			
		} catch (Exception e) {
			System.out.println("Some problems has occured during BookDetail find operation.");	

		}finally {
			session.close();
		}
		
		return null;
	}

}
