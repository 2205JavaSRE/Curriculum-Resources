package com.revature.inheritance;

public class Animal {
	
	public Animal(String newName,int uselessNumber) {
		super();
		this.name = newName;
	}
	
	public Animal() {
		
	}
	
	public String name;
	
	public void move() {
		System.out.println("I can move!");
	}

}
