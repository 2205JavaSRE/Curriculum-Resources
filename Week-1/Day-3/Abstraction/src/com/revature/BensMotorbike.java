package com.revature;

/*
 * Abstract Class: 
 * 		AC will have a constructor. (unlike an interface)
 * 		Variables also don't have any implicit modifers attached to it.
 * 		A class can only extend a single abstract class at a time. 
 * 			(That's because methods can be implemented) 
 * 		A child class will be abstract if it does not implement all the methods. 
 * 		Abstract classes cannot be instantiated!!! (Even with the constructor)
 * 			A child class has to implement the methods. 
 */

public abstract class BensMotorbike implements CarTruckMotorbike{
	
	public String name;
	
	public BensMotorbike() {
		
	}

	@Override
	public void wheelie() {

		System.out.println("My implementation of wheelie");
		
	}
	
	//A abstract method for child classes to implement!
	public abstract void donuts();

}
