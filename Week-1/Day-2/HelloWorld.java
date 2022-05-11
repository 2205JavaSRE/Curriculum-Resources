class HelloWorld{

	//I need the main method to allow the JVM to enter and execute code
	//
	
	public static void main(String[] args){

		//Primitive and Reference variable
		
		//What is a variable?
		// A keyword that you write that you access a value afterwards. 
		
		// In Java 8, every variable is declared with a data type. 
		//Declaration means that we are preparing space in 'memory' to store a value. 

		//Declaring variables, "a" and "b"
		//a can store any integer value
		//b can store a single character value 
		int a;
		char b;

		//Assignment operation, we assign a value to our variable
		a = 1;
		b = 'q';

		//When we decalre a variable with a certain type, the variable
		//can only store those datatypes. 

		//a = 2.0 ; //this will not work, a cannot store a decimal point number
		//b = 207000; //will not work, char cannot store integer values 


		//You can still reassign values though
		a = 2;
		a = a;
		a = a + 2 + a;

		//When we do use variables, commonly we will declare and assign at the same time
		double c = 27.0;


		System.out.println(a + 7);
		System.out.println(b);


		Car myToyota = new Car();

	}
}
