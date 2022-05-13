package com.revature.interfaces.java8;

public interface JustDoesOneThing {
	
	public void justTheOneThing();
	
	public default void extraImportantMethod() {
		
		//The default non-access modifier allow us to write concrete methods
		// in the interface.
		
		//This does kind of break the 100% abstraction aspect of interfaces, 
		// but this was necessary to allow modifications of interfaces after
		// they've been used in industry. 
		
	}
	
	public default void evenMoreImportant() {
		
	}

}
