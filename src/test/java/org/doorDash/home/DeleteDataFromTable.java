package org.doorDash.home;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteDataFromTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
//	    String expuser="afgs";
	    driver.findElement(By.xpath("//span[.='Users']")).click();
//driver.findElement(By.xpath("//th[.='Username']")).click();
	    
//	    List<WebElement> list = driver.findElements(By.xpath("//table[@id='myTable']/thead/tr/th[.='Username']"));
//	    for(WebElement use:list)
//	    {
//	    	 String name=use.getText();
//	    	if(name.equals(expuser)) {
	    		driver.findElement(By.xpath("//h4[.='All Users']/ancestor::div[@class='card card-outline-primary']/div/following::tr/th[.='FirstName']/ancestor::table/child::tbody/tr/td[contains(.,'afgs')]/ancestor::tr/td/a/i[@class='fa fa-trash-o']")).click();
//	    		break;
//	    		
//	    	}
//	    	}
//	    	 driver.findElement(By.xpath("//a[@href='delete_users.php?user_del=24']")).click();
//	    	 driver.switchTo().alert().accept();
	    	 
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(""))));
//	  
//	 List<WebElement> latestuse = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover']/tbody//tr/td//a[@href='delete_users.php?user_del=23']"));
//	  
//	  for(WebElement use:latestuse) {
//		  String usename = use.getText();
//		  
//		  if(usename.equals(expuser)) {
//			  System.out.println("TC Fail--->username is not deleted");
//		  }
//	    }
//	    
}
}