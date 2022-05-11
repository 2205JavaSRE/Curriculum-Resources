package com.revature.encapsulation;

//make sure password is not less than 8 characters!
public class User {
	
	private String username;
	private String password; //make sure password is not less than 8 characters!
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//we provide access to private resources in a safe way
	// we do this using public methods!
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		if(newPassword == null) {
			System.out.println("Can't be empty!");
		}else if(newPassword.length() > 8) {
			this.password = newPassword;
		}else {
			System.out.println("New password is not long enough!");
		}
		
	}
	
	
	private void superSecureMethod() {
		System.out.println("This is a secret!");
	}
	
	public void publicMethod(String password) {
		if(this.password.equals(password)) {
			superSecureMethod();
		}else {
			System.out.println("You put in the wrong passcode!");
		}
	}

}
