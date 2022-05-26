package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

		//Statement vs PreparedStatement 
		//	Prepared statements avoid sql injection. 
		// SQL injection is when malicious executions are passed along as a variable but interpreted as a command. 
		// INSERT INTO planets VALUES (DROP table planets;);
		
		//Prepared Statements avoid this by forcing every string to be interpreted correctly. 
		
//		String sql = "INSERT INTO planets (planet_name,has_rings) "
//				+ "VALUES ('"+p.getName()+"',"+p.isRings()+");";
//		Connection connection = ConnectionFactory.getConnection();
//		
//		try {
//			Statement s = connection.createStatement();
//			s.execute(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Prepared Stataement version 
		//try with resources 
		String sql = "INSERT INTO planets (planet_name) VALUES (?)";
		
		Connection connection = ConnectionFactory.getConnection();
		
		//try with resources, can be used with anything that implements AutoClosable, e.g. a connection. 
		try(PreparedStatement ps = connection.prepareStatement(sql)){ //connection will be closed after we are done!
			
			ps.setString(1, p.getName());

			
			ps.execute(); //We use execute when we DONT expect anything back 
			//ps.executeQuery(); //WE use use we DO expect something back!
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
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
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//create a planet object from the rows and then add them to the list!
				Planet p = new Planet(rs.getInt("planet_id"),
						rs.getString("planet_name"),
						null);
				
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
