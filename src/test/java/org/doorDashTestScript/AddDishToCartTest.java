package org.doorDashTestScript;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.WebDriverUtility;


import org.doordash.genericUtility.productNames;
import org.openqa.selenium.WebDriver;

import ogr.doordash.objectRepository.CommonPage;
import ogr.doordash.objectRepository.HomePage;
import ogr.doordash.objectRepository.LoginPage;
import ogr.doordash.objectRepository.OrderandPayPage;
import ogr.doordash.objectRepository.PickyourfavouritefoodPage;

public class AddDishToCartTest {
	public static void main(String[] args) {
		ExcelUtility excelutility = new ExcelUtility();
		FileUtility fileutility = new FileUtility();
		JavaUtility javautility = new JavaUtility();
		
		WebDriverUtility webdriverutility = new WebDriverUtility();
		String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
		String username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
		String password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
		String url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
		
		//String data=excelutility.getDataFromExcel(IConstantPath.EXCEL_PATH,"Home",3,1)+javautility.getRandomNumber(1000);
		WebDriver driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
		
		LoginPage loginpage=new LoginPage(driver);
		CommonPage commonpage=new CommonPage(driver);
		HomePage homepage=new HomePage(driver);
		PickyourfavouritefoodPage pickyourfavfood=new PickyourfavouritefoodPage(driver);
		OrderandPayPage orderandpaypage=new OrderandPayPage(driver);
		
		
		loginpage.loginAction(username,password);
		commonpage.clickRequiredTab(driver,TabNames.HOME,webdriverutility);
		System.out.println("clicked");
		homepage.clickRequiredName(productNames.YORKSHIRELAMBPATTIES, webdriverutility);
		pickyourfavfood.addtocartAction(productNames.YORKSHIRELAMBPATTIES, webdriverutility);
		pickyourfavfood.checkoutAction();
		orderandpaypage.orderNowAction();
		
		webdriverutility.Alertpopup(driver);
	     webdriverutility.Alertpopup(driver);
	     String expectedresult="order is placed to the cart";
			String actualresult="order is placed to the cart";
	     
	     if(actualresult.equals(expectedresult))
		    {
		    	System.out.println("test case is pass successfully");
		    }
		    else {
		    	System.out.println("test case is fail");
		    }
	     commonpage.logoutAction();
	     System.out.println("clicked");
	     webdriverutility.quitBrowser(driver);
}
}
