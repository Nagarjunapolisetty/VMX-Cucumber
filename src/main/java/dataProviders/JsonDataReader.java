package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Customer;
import testDataTypes.ProductData;

public class JsonDataReader {

	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ "Customer.json";
	private final String productDataFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ "ProductData.json";
	private List<Customer> customerList;
	private List<ProductData> productData;

	public JsonDataReader() {
		customerList = getCustomerData();
		productData = getProductData();
	}

	private List<Customer> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<ProductData> getProductData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(productDataFilePath));
			ProductData[] products = gson.fromJson(bufferReader, ProductData[].class);
			return Arrays.asList(products);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + productDataFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Customer getCustomerByName(String customerName) {
		return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
	
	public final ProductData getProductByType(String productType) {
		return productData.stream().filter(x -> x.productType.equalsIgnoreCase(productType)).findAny().get();
	}

}
