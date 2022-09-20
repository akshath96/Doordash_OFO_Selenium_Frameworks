package org.doorDash.home;

import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MavenPracticeTest {
@Test
 
public void step1Test() {
	String browser=System.getProperty("b");
	String url=System.getProperty("u");
	
	System.out.println("browser name is   "+browser);
	System.out.println("url name is    "+url);
	WebDriverUtility webdriverutility=new WebDriverUtility();
	WebDriver driver = webdriverutility.openBrowserWithApplication(browser, 10l, url);
	driver.close();
}

}
