package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOrderPage {
@FindBy(linkText="Update Order Status") private WebElement updateorderButton;
private WebDriver driver;
	
	
	public  ViewOrderPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
}
	public void updateorderAction() {
		updateorderButton.click();
	 }
}

