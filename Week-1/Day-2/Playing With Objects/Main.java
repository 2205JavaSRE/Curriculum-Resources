//This class will just contain the main method 

//The import statement declares that when we use the keyword "Car"
//We mean "Car from the garage package"

import garage.Car;
import garage.*;

public class Main{

	public static void main(String[] args){
		garage.Car myToyota = new garage.Car("Toyota Corolla");
		myToyota.isCool = true; //All cars will have a state defining whether they are cool or not. 
		myToyota.mileage = 1000;
		//myToyota.name = "My favorite car"; 
		//myToyota.name = "My 2nd favorite car";

		
		garage.Car myTesla = new garage.Car("Tesla 3");
		myTesla.isCool = false;
		myTesla.mileage = 10001;
		//myTesla.name = "borrowed from elon";
		//myTesla.flyingAbility = true; //This will not work, because we haven't defined it in the class

		othergarage.Car myOtherCar = new othergarage.Car();

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

