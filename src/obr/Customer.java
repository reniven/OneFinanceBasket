package obr;

import java.util.List;

public class Customer extends Persons{

	//constructor
	public Customer(String personCode, String firstName, String lastName, Address address,List<String> email) {
		super( personCode, firstName, lastName, address, email);
	}

	//method to return the SEC ID
	public String getSecID(){
		return null;
	}
	
	//method to return the type
	public String getType(){
		return null;
	}
	
	//method to return the commissions
	public double getCommissions(double totalReturnValue) {
		return 0;
	}
	
	//method to return the fees
	public double getFees(List<Assets> arrayList) {
		return 0;
	}
}
