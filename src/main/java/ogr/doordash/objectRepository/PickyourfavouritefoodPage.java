package ogr.doordash.objectRepository;

import org.doordash.genericUtility.WebDriverUtility;
import org.doordash.genericUtility.productNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickyourfavouritefoodPage {
	public WebDriver driver;
	public String dynamicXpath="//a[.='%s']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']";
	
 //@FindBy(xpath="//a[.='\"+productname+\"']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']") private WebElement addtoCartButton;
 @FindBy(xpath="//a[text()='Checkout']") private WebElement checkoutButton;
 
 public PickyourfavouritefoodPage(WebDriver driver) {
	 this.driver=driver;
		PageFactory.initElements(driver,this);
	
 }
 
 
 public void addtocartAction(productNames productName,WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath,productName.YORKSHIRELAMBPATTIES.getproductName(),driver).click();
 //public void addtocartAction() {
	// addtoCartButton.click();
 }
		public void checkoutAction() {	
	     checkoutButton.click();
 }
}
