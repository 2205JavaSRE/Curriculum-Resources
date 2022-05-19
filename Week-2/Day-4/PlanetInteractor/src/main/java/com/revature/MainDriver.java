package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Planet;
import com.revature.service.PlanetService;

public class MainDriver {
	
	private static PlanetService planetService = new PlanetService();
	
	
	public static void prettyDisplayOfPlanets(List<Planet> planetList) {
		for(Planet p: planetList) {
			System.out.println("");
			System.out.println("Planet name: " + p.getName());
			System.out.println("Planet ring status: " + p.isRings());
		}
	}

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to my Planets application!");
		
		System.out.println("Here are the planets we have!");
		
		prettyDisplayOfPlanets(planetService.getAllPlanets());
		

	}

}
