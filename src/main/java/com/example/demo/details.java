package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class details {
	@Id
	private int id;
	private String name;
	@Transient
	private int rank;
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
	public details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public details(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}