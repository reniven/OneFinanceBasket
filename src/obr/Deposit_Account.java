package obr;

public class Deposit_Account extends Assets{
	
	//creates private variables of class Deposit_Account
	private double apr;	
	private double balance;
	
	//constructor
	public Deposit_Account(String code, String type, String label,double apr) {
		super(code,type,label);
		this.apr = apr;
	}
	
	//copy constructor
	public Deposit_Account(Deposit_Account depositAccount) {
		this(depositAccount.getCode(), depositAccount.getType(), depositAccount.getLabel(), depositAccount.getAPR());
	}
	
	//method to return APR
	public double getAPR() {
		return apr;
	}	

	//method to return risk measure
	public double getRiskMeasure() {
		return 0;
	}
	

	//method to set the balance, used to set portfolio.dat value of deposits
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//method to return the balance
	public double getBalance() {
		return balance;
	}
	
	//method to calculate the value
	public double getCalcValue() {
		return getBalance();
	}
	
	//method to calculate the annual return
	public double getAnnualReturn() {
		double apy = 0.0;
		apy = Math.pow(Math.E, getAPR()) - 1;
		return (apy * getBalance());
	}
	
	//method to calculate the return rate
	public double getReturnRate(){
		double value = 0.0;
		value = getAnnualReturn()/getCalcValue() * 100;
		return value;
	}
}
