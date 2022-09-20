package org.doorDashTestScript;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughListMap {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility excelutility = new ExcelUtility();
		excelutility.openExcel(IConstantPath.EXCEL_PATH);
		List<Map<String, String>> list=excelutility.getDataFromExcelInList("Register form");
		System.out.println(list.get(1).get("Email"));	
		
}
}