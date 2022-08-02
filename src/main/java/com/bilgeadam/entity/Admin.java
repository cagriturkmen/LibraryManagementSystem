package com.bilgeadam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType = UserType.ADMIN;
	
	public Admin(String username, String password) {
		super(username, password);
	}
	
	public long getId() {
		return id;
	}
	public UserType getUserType() {
		return userType;
	}
	
	
}
