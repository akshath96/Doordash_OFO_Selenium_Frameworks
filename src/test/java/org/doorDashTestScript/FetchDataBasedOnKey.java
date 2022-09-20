package org.doorDashTestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.IConstantPath;

public class FetchDataBasedOnKey {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	ExcelUtility excelutility = new ExcelUtility();
	excelutility.openExcel(IConstantPath.EXCEL_PATH);
	String username = excelutility.getDataFromExcelSheet("Register form","Username");
	String firstname = excelutility.getDataFromExcelSheet("Register form","Firstname");
	String lastname = excelutility.getDataFromExcelSheet("Register form","Lastname");
	String email = excelutility.getDataFromExcelSheet("Register form","Email");
	String phoneno = excelutility.getDataFromExcelSheet("Register form","Phone");
	String password = excelutility.getDataFromExcelSheet("Register form","Password");
	String cpassword = excelutility.getDataFromExcelSheet("Register form","Cpassword");
	//String phoneno = excelutility.getDataFromExcelSheet("Register form","Phone");
	String adress = excelutility.getDataFromExcelSheet("Register form","Adress");
	
	
	System.out.println(username);
	System.out.println(firstname);
	System.out.println(lastname);
	System.out.println(email);
	System.out.println(phoneno);
	System.out.println(password);
	System.out.println(cpassword);
	System.out.println(adress);
}
}


