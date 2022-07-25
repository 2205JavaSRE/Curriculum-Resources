package com.revature.threads;

import java.util.LinkedList;
import java.util.Queue;

import com.revature.models.Garbage;

public class ThreadDriver {
	
	static int i = 0;
	
	//Synchronized keyword allows only a single thread to access shared resource. 
	// You can use it on static methods, instance methods or static blocks. 
	
	
	public synchronized static void safethreadMethod(String s) {
		//by default any thread can invoke this method simulatenously 
		// synchronized keyword restricts a method from being called by multiple threads. 
		System.out.println(s);
	
	}
	
	public static void unsafethreadMethod(int j) {
		//by default any thread can invoke this method simulatenously 
		// synchronized keyword restricts a method from being called by multiple threads. 
	
		System.out.println(i);
		i = i + j;
		
	}
	
	//synchronized only works with methods 
	// You can use volatile keyword 
	// Volatile: does not cache the values, so each thread has to reference the value from the main thread.
	public static Queue<Garbage> garbageQueue = new LinkedList<>();
	
	public static volatile Queue<Garbage> volatilegarbageQueue = new LinkedList<>();
	
	
	/*
	 * Thread: 
	 * 		Independent execution of logic. 
	 * 		(e.g. garbage collector is an example of a daemon thread, a background task that is always
	 * 			running)
	 * 
	 * 
	 * Lifecycle of a thread: 
	 * 		New 
	 * 		Runnable 
	 * 		Running 
	 * 		Non-runnable/Waiting/Time waiting (blocked)
	 * 		Terminated 
	 * 
	 * Common Multi-threading problems 
	 * 		Concurrent Modifications:
	 * 			This occurs when both threads are interacting/modifing an object simulatenously. 
	 * 			This causes a discrepency on the final state of the object, which can cause application 
	 * 			malfunction. 
	 * 
	 * 		Deadlock 
	 * 			When 2 threads are trying to access the same resource, what happens is both of them 
	 * 			can't have access so they stop executing further. 		
	 * 
	 * 		Livelock 	
	 * 			Similar to deadlock except you have programmed both threads to step back from the resource 
	 * 			at the same time. 
	 * 
	 * 		Producer Consumer Problem:
	 * 			A producer will produce resourcers for a consuming thread. 
	 * 			Producer can sometimes overfill the memory buffer 
	 * 			Consumer can sometimes empty the memory buffer causing a exception/error 
	 * 			To stop this from happening you can provide wait conditions to both to allow
	 * 				the consumer and producer thread to work together seemlessly. 
	 * 		
	 *	
	 */

	public static void main(String[] args) {
		Thread t = new Thread(); //This is a brand new thread, but I haven't provided it any logic.
		garbageQueue.add(new Garbage());
		
		
		//Recreating the producer consumer problem
		// One thread will add resources to the queue (producer) and the other will consume from the queue.
		// In this case the buffer is modifiable but we can artificially cause issues to be thrown. 
		// e.g. thrown an exception when size hits 0 or when it hits 10 
		
		Thread producer = new Thread(
				() -> {
					while(true) {
						if(garbageQueue.size() > 10) {
							throw new RuntimeException();
						}
						garbageQueue.add(new Garbage());
						System.out.println("Adding to the queue");
					}
					
				}
				);
		
		Thread consumer = new Thread(
				() -> {
					while(true) {
						if(garbageQueue.size() != 0) {
							garbageQueue.remove();
							System.out.println("Removing from the queue");
						}
					}				
				}
				);
		
		
		
		t.start();
		producer.start();
		consumer.start();
		
//		CustomThread ct = new CustomThread();
//		Thread rt = new Thread(new CustomRunnable());
//		ct.start();
//		rt.start();
		
	}

}
