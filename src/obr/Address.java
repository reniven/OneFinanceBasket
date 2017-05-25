package obr;

public class Address {
	
	//private varibles of class Address
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;

	//constructor
	public Address(String street, String city, String state, String country, String zipCode){
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	//method to return the street
	public String getStreet() {
		return street;
	}

	//method to return the city
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	//method to return the country
	public String getCountry() {
		return country;
	}

	//method to return the zip code
	public String getZipCode() {
		return zipCode;
	}

}
