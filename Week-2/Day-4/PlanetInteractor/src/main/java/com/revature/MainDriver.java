package com.revature;

import com.revature.dao.PlanetDao;
import com.revature.dao.PlanetDaoImpl;

public class MainDriver {

	public static void main(String[] args) {


		PlanetDao pDao = new PlanetDaoImpl();
		
		System.out.println(pDao.selectAllPlanets());

	}

}
