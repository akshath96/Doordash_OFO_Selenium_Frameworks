package org.doorDashTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeOrderStatusAsAdmin {
	public static void main(String[] args) throws InterruptedException, IOException {			
		FileInputStream fisExcel = null;		
		fisExcel = new FileInputStream("./src/test/resources/TestData.xlsx");		
				
		Workbook wb = WorkbookFactory.create(fisExcel);		
		String browser = wb.getSheet("CommonData").getRow(1).getCell(1).getStringCellValue();		
		WebDriver driver = null;		
		switch(browser)		
		{		
		case "chrome": 		
			WebDriverManager.chromedriver().setup();	
			driver  = new ChromeDriver();	
			break;	
		case "firefox": 		
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();	
			break;	
		case "ie": 		
			WebDriverManager.edgedriver().setup();	
			driver = new EdgeDriver();	
			break;	
		default: 		
			System.out.println("Please enter a valid browser");	
			break;	
		}		
		String url = wb.getSheet("CommonData").getRow(0).getCell(1).getStringCellValue();		
		String username = wb.getSheet("CommonData").getRow(2).getCell(4).getStringCellValue();		
		String password = wb.getSheet("CommonData").getRow(3).getCell(4).getStringCellValue();		
		String url1 = wb.getSheet("CommonData").getRow(4).getCell(1).getStringCellValue();		
		String username1 = wb.getSheet("CommonData").getRow(6).getCell(1).getStringCellValue();		
		String password1 = wb.getSheet("CommonData").getRow(7).getCell(1).getStringCellValue();		
				
		driver.manage().window().maximize();		
		driver.get(url);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
				
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
		driver.switchTo().alert().accept();		
		driver.switchTo().alert().accept();		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();		
		driver.get(url1);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(By.name("username")).sendKeys(username1);		
		driver.findElement(By.name("password")).sendKeys(password1);		
		driver.findElement(By.name("submit")).click();		
		driver.findElement(By.linkText("Orders")).click();		
		driver.findElement(By.xpath("//tbody//tr[last()]//td//i[@class='fa fa-edit']")).click();		
		driver.findElement(By.linkText("Update Order Status")).click();		
		Thread.sleep(3000);		
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
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();		
		driver.switchTo().alert().accept();		
		driver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']")).click();		
		driver.switchTo().window(ParentWindow2);		
		driver.findElement(By.linkText("Orders")).click();		
		String status = driver.findElement(By.xpath("//tbody//tr[last()]//button[@class='btn btn-warning']")).getText();		
		System.out.println("Order status is :"+status);		
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();		
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();		
			
		driver.quit();		

}
}