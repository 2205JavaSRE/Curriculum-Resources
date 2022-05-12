package com.revature;

public interface Car {
	
	//define methods that any "Car" object will be able to do. 
	
	//both of these methods are public and abstract. 
	//methods in Interfaces have an "implicit" modifier of public abstract 
	
	public abstract void accelerate();
	
	void brake(); //A child class will never be able to implement this method!

}
