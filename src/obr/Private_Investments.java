package obr;

public class Private_Investments extends Assets{
	
	//creates the private variables of class Private_Investments
	private double quartDiv;
	private double baseRateOfReturn;
	private double omegaBaseMeasure;
	private double totalValue;
	private double percentageStake;

	//constructor
	public Private_Investments(String code, String type, String label, double quartDiv, double BRR, double omegaBaseMeasure, double totalValue) {
		super(code, type, label); 
		this.omegaBaseMeasure = omegaBaseMeasure;
		this.baseRateOfReturn = BRR;
		this.totalValue = totalValue;
		this.quartDiv = quartDiv;
	}
	
	//copy constructor
	public Private_Investments(Private_Investments pi) {
		this(pi.getCode(), pi.getType(), pi.getLabel(), pi.getQuartDiv(), pi.getBRR(), pi.getRiskMeasure(), pi.getPVValue());
	}
	
	//method to return quarterly dividend
	public double getQuartDiv() {
		return quartDiv;
	}

	//method to return base rate of return
	public double getBRR() {
		return baseRateOfReturn;
	}

	//method to return the omega measure
	public double getRiskMeasure() {
		double omegaMeasure = 0.0;
		double offset = Math.pow(Math.E, (-100000/getCalcValue()));
		return omegaMeasure = offset + getOmegaMeasure();
	}
	
	public double getOmegaMeasure() {
		return omegaBaseMeasure;
	}
	//method to return value of the private investment
	public double getPVValue() {
		return totalValue;
	} 

	//method to set the stake percentage
	public void setPercentageStake(double percentageStake) {
		this.percentageStake = percentageStake;
	}
	
	//method to return the stake percentage
	public double getPercentageStake() {
		return percentageStake;
	}

	//method to calculate the total value
	public double getCalcValue() {
		double totalValue = 0;
		
		totalValue = getPVValue() * (getPercentageStake());
		return totalValue;
	}
	
	//method to calculate the annual return
	public double getAnnualReturn() {
		double value = 0.0;
		value = ((getBRR() * getPVValue()) + (4 * getQuartDiv()))  * (getPercentageStake());
		return value;
	}
	
	//method to calculate the return rate
	public double getReturnRate(){
		double value = (getAnnualReturn()/getCalcValue()) * 100;
		return value;
	}
}
