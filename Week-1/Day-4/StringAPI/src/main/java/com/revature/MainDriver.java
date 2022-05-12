package com.revature;

public class MainDriver {
	
	
	//Main method is a special method in Java, it acts as the entrypoint. 
	public static void main(String... kiwi) {
		
		
		/*
		 * String API:
		 * 	String is an object that contains an array of characters. It 
		 * 	allows us to create and manipulate "strings"
		 * 
		 * String class is immutable and the class is final. 
		 * 		immutable: The string cannot be changed
		 * 		final: The class cannot be extended
		 * 
		 * String "Objects" are stored in the heap, but String literals are actually
		 * 	stored in the String pool (which is also in the heap)
		 * 
		 * When a new String object is created, it checks to see if the string pool 
		 * 	already has it. If it does then it will point to that existing object. 
		 */
		
		char[] myCharArray = {'a','p','p','l','e'};
		String myString = "Apple";
		
		Object o = new Object();
		o.equals(o);
		String s = new String("Apple"); 
		//with the new keyword, we force the String object to ignore the String pool 
		// and make a brand new "Apple" string literal
		
		String s2 = myString;
		String s3 = myString;
		
//		System.out.println(s);
//		System.out.println(s.intern() == s2.intern());
//		System.out.println(s == s3); //these check memory address
//		System.out.println(s2 == myString);
//		System.out.println("Now checking using the .equals() method:");
//		System.out.println(s.equals(s2));
//		System.out.println(s.equals(myString));
		
		//I can reassign a value to the myString variable
//		myString = myString.toUpperCase();
		//This is not "changing it", this is just reassigning a new value. 
		
//		System.out.println(myString);
		
//		myCharArray. not many useful methods to manipulate the string
		
//		myString.length();
//		myString.charAt(3);
//		myString.substring(4);
//		myString.substring(0, 4);
//		myString.toUpperCase();
//		myString.toLowerCase();
//		myString.toString();
		
//		System.out.println(myString.toString().toString());
		
		
		
		//StringBuffer and StringBuilder
		//Both of these are mutable versions of String 
		
		//StringBuilder is quicker
		//String buffer is multithreading safe. 
		
		//Multithreading allows us to do multiple tasks concurrently (same time)
		//Each thread is effectively an isolated sequence of logic. 
		
		Object o1 = new Object();
		
		String st1 = new String("Apple");
		st1 = "a string literal";
		
		StringBuilder sb = new StringBuilder("Apples");
		StringBuilder sb2 = sb;
		
		StringBuffer sbuf = new StringBuffer("Kiwi");
		StringBuffer sbuf2 = sbuf;
		
		sbuf2.deleteCharAt(3);
		System.out.println(sbuf);
		
		sb.append(true);
		System.out.println(sb2);

	}

}
