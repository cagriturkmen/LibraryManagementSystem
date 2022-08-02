package com.bilgeadam.entity;

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
	private Date bookBorrowDate;
	@Column(name="rental_length")
	private int rentalLength;
	
	@OneToOne(mappedBy="detail")
	private Book book;
	
	public BookDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDetail(long id, String title, boolean isBorrowed, Date bookBorrowDate, int rentalLength, Book book) {
		super();
		this.id = id;
		this.title = title;
		this.isBorrowed = isBorrowed;
		this.bookBorrowDate = bookBorrowDate;
		this.rentalLength = rentalLength;
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

	public Date getBookBorrowDate() {
		return bookBorrowDate;
	}

	public void setBookBorrowDate(Date bookBorrowDate) {
		this.bookBorrowDate = bookBorrowDate;
	}

	public int getRentalLength() {
		return rentalLength;
	}

	public void setRentalLength(int rentalLength) {
		this.rentalLength = rentalLength;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
