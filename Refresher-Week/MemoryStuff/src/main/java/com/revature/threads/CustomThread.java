package com.revature.threads;

public class CustomThread extends Thread{

	public CustomThread() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(true) {
			System.out.println("Hi");
			
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
