package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Garbage;

public class MainDriver {
	
	/*
	 * Stack vs Heap: 
	 * 
	 * 	Stack: 
	 * 		> A space in memory where you store local variables. When you create a variable with a value 
	 * 		outside of a loop or inside the loop, once the loop or method is finished the value will be 
	 * 		popped out of the stack. 
	 * 		> Primitives and references are stored here. 
	 * 		> Stack is allocated to each thread. (By deafult the stack is multi threading safe)
	 * 		> Stack is much faster than the heap, following a LIFO/FILO (Last in First out) order. 
	 * 		> Memory allocated to a stack will exist as long as the function/method is still executing. Once
	 * 			the method is finished, the memory is deallocated. 
	 * 		> Stack is also usually smaller than the heap 
	 * 
	 * Heap: 
	 * 		> A space in memory where you store all of your objects. 
	 * 		> Heap is slower than the stack but it usually is bigger. 
	 * 		> Dynamic memory allocation (heap can increase in size), objects are ALWAYS created in the heap. 
	 * 		> The Heap has the garbage collector, memory is not deallocated in the heap but the GC 
	 * 			will step in to delete objects that are eligible for garbage collection. 
	 * 		> The heap is accessible by all threads.
	 * 
	 * 
	 * Garbage Collector and the Heap: 
	 * 		Garbage Collector is a daemon thread that will periodically check the heap for any objects
	 * 		eligible for garbage collection.
	 * 
	 * 		Typically speaking, most Java objects are deleted soon after they are created. 
	 * 		Objects in the heap exist in generations: 
	 * 
	 * 		1) Young Generation: This is where all new objects are allocated and aged. 
	 * 
	 * 		2) Old Generation: this is where long surviving object are stored. When a object in the 
	 * 			young generation hits a threshold age then the object is moved to the old generation.
	 * 
	 * 		3) Permanent Generation: this consists of JVM metadata for runtime classes and methods. 
	 * 
	 * 		When the garbage collectors deletes an object from memory, it will invoke the Object's
	 * 		finalize method. (the finalize method comes from the Object class)
	 * 
	 * 
	 * To increase/decrease the memory allocation, we add flags. 
	 * 
	 * "javac" to compile
	 * "java" to run 
	 * 
	 * "java -Xms256m" set initial size of Java heap to 256 mb
	 * "java -Xmx<size>" set maximum size of the Java heap 
	 * "java -Xss<size>" set java thread stack size 
	 */
	
	public static void recursiveMethod() { //stack overflow exception happening here. 
		recursiveMethod();
	}

	public static void main(String[] args) throws Throwable {

		
		
		
//		recursiveMethod(); StackOverflowError over here!
		
		Garbage g = new Garbage();
		new Garbage();
		new Garbage();
		new Garbage();
		new Garbage();
//		g.finalize();
		
		List<Garbage> garbageList = new ArrayList<>();
		
		System.gc();
		Runtime.getRuntime().gc();
		
//		while(true) {
//			garbageList.add( new Garbage());
//		}
		
		
//		while(true) {
//			System.out.println("Creating a new object!");
//			objectList.add(new Object());
//		}
	}

}
