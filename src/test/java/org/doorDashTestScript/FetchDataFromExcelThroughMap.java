package org.doorDashTestScript;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughMap {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility excelutility = new ExcelUtility();
		excelutility.openExcel(IConstantPath.EXCEL_PATH);
		Map<String,String> map=excelutility.getDataExcelInMap("Register form");
		System.out.println(map.get("Username"));
		System.out.println(map.get("Firstname"));
		System.out.println(map.get("Lastname"));
		System.out.println(map.get("Email"));
		System.out.println(map.get("Phone"));
		System.out.println(map.get("Password"));
		System.out.println(map.get("Cpassword"));
		System.out.println(map.get("Adress"));
		
}
}