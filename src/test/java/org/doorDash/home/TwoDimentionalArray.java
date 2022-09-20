package org.doorDash.home;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TwoDimentionalArray {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("CommonData");
	String[][] arr = new String[6][6];
	arr[0][0]="url";
	arr[1][0]="browser";
	arr[2][0]="username";
	arr[3][0]="password";
	
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i][i]);
	}
}
}
