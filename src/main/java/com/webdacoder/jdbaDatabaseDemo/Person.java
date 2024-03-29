package com.webdacoder.jdbaDatabaseDemo;

import java.util.Date;

public class Person {

	private int id;
	private String name;
	private String location;
    private Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Person()
	{
		
	}
	
	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.dob = birthDate;
	}
	@Override
	public String toString() {
		return " \n Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + dob + "]";
	}	
	
	
    
    
}
