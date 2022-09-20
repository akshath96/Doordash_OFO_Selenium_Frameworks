package org.doorDashTest;

import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.productNames;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ogr.doordash.objectRepository.HomePage;
import ogr.doordash.objectRepository.OrderandPayPage;
import ogr.doordash.objectRepository.PickyourfavouritefoodPage;

public class AddDishCartTest1 extends BaseClass{
    
	@Test
	
	public void addDishCartTest1() {
//		 String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
//		 String  url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
//		WebDriver driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
		loginpage.loginAction(username,password);
		commonpage.clickRequiredTab(driver,TabNames.HOME,webdriverutility);
		HomePage homepage = new HomePage(driver);
		PickyourfavouritefoodPage pickyourfavfood = new PickyourfavouritefoodPage(driver);
		OrderandPayPage orderandpaypage = new OrderandPayPage(driver);
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
	     commonpage.clickRequiredTab(driver,TabNames.LOGOUT,webdriverutility);
	     webdriverutility.quitBrowser(driver);
	}
	
}
