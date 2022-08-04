package com.bilgeadam.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class BookDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	@Column(name="is_borrowed")
	private boolean isBorrowed;
	@Column(name="book_borrow_date")
	private LocalDate bookBorrowDate;
	@Column(name="rental_length")
	private LocalDate bookReturnDate;
	
	@OneToOne(mappedBy="detail")
	private Book book;
	
	public BookDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDetail(long id, String title, boolean isBorrowed, LocalDate bookBorrowDate, LocalDate bookReturnDate, Book book) {
		super();
		this.id = id;
		this.title = title;
		this.isBorrowed = isBorrowed;
		this.bookBorrowDate = bookBorrowDate;
		this.bookReturnDate = bookReturnDate;
		this.book = book;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public LocalDate getBookBorrowDate() {
		return bookBorrowDate;
	}

	public void setBookBorrowDate(LocalDate bookBorrowDate) {
		this.bookBorrowDate = bookBorrowDate;
	}

	public LocalDate getBookReturnDate() {
		return bookReturnDate;
	}

	public void setBookReturnDate(LocalDate bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookDetail [id=" + id + ", title=" + title + "]";
	}
	
	
	
}
