package ogr.doordash.objectRepository;

import org.doordash.genericUtility.TabNames;
import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	//private WebDriver driver;
	private String dynamicXpath="//a[text()='%s']";
	@FindBy(xpath="//a[text()='Register']") private WebElement registerLink;
	@FindBy(linkText="Restaurants")private WebElement restaurantLink;
	
	//@FindBy(xpath="//a[text()='']")
	@FindBy(xpath="//a[.='Logout']") private WebElement logoutLink;
	
	public CommonPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickRequiredTab(WebDriver driver,TabNames TabName,WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath,TabName.getTabName(),driver).click();
		
	}
	
	public void clickRegister() {
		registerLink.click();
		
	
	}
	public void clickRestaurant() {
		restaurantLink.click();
	}
	
	 public void logoutAction() {
		 logoutLink.click();
	
	 }
}
	 
	
	
	
//@FindBy(linkText = "Login") private WebElement loginLink;
//@FindBy(xpath="//a[.='Logout']") private WebElement logoutLink;


//public CommonPage(WebDriver driver) {
	//PageFactory.initElements(driver,this);


 //public void clickAction() {
	 //loginLink.click(); 
 
 
 

