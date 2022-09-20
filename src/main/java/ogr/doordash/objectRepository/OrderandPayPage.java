package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderandPayPage {
@FindBy(xpath="//input[@name='submit']") private WebElement ordernowButton;

public OrderandPayPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void orderNowAction() {
	ordernowButton.click();
}
}
