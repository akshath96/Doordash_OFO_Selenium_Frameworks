package ogr.doordash.objectRepository;

import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdmincommonPage {
	
 @FindBy(xpath="//span[text()='Users']") private WebElement userButton;
 @FindBy(xpath="//img[@class='profile-pic']")  private WebElement signoutImage;
  @FindBy(xpath="//a[@href='logout.php']")  private WebElement signoutIcon;
 @FindBy(linkText="Orders") private WebElement OrderIcon;
 @FindBy(xpath="//a[@class='has-arrow  ']//span[text()='Restaurant']") private WebElement restuarantIcon;
 @FindBy(xpath="//a[text()='Add Category']") private WebElement addresturantIcon;
 
 
 public  AdmincommonPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
 public void userclickAction() {
	 userButton.click();
 }
 public void signoutAction() {
	 signoutIcon.click();
 }
 public void signoutImageAction() {
	 signoutImage.click();
 }
 public void orderAction() {
	 OrderIcon.click();
 }
 public void addrestuarantAction() {
	 addresturantIcon.click();
}
 public void RestuarantAction() {
	 restuarantIcon.click();
}
}