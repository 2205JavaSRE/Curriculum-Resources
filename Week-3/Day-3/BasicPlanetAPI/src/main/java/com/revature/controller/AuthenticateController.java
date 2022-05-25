package com.revature.controller;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.models.User;
import com.revature.service.AuthenticateService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthenticateController {
	
	

	public static void authenticateByPathParam(Context ctx) {


		System.out.println("We are authenticating!");
		System.out.println(ctx.pathParam("username"));
		System.out.println(ctx.pathParam("password"));
		
		// Retrieving credentials from the user!
		
		/*
		 * A couple of ways we can grab information from the user! 
		 * 
		 * 1) Path parameters! 
		 */
		
		// Internal mechanism to verify the credentials and authenticate the user. 
		
		
		// Inform the user that they are authenticated. 
		
	}

	public static void authenticateByFormParam(Context ctx) {
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		User u = new User(ctx.formParam("username"),ctx.formParam("password"));
		
		boolean access = AuthenticateService.authenticateUser(username, password);
		
		if(access) {
			ctx.result("You have access");
			ctx.status(HttpStatus.ACCEPTED_202);
		}else {
			ctx.result("You don't have access!");
			ctx.status(HttpCode.FORBIDDEN);
		}
		
	}
	
	public static void authenticateByJSON(Context ctx) {
		
		System.out.println(ctx.body());
		
		System.out.println(ctx.bodyAsClass(User.class));
		
	}

}
