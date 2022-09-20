package org.doorDash.home;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.ajio.com/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("")).click();
			driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
			
}
}