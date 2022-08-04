package com.bilgeadam.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.STUDENT;
	
	@ManyToMany(mappedBy="studentList")
	private List<Book> books;

	public Student() {
		super();
	}
	
	public Student(String username, String password) {
		super(username, password);
	}
		


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public long getId() {
		return id;
	}

	public UserType getUserType() {
		return userType;
	}
	
	
}
