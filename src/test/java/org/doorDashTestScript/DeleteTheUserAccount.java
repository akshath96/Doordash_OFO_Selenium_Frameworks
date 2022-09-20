package org.doorDashTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.doordash.genericUtility.JavaUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteTheUserAccount {
	public static void main(String[] args) throws IOException {			
		// Step1 --> Convert the Physical File into Java Reachable Object		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");		
				
		// Step2--> create the object for properties		
		Properties property = new Properties();		
				
		// Step3--> Load all the keys		
		property.load(fis);		
				
		// Step4--> Fetch the data		
				
		String url= property.getProperty("url").trim();		
		String browser = property.getProperty("browser").trim();
		String username = property.getProperty("username").trim();		
		String password = property.getProperty("password").trim();
		String url1= property.getProperty("url1").trim();		
		String username1 = property.getProperty("username1").trim();		
		String password1 = property.getProperty("password1").trim();		
				
		WebDriver driver = null;		
		switch (browser) {		
		case "fireFox":		
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();	
			break;	
				
		case "chrome":		
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();	
			break;	
				
		case "ie":		
			WebDriverManager.iedriver().setup();	
			driver = new InternetExplorerDriver();	
			break;	
				
		}		
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
				
		driver.get(url);		
		driver.manage().window().maximize();
		JavaUtility j = new JavaUtility();
		 int random = j.getRandomNumber(1000);	
		driver.findElement(By.xpath("//a[text()='Register']")).click();	
		
		  //int random = new RandomNumber(1000);
		   //random.nextInt(1000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("abc"+random);		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("abc"+random);		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("asd"+random);		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xyz@gmail.com"+random);		
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567891"+random);		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9535565467"+random);		
		driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys("9535565467"+random);		
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Bangalore"+random);		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		driver.findElement(By.linkText("Login")).click();
		String name="abc"+random;
		String cpass="9535565467"+random;
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(cpass);
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Alert a = driver.switchTo().alert();
	   // a.accept();
		//driver.findElement(By.linkText("Login")).click();
	    //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("abc"+random);
	    //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9535565467"+random);
	    //driver.findElement(By.xpath("//input[@value='Login']")).click();
	    //driver.findElement(By.xpath("//a[.='Logout']")).click();	
				
		driver.get(url1);		
				
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
				
				
		driver.findElement(By.name("username")).sendKeys(username1);		
		driver.findElement(By.name("password")).sendKeys(password1);		
		driver.findElement(By.xpath("//input[@value='Login']")).click();		
				
		driver.findElement(By.xpath("//span[text()='Users']")).click();		
				
		String deleteusername = "abc"+random;		
		driver.findElement(By.xpath("//tbody//tr//td[.='" + deleteusername		
				+ "']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
	driver.findElement(By.xpath("//img[@class='profile-pic']")).click();			
	//driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
	driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	driver.quit();			
		//System.out.println(url);	
		//System.out.println(username);
		//System.out.println(password);
		//System.out.println(url1);
		//System.out.println(username1);
		//System.out.println(password1);
	}			
				
				

}
