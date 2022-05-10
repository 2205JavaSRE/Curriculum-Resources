//This class will just contain the main method 

import garage.Car;

public class Main{

	public static void main(String[] args){
		Car myToyota = new Car("Toyota Corolla");
		myToyota.isCool = true; //All cars will have a state defining whether they are cool or not. 
		myToyota.mileage = 1000;
		//myToyota.name = "My favorite car"; 
		//myToyota.name = "My 2nd favorite car";

		
		Car myTesla = new Car("Tesla 3");
		myTesla.isCool = false;
		myTesla.mileage = 10001;
		//myTesla.name = "borrowed from elon";
		//myTesla.flyingAbility = true; //This will not work, because we haven't defined it in the class

		System.out.println("my Tesla is " + myTesla.isCool);
		System.out.println("my Toyota is " + myToyota.isCool);
		System.out.println("My Toyota car is called: " + myToyota.name);
	
		
		//myToyota.accelerate(100);
		//myTesla.accelerate(200);
		//

		boolean toyotaCoolness = myToyota.checkCar();
		boolean teslaCoolness = myTesla.checkCar();

		System.out.println("Is my Toyota cool? " + toyotaCoolness);
		System.out.println("Is my Tesla cool? " + teslaCoolness);
	}
}

