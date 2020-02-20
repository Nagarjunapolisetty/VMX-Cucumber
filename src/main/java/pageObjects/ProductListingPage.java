package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindAll(@FindBy(how = How.CSS, using = ".product__image"))
	 private List<WebElement> products_List;

}
