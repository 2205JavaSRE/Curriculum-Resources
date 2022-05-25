package com.revature.service;

import io.javalin.http.Context;

public class AuthenticateService {
	
	//Dao layer dependency 
	
	// THIS IS BAD 
	// The service layer should have no idea about your HTTP request and HTTP response. 
	// It also should no nothing about SQL 
	// Purely have Java logic!!!!!
	public static boolean authenticateUser(String username, String password) {
		
		if(username.equalsIgnoreCase("Bob")) {
			return false;
		}
		
		return true;
		
	}

}
