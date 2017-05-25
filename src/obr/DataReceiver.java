package obr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataReceiver {
	static Connection conn=null;
	private static List<Assets> asset= new ArrayList<Assets>();


	//used by getPortfolio to retrieve asset data and create asset objects
	public static void getAsset(){
		String assetCode;
		String label;
		double apr;
		double quartDiv;
		double bRR;
		double beta;
		String stockSymbol;
		double sharePrice;
		double omega;
		double totalValue;
		Connection conn = ConnectionInfo.connection();
		//retrieves deposit assets
		String queryD = "SELECT assetCode, assetName, apr FROM Asset WHERE assetType = 'D'";
		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			ps = conn.prepareStatement(queryD);
			rs = ps.executeQuery();

			while(rs.next()) {
				assetCode = rs.getString("assetCode");
				label = rs.getString("assetName");
				apr = rs.getDouble("apr");
				Deposit_Account d = new Deposit_Account (assetCode, "D", label,apr);
				asset.add(d);
			}

		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//retrieves stock assets
		String queryS = "SELECT assetCode, assetName, quarterlyDividend, baseRateReturn,beta,stockSymbol,sharePrice FROM Asset WHERE assetType = 'S'";
		try{
			ps = conn.prepareStatement(queryS);
			rs = ps.executeQuery();

			while(rs.next()) {
				assetCode = rs.getString("assetCode");
				label = rs.getString("assetName");
				quartDiv = rs.getDouble("quarterlyDividend");
				bRR = rs.getDouble("baseRateReturn");
				beta = rs.getDouble("beta");
				stockSymbol = rs.getString("stockSymbol");
				sharePrice = rs.getDouble("sharePrice");
				Stocks st = new Stocks (assetCode, "S", label,quartDiv,bRR,beta,stockSymbol,sharePrice);
				asset.add(st);
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//retrieves private investment asset
		String queryP = "SELECT assetCode, assetName, quarterlyDividend, baseRateReturn,omega,totalValue FROM Asset WHERE assetType = 'P'";
		try{
			ps = conn.prepareStatement(queryP);
			rs = ps.executeQuery();

			while(rs.next()) {
				assetCode = rs.getString("assetCode");
				label = rs.getString("assetName");
				quartDiv = rs.getDouble("quarterlyDividend");
				bRR = rs.getDouble("baseRateReturn");
				omega = rs.getDouble("omega");
				totalValue = rs.getDouble("totalValue");
				Private_Investments pi = new Private_Investments (assetCode, "P", label,quartDiv,bRR,omega,totalValue);
				asset.add(pi);
			}
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//retrieves Person and makes person objects
	public Persons getPerson(String pCode) {

		String personCode = pCode;
		int personID = 0;
		String firstName = null;
		String lastName = null;
		String secID = null;
		String personType = null;
		List<String> Email = new ArrayList<String>();

		Connection conn = ConnectionInfo.connection();
		String query = "SELECT personID FROM Person WHERE personCode = ?";
		PreparedStatement ps = null;
		ResultSet rs=null;

		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, personCode);
			rs = ps.executeQuery();

			while(rs.next()) {
				personID = rs.getInt("personID");
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}


		String query1 = "SELECT lastName, firstName, secID, personType FROM Person p WHERE p.personID = ?";
		String query2 = "SELECT addressID FROM Address a WHERE a.personID = ?";

		String query3 = "SELECT stateID, countryID, street, city, zipcode FROM Address WHERE addressID = ?";
		int addressID=0;
		int stateID=0;
		int countryID=0;
		String street = null;
		String city = null;
		String zipcode=null;
		String country=null;
		String state = null;
		Address a = null;


		try{
			ps = conn.prepareStatement(query1);
			ps.setInt(1, personID);
			rs = ps.executeQuery();
			while(rs.next()) {
				lastName = rs.getString("lastName");
				firstName = rs.getString("firstName");
				secID = rs.getString("secID");
				personType = rs.getString("personType");
				if (personType == null){
					personType="";
				}
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try{
			ps = conn.prepareStatement(query2);
			ps.setInt(1, personID);
			rs = ps.executeQuery();
			while(rs.next()){
				addressID = rs.getInt("addressID");
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try{
			ps = conn.prepareStatement(query3);
			ps.setInt(1, addressID);
			rs = ps.executeQuery();
			while(rs.next()) {
				stateID = rs.getInt("stateID");
				countryID = rs.getInt("countryID");
				street = rs.getString("street");
				city = rs.getString("city");
				zipcode = rs.getString("zipcode");
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//retrieves state corresponding to a person's address
		String query4 = "SELECT stateAbbreviation FROM States WHERE stateID = ?";
		try{
			ps= conn.prepareStatement(query4);
			ps.setInt(1, stateID);
			rs = ps.executeQuery();

			while(rs.next()) {
				state = rs.getString("stateAbbreviation");
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//retrieves country corresponding to a person's address
		String query5= "SELECT countryName FROM Country WHERE countryID=?";
		try{
			ps=conn.prepareStatement(query5);
			if (countryID==0){
				country="";
			}
			else{
				ps.setInt(1, countryID);
				rs=ps.executeQuery();
				while(rs.next()){
					country=rs.getString("countryName");
				}
			}

		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);

		}
		//creates address object from retrieved data
		a= new Address(street, city, state, country, zipcode);

		//retrieves email address
		String query6= "SELECT emailAddress FROM EmailAddress WHERE personID=?";
		try{
			ps=conn.prepareStatement(query6);
			ps.setInt(1, personID);
			rs=ps.executeQuery();
			while(rs.next()){
				Email.add(rs.getString("emailAddress"));
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		try {
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//creates person object
		if(personType.equals("J")) {
			Junior j = new Junior(personCode, personType, secID, firstName, lastName, a, Email);
			return j;

		}
		else if(personType.equals("E")) {
			Expert e = new Expert(personCode, personType, secID, firstName, lastName, a, Email);
			return e;
		}
		else{
			Customer c = new Customer(personCode, firstName, lastName, a, Email );
			return c;
		}
	}

	public LinkedList<Portfolios> getPortfolio(Comparator<Portfolios> c) {
		//getAsset();		
		Connection conn = ConnectionInfo.connection();

		LinkedList<Portfolios> l = new LinkedList<Portfolios>();
		List<Portfolios> p = new ArrayList<Portfolios>();
		List<Integer> temp = new ArrayList<Integer>();
		int portfolioID = 0;
		String portCode = null;
		double portValue=0;
		String assetCode=null;
		String assetType=null;
		String assetLabel=null;
		double quarterlyDividend=0;
		double BRR=0;
		String stockSymbol=null;
		double sharePrice=0;
		double betaMeasure=0;
		double apr=0;
		double omegaMeasure=0;
		double assetVal=0;

		//Key in Person table and foreign key in Portfolio table
		int ownerID= 0;
		int managerID = 0;
		int beneficiaryID = 0;
		int assetID=0;


		//Code in the Person table
		String ownerCode = null;
		String managerCode = null;
		String beneficiaryCode = null;

//		//creating a person
//		String lastName= null;
//		String firstName=null;
//		String secID=null;
//		String personType=null;

		//uses id to find corresponding asset to make the objects
		Map <Integer,Double> assetIDtemp= new HashMap<Integer,Double>();
		PreparedStatement ps = null;
		ResultSet rs=null;

		String query = "SELECT portfolioID FROM Portfolio";
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
				temp.add(rs.getInt("portfolioID"));
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);

		}

		//retrieves data from Portfolio table to create a portfolio object
		for(Integer pt: temp) {
			String query2 = "SELECT portCode, ownerID, managerID, beneficiaryID FROM Portfolio WHERE portfolioID = ?";
			try {
				ps = conn.prepareStatement(query2);
				ps.setInt(1, pt);
				rs = ps.executeQuery();

				while(rs.next()) {
					portCode = rs.getString("portCode");
					ownerID= rs.getInt("ownerID");
					managerID = rs.getInt("managerID");
					beneficiaryID = rs.getInt("beneficiaryID");
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			//Finds the personCode of the owner
			String query3 = "SELECT personCode FROM Person WHERE personID = ?";
			try{
				ps = conn.prepareStatement(query3);
				ps.setInt(1, ownerID);
				rs = ps.executeQuery();

				while(rs.next()) {
					ownerCode = rs.getString("personCode");
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
			//Finds the personCode of the manager
			String query4 = "SELECT personCode FROM Person WHERE personID = ?";
			try{
				ps = conn.prepareStatement(query4);
				ps.setInt(1, managerID);
				rs = ps.executeQuery();

				while(rs.next()) {
					managerCode = rs.getString("personCode");
				}

			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
			//Finds the personCode of the beneficiary
			String query5 = "SELECT personCode FROM Person WHERE personID = ?";
			try{
				ps = conn.prepareStatement(query5);
				ps.setInt(1, beneficiaryID);
				rs = ps.executeQuery();
				if (beneficiaryID==0){
					beneficiaryCode="";
				}
				else{
					while(rs.next()) {
						beneficiaryCode = rs.getString("personCode");
					}
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			//adds particular asset to hashmap
			String query6 = "SELECT assetID , portAssetValue FROM PortAsset WHERE portfolioID=?";
			try{
				ps = conn.prepareStatement(query6);
				ps.setInt(1, pt);
				rs = ps.executeQuery();	
				while(rs.next()) {
					assetID = rs.getInt("assetID");
					portValue=rs.getDouble("portAssetValue");
					assetIDtemp.put(assetID, portValue);
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			//retrieves asset data, puts data into asset 'a' list
			List<Assets> a = new ArrayList<Assets>();
			for(Entry<Integer, Double> entry : assetIDtemp.entrySet()) {
				String query7 = "SELECT assetCode, assetName, assetType, apr, quarterlyDividend, baseRateReturn, beta, omega, stockSymbol, totalValue, sharePrice FROM Asset WHERE assetID=?";
				try{
					ps = conn.prepareStatement(query7);
					ps.setInt(1, entry.getKey());
					rs = ps.executeQuery();	
					while(rs.next()) {
						assetCode = rs.getString("assetCode");
						assetLabel = rs.getString("assetName");
						assetType = rs.getString("assetType");
						apr = rs.getDouble("apr");
						quarterlyDividend = rs.getDouble("quarterlyDividend");
						BRR = rs.getDouble("baseRateReturn");
						betaMeasure = rs.getDouble("beta");
						omegaMeasure = rs.getDouble("omega");
						stockSymbol = rs.getString("stockSymbol");
						assetVal = rs.getDouble("totalValue");
						sharePrice = rs.getDouble("sharePrice");
						//creates new asset objects
//						for(int i=0; i<asset.size();i++){
//							if(asset.get(i).getCode().equals(assetCode)) {
								if (assetType.equals("D")){
									Deposit_Account d = new Deposit_Account(assetCode, assetType, assetLabel, apr);
									d.setBalance(entry.getValue());
									a.add(d);
								}
								else if (assetType.equals("P")){
									Private_Investments pi = new Private_Investments(assetCode, assetType, assetLabel, quarterlyDividend,BRR, omegaMeasure,assetVal);
									pi.setPercentageStake(entry.getValue());
									a.add(pi);

								}
								else {
									Stocks s = new Stocks (assetCode, assetType, assetLabel, quarterlyDividend, BRR, betaMeasure, stockSymbol, sharePrice);
									s.setSharesOwned(entry.getValue());
									a.add(s);	
								}
							}
//						}
//					}
				}catch (SQLException e) {
					System.out.println("SQLException: ");
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			Portfolios pf= null;
			//creates portfolio objects
			if(beneficiaryCode.equals("")) {
				pf = new Portfolios(portCode,getPerson(ownerCode),getPerson(managerCode),null,a);
			}else {
				pf = new Portfolios(portCode,getPerson(ownerCode),getPerson(managerCode),getPerson(beneficiaryCode),a);
			}

			l.addElement(pf, c);
			assetIDtemp.clear();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//returns list of portfolio objects
		return l;
	}
}
