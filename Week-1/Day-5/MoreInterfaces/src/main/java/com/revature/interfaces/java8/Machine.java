package com.revature.interfaces.java8;

public interface Machine {
	
	public default void move() {
		System.out.println("Moving with wheels!");
	}

	
	//static methods are also allowed
	public static void something() {
		//static methods always belongs to the Class
		// Objects can't inherit the static methods!
	}
}
