package org.doorDash.home;

import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor_ {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebDriverUtility webdriverutility = new WebDriverUtility();
	driver.manage().window().maximize();
	webdriverutility.jsIntialization(driver);
	webdriverutility.openApplicationUsingJS("http://localhost:8888");
	webdriverutility.sendKeysUsingJS(driver.findElement(By.name("user_name")), "admin");
	webdriverutility.sendKeysUsingJS(driver.findElement(By.name("user_password")),"admin");
	webdriverutility.clickUsingJS(driver.findElement(By.id("submitButton")));
	webdriverutility.scrollTillElementUsingJS(driver.findElement(By.xpath("//b[contains(text(),")));
}
}
