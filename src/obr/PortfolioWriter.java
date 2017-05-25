package obr;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PortfolioWriter {

	public static void PortfolioWrite(LinkedList<Portfolios>portInfo) {
		double totalFees = 0.0;
		double totalCommissions = 0.0;
		double totalReturnValue = 0.0;
		double totalValue = 0.0;
		double localTotalValue=0.0;
		double localReturnValue=0.0;
		//formats decimals
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat dflong = new DecimalFormat("0.0000");
		
		//prints summary of portfolios
		System.out.println("Porfolio Summary Report");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", "Portfolio", "Owner", "Manager", "Fees", "Comissions", "Weighted Risk", "Return", "Total"));
		for(int i = 0; i < portInfo.getSize(); i++) {
			localTotalValue = portInfo.getElement(i).getTotalValue(portInfo.getElement(i).getAssetList());
			totalValue = totalValue + localTotalValue;

			localReturnValue = portInfo.getElement(i).getTotalReturnValue(portInfo.getElement(i).getAssetList());
			totalReturnValue = totalReturnValue + localReturnValue;
			
			double localFees = 0.0;
			double localCommissions = 0.0;
			
			for(int k = 0; k < portInfo.getSize(); k++) {
				
				localFees = portInfo.getElement(k).getManager().getFees(portInfo.getElement(i).getAssetList());
				totalFees = totalFees + localFees;
				
				localCommissions = portInfo.getElement(k).getManager().getCommissions(portInfo.getElement(i).getTotalReturnValue(portInfo.getElement(i).getAssetList()));
				totalCommissions = totalCommissions + localCommissions;
			}
				
//			//calculates total commissions and fees
//			for(int k = 0; k < perInfo.size(); k++	) {
//				 if(portInfo.get(i).getManagerCode().equals(perInfo.get(k).getPersonCode())) {
//					 
//				localFees = perInfo.get(k).getFees(portInfo.get(i).getAssetList());
//				totalFees = totalFees + localFees;
//				
//				localCommissions = perInfo.get(k).getCommissions(portInfo.get(i).getTotalReturnValue(portInfo.get(i).getAssetList()));
//				totalCommissions = totalCommissions + localCommissions;
//				}
//			}
			
			//prints each portfolio's calculations and persons involved
			System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", portInfo.getElement(i).getPortfolioCode(), portInfo.getElement(i).getOwner().getLastName() + " " + portInfo.getElement(i).getOwner().getFirstName(), portInfo.getElement(i).getManager().getLastName() + " " + portInfo.getElement(i).getManager().getFirstName(), "$" +df.format(localFees), 
					"$" + df.format(localCommissions), dflong.format(portInfo.getElement(i).getRisk(portInfo.getElement(i).getAssetList())), "$" + df.format(localReturnValue), "$" + df.format(localTotalValue))); 
		}
		
		//prints total fees, commissions, return, and value of all portfolios
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-12s %25s %24s %15s %15s %16s %15s %15s", "", "", "Totals", "$" + df.format(totalFees), "$" + df.format(totalCommissions), "", "$" + df.format(totalReturnValue), df.format(totalValue)));
		
		((LinkedList<Portfolios>) portInfo).removeHead();
		
//		//System.outs the individual details of each portfolio
//		System.out.println();
//		System.out.println("Portfolio Details");
//		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
//		//outputs portfolio code, manger, owner, and beneficiary's name
//		for (int z = 0; z < portInfo.size(); z++) {
//			System.out.println("Portfolio: " + portInfo.get(z).getPortfolioCode());
//			
//			System.out.println("Owner: " + portInfo.get(z).getOwner().getPersonCode());
//			System.out.println("Manager: " + portInfo.get(z).getManager().getPersonCode());
//	
//			for(int j = 0; j < perInfo.size(); j++) {
//				if(portInfo.get(z).getBeneficiary().getPersonCode().equals(perInfo.get(j).getPersonCode()))  {
//					System.out.println("Beneficiary: " + perInfo.get(j).getLastName() + ", " + perInfo.get(j).getFirstName());
//					break;
//				}
//				else if(portInfo.get(z).getBeneficiary().getPersonCode().equals("")) {
//					System.out.println("Beneficiary: " + "none");
//					break;
//				}
//			}
//			//prints calculations for each asset in each portfolio
//			System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Value"));
//			try {
//				for(int t = 0; t < portInfo.get(z).getAssetList().size(); t++) {
//					System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", portInfo.get(z).getAssetList().get(t).getCode(),
//							portInfo.get(z).getAssetList().get(t).getLabel(), df.format(portInfo.get(z).getAssetList().get(t).getReturnRate()) + "%", df.format(portInfo.get(z).getAssetList().get(t).getRiskMeasure()),
//							"$" + df.format(portInfo.get(z).getAssetList().get(t).getAnnualReturn()), "$" + df.format(portInfo.get(z).getAssetList().get(t).getCalcValue())));
//				}
//			}
//			catch (NullPointerException e) {
//				System.out.print("");
//			}
//			//prints the totals of a particular portfolio
//			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
//			System.out.println(String.format("%-15s %-24s %-15s %-15s %-15s %-15s", "","","Totals", dflong.format(portInfo.get(z).getRisk(portInfo.get(z).getAssetList())), "$" + df.format(portInfo.get(z).getTotalReturnValue(portInfo.get(z).getAssetList())), "$" + df.format(portInfo.get(z).getTotalValue(portInfo.get(z).getAssetList()))));
		}
	
	
	public static void main(String args[]){	
		//retrieves data information through DataReceiver class
		DataReceiver dr = new DataReceiver();
		LastNameOrder LNO = new LastNameOrder();
		TypeOrder TO = new TypeOrder();
		ValueOrder VO = new ValueOrder();
		//writes the portfolio summary 
		
		PortfolioWrite(dr.getPortfolio(LNO));
		PortfolioWrite(dr.getPortfolio(VO));
		PortfolioWrite(dr.getPortfolio(TO));
		
		

	}
}
