package com.bilgeadam.util;

import java.util.HashMap;

import com.bilgeadam.controller.StudentController;

public class LibrarySystemMenu {
	
	StudentController studentController;
	
	
	public LibrarySystemMenu( ) {
		super();
		this.studentController = new StudentController();
		
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
		int key = BAUtils.readInt("Lütfen seçiminizi yapınız.");
		
		switch (key) {
		case 1:
			studentController.create();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
	
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
