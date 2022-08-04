package com.bilgeadam.service;

import com.bilgeadam.dao.StudentDao;
import com.bilgeadam.entity.Student;

public class StudentService implements IRepository<Student>{
	
	private StudentDao studentDao;
		
	
	public StudentService() {
		super();
		this.studentDao = new StudentDao();
	}

	@Override
	public Student create(Student entity) {
		studentDao.create(entity);
		return entity;
	}

	@Override
	public void delete(long id) {
		studentDao.delete(id);		
	}

	@Override
	public void update(long id, Student entity) {
		studentDao.update(id, entity);
	}

	@Override
	public void listAll() {
		studentDao.listAll();
	}

	@Override
	public Student find(long id) {
		Student stu= studentDao.find(id);
		return stu;
	}

}
