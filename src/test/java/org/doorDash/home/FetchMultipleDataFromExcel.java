package org.doorDash.home;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("CommonData");
		DataFormatter df = new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum();i++) {
			 
			for(int j=0; j<sheet.getRow(i).getLastCellNum();j++) {
				System.out.print(df.formatCellValue(sheet.getRow(i).getCell(j))+"   ||   ");
			} 
			System.out.println();
		}
}
}