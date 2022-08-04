package com.bilgeadam.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Author author;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "book_detail_id", referencedColumnName= "id")
	private BookDetail detail;
	
	@ManyToMany
	@JoinTable(name="book_student", joinColumns = @JoinColumn(name ="book_id"),inverseJoinColumns = @JoinColumn(name="student_id") )
	private List<Student> studentList;

	public Book() {
		
	}

	public Book(Author author, BookDetail detail, List<Student> studentList) {
		super();
		this.author = author;
		this.detail = detail;
		this.studentList = studentList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public BookDetail getDetail() {
		return detail;
	}

	public void setDetail(BookDetail detail) {
		this.detail = detail;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	
}
