package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile(String fileName)  {
		
		File xlsxfile = new File(System.getProperty("user.dir") + "//testData//"+ fileName);
		XSSFWorkbook workbook = null;
		List<User> userList = null;
		try {
			workbook = new XSSFWorkbook(xlsxfile);
			 userList = new ArrayList<>();
			Row row;
			Cell emailAddressCell;
			Cell passwordCell;
			User user;
			
			
			XSSFSheet xssfSheet = workbook.getSheet("LoginTestData");
			Iterator<Row> rowIterator = 	xssfSheet.iterator();
			rowIterator.next(); // skipping row 1
			while(rowIterator.hasNext()) {
				 row = rowIterator.next();
				 emailAddressCell = row.getCell(0);
				 passwordCell = row.getCell(1);
				 user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
			
			}
			workbook.close();
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
