package com.revature.memory;

public class StackVsHeap {
	
	public static void main(String[] args) {
		
		int a = 1; //declaring a primitive variable
		double d = 2.7;
		
//		a.state;
//		a.method();
		
		//Reference variables pass by reference. 
		//When we modify the original object, all other references 
		//	will also relfect that change
		
		
		Object o = new Object(); //reference variable 
		
		Human h = new Human();
		h.name = "Bobby";
		
		Human h2 = h;
		h2.name = "Not Bobby";
		
		Human h3 = h2;
		Human h4 = h3;
		Human h5 = h4;
		
		h5 = null;
		
		h5.name = "H5's name";
		
		System.out.println(h.name);
		
		
		//Primitive variables pass by value
		// they will pass a copy of the value. 
		
		int myInt = 2;
		int myCopyInt = myInt;
		
		myCopyInt = 7;
		
		System.out.println(myInt);
		
	}

}
