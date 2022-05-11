package com.revature;

import com.revature.models.Car;

public class MainDriver {
	
	int i = 2;
	
	
	public void aMethod() {
		
		if(true) {
			int i;
			i = 7;
		}
		
		if(true) {
			int i; //i has been declared twice in aMethod
			//The reason why, because we're in seperate block scopes. 
			
			//A block scope is a control flow statement. 
			
			i = 2;
		}
		
		while(true) {
			int i = 1;
			break;
		}
		
		//variables declared in a smaller scope cannot be accessed by the parent scope. 
		// in this case, there is no method level variable, just block scope. 
		int i = 3;
		
		System.out.println(i);
		
		
		
		
	}

	public void anotherMethod() {
		System.out.println(i);
		int i = 7;
		System.out.println(i);
		
		while(true) {
			this.i =3; //can't redeclare i inside of a block when method has declared it. 
			break;
		}
		
		System.out.println(i);
	}
	
	public void justForFun() {
		int i = 23;
	}
	
	//When it comes to scopes, we have 3
	//We have block level scope
	//We have the method level scopes
	//We have the class level scopes
	//We have the object level scopes. 
	
	//Child method scopes can redeclare a variable inside of that scope with relation to objects.
	//Child block scopes cannot redeclare the variable!
	// A method can declare "int i;" even if a class/object level scope i exists. 
	
	public static void main(String[] args) {
		
		//Arrays: 
		// Data structure in Java that allows us to store variables. 
		// When we declare an array, we use [] and the data type. 
		// Arrays can only a single data type;
		// When instantiating an Array, we have to declare the size of the array. 
		
		//Declaring arrays
		int[] intArray = new int[10];
		String[] stringArray = new String[1];
		Object[] objectArray = new Object[12];
		Car[] carArray = new Car[2];
		
		//Select a position in the array 
		intArray[0] = 7;
		intArray[2] = 23;
		
		//Reassign values in positions
		intArray[0] = -12;
		
		//Arrays cannot be resized!
		intArray[8] = 11;
		
		//printing out an array 
//		System.out.println(intArray); //memory address of the array 
		
		//an array is an object, so it will also have properties and methods. 
		//we mostly use the length
		
		for(int i = 0; i< intArray.length; i = i+1) {
			System.out.println(intArray[i]);
		}
		
		//enchanced for loop
		//does the EXACT same thing as above's for loop
		//this is just less syntax, it will go through every element in the array
		//starting from 0, finishing at the end of the array, incrementing by 1. 
		for(int i: intArray) {
			System.out.println(i);
		}
		
		
		
//		System.out.println("Hello World!");
		
		MainDriver md = new MainDriver();
		md.anotherMethod();
//		System.out.println(md.i);
		
		
		//Declaring, Assigning
		Car myCar = new Car();
		
//		Car myCar; // Will not work, the 'myCar' has already been declared. 
		//Within the same, variables cannot be redeclared. 
		
		//We create an object, that is defined by its class. 
		myCar.name = "My car";
		myCar.tagline();
		
		//The class is the blueprint not an 'actual' object in memory. 
//		Car.name = "A car";
//		Car.tagline();
		
		
		//Initialization
		//We are creating a new Car in memory (heap)
		//The Car/Object will not be accesible if it's not associated to a variable.
		Car a;
//		a = new Car();
//		new Car();
//		new Car();
//		new Car();
//		new Car();
		
		//Control Flow Statements: 
		// 	When we get into a fork in the code. 
		//  If a condition has been met, certain code will be executed. 
		
		//for loop 
		// for(<starting condition>; <keep going condition>; <increment level>)
		
//		for(int i = -10; i < 1000; i = i-111) {
//			System.out.println(i);
//		}
		
		int start = 0;
		int finish = 1000;
		int increment = 2;
		
//		for(int j = start; j< finish; j = j+ increment) {
//			System.out.println(j);
//			//Used with arrays or data structures a lot
//		}
		
		//while loop 
		//While loop will keep going until a condition is set to false
		// while([conditional statement]){
		// code will keep executing until condition is no longer met
		// }
		
//		while(true) {
//			System.out.println("Will run forever!");
//		}
		
//		while(false) {
//			System.out.println("This will never run!");
//		}
		
		int k = 0;
//		while(k < 1000) {
//			k = k + 1;
//			System.out.println(k);
//		}
		
		//do while loop 
		// very similar to a while loop, except it will execute at least once!
		
//		do {
//			System.out.println("I'll run at least once!");
//		}while(false);
		
		
		//if, else if and else: 
		
		if(k < 1000) {
			//This code block will execute if k is less than a thousand!
		}
		
		if(k < 1000) {
			//This code block will also execute if k is less than a thousand!
		}else if( k > 2000) {
			//if k is NOT less than a thousand and greater than 2000
			//Then this will execute as well. 
		}else if( k == 1500) {
			//If k is not less than a thousand, AND not greater than 2000, then 
			//this will execute if the condition of k being equal to 1500
		}
		
		if(k < 1000) {
			//This code block will also execute if k is less than a thousand!
		}else if( k > 2000) {
			//if k is NOT less than a thousand and greater than 2000
			//Then this will execute as well. 
		}else if( k == 3000) {
			//If k is not less than a thousand, AND not greater than 2000, then 
			//this will execute if the condition of k being equal to 1500
		}else {
			//If no other condition has been met, then this will execute. 
			//There is no additional conditional statement. 
		}
		
		
		//Switch cases 
		//Switches are similar to if and else if in that they can execute
		//certain blocks of code if conditions have been met. 
		
		//However, Switches do not have a conditional expression instead they will 
		// just check if a pattern matches. 
		// When a condition has been met, all the subsequent blocks also execute.
		// to stop that from happening, we use the 'break' keyword to make sure it
		// exits the swith block after a case. 
		
		String s = "Blue";
		
		switch(s) {
		case "Blue":
			System.out.println("s is Blue");
			break;
		case "Red":
			System.out.println("s is Red");
			break;
		case "Green":
			System.out.println("s is Green");
			break;
		default: 
			System.out.println("s is nothing");
			break;
			
		}
		
		int a2 = 2;
		
		switch(a2) {
		case 1000:
			//We can only match values, not evaluate conditional expressions!
		}
		
		double d2 = 2;
		
//		switch(d2) {
//		case 1000:
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
