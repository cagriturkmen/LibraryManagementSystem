package com.bilgeadam.service;

import java.util.List;
import java.util.Optional;

import com.bilgeadam.dao.AuthorDao;
import com.bilgeadam.entity.Author;

public class AuthorService implements IRepository<Author>{
	
	private AuthorDao authorDao;
		
	
	public AuthorService() {
		super();
		this.authorDao = new AuthorDao();
	}

	@Override
	public Author create(Author entity) {
		authorDao.create(entity);
		return entity;
	}

	@Override
	public void delete(long id) {
		authorDao.delete(id);		
	}

	@Override
	public void update(long id, Author entity) {
		authorDao.update(id, entity);
	}

	@Override
	public List<Author> listAll() {
		return authorDao.listAll();
	}

	@Override
	public Author find(long id) {
		Author stu= authorDao.find(id);
		return stu;
	}

	public Optional<Author> findByName(String firstname, String lastname) {
		
		return authorDao.findByName(firstname,lastname);
	}

}
