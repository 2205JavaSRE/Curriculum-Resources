package com.revature.service;

import java.util.List;

import com.revature.dao.PlanetDao;
import com.revature.dao.PlanetDaoImpl;
import com.revature.models.Planet;

public class PlanetService {
	
	private static PlanetDao pDao = new PlanetDaoImpl();
	
	public List<Planet> getAllPlanets(){
		return pDao.selectAllPlanets();
	}
	
	public boolean createPlanet(String name, boolean rings) {
		
		if(name.equals("Pluto")) {
			return false;
		}else {
			Planet newPlanet = new Planet(-1,name,rings);
			
			
			pDao.insertPlanet(newPlanet);
			return true;
		}
		
		
	}

}
