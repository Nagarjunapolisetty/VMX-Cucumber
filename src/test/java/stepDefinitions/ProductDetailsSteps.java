package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;

import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

import pageObjects.ProductDetailsPage;

import testDataTypes.ProductData;

public class ProductDetailsSteps {

	WebDriver driver;
	ProductDetailsPage pdp;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;

	public ProductDetailsSteps(TestContext context) {
		this.testContext = context;
		pdp = testContext.getPageObjectManager().getPdpPage();
	}

	@And("^I add  \"([^\"]*)\" to cart$")
	public void i_add_to_cart(String productType) throws Throwable {
		ProductData product = FileReaderManager.getInstance().getJsonReader().getProductByType(productType);
		pdp.addProductToCart(product);
	}

}
