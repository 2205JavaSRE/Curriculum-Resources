package com.revature;

import java.util.Scanner;

public class MainDriver {
	
	public static double basicDivide(int x, int y) {
		
		double total = 0;
		try { // we put risky code into our try block!
			
			total = x/y; //risky code!
		
		}catch(ArithmeticException e) { //We can catch Throwables
			//execute logic, in case of failure!
			System.out.println("You put in a 0!");
		}
			
			return total;
	}
	
	
	public static void something() throws Exception {
		somethingElse();
	}
	
	public static void somethingElse() throws  Exception {
		dangerousMethod();
	}
	
	public static void dangerousMethod () throws Exception, RuntimeException, ArithmeticException, ArrayIndexOutOfBoundsException{
		throw new RuntimeException("This method is still in beta!");
	}
	
	public static void main(String[] args) throws Exception{ //lets make it the JVMs problem!
		
		
		
		
		something(); //we can pass the buck up the method invokations. 
		
//		basicDivide(1,0);
//		
//		System.out.println("Carry on with the rest of my logic!");
		
//		throw new Error();
		
		//The ability to "throw" an Exceptions and Errors comes from the Throwable class;
		//Exceptions occurs when the natural flow of logic is not followed. A issue occured
		// due to code not being robust enough. 
		
		
		//Why do we want to throw exceptions in our own code?
		// When someone else is using our code and libraries, they might use it incorrectly!
		// Exceptions allow us to relay that message to other developers and users about the
		// nature of the issue and where it occured. 
		
		
		//When an exception is thrown, we get a "stack trace" 
		// stack traces allowe us to diagnose what went wrong and where it went wrong!
		
		//Exception is due to programming logic failure, theoroetically the program can recover
		// from that exception!
		//Error, there isn't really a easy or conistent way to recover from an error. 
		// 	e.g. stackOverflowError, we've ran out of memory so there really isn't anything
		// 	that the program can do. 
		// Also the reason why we don't try to handle Throwable, because throwables can also 
		//	be Error. 
		
		//How do we handle Exceptions (and theoretically Errors? )
		
		/*
		 * Ways to handle Exceptions: 
		 * 		Try Catch, Try Multi Catch, Try Catch Finally, Try Finally block!
		 * 
		 * Some situations where our code cannot handle the exception!!
		 * Instead we just notify the invoking method that this is a risky code!
		 * 
		 * throw vs throws: 
		 * 	throws labels a method, the method can throw that particular exception
		 * 
		 * 	throw will just cause an exception to be thrown
		 * 
		 */
		
		/*
		 * Checked vs Unchecked Exceptions: 
		 * 	Checked Exceptions are direct children of the Exception class
		 * 
		 * 	Unchecked Exceptions are direct children of the RuntimeException class
		 * 	(indirectly children of the Checked Exception)
		 * 
		 * Checked Exception have to be handled!
		 * 	Either you can put it in a try catch block. 
		 * 	Or you can make it someone else's porblem!
		 * 
		 * 
		 */
		throw new Exception();
		
//		try {
//			throw new Exception();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			
//		}
		
		
//		something();
		
		
		
		
//		System.out.println(basicDivide(1,0));
//		
//		
//		RuntimeException re = new RuntimeException(); //Exceptions are also Classes and objects. 
//		throw re;
		
//		System.out.println("Everything worked!");
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		String[] myStrings = {"Mercury","Venus","Jupiter"};
//		System.out.println("Welcome to my application!");
//		System.out.println("Give us a number between 0 and 2 to select a planet!");
		
		//We are going to convert String input into a integer. 
//		String userInput = sc.nextLine();
//		
//		try {
//			int index = Integer.parseInt(userInput); //risky code 
//
//			
//			System.out.println(myStrings[index]); //risky code!
//		}finally {
//			//This block of code will execute regardless of what happened!
//			System.out.println("Thank you for using my app!");
//			sc.close();
//		}
//		
//		System.out.println("This will not run if there is an error!");
		
	}

}
