package com.revature;

public class Garbage extends Object{

	
	
	@Override
	public void finalize() {
		System.out.println("I'm about to be destroyed!");
	}
}
