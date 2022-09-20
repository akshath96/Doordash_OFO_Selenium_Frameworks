package org.doorDashTest;

import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.restoNames;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ogr.doordash.objectRepository.AddRestoCategory;
import ogr.doordash.objectRepository.AdmincommonPage;
import ogr.doordash.objectRepository.AdminloginPage;


public class ChangeRestoCategory extends BaseClass{
	@Test
	public void changerestoCategory() {
		
		 String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
			String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
			String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
			String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
	     WebDriver driver=webdriverutility.openBrowserWithApplication(browser1,10l,url1);
	
	      AdminloginPage adminlogin = new AdminloginPage(driver);
	      adminlogin.AdminloginAction(username1, password1);
	     commonpage.clickRequiredTab(driver,TabNames.RESTAURANTS,webdriverutility);
	     AdmincommonPage admincommon = new AdmincommonPage(driver);
	     admincommon.RestuarantAction();
	     admincommon.addrestuarantAction();
	      AddRestoCategory addresto = new AddRestoCategory(driver);
	      addresto.clickRequiredrestoName(restoNames.AMERICAN, webdriverutility);
	      addresto.categoryAction();
	      addresto.restocategoryAction();
	      System.out.println("Category updated successfully");
	      admincommon.signoutAction();
//		commonpage.pickcategoryName();
//		String updatedCategoryName= "African";
//		commonpage.updateCategoryName(updatedCategoryName);
//		LoginPage.logOutAction();
		
		
		
		
		
		/*
		 * FileUtility fileUtility=new FileUtility();
		 * fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		 * 
		 * String browser =fileUtility.getDataFromPropertyFile("browser"); String admurl
		 * = fileUtility.getDataFromPropertyFile("admurl"); String adnusername =
		 * fileUtility.getDataFromPropertyFile("adnusername"); String adnpassword =
		 * fileUtility.getDataFromPropertyFile("adnpassword"); String Timeouts =
		 * fileUtility.getDataFromPropertyFile("Timeouts");
		 * 
		 * WebDriverUtility webDriverUtility = new WebDriverUtility(); WebDriver driver
		 * = webDriverUtility.launchBrowser(browser); JavaUtility javaUtility = new
		 * JavaUtility();
		 * 
		 * long longTimeOut =(long) javaUtility.convertStringIntoAnyDatatype(Timeouts,
		 * DataType.LONG); driver= webDriverUtility.openBrowserWithApplication(browser,
		 * longTimeOut, admurl);
		 * 
		 * driver.findElement(By.name("username")).sendKeys(adnusername);
		 * driver.findElement(By.name("password")).sendKeys(adnpassword);
		 * driver.findElement(By.xpath("//input[@value='Login']")).click();
		 */
				
				//driver.findElement(By.xpath("//a[@class='has-arrow  ']//span[text()='Restaurant']")).click();
				//driver.findElement(By.xpath("//a[text()='Add Category']")).click();
				
				//String CategoryName= "frgsdfgfdsgfrgsdfgfdsgaddffsdAfrican";
				//driver.findElement(By.xpath("//tbody//tr//td[text()='"+CategoryName+"']//ancestor::tr//td//i[@class='fa fa-edit']")).click();
				
				//driver.findElement(By.xpath("//input[@placeholder='Category Name']")).clear();
				//driver.findElement(By.xpath("//input[@placeholder='Category Name']")).sendKeys("African");
				
				//System.out.println("Category updated successfully");
				//driver.findElement(By.xpath("//input[@name='submit']")).click();
				//driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
				//driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
				
			//	webDriverUtility.closeBrowser(driver);
	}
}
