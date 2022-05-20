package com.revature.service;

import java.util.List;

import com.revature.dao.MoonDao;
import com.revature.dao.MoonDaoImpl;
import com.revature.dao.PlanetDao;
import com.revature.dao.PlanetDaoImpl;
import com.revature.models.Planet;

public class PlanetService {
	
	private static PlanetDao pDao = new PlanetDaoImpl();
	private static MoonDao mDao = new MoonDaoImpl();
	
	public List<Planet> getAllPlanets(){
		List<Planet> planetList = pDao.selectAllPlanets(); //returning all the planets without their moons!
		
		for(Planet p: planetList) { //First we are iterating through the planet list
			
			//we select a individula planet at a time to add their moons. 
			// we use the MoonDao to find the moons based on the Planets id 
			
			p.setMyMoons(mDao.selectMoonsByPlanetId(p));
			
			//we populate the planets with their moons
		}
		
		return planetList;
		
	}
	
	public boolean createPlanet(String name) {
		
		if(name.equals("Pluto")) {
			return false;
		}else {
			Planet newPlanet = new Planet(-1,name,null);
			
			
			pDao.insertPlanet(newPlanet);
			return true;
		}
		
		
	}

}
