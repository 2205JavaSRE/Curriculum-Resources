package com.revature.polymorphism;

//Constructor Chaining:
/*
 * Constructor chaining is when we invoke other constructors inside of constructors. 
 * 	We use the "this" keyword to refer to "ourself" (from the perspective of the class)
 * 	Allows us to reuse constructor code that we've already written. 
 */

public class Car {
	
	public double milage;
	public String name;
	public double maxSpeed;
	
	//Parametrized Constructor
		public Car(double milage, String name, double maxSpeed) {
			//this() or super() has to be at the top of the code block!
			super();
			this.milage = milage;
			this.name = name;
			this.maxSpeed = maxSpeed;
			System.out.println("Inside all args");
		}
	
	//No-args Constructor
	public Car() {
		//I still would like to instantiate the car based on some dummy values
//		this.maxSpeed = 150;
//		this.milage = 0;
//		this.name = "Fakey fake";
//		this(0,"Fakey fake",150);
		this("Fakey fake");
		System.out.println("Inside no args");
	}
	
	public Car(String name) {
		this(name,150);
		System.out.println("Inside single args");
	}
	
	public Car(String name, double maxSpeed) {
		this(0,name,maxSpeed);
		System.out.println("Inside double args");
	}
	
	
	
	protected void accelerate() {
		System.out.println("Accelerating like a normal car!");
	}
	
	public void brake() {
		/*
		 * 
		 * 
		 * Lots and lots of lines of code in this method
		 */
		System.out.println(this.name + " braking!");
		this.steer();
		
	}
	
	
	public void steer() {
		
	}
}
