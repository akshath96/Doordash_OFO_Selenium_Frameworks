package org.doordash.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is consists all common action on excel
 * @author admin
 *
 */
public class ExcelUtility {
 Workbook workbook=null;
	
	
	
	/**
	 * this method is used to open the excel workbook
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void openExcel(String excelPath) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel=new FileInputStream(excelPath);
		 workbook=WorkbookFactory.create(fisExcel);
	}
	/**
	 * this method is used to fetch the data from the excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel(String excelPath, String sheetName, int rowNumber, int cellNumber) {
		
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue((Cell) sheet.getRow(rowNumber).getCell(cellNumber));
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return data;
}
	/**
	 * this method is used to fetch the excel based on key
	 * @param sheetName
	 * @param requriedKey
	 * @return
	 */
	public String getDataFromExcelSheet(String sheetName,String requriedKey) {
		//Workbook workbook = null;
		Sheet sheet = workbook.getSheet(sheetName);
		String value=null;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			String actualKey=sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualKey.equalsIgnoreCase(requriedKey)) {
				value=sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return value;
	}
	
	/**
	 * this method is used the data from the excel and stored in map
	 * @param sheetName
	 * @return
	 */
	public Map<String,String> getDataExcelInMap(String sheetName){
		//Workbook workbook=null;
		Sheet sheet = workbook.getSheet(sheetName);
		Map<String, String>map=new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++) {
	map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
			
	}

		public List<Map<String,String>> getDataFromExcelInList(String sheetName){
		 Sheet sheet = workbook.getSheet(sheetName);
			List<Map<String,String>> list=new ArrayList<>();
			DataFormatter df=new DataFormatter();
			for(int k=0;k<=sheet.getRow(0).getLastCellNum();k++) {
				Map<String, String>map=new HashMap<>();
				for(int i=0;i<=sheet.getLastRowNum();i++) {
		map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));		
				}
				list.add(map);
		}
			return list;
	}
		
    public String[][] getMultipleData(String sheetname) {
    	Sheet sheet = workbook.getSheet(sheetname);
    	DataFormatter df = new DataFormatter();
    	String[][] arr=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	for(int i=1;i<=sheet.getLastRowNum();i++) {
    		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
    			arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
    		}
    	}
    	return arr;
    }
    }