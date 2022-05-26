package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.controller.RequestMapper;
import com.revature.models.Planet;
import com.revature.service.PlanetService;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class MainDriver {
	

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(7500);
		
		RequestMapper requestMapper = new RequestMapper();
		
		requestMapper.configureRoutes(app);

	}



}
