package org.itstep;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	public String readFromFile(String filePath) {
		String textFromFile = "";
		int oneByte = -1;
		try {
			FileReader reader = new FileReader(filePath);
			while ((oneByte = reader.read()) != -1) {
				textFromFile += String.valueOf((char)oneByte);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textFromFile;
	}

	public void writeToFile(String textToWrite, String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(textToWrite+"\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
