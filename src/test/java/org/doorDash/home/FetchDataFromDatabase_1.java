package org.doorDash.home;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromDatabase_1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		try {
		Sheet sheet=wb.getSheet("Sheet1");
		 //int data=(int)sheet.getRow(0).getCell(0).getNumericCellValue();
		  String data = sheet.getRow(0).getCell(0).toString();
		 
		 System.out.println(data);
}
  finally {
	  wb.close();
  }
	}
}