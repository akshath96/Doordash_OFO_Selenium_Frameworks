package org.doorDash.home;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requriedDate="20";
		String requriedMonth="January";
		String requiredYear="2022";
		
		 int requiredMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requriedMonth).get(ChronoField.MONTH_OF_YEAR);
		
		 int requriedYearInNum=Integer.parseInt(requiredYear);
		
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		 
		 String[] str=actualMonthYear.split(" ");
		 String actualMonth=str[0];
		 String actualYear=str[1];
		 int actualMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		  
		 int actualYearInNum=Integer.parseInt(actualYear);
		 
		 while(requiredMonthInNum>actualMonthInNum || requriedYearInNum>actualYearInNum) {
		driver.findElement(By.xpath("//span[text()='Next']")).click(); 
		actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		str=actualMonthYear.split(" ");
		actualMonth=str[0];
		actualYear=str[1];
		actualMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		
		actualYearInNum=Integer.parseInt(actualYear);
		 }
		 
		 while(requiredMonthInNum<actualMonthInNum || requriedYearInNum<actualYearInNum) {
				driver.findElement(By.xpath("//span[text()='Prev']")).click(); 
				actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				str=actualMonthYear.split(" ");
				actualMonth=str[0];
				actualYear=str[1];
				actualMonthInNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		 
				actualYearInNum=Integer.parseInt(actualYear);
}
		 driver.findElement(By.xpath("//a[text()='"+requriedDate+"']")).click();
}}