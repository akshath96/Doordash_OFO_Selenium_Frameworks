package org.doorDashTest;

import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.productNames;
import org.testng.annotations.Test;

import ogr.doordash.objectRepository.HomePage;
import ogr.doordash.objectRepository.OrderandPayPage;
import ogr.doordash.objectRepository.PickyourfavouritefoodPage;
import ogr.doordash.objectRepository.RestuarantPage;

public class RestuarantToOrderDishTest extends BaseClass {
	
     @Test
     public void restuarantToOrderDishTest() {
    	
    loginpage.loginAction(username,password); 
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
	System.out.println("Ordered Food Successfully");
     webdriverutility.quitBrowser(driver);
}
}