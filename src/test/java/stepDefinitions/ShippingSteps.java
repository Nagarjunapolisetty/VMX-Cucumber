package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.ShippingPage;
import testDataTypes.Customer;

public class ShippingSteps {
	
	WebDriver driver;
	ShippingPage shipping;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;
	
	Customer customer;
	public ShippingSteps(TestContext context) {
		this.testContext = context;
		shipping = testContext.getPageObjectManager().getShippingPage();
	}

	
	@And("^I fill my shipping \"([^\"]*)\"  form$")
	public void i_fill_my_shipping_form(String customerName) throws Throwable {
		customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		shipping.fillShippingForm(customer);
	}





}
