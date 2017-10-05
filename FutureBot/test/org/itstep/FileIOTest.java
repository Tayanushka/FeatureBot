package org.itstep;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileIOTest {

	private static String filePath =  "D://accountList.txt";
	
	@Test
	public void testFileWriteAndRead() {
		FileIO fileIO = new FileIO();
		
		String originalText = fileIO.readFromFile(filePath);
		
		String textToWrite = "some text to be writen to file";
		fileIO.writeToFile(textToWrite, filePath);
		
		String textFromFile = fileIO.readFromFile(filePath);
		
		assertTrue(textFromFile.contains(textToWrite));
		
		File file = new File(filePath);
		
		fileIO.writeToFile(originalText, filePath);
	}
}