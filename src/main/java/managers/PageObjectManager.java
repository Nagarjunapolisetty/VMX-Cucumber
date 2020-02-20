package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListingPage;
import pageObjects.ShippingPage;
import pageObjects.SignInPage;

public class PageObjectManager {
	WebDriver driver;
	private HomePage homePage;
	private ProductDetailsPage pdp;
	private ProductListingPage plp;
	private CartPage cart;
	private ShippingPage shipping;
	private SignInPage signIn;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public SignInPage getSignInPage() {
		return (signIn == null) ? signIn = new SignInPage(driver) : signIn;
	}
	
	public ProductDetailsPage getPdpPage() {
		return (pdp == null) ? pdp = new ProductDetailsPage(driver) : pdp;
	}
	
	public ProductListingPage getPlpPage() {
		return (plp == null) ? plp = new ProductListingPage(driver) : plp;
	}
	
	public CartPage getCartPage() {
		return (cart == null) ? cart = new CartPage(driver) : cart;
	}
	
	public ShippingPage getShippingPage() {
		return (shipping == null) ? shipping = new ShippingPage(driver) : shipping;
	}

}
