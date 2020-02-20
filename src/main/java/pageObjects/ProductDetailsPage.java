package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import genericKeywords.GenericKeywords;
import testDataTypes.ProductData;

public class ProductDetailsPage extends GenericKeywords {
	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addProductToCart(ProductData data) {
		String colorSelector ="#swatch_container_"+data.color;
		javaScriptExecutorBySelector(colorSelector);		
		if (data.warranty != null && data.warranty.length() > 0 && !data.skipWarranty)
			selectDropdownByVisibleText("#pdp-warranty-select", data.warranty);
		selectDropdownByVisibleText("#pdp-quantity-select", data.quantity);
		click("button[type=submit]");
	}

}
