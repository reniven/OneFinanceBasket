package obr;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class Data_Converter {

	//parse persons and assets files and connects to the database
	public void dataParser(){
		
		//Connects to the database
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		Connection conn = null;
 
		try {
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		try { 
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		//reads file
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("data/Persons.dat"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		//Creates a PorfolioData object
		//PortfolioData pd = new PortfolioData();
		//skips first line that is an integer
		String line1 = null;
		int startLine = 1;
		int counter = startLine;

		//Parsing Persons.dat into the Persons.java class
		try {
			while((line1 = reader.readLine()) != null) {
				if(counter > startLine) {
					String persons_arr[] = line1.split(";",-1);
					if(persons_arr.length <= 1) {

					}
					else {
						String personCode = persons_arr[0];
						String broker_data[];
						String brokerType;
						String secID;
						if (persons_arr[1].contains(",")){
							broker_data = persons_arr[1].split(",");
							brokerType = broker_data[0];
							secID = broker_data[1];
						}
						else{
							brokerType= "";
							secID= "";
						}
						//parsing in persons info
						String name[] = persons_arr[2].split(",");
						String firstName=name[1].trim();
						String lastName=name[0].trim();
						String addressArr[] = persons_arr[3].split(",");

						String street=addressArr[0].trim();
						String city=addressArr[1].trim();
						String state=addressArr[2].trim();
						String zipCode= addressArr[3].trim();
						
						String country=addressArr[4].trim();

						List<String>email=new ArrayList<String>();
						if(persons_arr.length == 5) {
							if (persons_arr[4].contains(",")){
								String temp[]=persons_arr[4].split(",");
								for (int i=0; i<temp.length;i++){
									email.add(temp[i]);
								}
							}
							else {
								email.add(persons_arr[4]);
							}
						}
						else{
							email.add("");
						}

						//pd.addPerson(personCode, firstName, lastName, street, city, state, zipCode, country, brokerType, secID);
						//pd.addEmail(personCode, email);
					}
				}
				counter++;

			}


		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			reader.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}

		//Parsing the Assets.dat file into a Persons.java object
		BufferedReader reader2 = null;

		try {
			reader2 = new BufferedReader(new FileReader("data/Assets.dat"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Invalid Input");
		}

		String line2 = null;
		int startLine2 = 1;
		int counter2 = startLine2;

		try {
			while((line2 = reader2.readLine()) != null) {
				if (counter2 > startLine2) {
					String assets_arr[] = line2.split(";");
					if(assets_arr.length <= 1) {

					}
					else {
						String assetCode = assets_arr[0];
						String type = assets_arr[1];
						String label;
						double quarterlyDividend;
						double BRR;
						double omegaMeasure;
						double totalValue;
						double betaMeasure;
						String stockSymbol;
						double sharePrice;
						double apr;										

						//adds assets to appropriate accounts

						if (type.equals("S")){
							Stocks b;
							label = assets_arr[2];
							quarterlyDividend = Double.parseDouble(assets_arr[3]);
							double tempBRR = Double.parseDouble(assets_arr[4]);
							BRR=(tempBRR)/100;
							betaMeasure = Double.parseDouble(assets_arr[5]);
							stockSymbol = assets_arr[6];
							sharePrice = Double.parseDouble(assets_arr[7]);
							//pd.addStock(assetCode, label, quarterlyDividend, BRR, betaMeasure, stockSymbol, sharePrice);
						}
						else if (type.equals("P")){
							Private_Investments b;
							label = assets_arr[2];
							quarterlyDividend = Double.parseDouble(assets_arr[3]);
							double tempBRR = Double.parseDouble(assets_arr[4]);
							BRR=(tempBRR)/100;
							omegaMeasure = Double.parseDouble(assets_arr[5]);
							totalValue = Double.parseDouble(assets_arr[6]);
							//pd.addPrivateInvestment(assetCode, label, quarterlyDividend, BRR, omegaMeasure, totalValue);
						}
						else if (type.equals("D")){
							Deposit_Account b;
							label = assets_arr[2];
							apr = Double.parseDouble(assets_arr[3]);
							//pd.addDepositAccount(assetCode, label, apr);
						}
					}
				}
				counter2++;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		BufferedReader reader3 = null;

		try {
			reader3 = new BufferedReader(new FileReader("data/Portfolios.dat"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Invalid Input");
		}

		//used to skip the first line
		String line3 = null;
		int startLine3 = 1;
		int counter3 = startLine3;
		String assetList[];
		//parses through Portfolio.dat 
		//stores codes in appropriate variables
		try {
			while((line3 = reader3.readLine()) != null) {
				if (counter3 > startLine3) {
					String portArr[] = line3.split(";", -1);
					if(portArr.length <= 1) {

					}
					else {
						String portCode = portArr[0];
						String ownerCode = portArr[1];
						String managerCode = portArr[2];
						String benCode = null;
						if(portArr[3].length() >= 4) {
							benCode = portArr[3];
						}
						else {
							benCode = "";
						}

				
							//Splits the asset list
			
							assetList = portArr[4].split(",");
							
							//parses through assetList

							
						
						//Adds the information to a list of Portfolios
							//pd.addPortfolio(portCode, ownerCode, managerCode, benCode);
							
							for(int i = 0; i < assetList.length; i++) {
								//splits each asset at its type and value
								String tempAsset[] = assetList[i].split(":");
								if(tempAsset[0].equals("")){
									
								}
								else{
									double value = Double.parseDouble(tempAsset[1]);
									//pd.addAsset(portCode, tempAsset[0], value);
								}
						}

							for(int i = 0; i < assetList.length; i++) {
									//splits each asset at its type and value
									String tempAsset[] = assetList[i].split(":");
									double value = Double.parseDouble(tempAsset[1]);
									//pd.addAsset(portCode, tempAsset[0], value);
							}
						
						//Adds the information to a list of Portfolios
							//pd.addPortfolio(portCode, ownerCode, managerCode, benCode);

					}
				}
				counter3++;
			}
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			reader3.close();
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	
	}
}

	
	//runs program

//	public static void main(String args[]){	
//		dataParser();
////		JSONWriter thing = new JSONWriter();
////		thing.JSONConverterP(perInfo);
////		XMLWriter thing2= new XMLWriter();
////		thing2.xmlPersonConverter(perInfo);
////		thing.JSONconverterA(assetInfo);
////		thing2.xmlAssetConverter(assetInfo);	
//	}
//}


	//public static void main(String args[]){	
		//dataParser();
//		JSONWriter thing = new JSONWriter();
//		thing.JSONConverterP(perInfo);
//		XMLWriter thing2= new XMLWriter();
//		thing2.xmlPersonConverter(perInfo);
//		thing.JSONconverterA(assetInfo);
//		thing2.xmlAssetConverter(assetInfo);	
	
//}




