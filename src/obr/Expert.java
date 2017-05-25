package obr;

import java.util.List;

public class Expert extends Persons {
	
	//creates private variables of class Expert
	private String secID;
	private String type;
	
	//constructor
	public Expert(String personCode, String broker_position, String secID, String firstName, String lastName, Address address,List<String> email) {
		super( personCode,firstName, lastName,address, email);
		this.type=broker_position;
		this.secID=secID;
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
		double commission = totalReturnValue * .05;
		return commission;
	}
	
	//method to calculate the fee
	public double getFees(List<Assets> arrayList) {
		double fee = 0.0;
		int counter = 1;
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) == null) {
				fee = 0.0;
				break;
			}
			else {
				fee = counter * 10;
			}
			counter++;
		}

		return fee;
	}

}
