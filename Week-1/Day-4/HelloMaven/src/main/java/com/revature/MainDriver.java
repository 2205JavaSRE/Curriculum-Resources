package com.revature;

import java.util.Scanner;

public class MainDriver {
	
	public static void main(String[] args) {
		System.out.println("Hello!");
		
		//Using Scanner
		boolean interacting = true;
		
		while(interacting) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please input your name:");
			String userInput = sc.nextLine();
			
			System.out.println("You inputed the name " + userInput);
			
			System.out.println("Do you want to escape?");
			
			String quitMode = sc.nextLine();
			
			switch(quitMode) {
			case "Yes, please":
				interacting = false;
				break;
			case "Yes":
				System.out.println("That's rude!");
			default:
				System.out.println("I guess we keep going!");
			}
		
		sc.close(); //after we're done, we should close. 
		}
		
		
		
	}

}
