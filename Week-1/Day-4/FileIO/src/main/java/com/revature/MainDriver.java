package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainDriver {
	
	public static void readCharacterStream(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = ""; //start with an empty string
			
			
			while((line = reader.readLine()) != null) { //keep reading until we find an empty line
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeCharacterStream(String filename) {
		
		//We create a buffered writer object
		// bufffered because we would like to write more than a character at a time.
		
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(filename));
		
			writer.write("Hi There \n");
			writer.write("Buffered streams allow us to write a lot at a time");
			writer.write("Buffered streams allow us to write a lot at a time");
			writer.write("Buffered streams allow us to write a lot at a time");
			writer.write("Buffered streams allow us to write a lot at a time");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}
	public static void main(String[] args) {
		
		//First we define the file we want to read and write to. 
		
		String filename = "./Example.txt";
		readCharacterStream(filename);
		
	}

}
