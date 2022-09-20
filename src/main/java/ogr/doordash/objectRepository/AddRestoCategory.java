package ogr.doordash.objectRepository;

import org.doordash.genericUtility.WebDriverUtility;
import org.doordash.genericUtility.restoNames;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRestoCategory {
	public WebDriver driver;
	public  String dynamicXpath="//tbody//tr//td[text()='%s']//ancestor::tr//td//i[@class='fa fa-edit']";
	 @FindBy(xpath="//input[@placeholder='Category Name']") private WebElement categoryLink;
	 @FindBy(xpath="//input[@placeholder='Category Name']") private WebElement restocategoryLink;
	 @FindBy(xpath="//input[@name='submit']") private WebElement saveButton;
	 
	public AddRestoCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickRequiredrestoName(restoNames restoName,WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath,restoName.AMERICAN.getrestoName(),driver).click();	
}
	public void categoryAction() {
		categoryLink.clear();

	 }
	public void restocategoryAction() {
		restocategoryLink.sendKeys("American");

	 }
	public void saveAction() {
		saveButton.click();

	 }
}
