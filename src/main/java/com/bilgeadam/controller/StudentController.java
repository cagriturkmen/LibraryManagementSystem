package com.bilgeadam.controller;

import java.util.Optional;

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
	
	public void delete() {
		
		long id = BAUtils.readInt("Silinmesini istediginiz ogrencinin id'sini giriniz: ");
		studentService.delete(id);
	}
	
	public void update() {
		int id = BAUtils.readInt("Guncellenmesini istediginiz ogrencinin id'sini giriniz.");
		
		String username = BAUtils.readString("Lutfen guncellemek istediginiz ogrenci cin belirediğiniz kulanıcıadını gir.");
		String password = BAUtils.readString("Lutfen guncellemek istediginiz ogrenci cin belirediğiniz sifreyi gir.");
		
		Student updateStudent =new Student(username,password);
		studentService.update(id, updateStudent);
	}
	
	public void listAll() {
		studentService.listAll();
	}
	
	public Student find() {
		int id = BAUtils.readInt("Bulmak istediğiniz ogrenci id'sini gir");
		return studentService.find(id);
	}
	
	public Optional<Student> findByUsername(String username){
		return studentService.findByUsername(username);
	}
	
}
