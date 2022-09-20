package org.doorDashTestScript;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectUserAccountCategory {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("akkks");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwe123");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.xpath("//a[text()='North Street Tavern']")).click();
	    driver.findElement(By.xpath("//a[.='North Street Tavern']")).click();
	    driver.findElement(By.xpath("//a[.='Yorkshire Lamb Patties']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']")).click();
	    driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg active']")).click();
	    driver.findElement(By.xpath("//input[@name='submit']")).click();
	    Alert a = driver.switchTo().alert();
	      a.accept();
	      Alert a1 = driver.switchTo().alert();
	      a1.accept();
	    driver.findElement(By.xpath("//a[.='Logout']")).click();
}
}