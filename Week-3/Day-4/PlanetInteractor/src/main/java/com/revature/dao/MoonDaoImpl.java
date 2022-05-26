package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Moon;
import com.revature.models.Planet;
import com.revature.util.ConnectionFactory;

public class MoonDaoImpl implements MoonDao {

	@Override
	public void insertMoon(Moon m) {
		// TODO Auto-generated method stub

	}

	@Override
	public Moon selectMoonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moon> selectMoonsByPlanetId(Planet p) {

		String sql = "SELECT * FROM moons WHERE my_planet_id = "
				+ "(SELECT planet_id FROM planets WHERE planet_id = ?);";	
		
		Connection connection = ConnectionFactory.getConnection();
		List<Moon> moonList = new ArrayList<>();
		
		
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery(); //executeQuery because moons back !
			
			while(rs.next()) {
				Moon m = new Moon(rs.getInt("moon_id"),rs.getString("moon_name"),p);
				
				moonList.add(m);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return moonList;
	}

	@Override
	public void updateMoonsPlanet(Moon m, Planet newPlanet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMoon(Moon m) {
		// TODO Auto-generated method stub

	}

}
