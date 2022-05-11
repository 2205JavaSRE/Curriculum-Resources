public class Primitives{


	public static void main(String[] args){
		
		//Primitives
		// Are very basic data types in Java
		// So basic that we can define them by their memory size. 
		// primitves don't have any behaviors, they only store a single value

		int i; // designed to store integers, 4 byts of memory. 
		char c; // designed to store 16 bits of memory. 
		boolean b; // only needs a single bit, but the way java works, it takes up a 8 bits
		long l; // designed to store large ints , 8 bytes of memory
		short s; // 2 bytes of information, 16 bits
		byte b2; // 8 bits, 2^8 or 256 values.
		double d; // designed to store decimal point numbers, 8 bytes of memory. 
		float f; // similar to a double, but smaller capacity at 4 bytes of memory.
		
		b = true; //booleans can't be converted into characters
		
		c = 'a'; //each character value is associated with an integer value
		i = c;
		d = i; //double has more memory than the int, so it can store int values. 
		f = i; //lets see if float can store int!
		System.out.println(d);


		//If I have a single bit, it can either be 1 or 0. 
		//If I have 2 bits it can be either, 00, 11, 01, 10. 
		
	}
	}
