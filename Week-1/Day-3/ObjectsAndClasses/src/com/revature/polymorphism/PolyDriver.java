package com.revature.polymorphism;

public class PolyDriver {
	
	
	/*
	 * Polymorphism is another pillar of OOP
	 * 	Polymorphism in Latin to "take many forms"
	 * 
	 * In Java we have Overriding and Overloading. 
	 * 
	 * Overriding: 
	 * 		We can only override methods, if the methods exist in the parent class. 
	 * 		Rules: 
	 * 			The method name has to be the same!
	 * 			The parameters have to match in the parent and child
	 * 			The return type has to be of the same type.
	 * 			The access modifier of the method can be more public, not more restrictive.
	 * 
	 * 		Run time polymorphism (dynamic binding)
	 * 
	 * Overloading: 
	 * 		Does not require parent child relationship. 
	 * 		Method name has to be the same BUT the parameters have to be different!
	 * 		Method can have different access modifiers and return type.
	 * 		Rules: 
	 * 			We can change the number of arguments!
	 * 			We can change the datatype of the arguments!
	 * 			We can change the order of the arguments!
	 * 
	 * 		Compile time polymorphism
	 */
	public static void main(String... apple) {
		
//		Car toyota = new Car();
//		toyota.accelerate();
//		toyota.brake();
//		toyota.steer();
		
		HyperCar koeneg = new HyperCar();
//		koeneg.accelerate();
//		koeneg.brake();
//		koeneg.steer();
//		koeneg.drift();
//		koeneg.donutsInTheParkingLot();
		
		//Even though the nissan is a car, the methods it can "see" will have been 
		// modified by the child class. That's why it can accelerate like a hypercar
		// and brake like a hypercar. 
		
		//It still 'sees' itself as a Car, so it doesn't think it can drift or any other
		// hyper car method. 
//		Car nissan = new HyperCar();
//		nissan.accelerate();
//		nissan.brake();
//		nissan.drift();
//		nissan.donutsInTheParkingLot();
		
//		----------------------------------------OVERLOADING------------------------------------------
		
//		Calculator calc = new Calculator();
//		calc = new Calculator(0, null, false);
//		
//		double total = calc.add("A String", true);
//		boolean b = calc.add(false,"Another string");
//		System.out.println(total);
//		
//		double[] doubleArray = {1,2,3,4,5,6}; //this has to be all in the same line.
//		System.out.println(calc.add(doubleArray));
//		
//		System.out.println(calc.add(1,2,3));
		
	}

}
