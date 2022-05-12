package com.revature.inheritance;

public class InheritanceDriver {
	
	/*
	 * Inheritance: 
	 * 
	 * Is one of the most important aspects of OOP. Allows us to inherit methods and
	 * variables from parent classes. 
	 * 
	 * Why is this useful?
	 * 	Promotes code reuse. 
	 * 
	 * For homogenous inheritance, we use the keyword: "extends"
	 * class -> class
	 * interface -> interface
	 * abstract class -> class
	 * abstract class -> abstract class
	 * class -> abstract class 
	 * 
	 * Hetrogenous inheritance, we use the keyword: "implements"
	 * interface -> class
	 * 
	 * Java does not have support for multiple class inheritance. So
	 * 	A class will not have multiple parents. But there is multilevel inheritance 
	 * 	support. 
	 * 	A -> B -> C
	 * 	C gets access to both B's and A's methods and variables. 
	 * 	B gets access to A's variables and methods 
	 * 	A does not have access to B or C's methods anx variables. 
	 */
	
	
	public static void main(String[] args) {
		
		//To establish an inheritance relationship between classes
		// we must use the "extends" keyword. 
		// "extends" keyword will establish a child parent relationship
		
		//Child will inherit the parent class' methods and attribute (by default)
		// Parent will not have access to the child's methods and attributes. 
		
		// Child classes do not inherit constructors!!!!
		
		
		//When we declare a Parent data type variable, we can point it to child class objects. 
		// This is okay, because the child class will at least have the parent methods!
		// But it will not see the child specific methods
		// We can do it the other way around, by casting ( Casting is () we see next to the = 
		
//		Object o = new Object();
//		o = new Animal("Object Wolf",0);
//		o = new Human();
//		o = new SuperHero();
		
		SuperHero greenLantern = new SuperHero();
//		greenLantern.move();
//		greenLantern.doTaxes();
//		greenLantern.fly();
		
		//This is an example of casting up
		Object o = (Object) greenLantern; //even though o is pointing at a super hero, it "sees" itself as an Object
		// an Object cannot move, doTaxes or fly!
//		o.move();
//		o.doTaxes();
//		o.fly();
		
		//This is an example of casting down
		SuperHero objectHero =  (SuperHero) o; //We can 'cast' it down, to a parent class
		objectHero.fly();
		
		
		Animal a = new Animal("Wolf",0);
//		a = new Human();
//		a = new SuperHero();
		a.move();
		a.name = "Wolf";
//		a.doTaxes(); parents do not have access to child methods!
		
		
		Human h = new Human();
//		h = new SuperHero();
		h.move();
		h.name = "Bobby";
		h.doTaxes();
		
		SuperHero sh = new SuperHero();
		sh.move();
		sh.name = "Super Bobby";
		sh.toString();
		sh.doTaxes();
		sh.fly();
	}

}
