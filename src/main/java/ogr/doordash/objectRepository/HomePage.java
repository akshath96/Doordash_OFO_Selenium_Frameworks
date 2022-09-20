package ogr.doordash.objectRepository;

import org.doordash.genericUtility.WebDriverUtility;

import org.doordash.genericUtility.productNames;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//String productname="YorkshireLambPatties";
  /*@FindBy(xpath="//a[text()='"+productname+"']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']") private WebElement orderNowButton;
 
 public HomePage(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
  public void ordernowAction() {
	  orderNowButton.click();*/
	
	public WebDriver driver;
	//String productname="YorkshireLambPatties";
	public String dynamicXpath="//a[.='%s']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']";
	//@FindBy(xpath="//a[text()='\"+productname+\"']/ancestor::div[@class='content']//div/following-sibling::div/a[@class='btn theme-btn-dash pull-right']") private WebElement orderNowButton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		public void clickRequiredName(productNames productName,WebDriverUtility webDriverUtility) {
			webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath,productName.YORKSHIRELAMBPATTIES.getproductName(),driver).click();	
  }
}
