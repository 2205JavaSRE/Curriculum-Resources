package com.revature;

public class MainDriver {

	public static void main(String[] args) {
		
		
		/*
		 * Garbage Collector: 
		 * 	Is a daemon thread (always running in the background) that works 
		 * 	at removing unreferenced objects in the heap (not the stack).
		 * 
		 * Thanks to the Garbage Collections, we don't need to worry about memory
		 * 	management of our Objects. We can create and destroy objects very
		 * 	easily. (Without affecting performance)
		 * 
		 * Garbage Collector will call a specific method before it destroys the 
		 * 	object. The method is "finalize()", from the Object class. 
		 * 
		 * We have a wonderful method from the System class, System.gc() to call it
		 * 	over (but it's not guaranteed). 
		 */

		Garbage g = new Garbage();
		
		Garbage[] garbageArray = new Garbage[Integer.MAX_VALUE/20];
		
		int i = 0;
		while(true) {
			new Garbage();
//			garbageArray[i] = new Garbage(); // only works on objects that aren't referenced!
//		
//			i++;
		}
		
	
//		System.gc(); //call over the garbage collector!
		// This is more of a requrest than a command!
		
//		System.out.println(g);
		
		
		
	}

}
