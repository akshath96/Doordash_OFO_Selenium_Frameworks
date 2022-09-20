package ogr.doordash.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminallOrdersPage {
	@FindBy(xpath="//tbody//tr[last()]//td//i[@class='fa fa-edit']") private WebElement editIcon;
	
	
	public  AdminallOrdersPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
}
	public void editorderAction() {
		editIcon.click();
	 }
}