package com.demo.main.entity;

public class User {
	
	private String name,address,email;
	private int id;
	public User() {}
	
	public User(String name,String address,String email,int id) {
		this.name=name;
		this.address=address;
		this.email=email;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
