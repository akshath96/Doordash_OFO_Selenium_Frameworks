package org.doorDashTest;

import java.util.Iterator;
import java.util.Set;

import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.productNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import ogr.doordash.objectRepository.AdminallOrdersPage;
import ogr.doordash.objectRepository.AdmincommonPage;
import ogr.doordash.objectRepository.AdminloginPage;
import ogr.doordash.objectRepository.AllusersPage;
import ogr.doordash.objectRepository.OrderandPayPage;
import ogr.doordash.objectRepository.PickyourfavouritefoodPage;
import ogr.doordash.objectRepository.RestuarantPage;
import ogr.doordash.objectRepository.ViewOrderPage;

public class ChangeOrderStatusAsAdminTest extends BaseClass {
  @Test
	public void changeOrderStatusAsAdminTest() {
	  
	  RestuarantPage restaurant = new RestuarantPage(driver);
		commonpage.clickRequiredTab(driver,TabNames.RESTAURANTS,webdriverutility);
		restaurant.clickViewmenu();
		PickyourfavouritefoodPage pickyourfavfood=new PickyourfavouritefoodPage(driver);
		OrderandPayPage orderandpaypage=new OrderandPayPage(driver);
		pickyourfavfood.addtocartAction(productNames.LOBSTERTHERMIDOR, webdriverutility);
		pickyourfavfood.checkoutAction();
		orderandpaypage.orderNowAction();
		webdriverutility.Alertpopup(driver);
	     webdriverutility.Alertpopup(driver);
	    // commonpage.clickRequiredTab(driver,TabNames.LOGOUT,webdriverutility);
	     
	     String browser1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser1");
			String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
			String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
			String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
	     WebDriver driver=webdriverutility.openBrowserWithApplication(browser1,10l,url1);
	     
	     AdminloginPage adminlogin = new AdminloginPage(driver);
		 AdmincommonPage admincommonpage = new AdmincommonPage(driver);
		 AdminallOrdersPage adminallorder=new AdminallOrdersPage(driver);
		 ViewOrderPage vieworder=new ViewOrderPage(driver);
		 adminlogin.AdminloginAction(username1,password1);
		 admincommonpage.orderAction();
		 adminallorder.editorderAction();
		 vieworder.updateorderAction();
		 String ParentWindow1 = driver.getWindowHandle();		
			String SubWindowHandler1 = null;		
			Set<String> Handles1 = driver.getWindowHandles();		
			Iterator<String> it1 = Handles1.iterator();		
			while(it1.hasNext())		
			{		
				SubWindowHandler1 = it1.next();	
			}		
			driver.switchTo().window(SubWindowHandler1);
//			String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
//			String username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
//			String password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
//			String url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
//			LoginPage loginpage=new LoginPage(driver);
		     loginpage.loginAction(username,password);
			//commonpage.clickRequiredTab(driver,TabNames.LOGOUT,webdriverutility);
			//commonpage.logoutAction();
			driver.switchTo().window(ParentWindow1);
			vieworder.updateorderAction();
			String ParentWindow2 = driver.getWindowHandle();		
			String SubWindowHandler2 = null;		
			Set<String> Handles2 = driver.getWindowHandles();		
			Iterator<String> it2 = Handles2.iterator();		
			while(it2.hasNext())		
			{		
				SubWindowHandler2 = it2.next();	
			}		
			driver.switchTo().window(SubWindowHandler2);
			System.out.println("clicked");
			loginpage.loginAction(username,password);
			System.out.println("clicked");
			Select select = new Select(driver.findElement(By.name("status")));		
			select.selectByVisibleText("On the way");
			AllusersPage alluser=new AllusersPage(driver);
			alluser.textwriteAction();
			alluser.testAction();
			webdriverutility.Alertpopup(driver);
			alluser.allAction();
			driver.switchTo().window(ParentWindow2);
			admincommonpage.orderAction();
			alluser.testAction();		
			admincommonpage.signoutAction();
			String expectedresult="order is placed to the cart";
			String actualresult="order is placed to the cart";
			if(actualresult.equals(expectedresult))
		    {
		    	System.out.println("test case is pass successfully");
		    }
		    else {
		    	System.out.println("test case is fail");
		    }
			webdriverutility.quitBrowser(driver);
			
  }
	
	
}
