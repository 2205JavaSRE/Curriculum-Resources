package com.revature;

import com.revature.interfaces.Car;
import com.revature.interfaces.Toyota;
import com.revature.interfaces.java8.JustDoesOneThing;
import com.revature.interfaces.java8.UnnecessaryClass;

public class MainDriver {
	
	private static class NestedClass{}
	
	
	//access modifiers and non-access modifiers
	/*
	 * Access modifiers will modify the access of the resource, be it class, method
	 * 	or variable. If no access modifier is given, it defaults to "package" access.
	 * 
	 * 
	 * non-access modifiers: 
	 * 	modify the default behavior of a resource (not related to access)
	 * 
	 * abstract:
	 * 		Class: A class with the abstract modifier may contain 0 or more abstract
	 * 			methods. Even if no abstract methods exist in the class, we still 
	 * 			cannot instantiate it. A concrete child class must extend it. 
	 * 		Method: A method with the abstract modifier means that it does not need
	 * 			a body. In interfaces, all methods are abstract. In classes, abstract
	 * 			methods must be in a abstract class. 
	 * 
	 * final: it makes a resource "immutable" 
	 * 		Class: A final class cannot be extended. An example of this is the String
	 * 			class. 
	 * 		Methods: A final method cannot be overridden. 
	 * 		Variable: a final variable can't be reassigned a value.
	 * 
	 * static: makes a resource associated with the Class/Interface instead of 
	 * 		the object. 
	 * 		Class: a class can be static 
	 * 		Methods: a static method can be accessed without creating an object. 
	 * 		Variable: a static variable can be accessed without creating an object
	 * 			of the class. 
	 */
	
	
	public static double divideGoodMethod(int x, int y) {
		
		double total = 0;
		
		try {
			double a = x;
			double b = y;
			total = a/b;
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	// A linter will look for "smelly" code
	// Code that works, but is poorly written.
	// In fact you can make it part of the development process, where if smelly 
	// code is detected, the project fails to build. 
	// "SonarLint" is what we will be using!
	public static double dividebadmethod(int x, int y) {
		double total = x/y;
		double z = 100;
		return total;
	}
	
	
	public static void main(String[] args) {
		
//		Ford f = new Ford();
//		Toyota myCar = new Toyota();
//		System.out.println(Toyota.name);
//		System.out.println(myCar.name);
		
//		Toyota.staticMethod();
		
//		myCar.donuts(); //child classes still have access to final methods. 
		
		
		
		//If I wanted to access JustDoesOneThing in the OOP way 
		// I would need to first make a child class!
		// The child class would implements the interface
		// Then I would instantiate the interface using the child class 
		
		JustDoesOneThing j = new UnnecessaryClass();
		j.justTheOneThing();
		
		
		// Java 8 way of doing it:
		
		JustDoesOneThing j2 = () -> {
			System.out.println("This is a lambda expression");
			//Instead of having to write out a brand new class that is a child
			// that implements the parent interface method, we can instead 
			// directly create it and pass in the code block!
		};
		j2.justTheOneThing();
		
		
		JustDoesOneThing j3 = () ->{
			System.out.println("When I just want to use a method "
					+ "without creating an entire class and object");
		};
		j3.justTheOneThing();
		
		
		//This only works with functional interfaces as they only have the one
		// method. 
		
		
	}

}
