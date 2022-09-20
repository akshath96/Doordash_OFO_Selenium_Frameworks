package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestuarantPage {
@FindBy(linkText="View Menu") private WebElement viewmenuButton;


public RestuarantPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickViewmenu() {
	viewmenuButton.click();
}
}
