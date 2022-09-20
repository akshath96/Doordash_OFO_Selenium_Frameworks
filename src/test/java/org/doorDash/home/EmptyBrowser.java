package org.doorDash.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyBrowser {
public static void main(String[] args) {
	String browser="firefox";
	WebDriver driver=null;
	if(browser.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
}
	else if(browser.equalsIgnoreCase("ie")) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
	}
	else {
		System.out.println("Please Enter Valid Browser Key");
	}
	switch(browser) {
	case"FireFox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	case"chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case"ie":
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		default:
			System.out.println("Please Enter Valid Browser Key");	
	}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlywait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
}
}