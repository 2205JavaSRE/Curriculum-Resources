package com.revature.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.revature.exceptions.BusinessException;


//Our service layer logic should never communicate directly to the user! 
public class FileServiceImpl implements FileService {

	public static final String FILENAME = "./default.txt";
	
	@Override
	public void write(String notes) {
		
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter(FILENAME));
			writer.write(notes);
			writer.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String read() throws BusinessException {
		// TODO Auto-generated method stub
		
		String line = ""; //start with an empty string
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			
			
			
			while((line += reader.readLine()).length() != line.length()) { 
				//keep reading until we find an empty line
				//Our checking condition is going to see if the string stops getting bigger!
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("File was not initalized!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return line;
	}

}
