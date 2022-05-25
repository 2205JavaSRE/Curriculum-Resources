package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapping {
	
	
	public static void configureRoutes(Javalin app) {
		
		
		
		app.get("/Planet/{name}", ctx -> {
			PlanetController.getPlanetByName(ctx);
		});
		app.get("/Planet/{id}", ctx -> {
			PlanetController.getPlanetById(ctx);
		});
		
		app.get("/Planets", ctx -> {
			PlanetController.getAllPlanets(ctx);
		});
		
		app.post("/Planet", ctx -> {
			PlanetController.createPlanet(ctx);
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
		
		
		
	}

}
