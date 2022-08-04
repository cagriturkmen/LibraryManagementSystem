package com.bilgeadam.controller;

import java.util.Optional;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.service.AuthorService;
import com.bilgeadam.service.BookDetailService;
import com.bilgeadam.service.BookService;
import com.bilgeadam.util.BAUtils;

public class BookController {
	
	BookService bookService;
	BookDetailService detailService;
	AuthorService authorService;
	
	
	public BookController() {
		super();
		this.detailService =new BookDetailService();
		this.authorService= new AuthorService();
		this.bookService = new BookService();
	}


	public void createBook() {
	Author author;	
	String title =	BAUtils.readString("Lütfen ekleyeceğiniz kitabın ismini girin: ");
	
	BookDetail detail = new BookDetail();
	Book book = new Book();
	
	detail.setTitle(title);
	
	//Id ile dönmüyor olabilir!!
	BookDetail bookDetailWithId = detailService.create(detail);
	
	String firstName = BAUtils.readString("Lutfen yazar adını giriniz.");
	String lastName = BAUtils.readString("Lutfen yazar soyadını giriniz.");
	
	Optional<Author> optAuthor =authorService.findByName(firstName, lastName);
	if(optAuthor.isEmpty()) {
		author = new Author(firstName,lastName);
		authorService.create(author);
	}else {
		author= optAuthor.get();
		System.err.println("Yazar db'de mevcut");
	}
	book.setAuthor(author);
	book.setDetail(bookDetailWithId);
	bookService.create(book);

	}
	
	public void delete() {
	long id=	BAUtils.readInt("Silinmesini istediğiniz kitabın id'sini giriniz:");
	bookService.delete(id);
	}
	
	public void update() {
		long id = BAUtils.readInt("Lütfen güncellemek istediğiniz kitap id'sini giriiz.: ");
		
		String title = BAUtils.readString("Lütfen güncellemek istediğiniz kitap için belirlediğiniz kitap adı giriiz.: ");
		
		Book updateBook = new Book();
		bookService.update(id, updateBook);
	}
	public void listAll(){
		bookService.listAll();
	}
	
	public Book find() {
		int id = BAUtils.readInt("Bulmak istediğiniz kitabıın id'sini giriniz.");
		return bookService.find(id);
	}
	
}
