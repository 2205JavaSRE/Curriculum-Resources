package com.revature.polymorphism;

public class Calculator {
	
	public Calculator() {
		
	}
	
	public Calculator(int a) {
		
	}
	
	
	public Calculator(int a, String b, boolean c) {
		
	}
	
	public double add(double x, double y) {
		double sum = x + y;
		return sum;
	}
	
	public double add(double x, double y, double z) {
		System.out.println("This is the 3 args!");
		return x+y+z;
	}
	
//	public double add(double[] doubleArray) {
//		double total = 0;
//		for(int i = 0;i < doubleArray.length; i++) {
//			total += doubleArray[i];
//		}
//		return total;
//	}
	
	public double add(double...doubleArray) { //var-args, we can pass a variable amount of arguments
		
		System.out.println("This is the indefinite amount of arguments!");
		double total = 0;
		for(double value: doubleArray) {
			total+= value;
		}
		return total;
	}
	
	public double add(double x) {
		return x;
	}
	
	
	public double add(String x, boolean y) {
		System.out.println("I don't know what you want?!");
		return 0;
	}
	
	boolean add(boolean y, String x) {
		System.out.println("I still don't know what you mean!?");
		return true;
	}
	
	//Changing the return type does not overload our method.
//	public boolean add(double x, double y) {
//		return x+y;
//	}
	
	//Changing the access modifier also does not work.
//	protected double add(double x, double y) {
//		return x+y;
//	}

}
