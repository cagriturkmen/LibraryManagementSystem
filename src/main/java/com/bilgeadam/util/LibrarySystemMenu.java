package com.bilgeadam.util;

import java.util.HashMap;

import com.bilgeadam.controller.BookController;
import com.bilgeadam.controller.StudentController;

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
			//studentLogin
			break;

		default:
			break;
		}
		
	}
	private void adminMenu() {
		
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Ogrenci ekle");
		menuItems.put(2, "Ogrenci sil");
		menuItems.put(3, "Kitap ekle");
		menuItems.put(4, "Kitap sil");
		menuItems.put(5, "Kitap iade zamanı");
		menuItems.put(6, "Kitabın kimde olduğu bilgisi");
		
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
	
			break;
		case 6:
	
			break;

		default:
			break;
		}
	}
	
}
