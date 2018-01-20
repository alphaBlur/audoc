package com.junit.assignment;

import java.util.Date;

public class Student {

	private int regNo;
	private String name;
	private Date dob;
	private String branch;
	private String phone;
	
	public Student(int regNo, String name, Date dob, String branch, String phone) {
		super();
		this.regNo = regNo;
		this.name = name;
		this.dob = dob;
		this.branch = branch;
		this.phone = phone;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int rollNo) {
		this.regNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}