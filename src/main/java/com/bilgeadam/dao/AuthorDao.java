package com.bilgeadam.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.bilgeadam.entity.Author;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class AuthorDao implements IRepository<Author> {

	@Override
	public void create(Author entity) {
		
		Session session = null;
		
		try {
			session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Author data is added to DB");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("Some problem occured while adding Author data");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		
		Session session = null;
		try {
			Author deleteAuthor = find(id);
			if(deleteAuthor != null) {
				
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteAuthor);
				session.getTransaction().commit();
				
				System.out.println("Author data is deleted from DB");
			}
		} catch (Exception e) {
		System.out.println(e.getMessage()); 
		System.out.println("Some problem occured while Deleting Author");
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public void update(long id, Author entity) {
		Session session = null;
		
		try {
			Author author = find(id);
			if(author != null) {
				author.setFirstName(entity.getFirstName());
				author.setLastName(entity.getLastName());
				author.setBooks(entity.getBooks());
				
				session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(author);
				session.getTransaction().commit();
				System.out.println("Successful Author update ");
				
			}
		} catch (Exception e) {
			System.out.println("Some problem has occured while Author UPDATE.");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Author> listAll() {
		Session session = null;
		
			session = databaseConnectionHibernate();
			String query = "select author from Author as author";
			TypedQuery<Author> typedQuery = session.createQuery(query,Author.class);
			List<Author> authorList = typedQuery.getResultList();
			
			for (Author author : authorList) {
				System.out.println(author);
			}
			return authorList;		
	}

	@Override
	public Author find(long id) {
		
		Session session = databaseConnectionHibernate();
		Author author;
		
		try {
			author = session.find(Author.class, id);
			
			if(author != null) {
				System.out.println("author found: "+ author);
				return author;
			}else {
				System.out.println("author not found");
				return author;
			}
			
		} catch (Exception e) {
			System.out.println("Some problems has occured during Author find operation.");	

		}finally {
			session.close();
		}
		
		return null;
	}

	public Optional<Author> findByName(String firstname, String lastname) {
		
		Session session = databaseConnectionHibernate();
		Author author;
		String hql = "select a from Author as a where a.firstName =:fn and a.lastName =:ln ";
		Query query = session.createQuery(hql);
		query.setParameter("fn", firstname);
		query.setParameter("ln", lastname);
		try {
			author  = (Author) query.getSingleResult();
			return Optional.of(author);
		} catch (NoResultException e) {
			return Optional.empty();
		}
		
	}

}
