package com.revature.dao;

import java.util.List;

import com.revature.models.Moon;
import com.revature.models.Planet;

public interface MoonDao {
	
	
	public void insertMoon(Moon m);
	
	public Moon selectMoonById(int id);
	
	public List<Moon> selectMoonsByPlanetId(Planet p);

	public void updateMoonsPlanet(Moon m, Planet newPlanet);

	public void deleteMoon(Moon m);
}
