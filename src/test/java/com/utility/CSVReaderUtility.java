package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String filename)  {
		
		File csvFile = new File(System.getProperty("user.dir") + "//testData//" + filename);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userData;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new  CSVReader(fileReader);
			csvReader.readNext(); /// reading the column names
//			data = csvReader.readNext();
			 userList = new ArrayList<User>();
			
			while((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
	
			for(User us : userList) {
				System.out.println(us);
			}
			
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		
		
			return userList.iterator();	
	}
}
