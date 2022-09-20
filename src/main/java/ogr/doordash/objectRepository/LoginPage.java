package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	
  @FindBy(xpath="//input[@name='username']") private WebElement userNameTextField;
  @FindBy(xpath="//input[@name='password']") private WebElement passwordTextField;
  @FindBy(xpath="//input[@name='submit']") private WebElement LoginButton;
  
  
  //initialization all element variable
  public LoginPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  
   //business library
  public void loginAction(String username,String password) {
	  userNameTextField.sendKeys(username);
	  passwordTextField.sendKeys(password);
	 LoginButton.click();
  /*}
  public void loginaction(String Username,String Password) {
	  userNameTextField.sendKeys(Username);
	  passwordTextField.sendKeys(Password);
	  LoginButton.click();*/
  }
}
