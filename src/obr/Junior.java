package obr;

import java.util.List;

public class Junior extends Persons {

	//creates private variables of class Junior
	private String type;
	private String secID;

	//constructor
	public Junior(String personCode, String broker_position, String secID, String firstName, String lastName,Address address,List<String>email) {
		super(personCode, firstName, lastName, address,email);
		this.secID=secID;
		this.type=broker_position;
	}

	//method to return SEC ID
	public String getSecID(){
		return this.secID;
	}

	//method to return type
	public String getType(){
		return this.type;
	}

	//method to calculate commissions
	public double getCommissions(double totalReturnValue) {
		double commission = totalReturnValue * .02;
		return commission;
	}

	//method to calculate fees
	public double getFees(List<Assets> arrayList) {
		double fee = 0.0;
		int counter = 1;
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) == null) {
				fee = 0.0;
				break;
			}
			else {
				fee = counter * 50;
			}
			counter++;
		}
		counter = 0;
		return fee;
	}
}
