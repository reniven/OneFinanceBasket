package obr;

public abstract class Assets {
	//private variables of class Assets
	private String code;
	private String type;
	private String label;
	
	//constructor
	Assets(String code, String type, String label) {
		this.code = code;
		this.type = type;
		this.label = label;
	}
	
	//method to return the code
	public String getCode() {
		return code;
	}	

	//method to return the type
	public String getType() {
		return type;
	}	

	//method to return the label
	public String getLabel() {
		return label;
	}
	
	//abstract method to calculate the risk measure
	public abstract double getRiskMeasure();
	
	//abstract method to calculate the annual return
	public abstract double getAnnualReturn();
	
	//abstract method to return the calculated value of an asset
	public abstract double getCalcValue();

	//abstract method to return the return rate of each asset
	public abstract double getReturnRate();
}
