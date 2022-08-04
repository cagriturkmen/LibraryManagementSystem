package com.bilgeadam.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.Student;
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
		bookService.listAll().forEach(book-> System.out.println(book));
	}
	
	public void listBorrowedBooks() {
		
		bookService.listAll().stream()
		.filter(book -> book.getDetail().isBorrowed()==true)
		.forEach(book-> System.out.println(book));
		
	}
	
	public Book find() {
		int id = BAUtils.readInt("Bulmak istediğiniz kitabıın id'sini giriniz.");
		return bookService.find(id);
	}
	
	
	public void borrowBook(Student student) {
		
		System.out.println(bookService.listAll());
		List<Book> books = bookService.listAll().stream()
				.filter(book -> !book.getDetail().isBorrowed())
				.collect(Collectors.toList());
		
		books.forEach(book -> System.out.println(book.getId()+ book.getDetail().getTitle()));
		
		
		int bookId = BAUtils.readInt("Kiralamak istediğin kitabn id'sini gir:");
		int duration = BAUtils.readInt("Kaç gün kiralacaksın?");
		
		Book borrowBook = bookService.find(bookId);
		LocalDate date = LocalDate.now();
		borrowBook.getDetail().setBookBorrowDate(date);
		borrowBook.getDetail().setBookReturnDate(date.plusDays(duration));
		borrowBook.getStudentList().add(student);
		borrowBook.getDetail().setBorrowed(true);
		student.getBooks().add(borrowBook);
		bookService.update(bookId, borrowBook);
		
	}
	public void returnBook(Student student) {
		
		List<Book> books = student.getBooks();
		books.forEach(book -> System.out.println(book.getId()+" "+book.getDetail().getTitle()));
		int bookId =BAUtils.readInt("Iade etmek istediginiz kitabın id'sini giriniz.");
		Book returnBook = bookService.find(bookId);
		returnBook.getDetail().setBorrowed(false);
		returnBook.getDetail().setBookReturnDate(LocalDate.now());
		bookService.update(bookId, returnBook);
	}
	
	public Student holderInfo() {
		
		int bookId = BAUtils.readInt("Kimde oldugunu bulmak istedigin kitabın idsini gir");
		
		Book book = bookService.find(bookId);
		List<Student> studentsBorrowedBook =book.getStudentList();
		
		return 	studentsBorrowedBook.get(studentsBorrowedBook.size()-1);
	}
	public LocalDate returnDate() {
		int bookId = BAUtils.readInt("Teslim tarihini  bulmak istedigin kitabın idsini gir");
		LocalDate date =bookService.find(bookId).getDetail().getBookReturnDate();
		System.out.println(date);
		return date;
	}
	
}
