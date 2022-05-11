package com.revature.models;

public class Car {
	
	//A way to create the object
	public Car() {
		System.out.println("I'm being created!");
	}
	
	//A state that the object can store
	public String name;
	
	//A behavior associated with the Car
	public String tagline() {
		return "I'm the best car";
	}

}
