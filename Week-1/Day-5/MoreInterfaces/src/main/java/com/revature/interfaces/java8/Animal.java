package com.revature.interfaces.java8;

public interface Animal {
	
	public default void move() {
		System.out.println("Moving with my legs");
	}

}
