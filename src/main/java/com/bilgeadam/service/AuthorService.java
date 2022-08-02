package com.bilgeadam.service;

import com.bilgeadam.dao.AuthorDao;
import com.bilgeadam.entity.Author;

public class AuthorService implements IRepository<Author>{
	
	private AuthorDao authorDao;
		
	
	public AuthorService() {
		super();
		this.authorDao = new AuthorDao();
	}

	@Override
	public void create(Author entity) {
		authorDao.create(entity);
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
	public void listAll() {
		authorDao.listAll();
	}

	@Override
	public Author find(long id) {
		Author stu= authorDao.find(id);
		return stu;
	}

}
