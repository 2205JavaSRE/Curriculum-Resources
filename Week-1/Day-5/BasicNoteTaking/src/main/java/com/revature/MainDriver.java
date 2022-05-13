package com.revature;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

import com.revature.exceptions.BusinessException;
import com.revature.service.AuthenticationService;
import com.revature.service.AuthenticationServiceImpl;
import com.revature.service.FileService;
import com.revature.service.FileServiceImpl;
import com.revature.service.FileServiceImplFaster;

public class MainDriver {
	
	//Presentation layer
	// 	Webpage 
	//	Game Menu
	//	Terminal 
	
	//Service layer 
	// (Future) Persistence/Repository layer
	
	public static void welcomeMessage(Scanner sc, AuthenticationService as) {
		System.out.println("Hello, Welcome to my Notetaking application!");
		System.out.println("First we must make sure you have access!");
		System.out.println("Put in the username!");
		String username = sc.nextLine();
		
		System.out.println("Put in the password!");
		String password = sc.nextLine();
		
		boolean access = as.authenticate(username,password);
		
		if(access) {
			System.out.println("You have access!");
		}else {
			System.out.println("You are not allowed here!");
			throw new RuntimeException("This is not allowed");
		}
		
	}

	public static void menuOptions() {
		System.out.println("What would you like to do?");
		System.out.println("Would you like to write sometthing new? [0]");
		System.out.println("Would you like to read your previous notes? [1]");
		System.out.println("Would you like to logout? [q]");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		FileService fs = new FileServiceImpl();
		
		AuthenticationService as = new AuthenticationServiceImpl();
		welcomeMessage(sc,as);
		
		boolean interacting = true;
		
		while(interacting) {
			
			menuOptions();
			
			
			String userInput = sc.nextLine();
			
			
			switch(userInput) {
			case "0":
				System.out.println("Option 0 is selected!");
				System.out.println("What would you like to write?");
				
				String newNotes = sc.nextLine();
				
				fs.write(newNotes);
				
				System.out.println("File successfully written to!");
				
				System.out.println("");
				System.out.println("");
				
				break;
			case "1":
				System.out.println("Option 1 is selected!");
				
				String fileValue;
				try {
					fileValue = fs.read();
					System.out.println("Your last notes were:");
					System.out.println(fileValue);
				}catch(BusinessException b) {
					System.out.println("");
					System.out.println("");
					
					System.out.println("You did not create a file yet!");
					System.out.println("Please write a note first!");
				}
				
				
				
				
				System.out.println("");
				System.out.println("");
				
				break;
			case "q":
				System.out.println("Exit option selected!");
				interacting = false;
				break;
			default:
				System.out.println("Invalid option!");
			}
			
		}
		
		
		

	}

}
