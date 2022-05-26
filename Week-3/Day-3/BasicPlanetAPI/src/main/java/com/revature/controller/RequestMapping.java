package com.revature.controller;

import com.revature.models.User;

import io.javalin.Javalin;
import io.javalin.http.Cookie;
import io.javalin.http.HttpCode;

public class RequestMapping {
	
	
	public static void configureRoutes(Javalin app) {
		
		
		
		app.get("/Planet/{name}", ctx -> {
			PlanetController.getPlanetByName(ctx);
		});
		app.get("/Planet/{id}", ctx -> {
			PlanetController.getPlanetById(ctx);
		});
		
		app.get("/Planets", ctx -> {
			if(AuthenticateController.verifyUser(ctx)) {
				PlanetController.getAllPlanets(ctx);
			}else {
				ctx.status(418);
			}
			
		});
		
		app.post("/Planet", ctx -> {
			
			if(AuthenticateController.verifyUser(ctx)) {
				PlanetController.createPlanet(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
		});
		
		
		//When sending private information over HTTP, we would like to keep it in the body of the request. 
		// GET requests do not have Request bodies. 
		
		//Bad Idea 
//		app.post("/login/{username}/{password}", ctx -> {
//			AuthenticateController.authenticateByPathParam(ctx);
//		});
		
		//Good Idea
		app.post("/login", ctx -> {
			AuthenticateController.authenticateByFormParam(ctx);
		});
		
		//Another Good Idea 
//		app.post("/login", ctx -> {
//			AuthenticateController.authenticateByJSON(ctx);
//		});
		
		
		
		// We won't use specific controllers this time!
		//-----------COOKIES-------------------------
		//Creating Cookies 
		app.get("/cookies", ctx -> {
			
			
			// Cookies are simple key value pairs that the server creates and sends over in the the response. 
			// This allows the "client" to then store the cookie and send the cookie with any future requests! 
			
			// Javalin Method for storing cookies in the response, to be sent over in the response
			ctx.cookieStore("FavoriteFruit","Apple");
			ctx.cookie("FavoriteCar","Beetles",10);
			
		} );
		
		//Checking Cookies 
		app.get("/checkCookies",ctx -> {
			
			//JAvalin method for reading cookies. 
			String fruit = ctx.cookieStore("FavoriteFruit");
			
			//More manual servlet way of grabbing cookies 
			javax.servlet.http.Cookie[] cookieArray = ctx.req.getCookies();
			System.out.println(cookieArray[0].getValue());
			
			
			
			System.out.println(fruit);
			
//			String car = ctx.cookieStore("FavoriteCar");
//			System.out.println(car);
		});
		
		//Deleting Cookies 
		app.get("/removeCookies", ctx -> {
			
			ctx.clearCookieStore();
		});
		
		
		//--------Security with cookies!
		
		app.post("/cookie/login", ctx -> {
			
			User u = ctx.bodyAsClass(User.class);
			
			if(u.getUsername().equals("Bobby")) {
				
				ctx.cookieStore("access", true);
				ctx.status(200);
			}
			
		});
		
		app.get("/cookie/secret", ctx -> {
			
			//Grabbing the cookie from the cookie store
			Boolean b = ctx.cookieStore("access");
			
			//if the cookie is non existent or has a different value than expected!
			if(b == null || !b.toString().equals("true")) {
				ctx.result("You don't have access!");
			}else {
				ctx.result("You have access!");
			}
			
		
		});
		
		app.get("/cookie/logout", ctx -> {
			ctx.clearCookieStore();
		});
		
		
		
		//Sessions
		// Sessions are similar to cookies in the fact that they are used to keep track of the client. 
		// Cookies will store their informatoin in the client side 
		// Sessions will store the information on both the client and the server side. 
		
		// (Javalin as a framework has helped to cover some of the problems with cookies, like encrypting the 
		// cookies the client side)
		
			
		app.post("/get/session", ctx -> {
		
			//some validation would be involved here first 
			User u = ctx.bodyAsClass(User.class);
			
			ctx.sessionAttribute("user",u);
			
			
		});
		
		app.get("/session/secret", ctx -> {
			
			User u = ctx.sessionAttribute("user");
			
			System.out.println(u.getUsername());
		});
	
		app.get("/session/invalidate", ctx-> {
			ctx.consumeSessionAttribute("user");
		});
		
	}

}
