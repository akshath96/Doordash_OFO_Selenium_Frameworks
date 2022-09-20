package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminloginPage {
   @FindBy(name="username") private WebElement usenameTextfield;
   @FindBy(name="password") private WebElement passwordTextfield;
   @FindBy(xpath="//input[@value='Login']") private WebElement loginButton;
   
   
   public  AdminloginPage(WebDriver driver1) {
	   PageFactory.initElements(driver1, this);
   }
   public void AdminloginAction(String username1,String password1) {
		  usenameTextfield.sendKeys(username1);
		  passwordTextfield.sendKeys(password1);
		  loginButton.click();
}
   
}