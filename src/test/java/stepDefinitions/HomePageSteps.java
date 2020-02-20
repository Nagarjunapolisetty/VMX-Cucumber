package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.ConfigFileReader;
import junit.framework.Assert;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.SignInPage;

public class HomePageSteps {
	WebDriver driver;
	HomePage homePage;
	ProductDetailsPage pdp;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	TestContext testContext;
	SignInPage signInPage;
	
	

	public HomePageSteps(TestContext context) {
		this.testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signInPage = testContext.getPageObjectManager().getSignInPage();
	}


	@And("^I navigate to the Home Page$")
	public void i_navigate_to_the_Home_Page() throws Throwable {
		homePage.navigateToHomePage();
	}
	
	@And("^I click on 'My Account' link in the header$")
	public void i_click_on_My_Account_link_in_the_header() throws Throwable {
	    homePage.clickOnMyAccount();
	}

	@And("^I navigate to pdp of \"([^\"]*)\"$")
	public void i_navigate_to_pdp_of(String path) throws Throwable {
		homePage.navigateToPage(path);
	}
	
	@Then("^I verify logged-in user state$")
	public void i_verify_logged_in_user_state() throws Throwable {
		System.out.println("in -------------------------");
		Assert.assertEquals(homePage.verifyLoggedInState(), true);
	}
	


}
