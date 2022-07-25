package com.revature.threads;

public class CustomRunnable implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("Bonjour");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
