package com.revature.encapsulation;

public class EncapDriver {
	
	public String publicString;
	protected String protectedString;
	
	protected void protectedMethod() {
		
	}
	
	void packageMethod() {
		
	}
	/*
	 * Encapsulation: 
	 * 		It is the practice of restricting access to resources within our 
	 * 		classes and objects. This is to ensure data isn't accessible or prone 
	 * 		to dangerous operation without the appropriate permissions or procedures. 
	 * 
	 * Java achieves encapsulation via Access Modifer keywords 
	 * In order of least secure to most secure: 
	 * 
	 * 1) public: this resource is available anywhere in the system. 
	 * 		public can be added to Class, Methods and Variables
	 * 
	 * 2) protected: this resource is only available to classes or objects within
	 * 		the same package as the resource or it's child classes. 
	 * 
	 * 3) (default) package: this resource is only available to the class or objects
	 * 		within the same package as the resource.
	 * 		(This access modifier is implicit, we don't write it out)
	 * 
	 * 4) private: this resource is only available to the class or object itself. 
	 */
	public static void main(String...kiwi) {
		
		User u = new User("Bob","password"); //password can't be less than 8 characters
		
		//we allow other class to 'retrieve" the value, without being able to modify it
		System.out.println(u.getUsername()); 
		System.out.println(u.getPassword());
		
		u.setUsername("Bobby");
		u.setPassword(null);
		u.setPassword("pass");
		u.setPassword("supersecurepassword");
		
		System.out.println(u.getUsername()); 
		System.out.println(u.getPassword());
		
		u.publicMethod("supersecurepassword");
		
		
		
	}
}
