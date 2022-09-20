package org.doorDashTestScript;

import java.util.Map;
import java.util.Random;

import javax.lang.model.element.Element;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;

import ogr.doordash.objectRepository.AdmincommonPage;
import ogr.doordash.objectRepository.AdminloginPage;
import ogr.doordash.objectRepository.AllusersPage;
import ogr.doordash.objectRepository.CommonPage;
import ogr.doordash.objectRepository.LoginPage;
import ogr.doordash.objectRepository.RegisterPage;

public class DeleteUserAccountTest {
public static void main(String[] args) {
	ExcelUtility excelutility = new ExcelUtility();
	FileUtility fileutility = new FileUtility();
	JavaUtility javautility = new JavaUtility();
	
	
	WebDriverUtility webdriverutility = new WebDriverUtility();
	int random = javautility.getRandomNumber(1000);
	String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
	String username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
	String password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
	String url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
	String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
	String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
	String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
	String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
	String excel=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH,"Register form", 0, 1)+javautility.getRandomNumber(1000);
	

	    
	Map<String,String>map=excelutility.getDataExcelInMap("Register form");
	
		WebDriver driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
	 CommonPage commonpage = new CommonPage(driver);
	 RegisterPage register = new RegisterPage(driver);
	 LoginPage loginpage = new LoginPage(driver);
	
	 commonpage.clickRegister();
	 register.registerAction(javautility, excelutility,driver);
	// webdriverutility.Alertpopup(driver);
	 
	  String username2=map.get("Username");
	String password2= map.get("Password");
	loginpage.loginAction(username2,password2);
	
	 WebDriver driver1=webdriverutility.openBrowserWithApplication(browser1,10l,url1);
	 AdminloginPage adminlogin = new AdminloginPage(driver1);
	 AdmincommonPage admincommonpage = new AdmincommonPage(driver1);
	 AllusersPage alluser = new AllusersPage(driver1);
	 System.out.println("clicked");
	 adminlogin.AdminloginAction(username1,password1);
	 System.out.println("clicked");
	 admincommonpage.userclickAction();
	 alluser.deleteAction();
	 System.out.println("clicked");
	 admincommonpage.signoutAction();
	 System.out.println("clicked");
	 webdriverutility.quitBrowser(driver1);
     webdriverutility.quitBrowser(driver);
}
}
