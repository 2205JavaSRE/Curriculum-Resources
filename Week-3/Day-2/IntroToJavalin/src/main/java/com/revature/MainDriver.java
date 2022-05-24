package com.revature;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class MainDriver {

	public static void main(String[] args) {
		
		/*
		 * Over a network, we communicate between 2 machines using their IP (Internet Protocol) address.
		 * 
		 * When we have services running on our own machine, we use "localhost", referring to itself. 
		 * 	When a program wants to communicate to another program on the same machine, we use localhost. 
		 * 
		 * Port number?
		 * 	Port is an endpoint, it allows us to distinguish the many services running on a single machine.
		 * 	A port number is a 16 bit number, so we can have ports ranging from 0 - 65535.  
		 * 
		 * 	Certain port numbers are reserved for certain purposes/programs. 
		 *		Postgresql: 5432 
		 *		Oracle: 1521 
		 *		MySQL: 3306
		 *		SSH: 22
		 *		HTTP: 80
		 *
		 *	We can specify our services to run on different ports than they choose to. 
		 *	In fact a lot of web applications will default to port 8080
		 *	I recommend choosing a different port to avoid conflicts. 
		 */
		
		/*
		 * Why Javalin?
		 * 	Javalin is a simple web framework that allows us to build web applications. 
		 * 		It is built on top of Jetty, provides us a stable web server that can handle 
		 * 		network protocols such as HTTP (and other useful integrations like WebSockets)
		 * 
		 * Javalin uses an 'embeded' server, so we can simply instantiate a Javalin object to get
		 * 	our application online. 
		 * 
		 * You can instnatiate multiple Javalin objects - but you SHOULD NOT. It serves no purpose,
		 * 	creates a performance hit and makes the entire app architecture more confusing. 
		 */
		
		Javalin app = Javalin.create().start(7001);
//		Javalin app2 = Javalin.create().start(7000); //DONT DO THIS!
		
		
		/*
		 * Even though we can now run the server, it is not providing any functionlity. 
		 * We can configure functionality using 
		 * 	Javalin's HTTP methods, 
		 * 	Handlers 
		 * 	and the Context object
		 */
	
		//This http method requires a path (String) and what to do when that URL is pinged (Handler)
		
		
		app.get("/hello", new MyHandler());

		// A Handler is a functional interface, with a single method for us to define. 
		// 	That means we can use Java 8 lambda expressions to build them in short hand. 
		//	(Handlers are only used once, typically, so we don't need to create a child class)
		
		app.get("/path", (ctx) -> {
			
			ctx.result("We're not hitting another endpoint!");
		});
		
		
		//path is simply a text, corresponding to a url to which your server will respond to!
		
		app.get("/this/is/a/path", ctx -> {
			ctx.result("This is a path");
		});
		
		app.get("/thisIsAlsoAPath.txt", ctx -> {
			ctx.result("This is not a file! This is a response, with text in the body");
		});
		
		app.get("/thisIsAlsoAPath.exe", ctx -> {
			ctx.result("This is also another valid path");
		});
		
	}

}
