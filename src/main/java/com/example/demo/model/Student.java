package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student {
	 
	@Id
	private long ID;
	private long contact;//contact number
	private String fname;//first name
	private String lname;//last name
	private String dob;
	private double age;
	private String college;
	private String branch;
	private String email;
	
	public Student(long iD, long contact, String fname, String lname, String dob, double age, String college,
			String branch, String email) 
	{
		super();
		ID = iD;
		this.contact = contact;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.age = age;
		this.college = college;
		this.branch = branch;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", contact=" + contact + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", age=" + age + ", college=" + college + ", branch=" + branch + ", email=" + email + "]";
	}
	
	

}
