package com.revature.interfaces;

/*
 * Interfaces in Java allow us to achieve behavior driven abstraction. 
 * 
 * Interfaces will define "abstract" methods, that do not have a body. This 
 * 	puts the responsibility on child (concrete) classes to implement these 
 * 	methods. 
 * 
 * Interfaces don't have contructors, (by default) don't have concrete methods. 
 * Classes can implement multiple interfaces and interfaces can extend multiple
 * other interfaces. 
 * 
 * methods and variables have implicit modifiers: 
 * 	methods are public and abstract.
 * 	variables are public, static and final. 
 */

public interface Car {
	
	public final double pi = 3.14;
	
	public abstract void drive();

}
