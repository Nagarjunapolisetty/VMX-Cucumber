package testDataTypes;

public class Customer {
	public String firstName;
	public String lastName;
	
	public Address address;

	public class Address {
		public String line1;
		public String city;
		public String postCode;
		public String state;
	}
	
	public String emailAddress;
	public String phoneNumber;

}