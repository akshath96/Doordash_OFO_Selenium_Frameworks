package org.doorDash.home;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingMethodChaining_1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	DataFormatter df=new DataFormatter();
	
	
		try {
		Sheet sheet=wb.getSheet("Sheet1");
		 String data=df.formatCellValue(sheet.getRow(0).getCell(0));
		 System.out.println(data);
}
		finally {
			wb.close();
		}
}
}