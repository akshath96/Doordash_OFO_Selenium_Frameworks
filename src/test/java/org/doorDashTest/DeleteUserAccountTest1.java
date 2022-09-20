package org.doorDashTest;

import java.util.Map;

import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.TabNames;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ogr.doordash.objectRepository.AdmincommonPage;
import ogr.doordash.objectRepository.AdminloginPage;
import ogr.doordash.objectRepository.AllusersPage;
import ogr.doordash.objectRepository.RegisterPage;

public class DeleteUserAccountTest1 extends BaseClass{
  @Test
    public void deleteUserAccountTest1() {
	  Map<String,String>map=excelutility.getDataExcelInMap("Register form");
	  RegisterPage register = new RegisterPage(driver);
		 commonpage.clickRegister();
		 String username2 = register.registerAction(javautility, excelutility,driver);
		 System.out.println(username2);
		 webdriverutility.Alertpopup(driver);
		 commonpage.clickRequiredTab(driver,TabNames.LOGIN,webdriverutility);
		 //String username2=map.get("Username")+""+random;
		 String password2= map.get("Password");
		 
	   loginpage.loginAction(username2,password2);
	  String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
		String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
		String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
		String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
		
	  WebDriver driver=webdriverutility.openBrowserWithApplication(browser1,10l,url1);
		 AdminloginPage adminlogin = new AdminloginPage(driver);
		 AdmincommonPage admincommonpage = new AdmincommonPage(driver);
		 AllusersPage alluser = new AllusersPage(driver);
		  AdmincommonPage admincommon = new AdmincommonPage(driver);
		 adminlogin.AdminloginAction(username1,password1);
		 admincommonpage.userclickAction();
		 alluser.deleteAction();
		 admincommonpage.signoutAction();
		 System.out.println("clicked");
		 admincommon.signoutImageAction();
	      admincommon.signoutAction();
	      webdriverutility.quitBrowser(driver);
	  
  }
  
}
