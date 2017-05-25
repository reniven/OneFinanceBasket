package obr;
import java.util.List;

public abstract class Persons {
	
	//create private variables of class Persons
	private String personCode;
	private String firstName;
	private String lastName;
	private Address address;
	private List<String> email;
	
	//constructor
	public Persons(String personCode, String firstName, String lastName, Address address,List<String> email) {
		this.personCode = personCode;
		this.firstName = firstName;
		this.lastName=lastName;
		this.email = email;
		this.address = address;
	}

	//method to return person code
	public String getPersonCode() {
		return personCode;
	}

	//method to return first name
	public String getFirstName() {
		return firstName;
	}

	//method to return last name
	public String getLastName() {
		return lastName;
	}
	
	//method to return an array of emails
	public List<String> getEmail() {
		return email;
	}
	
	public Address getAddress() {
		return address;
	}
	//
	public abstract String getSecID();
	
	public abstract String getType();

	//abstract method to calculate the commissions
	public abstract double getCommissions(double totalReturnValue);
	
	//abstract method to calculate the fees
	public abstract double getFees(List<Assets> assetList);
	
}
