package com.revature.models;

public class Garbage extends Object{

	public Garbage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println("I'm about to be eaten!");
	}
	

}
