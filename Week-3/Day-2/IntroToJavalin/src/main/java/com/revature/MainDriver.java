package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class MainDriver {
	
	static List<Planet> planetList = new ArrayList<>();

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
		
		
		//REMEMBER: 
		// The search bar is not a file explorer. 
		// The path is simply a text, corresponding to a endpoint to which your server will respond to!
		
		app.get("/this/is/a/path", ctx -> {
			ctx.result("This is a path");
		});
		
		app.get("/thisIsAlsoAPath.txt", ctx -> {
			ctx.result("This is not a file! This is a response, with text in the body");
		});
		
		app.get("/thisIsAlsoAPath.exe", ctx -> {
			ctx.result("This is also another valid path");
		});
		
//		app.get("/planet/{id}", ctx -> {
//			
////			System.out.println(ctx.url()); No need for fancy regex 
//			
//			String id = ctx.pathParam("id");
//			
//			ctx.result("You are targetting the right endpoint, the id is: " + id);
//		});
		
		
//		app.get("/planet/name/{name}", ctx -> {
//			
//			String name = ctx.pathParam("name");
//			
//			Planet p = new Planet(name);
//			
//			//You can only send back a single response! 
//			// If you're doing a result(), json(), etc, do that only once. 
//			
//			// Here we are sending back the planet objects as a text representation. 
//			ctx.result(p.toString());
//			
//			// Instead of text, we can return the planet as a JSON 
//			
//			/*
//			 * JSON: 
//			 * 	JavaScript Object Notation. 
//			 * 	With the popularity of JS, JSON has become the 'standard' way of sending 
//			 * 	back and forth information. 
//			 * 
//			 * 	Thanks it being hte standard, there are a lot of libraries that can parese JSON
//			 * 	into Java objects and Java objects into json 
//			 * 
//			 * As the name suggests, it follows Javascript notation for an object
//			 * 	i.e. key value pairs: 
//			 * 
//			 * 	Planet object: 
//			 * 		{
//			 * 			id: 1,
//			 * 			name: "Planet 0",
//			 * 			mass: "1",
//			 * 			moons: [{name: "The Moon"}]
//			 * 		}
//			 */
//			
//			ctx.json(p);
//			ctx.status(201);
//		});

		
		//A GET request should be for retrieving information NOT creating it!
		// Theoretically I can do anything with any verb, but we should follow standards and conventions. 
		
		// When creating a resource, we use a POST request. 
		
		//Let's do this properly
		// With a GET request, we can't send information in the HTTP request body. 
		// With a POST request, we can send information in the body. 
		// Also because we can send credentials safely, by not appending it to the url. 
		app.post("/planet", ctx -> {
			
			System.out.println(ctx.body()); //reading from the HTTP Request body
			
			// I want a planet to be sent. 
			// Jackson (the dependency I have in maven) will parse the json into a java object!
			Planet p = ctx.bodyAsClass(Planet.class);
			planetList.add(p);
			
			ctx.status(HttpCode.CREATED); //201
			
		});
		
		app.get("/planets", ctx -> {
			
			ctx.json(planetList);
			
		});
		
		
		app.get("/planet/{name}", ctx -> {
			
			String name = ctx.pathParam("name");
			Planet outGoingPlanet = null;
			
			for(Planet p: planetList) {
				if(p.getName().equals(name)) {
					outGoingPlanet = p;
				}
			}
			
			if(outGoingPlanet == null) {
				ctx.status(HttpCode.NOT_FOUND);
			}else {
				ctx.json(outGoingPlanet);
			}
			
		});
		
		//for deleting
//		app.delete(null, null);
		
		//for updating existing resources!
//		app.put(null, null);
		
		
	}

}
