package org.doorDashTestScript;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;

public class TestingGenericUtility {
public static void main(String[] args) {
	int randomNumber = new JavaUtility().getRandomNumber(1000);
	   
	
	String data = new ExcelUtility().getDataFromExcel(IConstantPath.EXCEL_PATH,"Home",3,1)+randomNumber;
	System.out.println(data);
	
	String browser = new FileUtility().getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
	System.out.println(browser);
}
}
