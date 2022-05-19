package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Planet;
import com.revature.util.ConnectionFactory;

public class PlanetDaoImpl implements PlanetDao {

	@Override
	public void insertPlanet(Planet p) {

	}

	@Override
	public Planet selectPlantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planet selectPlanetByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planet> selectAllPlanets() {
		
		String sql = "SELECT * FROM planets";
		Connection connection = ConnectionFactory.getConnection();
		
		//Grabbing a list of planets
		Planet[] planetArray = new Planet[100];
		
		// The List interface is part of the Collection API, which provides useful data structures. 
		// e.g. List, Set, Queues
		// The List has many more methods than Array 
		// It is mutable in size, so we don't need to declare a size when we create it. 
		// The only downside is it can only store Objects. 
		
		//Because of the angle brackets <>, these declare what kind of objects you can store. 
		// But you can only declare objects in them, not primitives. 
		
		List<Planet> planetList = new ArrayList<>(); // a better version of array. 
		
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				//create a planet object from the rows and then add them to the list!
				Planet p = new Planet(rs.getInt("planet_id"),
						rs.getString("planet_name"),
						rs.getBoolean("has_rings"));
				
				planetList.add(p);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return planetList;
	}

	@Override
	public void updatePlanetRingStatus(Planet p, boolean newRingStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePlanet(Planet p) {
		// TODO Auto-generated method stub

	}

}
