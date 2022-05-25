package com.revature.models;

public class Planet {
	
	private int id;
	private String name;
	private double mass;
	
	
	
	public Planet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Planet(String name) {
		this(0,name,1);
	}


	public Planet(int id, String name, double mass) {
		super();
		this.id = id;
		this.name = name;
		this.mass = mass;
	}
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
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", mass=" + mass + "]";
	}
	
	

}
