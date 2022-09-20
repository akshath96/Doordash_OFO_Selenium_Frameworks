package org.doorDash.home;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDynamicData {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.xpath("//span[.='Users']")).click();
	    driver.findElement(By.xpath("//th[.='Username']")).click();
	    
	    List<WebElement> list = driver.findElements(By.xpath("//table[@id='myTable']/thead/tr//following::tr/td"));
	   List<WebElement> name= new ArrayList<WebElement>();
	   for(int i=0; i<list.size();i++)
	   {
		   String name1=list.get(i).getText();
		   if(name1.equals("Username")) {
			   driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td["+(1+1)+"]"));
			   break;
			   
		   }
	   }
	   for(WebElement user:list) {
		   System.out.println(user.getText());
	   }
}
}