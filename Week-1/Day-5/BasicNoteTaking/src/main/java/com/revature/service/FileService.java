package com.revature.service;

import com.revature.exceptions.BusinessException;

public interface FileService {

	void write(String newNotes);
	
//	void writeToNewFile(String filename,String newNotes);

	String read() throws BusinessException;

}
