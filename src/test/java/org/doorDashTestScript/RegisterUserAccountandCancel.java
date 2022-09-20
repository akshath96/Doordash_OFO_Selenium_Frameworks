package org.doorDashTestScript;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterUserAccountandCancel {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@class='nav-link active'])[4]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("afgsr");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("akshatha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("B A");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("akshatharpee15@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("987345627");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwe123");
		driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys("qwe123");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Alert a = driver.switchTo().alert();
	    a.accept();
	    driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("afgsr");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwe123SS");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.xpath("(//a[@class='nav-link active'])[4]")).click();
	    driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.xpath("(//a[@href='all_users.php'])")).click();
	    driver.findElement(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).click();
	    driver.findElement(By.xpath("//i[@class='fa fa-tachometer']")).click();
	    driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
	    driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
}
}