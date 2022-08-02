package com.bilgeadam.service;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.entity.Admin;

public class AdminService implements IRepository<Admin>{
	
	private AdminDao adminDao;
		
	
	public AdminService() {
		super();
		this.adminDao = new AdminDao();
	}

	@Override
	public void create(Admin entity) {
		adminDao.create(entity);
	}

	@Override
	public void delete(long id) {
		adminDao.delete(id);		
	}

	@Override
	public void update(long id, Admin entity) {
		adminDao.update(id, entity);
	}

	@Override
	public void listAll() {
		adminDao.listAll();
	}

	@Override
	public Admin find(long id) {
		Admin stu= adminDao.find(id);
		return stu;
	}

}
