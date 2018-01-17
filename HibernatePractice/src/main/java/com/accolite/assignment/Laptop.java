package com.accolite.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id 
	private int id;
	private String price;
	private String brandName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}