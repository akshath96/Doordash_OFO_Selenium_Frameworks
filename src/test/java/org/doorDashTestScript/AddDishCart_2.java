package org.doorDashTestScript;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddDishCart_2 {
public static void main(String[] args) {
	ExcelUtility excelutility = new ExcelUtility();
	FileUtility fileutility = new FileUtility();
	JavaUtility javautility = new JavaUtility();
	WebDriverUtility webdriverutility = new WebDriverUtility();
	
	String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
	String username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
	String password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
	String url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
	//String timeout=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"timeout");
	String data=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH,"Home",3,1)+javautility.getRandomNumber(1000);
	
	//long longTimeout= (long) javautility.convertStringIntoAnyDataType(timeout,DataType.LONG);
	
	WebDriver driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
	
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@name='submit']")).click();

	    String productname="productname";
		driver.findElement(By.xpath("//a[text()='"+productname+"']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']")).click();
	    driver.findElement(By.xpath("//a[.='"+productname+"']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']")).click();
	    driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg active']")).click();
	    driver.findElement(By.xpath("//input[@name='submit']")).click();
	    String expectedresult="order is placed to the cart";
		String actualresult="order is placed to the cart";
		if(actualresult.equals(expectedresult))
	    {
	    	System.out.println("test case is pass successfully");
	    }
	    else {
	    	System.out.println("test case is fail");
	    }
	     webdriverutility.Alertpopup(driver);
	     webdriverutility.Alertpopup(driver);
	     driver.findElement(By.xpath("//a[.='Logout']")).click();
	     
	     webdriverutility.quitBrowser(driver);

System.out.println(browser);
System.out.println(url);
System.out.println(username);
System.out.println(password);
//System.out.println(timeout);
}}
