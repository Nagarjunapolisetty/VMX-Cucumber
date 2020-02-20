package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.CartPage;

public class CartSteps {
	
	WebDriver driver;
	CartPage cart;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;
	

	public CartSteps(TestContext context) {
		this.testContext = context;
		cart = testContext.getPageObjectManager().getCartPage();
	}

	@And("^I click the 'checkout' button$")
	public void i_click_the_checkout_button() throws Throwable {
		cart.clickOnCheckout();
	}

}
