package com.spring.rest.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	@Size(min=2) // size of name shld contain minimum of 2 characters
	private String name;
	
	private int id;
	
	@Past // dateofbirth shld be past it is not future date 
	private LocalDate dateOfBirth;
	
	public User(String name, int id, LocalDate date) {
		super();
		this.name = name;
		this.id = id;
		this.dateOfBirth = date;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public LocalDate getDate() {
		return dateOfBirth;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(LocalDate date) {
		this.dateOfBirth = date;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", date=" + dateOfBirth + "]";
	}
	
	

}
