package com.revature.encapsulation.a;

import com.revature.encapsulation.b.DummyClassB;

public class DummyClassA extends DummyClassB{
	
	public void randomMethod() {
		this.aMethod();
		super.aMethod();
		
		this.protectedMethod(); 
		super.protectedMethod();
		
		this.defaultMethod();
		super.defaultMethod();
		
		this.privateMethod();
		super.privateMethod();
		// it has access if it is 
		//	treated as a child class
	}
	
	public void testMethod() {
		DummyClassB dB = new DummyClassB();
		dB.aMethod(); //access to public methods from B
		dB.protectedMethod(); 
		dB.defaultMethod();
		dB.privateMethod(); //only access within the class itself
	}

}
