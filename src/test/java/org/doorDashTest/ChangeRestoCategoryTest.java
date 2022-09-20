package org.doorDashTest;

import org.doorDash.home.JavaScriptExecutor_;
import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.restoNames;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ogr.doordash.objectRepository.AddRestoCategory;
import ogr.doordash.objectRepository.AdmincommonPage;
import ogr.doordash.objectRepository.AdminloginPage;

public class ChangeRestoCategoryTest extends BaseClass {

	@Test
		public void changerestoCategory() {
		//JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			 String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
				String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
				String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
				String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
		      driver=webdriverutility.openBrowserWithApplication(browser1,10l,url1);
		
		      AdminloginPage adminlogin = new AdminloginPage(driver);
		      adminlogin.AdminloginAction(username1, password1);
		      AdmincommonPage admincommon = new AdmincommonPage(driver);
		      admincommon.RestuarantAction();
		      admincommon.addrestuarantAction();
		      AddRestoCategory addresto = new AddRestoCategory(driver);
		      System.out.println("Category updated successfully");
		      addresto.clickRequiredrestoName(restoNames.AMERICAN, webdriverutility);
		      addresto.categoryAction();
		      addresto.restocategoryAction();
		      addresto.saveAction();
		      System.out.println("Category updated successfully");
		      admincommon.signoutImageAction();
		      admincommon.signoutAction();
      
}
}