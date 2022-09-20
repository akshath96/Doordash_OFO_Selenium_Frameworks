package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllusersPage {
	String random;
	String deleteusername ="abc"+random;
@FindBy(xpath="//tbody//tr//td[.='+deleteusername+']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']") private WebElement userIcon;
  @FindBy(xpath="//img[@class='profile-pic']") private WebElement deleteIcon;
  @FindBy(name="status") private WebElement statusIcon;
  @FindBy(xpath="//textarea[@name='remark']") private WebElement textAction;
  @FindBy(xpath="//input[@class='btn btn-primary']") private WebElement clickAction;
  @FindBy(xpath="//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']") private WebElement clicksetAction;
  
  
public  AllusersPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void userAction() {
	userIcon.click();
}
public void deleteAction() {
	deleteIcon.click();
	
}
public void statusAction() {
	statusIcon.click();
}
public void textwriteAction() {
	textAction.sendKeys("Order is On the way");
}
public void testAction() {
	clickAction.click();
}
public void allAction() {
	clicksetAction.click();
}
}