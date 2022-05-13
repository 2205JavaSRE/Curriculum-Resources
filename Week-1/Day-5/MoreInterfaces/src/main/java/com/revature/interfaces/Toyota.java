package com.revature.interfaces;

public final class Toyota extends Ford implements Car{
	
	public String name = "My Car";
	public static final int YEARS_OF_COVERAGE = 3;
	
	public static void staticMethod() {
		System.out.println(YEARS_OF_COVERAGE);
		System.out.println(this.name); 
		this.drive();
		//we can't access non-static variables or methods from a static method. 
	}

	@Override
	public void brake() {
		// TODO Auto-generated method stub
		this.drive();
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
	}
	

}
