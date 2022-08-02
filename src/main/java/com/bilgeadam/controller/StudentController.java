package com.bilgeadam.controller;

import com.bilgeadam.entity.Student;
import com.bilgeadam.service.StudentService;
import com.bilgeadam.util.BAUtils;

public class StudentController {
	
	StudentService studentService;
	
	
	
	public StudentController() {
		super();
		this.studentService = new StudentService();
	}


	public void create() {
		
		String username = BAUtils.readString("Lütfen kullanıcı için belirlediğiniz kullanıcı adını giriniz: ");
		String password = BAUtils.readString("Lütfen kullanıcı için belirlediğiniz kullanıcı şifresini giriniz: ");

		Student stu = new Student(username,password);
		
		studentService.create(stu);
		
	}
	
}
