package com.revature.inheritance;

public class Human extends Animal{
	
	/*
	 * public Human(){
	 * super(); // this is the Human class 'borrowing' the constructor from the Animal class!
	 * }
	 */
	
//	public Human() {
//		super("fakey fake",0);
//	}

	public void doTaxes() {
		System.out.println("I love doing my taxes!");
	}
}
