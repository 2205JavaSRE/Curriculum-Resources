package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class PlanetController {
	
	public static List<Planet> planetList = new ArrayList<>();

	public static void getPlanetByName(Context ctx) {
	
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
		
	}

	public static void getPlanetById(Context ctx) {
		// TODO Auto-generated method stub
		
	}

	public static void getAllPlanets(Context ctx) {
		ctx.json(planetList);
		
	}

	public static void createPlanet(Context ctx) {
		System.out.println(ctx.body()); //reading from the HTTP Request body
		
		// I want a planet to be sent. 
		// Jackson (the dependency I have in maven) will parse the json into a java object!
		Planet p = ctx.bodyAsClass(Planet.class);
		planetList.add(p);
		
		ctx.status(HttpCode.CREATED); //201
		
	}

}
