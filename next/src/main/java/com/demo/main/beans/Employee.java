package com.demo.main.beans;

public class Employee {
  String name,address;int id;

  public Employee(String name, int id, String address) {
	// TODO Auto-generated constructor stub
	  this.name=name;
	  this.id=id;
	  this.address=address;
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

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }
  public void display()
	{
		System.out.println("Name :"+name);
		System.out.println("Roll :"+id);
		System.out.println("Address :"+address);
	}
}
