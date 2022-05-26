package com.revature.controller;

import java.util.List;

import com.revature.models.Planet;
import com.revature.service.PlanetService;

import io.javalin.http.Context;

public class PlanetController {
	
	private PlanetService planetService = new PlanetService();
	
	public void getAllPlanets(Context ctx) {
		
		List<Planet> planetList = planetService.getAllPlanets();
		
		ctx.json(planetList);
		
	}
	
	public void getPlanetByName(Context ctx) {
		
		ctx.result("To be implemented");
		//to be implemented!
		
	}
	
	public void createPlanet(Context ctx) {
		
		Planet jsonPlanet = ctx.bodyAsClass(Planet.class);
		
		planetService.createPlanet(jsonPlanet.getName());
		
		ctx.status(201);
	}
	
	

}
