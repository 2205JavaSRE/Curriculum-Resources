package com.revature.objectclass;
//import java.lang.Object;

import com.revature.memory.Human;

public class ObjectClassExample {
	
	public static void main(String[] args) {
		//What is the Object class?
		// Object is a class 
		// object is a variable (probably an object)
		// Class Object is the root of the class hierarchy. Every class has Object as 
		// 	a superclass. All objects, including arrays, implement the methods of the class. 
		
		//Object is part of java.lang
		//You don't need to import java.lang, it will default to looking in that package. 
		
		Object object;
		
		//Object is the ROOT CLASS of all objects!
		// EVery object we create can be considered an object. 
		// What are some of things the Object class provides for all objects?
		
		//.toString method 
		//	The default behavior of toString method is to print memory address. 
		//.equals(Object o)
		//	This method will check the memory address of itself to another object.
		
		Human h = new Human();
		h.name = "Bobby";
		Human h2 = new Human();
		h2.name = "Bobby";
		String s = new String();
		Object o = new Object();
		
		Object o2 = o;
		Object o3 = s;
		Object o4 = h;
		
		System.out.println();
		System.out.println(h); //the sysout method is invoking the .toString() method. 
		System.out.println(h.toString());
		
		System.out.println(h.equals(o4));
		System.out.println(h.equals(o3));
		System.out.println(h.equals(h2));
		
		int[] intArray = new int[10];
//		intArray.length; an array is an object, but it has one extra attribute. The length. 
		
//		h.equals(object);
//		h.toString();
	
	}

}
