package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CredentialsReader {

	private Properties properties;
	private final String credentialsFilePath = "configs//testData.properties";

	public CredentialsReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(credentialsFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Credentials file not found at path : " + credentialsFilePath);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public String getLoginEmail() {
		String login_email = new String("");
		login_email = properties.getProperty("login_email");
		return login_email;
	}

	public String getLoginPassword() {
		String login_password = new String("");
		login_password = properties.getProperty("login_password");
		return login_password;
	}

	public String getGiftCardNumber() {
		String giftcard_number = properties.getProperty("gift_card_number");

		if (giftcard_number != null)
			return giftcard_number;
		else
			throw new RuntimeException("Gift Card Number not specified in the loginCredentials.properties file");
	}

	public String getGiftCardPin() {
		String giftcard_pin = properties.getProperty("gift_card_pin");

		if (giftcard_pin != null)
			return giftcard_pin;
		else
			throw new RuntimeException("Gift Card Pin not specified in the loginCredentials.properties file");
	}

	public String getPaypalUserName() {
		String paypal_username = properties.getProperty("paypal_user");

		if (paypal_username != null)
			return paypal_username;
		else
			throw new RuntimeException("PayPal username not specified in the loginCredentials.properties file");
	}

	public String getPaypalPassword() {
		String paypal_password = properties.getProperty("paypal_password");

		if (paypal_password != null)
			return paypal_password;
		else
			throw new RuntimeException("PayPal password not specified in the loginCredentials.properties file");
	}

}
