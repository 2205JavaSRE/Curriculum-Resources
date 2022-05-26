package com.revature.dao;

import java.util.List;

import com.revature.models.Planet;

public interface PlanetDao {
	
	//DAO: Data Access Object
	// This is a design pattern to connect our Java project to our database. 
	// We provide abstracted methods to the rest of our project to interact with our database. 
	
	/*
	 * CREATE data in the database
	 * READ data from the database
	 * UPDATE existing data in the database
	 * DELETE existing data in the database
	 */
	
	public void insertPlanet(Planet p);
	
	public Planet selectPlantById(int id);
	public Planet selectPlanetByName(String name);
//	public Planet[] selectAllPlanets();
	public List<Planet> selectAllPlanets();
	
	public void updatePlanetRingStatus(Planet p, boolean newRingStatus);
	
	public void deletePlanet(Planet p);

}
