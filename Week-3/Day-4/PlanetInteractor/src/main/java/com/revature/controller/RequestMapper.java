package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapper {

	private PlanetController planetController = new PlanetController();
	private MoonController moonController = new MoonController();
	
	public void configureRoutes(Javalin app) {


		app.get("/api/planets", ctx -> {
			planetController.getAllPlanets(ctx);
		});
		
		app.get("/api/planet/{name}", ctx -> {
			planetController.getPlanetByName(ctx);
		});
		
		app.post("/api/planet", ctx -> {
			planetController.createPlanet(ctx);
		});
		
		app.post("/api/moon", ctx -> {});
		
		app.get("/api/moons/{planet_id}", ctx -> {});
		
		app.get("/api/moons", ctx -> {});
		
		
	}

}
