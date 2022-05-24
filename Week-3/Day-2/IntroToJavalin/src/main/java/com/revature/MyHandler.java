package com.revature;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class MyHandler implements Handler {

	@Override
	public void handle(Context ctx) throws Exception {
		
		/*
		 * The context objects allows us to interact with the HTTP request and response
		 * 
		 * IT is Java abstractions, with methods to read the HTTP request from the client
		 * 	and methods to modify our HTTP response to the request!
		 */

//		System.out.println("Hello World!");
		
		ctx.result("Hello World"); //This will return a text back in the response body. 

	}

}
