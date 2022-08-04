package com.bilgeadam.controller;

import java.util.Optional;

import com.bilgeadam.entity.Author;
import com.bilgeadam.service.AuthorService;
import com.bilgeadam.util.BAUtils;

public class AuthorContoller {
	
	AuthorService authorService;
	
	public AuthorContoller( ) {
		super();
		this.authorService = new AuthorService();
	}
	
	public void delete() {
		long id =BAUtils.readInt("Silinmesini istediğiniz yazarın id'sini giriniz: ");
		authorService.delete(id);
	}
	
	public void update() {
		
		long id = BAUtils.readInt("Güncellenmesini istediğiniz yzzarin id'sini gir.");
		Author author = new Author(null, null);
		
		String firstname = BAUtils.readString("Lütfen yazar için güncel adı giriniz:");
		String lastname = BAUtils.readString("Lütfen yazar için güncel soyadı giriniz:");
		author.setFirstName(firstname);
		author.setLastName(lastname);
		authorService.update(id, author);
		
	}
	public void listAll() {
		authorService.listAll();
	}
	
	public Author find() {
		long id = BAUtils.readInt("Bulmak istediğiniz yazarin id'sini gir.");
		return authorService.find(id);
	}
	

	public Optional<Author> findByName(String firstname, String lastname){
		
		return authorService.findByName(firstname,lastname);
	}
	
}
