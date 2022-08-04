package com.bilgeadam.util;

import java.util.HashMap;
import java.util.Optional;

import com.bilgeadam.controller.BookController;
import com.bilgeadam.controller.StudentController;
import com.bilgeadam.entity.Student;

public class LibrarySystemMenu {
	
	StudentController studentController;
	BookController bookController;
	
	
	public LibrarySystemMenu( ) {
		super();
		this.studentController = new StudentController();
		this.bookController = new BookController();
		
	}
	public void menu() {
		
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Admin");
		menuItems.put(2, "Öğrenci");
			
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			//adminLogin
			adminMenu();
			break;
		case 2:
			studentLogin();
			break;

		default:
			break;
		}
		
	}
	private Student studentLogin() {
		String username = BAUtils.readString("Lütfen kulanıcı adınızı giriniz.");
		String password = BAUtils.readString("Lütfen kulanıcı şifrenizi giriniz.");
		
		Optional<Student> stu =studentController.findByUsername(username);
	if(stu.isPresent()) {
		if(stu.get().getPassword().equals(password)) {
			studentMenu(stu.get());
			
		}else {
			System.out.println("Kullanıcı adı veya şifresi hatalı");
		}
		}else{
			System.out.println("Kullanıcı adı veya şifresi hatalı");
		}
		return stu.get();
	}
	private void adminMenu() {
		
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Ogrenci ekle");
		menuItems.put(2, "Ogrenci sil");
		menuItems.put(3, "Kitap ekle");
		menuItems.put(4, "Kitap sil");
		menuItems.put(5, "Tüm kitapları listele");
		menuItems.put(6, "Kirada olan kitapları listele");
		menuItems.put(7, "Kitabın kimde oldugu bilgisi");
		menuItems.put(8, "Kitabın ne zaman döneceği bilgisi");

		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			studentController.create();
			break;
		case 2:
			studentController.delete();
			break;
		case 3:
			bookController.createBook();
			break;
		case 4:
			bookController.delete();
			break;
		case 5:
			bookController.listAll();
			break;
		case 6:
			bookController.listBorrowedBooks();
			break;
		case 7:
			bookController.holderInfo();
			break;
		case 8:
			bookController.returnDate();
			break;

		default:
			break;
		}
	}
	
	private void studentMenu(Student student) {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Kitap ödünç al");
		menuItems.put(2, "Kitabı iade et");
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			bookController.borrowBook(student);
			break;
		case 2:
			bookController.returnBook(student);
			break;
	}
	}
}
