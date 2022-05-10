
//A class is a blueprint for an object
//A class may contain states and behaviors, and how to create itself (constructor)

package garage;

public class Car{
	//How to create itself?
	//Every class in Java has a constructor, whether we provide one or not!
	// The JVM will provide a constructor if it does NOT see one present. 
	//
	// public Car(){
	// 	super();
	// }
	//
	// The constructor is a very special method in Java
	// The construcotr name is the same as the Class name. 
	// The constructor has no return type
	

	public Car(String nameOfMyNewCar){
		//super(); the super method will be invoked whether we write it not. 
		
		this.name = nameOfMyNewCar;
		System.out.println("I exist now!");
	}


	//states of an objects
	
	public int numberOfWheels;
	public double mileage;
	public boolean isCool;
	public String name;

	//behaviors of an object
	//What the object can do, once it's created. 
	//These are effectively methods/functions that are associated with an object. 
	

	//When defining a method we define a few things
	// <Access modifer> <Return-type> <name-of-method>(<parameters>)
	// parameters are used when we define the method
	// arguments are what we pass along when we execute the method. 
	
	public void accelerate(double maxSpeed){
		System.out.println("I'm accelerating super fast to " + maxSpeed);
	
	}

	public boolean checkCar(){
		boolean coolness = this.isCool;
		return coolness;
	}
}
