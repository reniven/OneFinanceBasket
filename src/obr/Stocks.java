package obr;

public class Stocks extends Assets{
	
	//create the private variables of class Stocks
	private double quartDiv;
	private double baseRateOfReturn;
	private double betaMeasure;
	private String stockSymbol;
	private double sharePrice;
	private double sharesOwned;

	//constructor
	public Stocks (String code, String type, String label, double quartDiv, double baseRateOfReturn, double betaMeasure, String stockSymbol
			, double sharePrice) {
		super(code,type, label);
		this.quartDiv=quartDiv;
		this.baseRateOfReturn=baseRateOfReturn;
		this.betaMeasure=betaMeasure;
		this.stockSymbol=stockSymbol;
		this.sharePrice=sharePrice;
		
	}
	
	//copy constructor
	public Stocks(Stocks aStock) {
		this(aStock.getCode(), aStock.getType(), aStock.getLabel(), aStock.getQuartDiv(), aStock.getBRR(), aStock.getRiskMeasure(), aStock.getStockSymbol(), aStock.getSharePrice());
	}

	//method to return quarterly dividend
	public double getQuartDiv() {
		  return quartDiv;
	}
	
	//method to return base rate of return
	public double getBRR() {
		  return baseRateOfReturn;
	}
	
	//method to return beta measure
	public double getRiskMeasure() {
		return betaMeasure;
	}

	//method to return stock symbol
	public String getStockSymbol() {
		return stockSymbol;
	}

	//method to return share price
	public double getSharePrice() {
		return sharePrice;
	}
	
	//method to set the shares owned variable
	public void setSharesOwned(double sharesOwned) {
		this.sharesOwned = sharesOwned;
	}
	
	//method to return shares owned
	public double getSharesOwned() {
		return sharesOwned;
	}
	
	//method to calculate the value 
	public double getCalcValue() {
		double totalValue = getSharePrice() * getSharesOwned();
		return totalValue;
	}
	
	//method to calculate the annual return 
	public double getAnnualReturn() {
		double value = 0.0;
		value = (getBRR() * getCalcValue()) + (4 * getQuartDiv() * getSharesOwned());
		return value;
	}
	
	//method to calculate the return rate
	public double getReturnRate(){
		double value = 0.0;
		value = (getAnnualReturn()/getCalcValue()) * 100;
		return value;
	}
}
