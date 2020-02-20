package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testDataTypes.Customer;

public class ShippingPage {

	WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#shipping_firstName")
	private WebElement textBoxFirstName;

	@FindBy(how = How.CSS, using = "#shipping_lastName")
	private WebElement textBoxLastName;

	@FindBy(how = How.CSS, using = "#shipping_address1")
	private WebElement textBoxAddressLine1;

	@FindBy(how = How.CSS, using = "#shipping_city")
	private WebElement textBoxCity;

	@FindBy(how = How.CSS, using = "#shipping_state")
	private WebElement dropDownState;

	@FindBy(how = How.CSS, using = "#shipping_postalCode")
	private WebElement textBoxPostalCode;

	@FindBy(how = How.CSS, using = "#shipping_phone_number")
	private WebElement textBoxPhoneNumber;

	@FindBy(how = How.CSS, using = "#shipping_email")
	private WebElement textBoxEmail;

	public void selectDropDownValueByVisibleText(String state) {
		Select select = new Select(dropDownState);
		select.selectByVisibleText(state);

	}

	public void fillShippingForm(Customer customer) {
		textBoxFirstName.sendKeys(customer.firstName);
		textBoxLastName.sendKeys(customer.lastName);
		textBoxAddressLine1.sendKeys(customer.address.line1);
		textBoxCity.sendKeys(customer.address.city);
		selectDropDownValueByVisibleText(customer.address.state);
		textBoxPostalCode.sendKeys(customer.address.postCode);
		textBoxPhoneNumber.sendKeys(customer.phoneNumber);
		textBoxEmail.sendKeys(customer.emailAddress);
	}
}
