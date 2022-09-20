package org.doordash.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	/**
	 * this method is used to launch the browser
	 * @param driver
	 */

   public WebDriver launchBrowser(String browser) {
	WebDriver driver = null;
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
}
 return driver;
   }
/**
 * this method is used to maximize the browser
 * @param driver
 */
public void maximizeBrowser(WebDriver driver) {
driver.manage().window().maximize();
}
/**
 * this method is used to open the application
 * @param driver
 * @param url
 */
public void navigateApplication(WebDriver driver,String url) {
driver.get(url);
}
/**
 * this method is to wait the controller implicitly Till load
 * @param driver
 * @param longTimeout
 */
public void waitTillPageLoad(WebDriver driver,Long longTimeout) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method is used to Launch browser,Maximize Browser,Wait page implicitly and navigate application
 * @param browser
 * @param longTimeout
 * @param url
 * @return
 */
public WebDriver openBrowserWithApplication(String browser,Long longTimeout,String url) {
WebDriver driver=launchBrowser(browser);
maximizeBrowser(driver);
waitTillPageLoad(driver, longTimeout);
navigateApplication(driver, url);
return driver;
}
/**
 * this method is used to do mouse hover action
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver, WebElement element ) {
	new Actions(driver).moveToElement(element).perform();
}

/**
 * this method is used to double click on Webelement
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver, WebElement element ) {
	new Actions(driver).doubleClick(element).perform();
}

/**
 * this method is used to close the Browser instance
 * @param driver
 */
public void quitBrowser(WebDriver driver) {
        driver.quit();
}
/**this method is used to handle alert popup
 * 
 * @param driver
 */
public void Alertpopup(WebDriver driver) {
	 Alert a1 = driver.switchTo().alert();
     a1.accept();
 }
   /**
    * this method is used to wait till the element visible
    * @param driver
    * @param timeouts
    * @param element
    */
 public void waitTillElementVisible(WebDriver driver,long timeouts, WebElement element) {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeouts));
	 wait.until(ExpectedConditions.visibilityOf(element));
 }
 /**
  * this method is used to switch the window based on partialtext of url
  * @param driver
  * @param partialText
  */
  public void switchToWindow(WebDriver driver,String partialText) {
Set<String> winIds = driver.getWindowHandles();
   for(String id:winIds)
   {
	   driver.switchTo().window(id);
	   if(driver.getCurrentUrl().contains(partialText)) {
		   break;
	   }}}
   JavascriptExecutor jsExecutor;
	   public void jsIntialization(WebDriver driver) {
		   jsExecutor=(JavascriptExecutor) driver;
	   }
	 public void openApplicationUsingJS(String url) {
		 jsExecutor.executeScript("window.location=arguments[0]",url);
	 }
	   public void sendKeysUsingJS(WebElement element,String data) {
		   jsExecutor.executeScript("arguments[0].value=arguments[1]",element);
		   
	   }
	   public void clickUsingJS(WebElement element) {
	   jsExecutor.executeScript("arguments[0].click()",element);
   }
   public void scrollTillElementUsingJS(WebElement element) {
	   jsExecutor.executeScript("arguments[0].scrollIntoView()",element);
   }

   
   public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath,String replaceData,WebDriver driver) {
	   String requiredXpath=String.format(dynamicXpath, replaceData);
	   WebElement element=driver.findElement(By.xpath(requiredXpath));
	   return element;
   }
   
   public void verifyWebPage(WebElement element,WebDriver driver,long longTimeOut,String expectedText) {
	   for(;;) {
	   try {
	   Assert.assertEquals(element.getText(),expectedText);
	   break;
	   }
	   catch(Exception e){
	   waitTillElementVisible(driver,longTimeOut, element);
   }
	   }}
   public String screenShot(WebDriver driver,JavaUtility javautility,String className)throws IOException {
	   String currentTime = javautility.currentTime();
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
	   FileUtils.copyFile(src,dst);
   
      return dst.getAbsolutePath();
}
   public String screenShot(WebDriver driver) {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   String tempPath = ts.getScreenshotAs(OutputType.BASE64);
	   return tempPath;
   }
}