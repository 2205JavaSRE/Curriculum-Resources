package com.revature.storage;

import com.revature.models.Human;

//Interface establishes a contract, that any child class MUST implement these methods!
public interface HumanArray {
	
	//abstract is an example of a non-access modifier
	//it defines methods without having to create a code block for it. 
	
	public abstract void addHuman(Human h);
	
	public abstract Human findHumanByName(String name);
	
	public abstract void removeHumanByName(String name);
	
	public abstract void printAllTheHumans();
	
	

}
