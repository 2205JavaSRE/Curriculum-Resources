package com.revature;

import com.revature.controller.RequestMapping;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {


		Javalin myApp = Javalin.create().start(8501);
		
		//Setting up the routes
		RequestMapping.configureRoutes(myApp);
		
	}

}
