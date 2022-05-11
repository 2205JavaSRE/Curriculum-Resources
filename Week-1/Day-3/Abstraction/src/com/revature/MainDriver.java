package com.revature;

import com.revature.models.Human;
import com.revature.storage.HumanArrayImpl;

public class MainDriver {
	
	/*
	 * Abstraction:
	 * 	What does it mean for something to abstract?
	 * 		More of an idea
	 * 		not fully interpreted or described 
	 * 		hiding details
	 * 		generalized
	 * 
	 * When something is abstract, it means we don't understand how it works!
	 */
	
	public static void main(String... apples) {
		
		HumanArrayImpl hArray = new HumanArrayImpl();
		hArray.addHuman(new Human("Bob",2));
		hArray.addHuman(new Human("Bob",2));
		hArray.addHuman(new Human("Bob",2));
		hArray.addHuman(new Human("Bob",2));
		hArray.addHuman(new Human("Bob",2));
		
		hArray.printAllTheHumans();
		
		
		
		/*
		 * I want to create a custom array that will store just Human objects
		 * 
		 * Downsides of using an Array?
		 * 		It is immutable in size, so I've got to know exactly how big my array has to be.
		 * 		Array has also no extra methods, ust a single .length attribute. 
		 * 
		 * I've create an interface, that will define some features that I want out of my
		 * 	fancy new custom array!
		 * 
		 */
		
//		System.out.println(h.toString());
	}

}
