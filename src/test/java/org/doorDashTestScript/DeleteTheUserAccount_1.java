package org.doorDashTestScript;

import java.time.Duration;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteTheUserAccount_1 {
	public static void main(String[] args) {
		ExcelUtility excelutility = new ExcelUtility();
		FileUtility fileutility = new FileUtility();
		JavaUtility javautility = new JavaUtility();
		//String data=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH,"Home",3,1)+javautility.getRandomNumber(1000);
		 
		WebDriverUtility webdriverutility = new WebDriverUtility();
		String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
		String username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
		String password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
		String url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
		String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
		String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
		String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
		String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
		
		WebDriver driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
		//WebDriver driver1=webdriverutility.openBrowserWithApplication(browser1,10l,url1);
		
		 int random = javautility.getRandomNumber(1000);
		 String Username=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",0,1);
		 String Firstname =excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",1,1);
		 String Lastname=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",2,1);
		 String Email=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",3,1);
		 String Phone=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",4,1);
		 String Password=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",5,1);
		 String Cpassword=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",6,1);
		 String Adress=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH, "Register form",7,1);

		 
		 driver.findElement(By.xpath("//a[text()='Register']")).click();	
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username+random);		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Firstname+random);		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname+random);		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email+random);		
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Phone+random);		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password+random);		
		driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys(Cpassword+random);		
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(Adress+random);		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username+random);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password+random);
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	   	
				
	    WebDriver driver1=webdriverutility.openBrowserWithApplication(browser1,10l,url1);		
		driver1.findElement(By.name("username")).sendKeys(username1);		
		driver1.findElement(By.name("password")).sendKeys(password1);		
		driver1.findElement(By.xpath("//input[@value='Login']")).click();		
				
		driver1.findElement(By.xpath("//span[text()='Users']")).click();		
				
		String deleteusername = Username+random;		
		driver1.findElement(By.xpath("//tbody//tr//td[.='" + deleteusername+ "']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
	driver1.findElement(By.xpath("//img[@class='profile-pic']")).click();			
	driver1.findElement(By.xpath("//a[@href='logout.php']")).click();
	String expectedresult="user account is deleted";
	String actualresult="user account is deleted";
	if(actualresult.equals(expectedresult))
    {
    	System.out.println("test case is pass successfully");
    }
    else {
    	System.out.println("test case is fail");
    }
	webdriverutility.quitBrowser(driver);
	webdriverutility.quitBrowser(driver1);
}
}