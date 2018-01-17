package com.accolite.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expenses {
	@Id
	private int id;
	private String name;
	private int cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return name;
	}
	public void setType(String type) {
		this.name = type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}