package org.doordash.genericUtility;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ogr.doordash.objectRepository.CommonPage;
import ogr.doordash.objectRepository.LoginPage;
import ogr.doordash.objectRepository.RegisterPage;

public class BaseClass {
  protected LoginPage loginpage;
  protected String username;
  protected String password;
  protected CommonPage commonpage;
  protected WebDriver driver;
  protected WebDriverUtility webdriverutility;
  protected Random random;
  protected FileUtility fileutility;
  protected ExcelUtility excelutility;
  protected JavaUtility javautility;
  public static JavaUtility sjavautility;
  public static WebDriver sdriver;
// protected String browser;
 //protected String url;
  
  
   //code changes done by engg 1
 HEAD
  //code change by  engg2
  //code change by engg=1
 
	@BeforeClass
	public void classSetUp() {
		//create instance for the generic Utility
		
		excelutility = new ExcelUtility();
		fileutility = new FileUtility();
	    javautility = new JavaUtility();
	    sjavautility=javautility;
	     webdriverutility = new WebDriverUtility();
		
		// int random = javautility.getRandomNumber(1000);
		//fetch the data from propretyfile
		 String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
		 username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
		 password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
		String  url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
		
//		String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
//		String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
//		String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
//		String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
		String excel=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH,"Register form", 0, 1)+javautility.getRandomNumber(1000);
		
		//Map<String,String>map=excelutility.getDataExcelInMap("Register form");
		//sdriver=driver;
		 driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
		   sdriver=driver;
		//WebDriverUtility.scrollTillElementUsingJS();
		loginpage=new LoginPage(driver);
		commonpage = new CommonPage(driver);
		// RegisterPage register = new RegisterPage(driver);
		 
		// commonpage.clickRegister();
		// String username3 = register.registerAction(javautility, excelutility,driver);
		// System.out.println(username3);
		// webdriverutility.Alertpopup(driver);
		 //String username2=map.get("Username"+random);
			//String password2= map.get("Password");
		 
			//loginpage.loginAction(username3,password2);
	}
	
//	 @BeforeMethod
//	   public void  MethodSetUp() {
//		 loginpage.loginAction(username,password);
//	 }
  @AfterMethod
	public void  MethodTearDown() {
    // commonpage.clickRequiredTab(driver,TabNames.LOGOUT,webdriverutility);
	  //commonpage.logoutAction();
	 }
	   @AfterClass
	   public void classTearDown() {
		   webdriverutility.quitBrowser(driver);
	   }
} 
	   
	   
	   
	 

