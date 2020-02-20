package genericKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GenericKeywords {
	static WebDriver driver;

	public GenericKeywords(WebDriver driver) {

		GenericKeywords.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendKeys(String selector, String text) {
		WebElement element = findElementBySelector(selector);
		sendKeys(element, text);
	}

	public void sleep(int mS) {
		try {
			Thread.sleep(mS);
		} catch (Exception e) {
			// log.error(e);
		}
	}

	public void sendKeys(WebElement element, String text) {
		if (text != null && text.length() > 0) {
			element.clear();
			sleep(30);

			for (int x = 0; x < text.length(); x++) {
				char ch = text.charAt(x);
				element.sendKeys(String.valueOf(ch));
				sleep(20);
			}
		}
	}

	protected static WebElement findElementBySelector(String selector) {
		try {
			return driver.findElement(By.cssSelector(selector));
		} catch (Exception e) {
			// Just capture the exception to add more verbosity to it
			String msg = "Couldn't find css selector [" + selector + "] on page: [" + driver.getCurrentUrl() + "]";
			throw new NoSuchElementException(msg);
		}
	}

	protected static boolean isElementPresent(String selector) {
		boolean status = false;
		try {
			if (findElementBySelector(selector).isDisplayed())
				status = true;
		} catch (Exception e) {
			// Just capture the exception to add more verbosity to it
			String msg = "Couldn't find css selector [" + selector + "] on page: [" + driver.getCurrentUrl() + "]";
			throw new NoSuchElementException(msg);
		}
		return status;
	}

	protected List<WebElement> findElementLengthBySelector(String selector) {
		try {
			System.out.println("elemnt/t:" + selector);
			List<WebElement> length = driver.findElements(By.cssSelector(selector));
			return length;
		} catch (Exception e) {
			// Just capture the exception to add more verbosity to it
			String msg = "Couldn't find css selector [" + selector + "] on page: [" + driver.getCurrentUrl() + "]";
			throw new NoSuchElementException(msg);
		}
	}

	public static void click(String selector) {
		findElementBySelector(selector).click();
	}

	public void selectDropdownByOptionValue(String selector, String value) {
		sleep(25);
		Select dropDown = new Select(findElementBySelector(selector));
		int i = 0;
		for (WebElement current : dropDown.getOptions()) {
			String currentOptionValue = current.getAttribute("value").trim();

			if (currentOptionValue.equalsIgnoreCase(value)) {
				dropDown.selectByIndex(i);
				break;
			}
			i++;
		}
	}

	public void selectDropdownByVisibleText(String selector, String text) {
		sleep(25);
		Select dropDown = new Select(findElementBySelector(selector));
		dropDown.selectByVisibleText(text);
	}

	public void javaScriptExecutorBySelector(String selector) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", findElementBySelector(selector));
	}

}