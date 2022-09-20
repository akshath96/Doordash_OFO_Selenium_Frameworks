package org.doorDashTestScript;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.FileUtility;
import org.doordash.genericUtility.IConstantPath;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeOrderStatusAsAdmin_1 {
	public static void main(String[] args) {
		ExcelUtility excelutility = new ExcelUtility();
		FileUtility fileutility = new FileUtility();
		JavaUtility javautility = new JavaUtility();
		
		WebDriverUtility webdriverutility = new WebDriverUtility();
		String browser=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"browser");
		String username=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username");
		String password=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password");
		String url=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url");
		String url1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"url1");
		String username1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"username1");
		String password1=fileutility.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH,"password1");
		
		
		
		
		
		WebDriver driver=webdriverutility.openBrowserWithApplication(browser,10l,url);
		
		driver.findElement(By.linkText("Login")).click();		
		
		driver.findElement(By.name("username")).sendKeys(username);		
		driver.findElement(By.name("password")).sendKeys(password);		
		driver.findElement(By.id("buttn")).click();		
		driver.findElement(By.linkText("Restaurants")).click();		
		driver.findElement(By.linkText("View Menu")).click();		
		driver.findElement(By.xpath("(//input[@class='btn theme-btn'])[1]")).click();		
		driver.findElement(By.linkText("Checkout")).click();		
		driver.findElement(By.xpath("//span[text()='Cash on Delivery']")).click();		
		driver.findElement(By.name("submit")).click();		
		//driver.switchTo().alert().accept();		
		//driver.switchTo().alert().accept();
		webdriverutility.Alertpopup(driver);
		webdriverutility.Alertpopup(driver);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();		
		driver.get(url1);	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(By.name("username")).sendKeys(username1);		
		driver.findElement(By.name("password")).sendKeys(password1);		
		driver.findElement(By.name("submit")).click();		
		driver.findElement(By.linkText("Orders")).click();		
		driver.findElement(By.xpath("//tbody//tr[last()]//td//i[@class='fa fa-edit']")).click();		
		driver.findElement(By.linkText("Update Order Status")).click();			
		String ParentWindow1 = driver.getWindowHandle();		
		String SubWindowHandler1 = null;		
		Set<String> Handles1 = driver.getWindowHandles();		
		Iterator<String> it1 = Handles1.iterator();		
		while(it1.hasNext())		
		{		
			SubWindowHandler1 = it1.next();	
		}		
		driver.switchTo().window(SubWindowHandler1);		
				
		driver.findElement(By.name("username")).sendKeys(username);		
		driver.findElement(By.name("password")).sendKeys(password);		
		driver.findElement(By.id("buttn")).click();		
		driver.close();
		//webdriverutility.closeBrowser(driver);
		driver.switchTo().window(ParentWindow1);		
		driver.findElement(By.linkText("Update Order Status")).click();		
		String ParentWindow2 = driver.getWindowHandle();		
		String SubWindowHandler2 = null;		
		Set<String> Handles2 = driver.getWindowHandles();		
		Iterator<String> it2 = Handles2.iterator();		
		while(it2.hasNext())		
		{		
			SubWindowHandler2 = it2.next();	
		}		
		driver.switchTo().window(SubWindowHandler2);		
		Select select = new Select(driver.findElement(By.name("status")));		
		select.selectByVisibleText("On the way");		
				
		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Order is On the way");			
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();		
		//driver.switchTo().alert().accept();
		webdriverutility.Alertpopup(driver);
		driver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']")).click();		
		driver.switchTo().window(ParentWindow2);		
		driver.findElement(By.linkText("Orders")).click();		
		String status = driver.findElement(By.xpath("//tbody//tr[last()]//button[@class='btn btn-warning']")).getText();		
		System.out.println("Order status is :"+status);		
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();		
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
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
		//System.out.println(url1);
		//System.out.println(username1);
		//System.out.println(password1);
		
}
}