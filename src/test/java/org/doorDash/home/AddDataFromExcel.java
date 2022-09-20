package org.doorDash.home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 
		//step1-->convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resource/TestData.xlsx");
		
		//step2-->open the excel workshop
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3-->get the control on sheet
		Sheet sheet = wb.getSheet("Home");
		
		Row row = sheet.createRow(15);//------>get the control on row for new row
		//Row row = sheet.getRow(15);------>get the control on row for existing row
		Cell cell = row.createCell(2);
		
		//step6-->update the status/set the data
	cell.setCellValue("skip");
	FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
	
	//step7-->write the data into excel
	wb.write(fos);
	System.out.println("data updated successfully");
	
	//step8-->close the workbook
	wb.close();
}}
