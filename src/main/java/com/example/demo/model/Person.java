package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

	private String fname;
	private String lname;
	private int age;
	private String emailAddress;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String fname, String lname, int age){
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	public Person(String fname, String lname, int age, String emailAddress){
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", age=" + age + ", emailAddress=" + emailAddress + "]";
	}
	
	
	
	
}
