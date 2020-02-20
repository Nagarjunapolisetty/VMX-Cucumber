package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.SignInPage;

public class AccountManagementSteps {
	
	WebDriver driver;
	CartPage cart;
	SignInPage signInPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;
	

	public AccountManagementSteps(TestContext context) {
		this.testContext = context;
		signInPage = testContext.getPageObjectManager().getSignInPage();
	}
	
	@And("^I enter my 'Email' and 'Password' in the text fields$")
	public void i_enter_my_Email_and_Password_in_the_text_fields() throws Throwable {
	    signInPage.enterEmailAddress().enterPassword();;
	}
	
	@And("^I click the 'Login' button$")
	public void i_click_the_Login_button() throws Throwable {
	    signInPage.clickLoginButton();
	}

}
