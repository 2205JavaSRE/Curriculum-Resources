package com.revature.service;

import com.revature.models.User;

public class AuthenticationServiceImpl implements AuthenticationService {

	
	//very basic credentials!
	@Override
	public boolean authenticate(String username, String password) {
		User u = new User("Bobby","Password");
		boolean authenticated = false;
		
		if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
			authenticated = true;
		}
		return authenticated;
	}

}
