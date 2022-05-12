package com.revature;

import com.revature.models.Human;
import com.revature.storage.HumanArrayImpl;

public class MainDriver {
	
	public void fordCheckup(FordF150 f) {
		
	}
	
	public void carCheckup(Car c) {
		//Any car objects, even ones yet to be 
	}
	
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
		hArray.addHuman(new Human("Boby",2));
		hArray.addHuman(new Human("Bobbby",2));
		hArray.addHuman(new Human("Bobiet",2));
		hArray.addHuman(new Human("Bobster",2));
		
		hArray.printAllTheHumans();
		
		System.out.println(hArray.findHumanByName("Bobs"));
		System.out.println(hArray.findHumanByName("Boby"));
		System.out.println(hArray.findHumanByName("Bobby"));
		System.out.println(hArray.findHumanByName("Bobster"));
		
		
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
		
		
		
		//-----------------------------------Vehicle Example-----------------------------------
		
		Object o = new FordF150(); //This isn't really good!
		//I don't access to any of the FordF150 or Car methods! 
		
		
		FordF150 ford = new FordF150(); 
//		ford = new Jaguar();
		//Gives us access to all the methods!
		ford.accelerate();
		ford.brake();
		ford.offroadDriving();
		
		Car myCar = new FordF150();
//		myCar = new Jaguar();
		//Only gives us accesss to Car methods!
		myCar.accelerate();
		myCar.brake();
//		myCar.offRoadDriving();
		
		
		Truck t = new FordF150();
		//Only access to Truck methods
		t.accelerate();
		t.carryStuff();
//		t.brake();
	}

}
