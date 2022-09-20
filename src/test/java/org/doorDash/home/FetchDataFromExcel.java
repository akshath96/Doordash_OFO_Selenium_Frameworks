package org.doorDash.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step1-->convert the physical file into java readable object
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	//step2-->open the excel workbook
	Workbook wb = WorkbookFactory.create(fis);
	//step3-->get the control on sheet
	Sheet sheet = wb.getSheet("CommonData");
	//step4-->get the control on row
	Row row = sheet.getRow(1);
	//step5-->get the control on cell 
	Cell cell = row.getCell(1);
	String username = cell.getStringCellValue();
	System.out.println(username);
	wb.close();
}
}