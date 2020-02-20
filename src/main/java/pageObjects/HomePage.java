package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import genericKeywords.GenericKeywords;
import managers.FileReaderManager;

public class HomePage extends GenericKeywords {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToPage(String path) {
		driver.navigate().to("https://www.vitamix.com/us/en_us/" + path);
	}

	public void navigateToHomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void clickOnMyAccount(){
		click("#headerMyAccountLink");
	}
	
	public boolean verifyLoggedInState(){
		return isElementPresent("a#header-signout");
		
	}
	
}
