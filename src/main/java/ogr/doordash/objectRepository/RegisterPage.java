package ogr.doordash.objectRepository;

import java.util.Map;
import java.util.Random;

import org.doordash.genericUtility.ExcelUtility;
import org.doordash.genericUtility.JavaUtility;
import org.doordash.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
  @FindBy(xpath="//input[@name='username']") private WebElement usernameTextfield;
  @FindBy(xpath="//input[@name='firstname']") private WebElement firstTextfield;
  @FindBy(xpath="//input[@name='lastname']") private WebElement lastTextfield;
  @FindBy(xpath="//input[@name='email']") private WebElement emailTextfield;
  @FindBy(xpath="//input[@name='phone']") private WebElement phoneTextfield;
  @FindBy(xpath="//input[@name='password']") private WebElement passwordTextfield;
  @FindBy(xpath="//input[@name='cpassword']") private WebElement cpasswordTextfield;
  @FindBy(xpath="//textarea[@name='address']") private WebElement addressTextareafield;
  @FindBy(xpath="//input[@value='Register']") private WebElement registerButton;

public RegisterPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
  // public void registerAction(String Username,String Firstname,String Lastname,String Email,String Phone,String Password,String Cpassword,String Adress) {
	   public String registerAction(JavaUtility javautility,ExcelUtility excelutility,WebDriver driver){
	   Map<String,String> map=excelutility.getDataExcelInMap("Register form");
	   int rand = javautility.getRandomNumber(10000);
	   String username2 = map.get("Username")+""+rand;
	   String password2 = map.get("Password");
	usernameTextfield.sendKeys(username2);
	firstTextfield.sendKeys(map.get("Firstname"));
	lastTextfield.sendKeys(map.get("Lastname"));
	emailTextfield.sendKeys(map.get("Email"));	
	phoneTextfield.sendKeys(map.get("Phone"));
	passwordTextfield.sendKeys(password2);
	cpasswordTextfield.sendKeys(map.get("Cpassword"));
	addressTextareafield.sendKeys(map.get("Address"));
	registerButton.click();
	return username2;
   }
   }