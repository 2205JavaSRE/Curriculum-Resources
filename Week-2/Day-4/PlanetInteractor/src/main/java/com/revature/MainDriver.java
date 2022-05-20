package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Planet;
import com.revature.service.PlanetService;
import com.revature.util.ConnectionFactory;

public class MainDriver {
	
	private static PlanetService planetService = new PlanetService();
	
	
	public static void prettyDisplayOfPlanets(List<Planet> planetList) {
		for(Planet p: planetList) {
			System.out.println("");
			System.out.println("Planet name: " + p.getName());
			System.out.println("My moons: " + p.getMyMoons());
			
		}
	}

	public static void main(String[] args) {
		
		//Make the connection object ot check connection first
		//create the dao object to check the dao directly 

		Scanner sc = new Scanner(System.in);
		
		PlanetService ps = new PlanetService();
//		
		System.out.println("Welcome to my Planets application!");
		
		System.out.println("What would you like to do?");
		System.out.println("[0] View Planets!");
		System.out.println("[1] Create Planet!");
		System.out.println("[2] Logout");
		
		
		String stringInput = sc.nextLine();
		
		int input = Integer.parseInt(stringInput);
		
		switch(input) {
		case 0: 
				prettyDisplayOfPlanets(ps.getAllPlanets());
				
				break;
		case 1:

				createPlanetMenu();
			break;
		case 2:
			System.out.println("User selected option 2");
			break;
		
		}
		
//		
//		System.out.println("Here are the planets we have!");
		
		
	
//		
//		prettyDisplayOfPlanets(planetService.getAllPlanets());
		

	}

	private static void createPlanetMenu() {
		// TODO Auto-generated method stub
		
	}

}
