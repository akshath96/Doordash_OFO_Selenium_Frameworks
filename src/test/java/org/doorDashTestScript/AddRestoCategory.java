package org.doorDashTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddRestoCategory {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
	    driver.findElement(By.xpath("//a[text()='Add Category']")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("spanies");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.xpath("//*[@id=\"sidebarnav\"]/li[3]/a/span")).click();
	    driver.findElement(By.xpath("//img[@alt='user']")).click();
	    driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	    driver.findElement(By.xpath("//*[@id=\"sidebarnav\"]/li[3]/a/span")).click();
}
}