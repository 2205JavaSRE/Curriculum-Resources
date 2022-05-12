package com.revature;
/*
 * Interfaces can have variables and abstract methods, but they have implicit modifiers
 * 	Method: 
 * 		public abstract
 * 
 * Variable: 
 * 		public static final
 * 
 * Interface does not contain a constructor 
 * Interface can extend multiple other interfaces 
 * 
 * Interfaces are considered 100% abstraction, and a class can implement multiple interfaces 
 * 	because of that. 
 */

public interface Truck {
	
	public static final double PI = 3.14;
	String SOMETHING_IMPORTANT = "not really";
	
	void accelerate();
	
	void carryStuff();

}
