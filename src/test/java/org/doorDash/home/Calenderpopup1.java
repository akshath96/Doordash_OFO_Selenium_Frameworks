package org.doorDash.home;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requriedDate="20";
		String requriedMonth="January";
		String requiredYear="2024";
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		 
		 String[] str=actualMonthYear.split(" ");
		 String actualMonth=str[0];
		 String actualYear=str[1];
		 while(!(actualMonth.equals(requriedMonth) && actualYear.equals(requiredYear))) {
			 driver.findElement(By.xpath("//span[text()='Next']")).click(); 
				actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				str=actualMonthYear.split(" ");
				actualMonth=str[0];
				actualYear=str[1];
		 }
		 driver.findElement(By.xpath("//a[text()='"+requriedDate+"']")).click();
}}
