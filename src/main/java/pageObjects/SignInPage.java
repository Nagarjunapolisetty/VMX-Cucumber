package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import genericKeywords.GenericKeywords;
import managers.FileReaderManager;

public class SignInPage extends GenericKeywords {
	
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private String email = FileReaderManager.getCredentialsReader().getLoginEmail();
	private String password = FileReaderManager.getCredentialsReader().getLoginPassword();
	
	public SignInPage enterEmailAddress(){
		sendKeys("#email", email);
		return this;
		
	}
	
	public void enterPassword(){
		sendKeys("#password", password);
	}
	
	public void clickLoginButton(){
		sleep(10);
		click("#loginBtn");
	}

}
