package org.doorDash.home;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();

	
	ChromeDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//p[.='Chennai, India']/ancestor::li[@class='react-autosuggest__suggestion']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//p[.='Mumbai, India']/ancestor::div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']//following::li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
}
}
