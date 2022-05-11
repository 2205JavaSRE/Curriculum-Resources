package com.revature.models;

public class Human {
	
	private String name;
	private double weight;
	
	public Human() {
		this("To be determined",100);
	}
	public Human(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}

}
