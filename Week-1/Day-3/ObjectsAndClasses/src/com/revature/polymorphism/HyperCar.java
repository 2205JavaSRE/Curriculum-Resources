package com.revature.polymorphism;

/*
 * Annotations: 
 * 	Annotations provide meta data to the JVM. Annotations can be put on top of methods, 
 * 	classes and class variables. 
 * 
 * 	Common example is "@Override"
 * @Override tells the JVM that the following method should be overriding a parent class
 * 	method. 
 * 
 * @Override: 
 * 		It will make sure that the developer is overriding as intended. 
 * 		(point out mistakes to the deveoper and stops the code from compiling)
 */

public class HyperCar extends Car{
	
	public HyperCar() {
//		this("Fake fake hyper car",200,0); //calling our own all-args constructor
		super(); //calling parent no-args constructor
		System.out.println("Inside no args hyper car");
	}
	
	public HyperCar(String name, double maxSpeed, double milage) {
		super(milage,name,maxSpeed); //parent constructor all-args
		System.out.println("Inside all args hyper car");
	}
	
	
	
	@Override
	public void accelerate() {
		System.out.println("I'm accelerating like a hyper car!");
//		accelerate(); //recursive never ending method
		
	}
	
	@Override
	public void brake() {
		//The way we refer to our parent class is by using the "super" keyword
		super.brake();
		System.out.println("I'm braking even harder!");
	}
	

	public void drift() { //In my drift method I'm using both my parent's brake and accelerate methods!
		super.brake();
		super.accelerate();
		System.out.println("combines together to cause drifting");
	}
	
	//When we "super" anywhere, always think parent!
	//With super, we can invoke the parents methods, constructors and access parent variables
	public void donutsInTheParkingLot() {
		super.brake(); //parent's method
		this.brake(); // "My" method/ 
		double a = super.milage; //this is not normal, once we encapsulate we lose access to this.
		double a2 = this.milage;
	}
}
